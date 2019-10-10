
# Employees working at macys
SELECT * FROM employees JOIN jobs ON employees.ssn=jobs.ssn WHERE company='Macy''s';

# Companies in Boston
SELECT * FROM employees JOIN jobs ON employees.ssn=jobs.ssn WHERE city='Boston';

# Employee with the highest salary
SELECT * FROM employees JOIN jobs ON employees.ssn=jobs.ssn ORDER BY SALARY DESC LIMIT 1;
