create database Re_Training;
use Re_Training;

create table employee(id int,empname varchar(225),job varchar(225),salary int,dpmtno int);
insert into employee values('1','rakesh','analyst','10000','001'),
                           ('2','sam','clerk','3000','002'),
                           ('3','sanju','salesman','2000','003'),
                           ('4','jack','manager','8000','004');
create table department(dpmtno int,dpmtname varchar(225),doj date);
insert into department values('2','HR','2002-01-20'),
                             ('3','ENG','2005-03-20'),
                             ('4','IT','2008-08-20');


select * from employee;
select * from department;

truncate table employee;
drop table employee;
select empname,job from employee;
select * from employee where salary<='3000';
select empname,salary*12 as salary from employee ;
select * from employee where job IN('clerk','salesman')&&salary=3000;
select* from employee where empname Like '%h';
Select* from department where doj>'2002-01-20';
select sum(salary) as totalsalary from employee;
select* from employee where dpmtno in(select dpmtno from department where doj>'2022-01-20');
select * from employee where dpmtno in(select  dpmtno from department where salary<10000);
use virtusafeb;
insert into customer values('1','shanthi','snt','india');
insert into customer values('2','rakesh','rk','india');
insert into customer values('3','ganesh','gnh','india');
insert into customer values('4','ashwini','awn','india');
select* from customer;