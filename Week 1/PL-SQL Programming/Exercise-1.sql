DECLARE
    CURSOR customer_cursor IS
        SELECT CustomerID, Age
        FROM Customers;

BEGIN
    FOR customer_rec IN customer_cursor LOOP
        IF customer_rec.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = customer_rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE(
                'Interest rate updated for Customer ID: ' || customer_rec.CustomerID
            );
        END IF;
    END LOOP;

    COMMIT;
END;
/


DECLARE
    CURSOR customer_cursor IS
        SELECT CustomerID, Balance
        FROM Customers;

BEGIN
    FOR customer_rec IN customer_cursor LOOP
        IF customer_rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = customer_rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE(
                'Customer ID ' || customer_rec.CustomerID || ' promoted to VIP.'
            );
        END IF;
    END LOOP;

    COMMIT;
END;
/


DECLARE
    CURSOR loan_cursor IS
        SELECT LoanID, CustomerID, DueDate
        FROM Loans
        WHERE DueDate BETWEEN SYSDATE AND SYSDATE + 30;

BEGIN
    FOR loan_rec IN loan_cursor LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan ID ' || loan_rec.LoanID || ' for Customer ID ' || loan_rec.CustomerID || ' is due on ' || TO_CHAR(loan_rec.DueDate, 'DD-MON-YYYY')
        );
    END LOOP;
END;
/

