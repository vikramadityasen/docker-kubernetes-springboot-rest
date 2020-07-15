insert into department(id, name, created_by, created_date, updated_by, updated_date) values(1111, 'Research & development', 'Vikram', TO_DATE('02/08/2019 12:00', 'DD/MM/YYYY HH24:MI'), 'Vikram', TO_DATE('03/08/2019 12:00', 'DD/MM/YYYY HH24:MI'));

insert into employee(id, address, city, country, created_by, created_date, date_of_birth, gender, name, updated_by, updated_date, department_id) values(101, '310 Evergreen Circle FL 33193', 'Miami', 'USA', 'Aditya', TO_DATE('02/08/2019 12:00', 'DD/MM/YYYY HH24:MI'), '15/04/1989', 'male', 'Micheal', 'Aditya', TO_DATE('03/08/2019 12:00', 'DD/MM/YYYY HH24:MI'), 1111);

insert into department_employees(department_id, employees_id) values(1111, 101);