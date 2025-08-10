import React from "react";

function CourseDetails() {
  const courses = [
    { name: "Angular", date: "4/5/2025" },
    { name: "React", date: "6/8/20205" },
  ];

  return (
    <div>
      <h2>Course Details</h2>
      {courses.map((course, i) => (
        <div key={i}>
          <strong>{course.name}</strong>
          <p>{course.date}</p>
        </div>
      ))}
    </div>
  );
}

export default CourseDetails;
