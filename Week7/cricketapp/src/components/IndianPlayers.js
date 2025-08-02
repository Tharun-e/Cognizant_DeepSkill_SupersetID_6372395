import React from "react";

const IndianPlayers = () => {
  const players = ["Sachin1", "Rohit2", "Virat3", "Raina4", "Yuvaraj5", "Dhoni6"];

  const [first, second, third, fourth, fifth, sixth] = players;

  const oddPlayers = [
    { label: "First", name: first },
    { label: "Third", name: third },
    { label: "Fifth", name: fifth },
  ];

  const evenPlayers = [
    { label: "Second", name: second },
    { label: "Fourth", name: fourth },
    { label: "Sixth", name: sixth },
  ];

  const T20players = [
    "Mr. First Player",
    "Mr. Second Player",
    "Mr. Third Player",
  ];
  const RanjiPlayers = [
    "Mr. Fourth Player",
    "Mr. Fifth Player",
    "Mr. Sixth Player",
  ];

  const mergedPlayers = [...T20players, ...RanjiPlayers];

  return (
    <div>
      <h2>Odd Players</h2>
      <ul>
        {oddPlayers.map((player, index) => (
          <li key={index}>
            {player.label} : {player.name}
          </li>
        ))}
      </ul>

      <h2>Even Players</h2>
      <ul>
        {evenPlayers.map((player, index) => (
          <li key={index}>
            {player.label} : {player.name}
          </li>
        ))}
      </ul>

      <h2>List of Indian Players Merged:</h2>
      <ul>
        {mergedPlayers.map((p, i) => (
          <li key={i}>{p}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;
