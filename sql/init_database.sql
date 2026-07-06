CREATE TABLE officer (
officer_id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
badge_number INT NOT NULL UNIQUE,
officer_rank VARCHAR(20) NOT NULL
);

CREATE TABLE prison (
prison_id INT PRIMARY KEY AUTO_INCREMENT,
prison_name VARCHAR(50) NOT NULL,
location VARCHAR(50) NOT NULL,
prison_description TEXT,
prison_capacity INT NOT NULL CHECK (prison_capacity >= 0)
);

CREATE TABLE person (
person_id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
age INT NOT NULL CHECK (age >= 0),
address VARCHAR(150),
gender ENUM('Male', 'Female') NOT NULL
);

CREATE TABLE crime (
crime_id INT PRIMARY KEY AUTO_INCREMENT,
crime_name VARCHAR(50) NOT NULL,
crime_category VARCHAR(50) NOT NULL
);

CREATE TABLE criminal_case (
case_id INT PRIMARY KEY AUTO_INCREMENT,
person_id INT NOT NULL,
crime_id INT NOT NULL,
arrest_date DATE NOT NULL,
court_date DATE,
FOREIGN KEY (person_id) REFERENCES person(person_id),
FOREIGN KEY (crime_id) REFERENCES crime(crime_id)
);

CREATE TABLE department (
department_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
location VARCHAR(50) NOT NULL
);

CREATE TABLE sentence (
sentence_id INT PRIMARY KEY AUTO_INCREMENT,
case_id INT NOT NULL,
prison_id INT NOT NULL,
years INT NOT NULL CHECK (years >= 0),
start_date DATE NOT NULL,
end_date DATE NOT NULL,
FOREIGN KEY (case_id) REFERENCES criminal_case(case_id),
FOREIGN KEY (prison_id) REFERENCES prison(prison_id),
CHECK (end_date >= start_date)
);

CREATE TABLE case_officer (
case_id INT NOT NULL,
officer_id INT NOT NULL,
department_id INT NOT NULL,
PRIMARY KEY (case_id, officer_id),
FOREIGN KEY (case_id) REFERENCES criminal_case(case_id),
FOREIGN KEY (officer_id) REFERENCES officer(officer_id),
FOREIGN KEY (department_id) REFERENCES department(department_id)
);