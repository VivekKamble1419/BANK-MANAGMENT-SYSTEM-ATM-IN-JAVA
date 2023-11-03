create database bankmanagmentsystem;
show databases;
use bankmanagmentsystem;
show tables;
create table signup(Form_no varchar(20),Name varchar(40),Father_Name varchar(40),Date_of_Birth varchar(20),Gender varchar(20),Email varchar(30),Marital varchar(20),Address varchar(50),City varchar(20),State varchar(25),Pin_Code varchar(20));
show tables;
select * from signup;

create table signuptwo(Form_no varchar(20),Religion varchar(20),Category varchar(20),Income varchar(30),Education_Qualification varchar(30),Occupation varchar(30),Pan_Number varchar(30),Addhar_Number varchar(30),Existing_Account varchar(20));
select * from signuptwo;

create table signupthree(Form_no varchar(20),Account_Type varchar(40),Card_Number varchar(30),PIN varchar(30),Facility varchar(100));
select * from signupthree;

create table login(formno varchar(40),cardnumber varchar(40),pin varchar(20));
select * from login;

create table bank(pin varchar(20),date varchar(100),type varchar(30),amount varchar(300));

select * from bank;
desc bank;
DELETE FROM login; // for delete all data in table