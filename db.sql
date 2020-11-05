SET MODE postgresql;

CREATE DATABASE news;

CREATE TABLE employees(
    id SERIAL PRIMARY KEY,
    name varchar,
    employeePosition varchar,
    role varchar,
    department varchar
);

CREATE TABLE departments(
    id SERIAL PRIMARY KEY,
    departmentName varchar,
    departmentDesc varchar,
    departmentEmployees int
);

CREATE TABLE departmentEmployees(
    id SERIAL PRIMARY KEY,
    departmentId int,
    employeeId int
);