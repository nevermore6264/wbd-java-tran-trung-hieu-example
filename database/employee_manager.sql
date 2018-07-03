CREATE DATABASE employee_manager;

USE employee_manager;

CREATE TABLE group_employee(
	group_employee_id INT AUTO_INCREMENT,
    group_employee_name NVARCHAR(100) NOT NULL,
	group_employee_desc NVARCHAR(200) NOT NULL,
    CONSTRAINT pk_group_employee PRIMARY KEY (group_employee_id)
);

CREATE TABLE employee(
	employee_id INT AUTO_INCREMENT,
    employee_name NVARCHAR(200) NOT NULL,
    gender tinyint NOT NULL,
    day_of_birthday DATE NOT NULL,
    phone_number NVARCHAR(15) NOT NULL,
    employee_idcard NVARCHAR(20) NOT NULL,
    employee_email NVARCHAR(50) NOT NULL,
    empolyee_address NVARCHAR(300) NOT NULL,
    group_employee_id INT,
    CONSTRAINT pk_employee PRIMARY KEY (employee_id),
    CONSTRAINT fk_empolyee_group FOREIGN KEY  (group_employee_id) REFERENCES group_employee (group_employee_id)
);

CREATE TABLE shift(
	shift_id INT AUTO_INCREMENT,
    shift_name NVARCHAR(100) NOT NULL,
    shift_start_time TIME NOT NULL,
    shift_end_time TIME NOT NULL,
    day_of_use NVARCHAR(15) NOT NULL,
	CONSTRAINT pk_shift PRIMARY KEY (shift_id)
);

CREATE TABLE employee_shift(
	empoly_shift_id INT AUTO_INCREMENT,
    shift_id INT,
    employee_id INT,
	CONSTRAINT pk_employee_shift PRIMARY KEY (empoly_shift_id),
    CONSTRAINT fk_employee_shift_employee FOREIGN KEY  (employee_id) REFERENCES employee (employee_id),
    CONSTRAINT fk_empolyee_group_shift FOREIGN KEY  (shift_id) REFERENCES shift (shift_id)
);

