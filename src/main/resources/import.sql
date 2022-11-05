-- Contract Types
INSERT INTO contract_types (name, description, is_active, created_at, updated_at) VALUES ('permanent', 'full time', true, now(), now());
INSERT INTO contract_types (name, description, is_active, created_at, updated_at) VALUES ('fixed-term', 'full time', true, now(), now());
INSERT INTO contract_types (name, description, is_active, created_at, updated_at) VALUES ('external', 'part time', true, now(), now());

-- Employees
INSERT INTO employee (birth_date, cell_phone, created_at, is_active, updated_at, email, last_name, name, tax_id_number) VALUES( '2022-11-05', 'string', '2022-11-05', 1, '2022-11-05', 'string@string.com', 'string', 'string', 'stringlargo');


-- Contracts
INSERT INTO contracts ( created_at, is_active, updated_at, date_from, date_to, salary_per_day, contract_id, employee_id) VALUES( '2022-11-05', 0, '2022-11-05', '2022-11-05', '2022-11-05', 500.0, 1, 1);
INSERT INTO contracts ( created_at, is_active, updated_at, date_from, date_to, salary_per_day, contract_id, employee_id) VALUES('2022-11-05', 1, '2022-11-05', '2022-11-05', '2022-11-05', 500.0, 1, 1);
