import React from "react";
import CourseDetails from "./components/CourseDetails";
import BookDetails from "./components/BookDetails";
import BlogDetails from "./components/BlogDetails";

function App() {
  return (
    <div style={{ padding: "30px", fontFamily: "Segoe UI" }}>
      <div
        style={{
          display: "flex",
          justifyContent: "space-around",
          alignItems: "flex-start",
          textAlign: "left",
        }}
      >
        <div style={{ padding: "10px", borderRight: "4px solid red" }}>
          <CourseDetails />
        </div>

        <div style={{ padding: "10px", borderRight: "4px solid green" }}>
          <BookDetails />
        </div>

        <div style={{ padding: "10px" }}>
          <BlogDetails />
        </div>
      </div>
    </div>
  );
}

export default App;
