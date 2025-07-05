CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    department VARCHAR(100)
);
INSERT INTO employee (name, department) VALUES ('Alice', 'Finance');
INSERT INTO employee (name, department) VALUES ('Bob', 'Marketing');
SELECT*from employees;