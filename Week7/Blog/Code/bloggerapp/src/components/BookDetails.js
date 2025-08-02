import React from "react";

function BookDetails() {
  const books = [
    { title: "Master React", price: 600 },
    { title: "Deep Dive into Angular 11", price: 800 },
    { title: "Mongo Essentials", price: 450 },
  ];

  return (
    <div>
      <h2>Book Details</h2>
      {books.map((book, i) => (
        <div key={i}>
          <strong>{book.title}</strong>
          <p>{book.price}</p>
        </div>
      ))}
    </div>
  );
}

export default BookDetails;
