-- Write select queries for each of the following:

-- Employees working at Macy's: The full names of employees working at Macy's.
    
    SELECT first_name, last_name
    FROM employees
    JOIN jobs
    ON employees.ssn = jobs.ssn
    WHERE company = 'Macy''s';

-- Companies in Boston: The companies located in Boston.

    SELECT company
    FROM employees
    JOIN jobs
    ON employees.ssn = jobs.ssn
    WHERE city = 'Boston';

-- Employee with the highest salary: The full name of the employee with the highest salary.

    SELECT first_name, last_name
    FROM employees
    JOIN jobs
    ON employees.ssn = jobs.ssn
    ORDER BY salary DESC
    LIMIT 1;