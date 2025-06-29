CREATE TABLE bank_customers (
    cust_id NUMBER PRIMARY KEY,
    full_name VARCHAR2(100),
    cust_age NUMBER,
    acct_balance NUMBER,
    vip_status CHAR(1) DEFAULT 'N'
);
CREATE TABLE customer_loans (
    loan_ref NUMBER PRIMARY KEY,
    cust_id NUMBER,
    int_rate NUMBER(5,2),
    due_dt DATE,
    FOREIGN KEY (cust_id) REFERENCES bank_customers(cust_id)
);
INSERT INTO bank_customers VALUES (101, 'Ravi Sharma', 62, 14000, 'N');
INSERT INTO bank_customers VALUES (102, 'Neha Verma', 48, 9500, 'N');
INSERT INTO bank_customers VALUES (103, 'Sanjay Kumar', 68, 18000, 'N');

INSERT INTO customer_loans VALUES (201, 101, 7.25, SYSDATE + 20);
INSERT INTO customer_loans VALUES (202, 102, 8.10, SYSDATE + 45);
INSERT INTO customer_loans VALUES (203, 103, 9.20, SYSDATE + 5);

COMMIT;

BEGIN
    FOR cust_rec IN (SELECT * FROM bank_customers WHERE cust_age > 60) LOOP
        UPDATE customer_loans
        SET int_rate = int_rate - 1
        WHERE cust_id = cust_rec.cust_id;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Interest discount applied for senior customers 60+');
END;


BEGIN
    FOR vip_rec IN (SELECT * FROM bank_customers WHERE acct_balance > 10000) LOOP
        UPDATE bank_customers
        SET vip_status = 'Y'
        WHERE cust_id = vip_rec.cust_id;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('VIP status assigned for high balance customers');
END;

BEGIN
    FOR due_rec IN (
        SELECT l.loan_ref, c.full_name, l.due_dt
        FROM customer_loans l
        JOIN bank_customers c ON l.cust_id = c.cust_id
        WHERE l.due_dt <= SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || due_rec.loan_ref || 
                             ' for ' || due_rec.full_name || 
                             ' is due on ' || TO_CHAR(due_rec.due_dt, 'DD-Mon-YYYY'));
    END LOOP;
END;

