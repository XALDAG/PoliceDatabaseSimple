ALTER TABLE officer
ADD COLUMN age INT NOT NULL CHECK (age >= 18);

CREATE TABLE addresses (
address_id INT AUTO_INCREMENT PRIMARY KEY,
address_line1 VARCHAR(255) NOT NULL,
address_line2 VARCHAR(255),
city VARCHAR(100) NOT NULL,
state_province VARCHAR(100),
postal_code VARCHAR(20),
country VARCHAR(100) NOT NULL,
latitude DECIMAL(10,8),
longitude DECIMAL(11,8),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


ALTER TABLE person
ADD COLUMN address_id INT NOT NULL;


ALTER TABLE person
DROP COLUMN address;


ALTER TABLE addresses
RENAME TO address;


ALTER TABLE person
ADD CONSTRAINT fk_address
FOREIGN KEY (address_id)
REFERENCES address(address_id);


ALTER TABLE crime
ADD COLUMN address_id int;

ALTER TABLE crime
ADD CONSTRAINT fk2_address
FOREIGN KEY (address_id)
REFERENCES address(address_id);


ALTER TABLE officer
ADD COLUMN address_id int;

ALTER TABLE officer
ADD CONSTRAINT fk3_address
FOREIGN KEY (address_id)
REFERENCES address(address_id);


ALTER TABLE department
ADD COLUMN address_id int;

ALTER TABLE department
ADD CONSTRAINT fk4_address
FOREIGN KEY (address_id)
REFERENCES address(address_id);


ALTER TABLE prison
ADD COLUMN address_id int;

ALTER TABLE prison
ADD CONSTRAINT fk5_address
FOREIGN KEY (address_id)
REFERENCES address(address_id);


ALTER TABLE prison
DROP COLUMN location;

ALTER TABLE department
DROP COLUMN location;



ALTER TABLE case_officer
DROP FOREIGN KEY case_officer_ibfk_2;

ALTER TABLE case_officer
DROP COLUMN officer_id;

ALTER TABLE officer
MODIFY COLUMN officer_id int;

ALTER TABLE officer
DROP COLUMN officer_id;


DROP TABLE case_officer;





CREATE TABLE case_officer (
case_id INT NOT NULL,
badge_number INT NOT NULL,
department_id INT NOT NULL,
PRIMARY KEY (case_id, badge_number),
FOREIGN KEY (case_id) REFERENCES criminal_case(case_id),
FOREIGN KEY (badge_number) REFERENCES officer(badge_number),
FOREIGN KEY (department_id) REFERENCES department(department_id)
);





alter table case_officer
drop foreign key case_officer_ibfk_2;

alter table officer
modify column badge_number int not null auto_increment;


alter table case_officer
add constraint case_officer_ibfk_2
foreign key (badge_number)
references officer(badge_number);


