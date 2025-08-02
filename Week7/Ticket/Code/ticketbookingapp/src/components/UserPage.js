import React from "react";

function UserPage() {
  const flights = [
    "Indigo 6E - Chennai to Delhi - 8:00 AM",
    "Air India - Mumbai to Kolkata - 10:30 AM",
    "Vistara - Bangalore to Pune - 2:45 PM",
    "Emirates - Chennai to Dubai - 9:15 PM",
  ];

  return (
    <div style={{ padding: "20px" }}>
      <h2>Welcome Back, User</h2>
      <p>You can now book your flight:</p>
      <ul>
        {flights.map((flight, index) => (
          <li key={index} style={{ marginBottom: "15px" }}>
            <span style={{ marginRight: "20px" }}>Flight: {flight}</span>
            <button style={{ padding: "5px 10px", cursor: "pointer" }}>
              Book Now
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default UserPage;
