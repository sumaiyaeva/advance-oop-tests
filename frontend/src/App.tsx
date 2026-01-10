import { useEffect, useState } from "react";

type Student = {
  id: number;
  name: string;
  email: string;
};

function App() {
  const [students, setStudents] = useState<Student[]>([]);
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");

  // Load students
  useEffect(() => {
    fetch("http://localhost:8080/students")
      .then((res) => res.json())
      .then((data) => setStudents(data));
  }, []);

  // Create student
  const addStudent = async () => {
    await fetch("http://localhost:8080/students", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ name, email }),
    });

    setName("");
    setEmail("");

    const res = await fetch("http://localhost:8080/students");
    const data = await res.json();
    setStudents(data);
  };

  // Delete student
  const deleteStudent = async (id: number) => {
    await fetch(`http://localhost:8080/students/${id}`, {
      method: "DELETE",
    });

    setStudents(students.filter((s) => s.id !== id));
  };

  return (
    <div style={{ padding: "40px" }}>
      <h1>Student Management</h1>

      <input
        placeholder="Name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <input
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <button onClick={addStudent}>Add Student</button>

      <ul>
        {students.map((s) => (
          <li key={s.id}>
            {s.name} ({s.email})
            <button onClick={() => deleteStudent(s.id)}>❌</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
