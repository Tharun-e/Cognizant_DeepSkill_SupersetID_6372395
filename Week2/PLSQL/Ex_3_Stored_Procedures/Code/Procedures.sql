CREATE TABLE savings_accounts (
    acct_id NUMBER PRIMARY KEY,
    cust_id NUMBER,
    balance NUMBER(10,2)
);
CREATE TABLE bank_employees (
    emp_id NUMBER PRIMARY KEY,
    emp_name VARCHAR2(100),
    department_id NUMBER,
    salary NUMBER(10,2)
);
CREATE TABLE customer_accounts (
    acct_id NUMBER PRIMARY KEY,
    cust_id NUMBER,
    acct_type VARCHAR2(20),
    balance NUMBER(10,2)
);
INSERT INTO savings_accounts VALUES (301, 101, 15000);
INSERT INTO savings_accounts VALUES (302, 102, 8000);
INSERT INTO savings_accounts VALUES (303, 103, 12000);

INSERT INTO bank_employees VALUES (401, 'Ram', 10, 60000);
INSERT INTO bank_employees VALUES (402, 'Mohan', 10, 55000);
INSERT INTO bank_employees VALUES (403, 'Sitta', 20, 58000);

INSERT INTO customer_accounts VALUES (501, 101, 'SAVINGS', 12000);
INSERT INTO customer_accounts VALUES (502, 101, 'CHECKING', 6000);
INSERT INTO customer_accounts VALUES (503, 102, 'SAVINGS', 7000);
INSERT INTO customer_accounts VALUES (504, 102, 'CHECKING', 3000);

COMMIT;
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR acct_rec IN (SELECT * FROM savings_accounts) LOOP
        UPDATE savings_accounts
        SET balance = balance + (balance * 0.01)
        WHERE acct_id = acct_rec.acct_id;
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('Monthly interest applied to all savings accounts');
END;
/
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_dept_id IN NUMBER,
    p_bonus_pct IN NUMBER 
) IS
BEGIN
    UPDATE bank_employees
    SET salary = salary + (salary * p_bonus_pct)
    WHERE department_id = p_dept_id;

    DBMS_OUTPUT.PUT_LINE('Bonuses applied for Department ID: ' || p_dept_id);
END;
/
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_acct IN NUMBER,
    p_to_acct IN NUMBER,
    p_amount IN NUMBER
) IS
    v_balance NUMBER;
BEGIN
    SELECT balance INTO v_balance FROM customer_accounts WHERE acct_id = p_from_acct FOR UPDATE;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
    END IF;
    UPDATE customer_accounts
    SET balance = balance - p_amount
    WHERE acct_id = p_from_acct;
    UPDATE customer_accounts
    SET balance = balance + p_amount
    WHERE acct_id = p_to_acct;

    DBMS_OUTPUT.PUT_LINE('Transferred ' || p_amount || ' from Account ' || p_from_acct || ' to Account ' || p_to_acct);
END;
/
