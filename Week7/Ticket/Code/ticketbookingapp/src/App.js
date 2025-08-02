import React, { useState } from "react";
import GuestPage from "./components/GuestPage";
import UserPage from "./components/UserPage";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLoginLogout = () => {
    setIsLoggedIn(!isLoggedIn);
  };

  return (
    <div style={{ padding: "30px", fontFamily: "Arial" }}>
      <h1>Ticket Booking App</h1>
      <button
        onClick={handleLoginLogout}
        style={{
          padding: "10px 20px",
          marginBottom: "20px",
          backgroundColor: isLoggedIn ? "#e74c3c" : "#2ecc71",
          color: "white",
          border: "none",
          borderRadius: "5px",
        }}
      >
        {isLoggedIn ? "Logout" : "Login"}
      </button>

      {isLoggedIn ? <UserPage /> : <GuestPage />}
    </div>
  );
}

export default App;
