import React from "react";

const ListOfPlayers = () => {
  const players = [
    { name: "Rohit", score: 90 },
    { name: "Virat", score: 65 },
    { name: "Gill", score: 80 },
    { name: "Raina", score: 68 },
    { name: "Pant", score: 54 },
    { name: "Rahul", score: 68 },
    { name: "Dhoni", score: 72 },
    { name: "Jadeja", score: 65 },
    { name: "Kuldeep", score: 25 },
    { name: "Shami", score: 30 },
    { name: "Bumrah", score: 22 },
  ];

  const lowScorers = players.filter((p) => p.score < 70);

  return (
    <div>
      <h2>List of Players</h2>
      <ul>
        {players.map((p, index) => (
          <li key={index}>{p.name} - Score: {p.score}</li>
        ))}
      </ul>
      <h3>Players Scoring Below 70</h3>
      <ul>
        {lowScorers.map((p, index) => (
          <li key={index}>{p.name} - Score: {p.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListOfPlayers;
