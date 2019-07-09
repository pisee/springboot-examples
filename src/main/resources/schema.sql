
drop table if exists emp;
drop table if exists city;
drop table if exists hotel;

create table emp (emp_no varchar primary key, emp_name varchar, sal int);
create table city (id int primary key auto_increment, name varchar, state varchar, country varchar);
create table hotel (city int, name varchar, address varchar, zip varchar);

insert into city (name, state, country) values ('San Francisco', 'CA', 'US');
insert into hotel(city, name, address, zip) values (1, 'Conrad Treasury Place', 'William & George Streets', '4001');

insert into emp (emp_no, emp_name, sal) values ('1', 'empName', 1000);
