import React, { useState } from "react";

function CurrencyConverter() {
  const [rupees, setRupees] = useState("");

  const handleConvert = (e) => {
    e.preventDefault();
    const amount = parseFloat(rupees);
    if (!isNaN(amount)) {
      const euroAmount = amount * 80; 
      alert(`Converting to Euro Amount is ${euroAmount}`);
    } else {
      alert("Please enter a valid number.");
    }
  };

  return (
    <div style={{ padding: "20px", fontFamily: "Segoe UI" }}>
      <h2 style={{ color: "green" }}>Currency Convertor!!!</h2>
      <form onSubmit={handleConvert}>
        <label>
          <strong>Amount:</strong>{" "}
          <input
            type="text"
            value={rupees}
            onChange={(e) => setRupees(e.target.value)}
            style={{
              padding: "5px",
              margin: "5px",
              borderRadius: "5px",
              border: "1px solid #ccc",
            }}
          />
        </label>
        <br />
        <label>
          <strong>Currency:</strong>{" "}
          <select
            style={{ padding: "5px", margin: "5px", borderRadius: "5px" }}
            disabled
          >
            <option>Euro</option>
          </select>
        </label>
        <br />
        <button
          type="submit"
          style={{
            padding: "6px 12px",
            background: "green",
            color: "white",
            border: "none",
            borderRadius: "5px",
            marginTop: "10px",
          }}
        >
          Submit
        </button>
      </form>
    </div>
  );
}

export default CurrencyConverter;
