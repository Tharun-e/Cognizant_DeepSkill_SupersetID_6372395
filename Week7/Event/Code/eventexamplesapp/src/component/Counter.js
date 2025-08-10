import React, { Component } from "react";

class Counter extends Component {
  constructor() {
    super();
    this.state = {
      count: 1,
    };
  }

  increment = () => {
    this.setState({ count: this.state.count + 1 });
    this.sayHello();
  };

  decrement = () => {
    this.setState({ count: this.state.count - 1 });
  };

  sayHello = () => {
    alert("Hello from React Events!");
  };

  sayWelcome = (msg) => {
    alert("Message: " + msg);
  };

  handleClick = (e) => {
    alert("I was clicked");
  };

  render() {
    return (
      <div style={{ marginBottom: "40px" }}>
        <h3>Count: {this.state.count}</h3>
        <button onClick={this.increment}>Increment</button>&nbsp;
        <button onClick={this.decrement}>Decrement</button>&nbsp;
        <button onClick={() => this.sayWelcome("Welcome to React!")}>
          Say welcome
        </button>&nbsp;
        <button onClick={this.handleClick}>Click on me</button>
      </div>
    );
  }
}

export default Counter;
