import React from "react";

function App() {
  const heading = "Office Space Rental";
  const imageUrl =
    "https://i.pinimg.com/originals/0c/e5/73/0ce573d1f7d0e1a25f5cb7c1369e0443.jpg";

  const office = {
    name: "Green Tower, Coimbatore",
    rent: 55000,
    address: "Trichy Road, Coimbatore",
  };

  const officeList = [
    { name: "Blue Square", rent: 58000, address: "Race Course, Coimbatore" },
    { name: "IT Hub", rent: 65000, address: "Peelamedu, Coimbatore" },
    { name: "Cyber Park", rent: 70000, address: "Tidel Park, Coimbatore" },
    { name: "Eco Tower", rent: 40000, address: "Avinashi Road, Coimbatore" },
  ];

  const getRentColor = (rent) => {
    return {
      color: rent > 60000 ? "green" : "red",
      fontWeight: "bold",
    };
  };

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h1>{heading}</h1>

      <img
        src={imageUrl}
        alt="Office Space"
        width="500"
        style={{ borderRadius: "10px" }}
      />

      <h2>Featured Office</h2>
      <p>
        <strong>Name:</strong> {office.name}
      </p>
      <p style={getRentColor(office.rent)}>
        <strong>Rent:</strong> ₹{office.rent}
      </p>
      <p>
        <strong>Address:</strong> {office.address}
      </p>

      <h2>All Office Listings</h2>
      <ul>
        {officeList.map((item, index) => (
          <li key={index} style={{ marginBottom: "10px" }}>
            <strong>Name:</strong> {item.name} <br />
            <span style={getRentColor(item.rent)}>
              <strong>Rent:</strong> ₹{item.rent}
            </span>
            <br />
            <strong>Address:</strong> {item.address}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
