import React from "react";

function BlogDetails() {
  const blogs = [
    {
      title: "React Learning",
      author: "Stephen Biz",
      content: "Welcome to learning React!",
    },
    {
      title: "Installation",
      author: "Schewzdenier",
      content: "You can install React from npm.",
    },
  ];

  return (
    <div>
      <h2>Blog Details</h2>
      {blogs.map((blog, i) => (
        <div key={i}>
          <strong>{blog.title}</strong>
          <p style={{ fontWeight: "bold" }}>{blog.author}</p>
          <p>{blog.content}</p>
        </div>
      ))}
    </div>
  );
}

export default BlogDetails;
