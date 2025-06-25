import { Routes, Route, Navigate } from "react-router-dom";
import Register from "./Register";
import Login from "./Login";
import Dashboard from "./Dashboard";

function App() {
  const isLoggedIn = localStorage.getItem("isLoggedIn") === "true";

  return (
    <Routes>
      <Route
        path="/"
        element={
          <>
            <h1 style={{ textAlign: "center" }}>User Auth System</h1>
            <div style={{ display: "flex", justifyContent: "space-around" }}>
              <Register />
              <Login />
            </div>
          </>
        }
      />

      <Route
        path="/dashboard"
        element={
          isLoggedIn ? <Dashboard /> : <Navigate to="/" />
        }
      />
    </Routes>
  );
}

export default App;
