create database university;
use university;
create table student(id int auto_increment,name varchar(100),age int not null,email varchar(30) not null,primary key(id));
insert into student values(10,'mani',18,'mani@gmail.com');
select * from student;

create table cirtificates(id int,year int,sem int,primary key(id));
insert into cirtificates values(1,1,1),
								(2,1,2),
                                (3,2,1),
                                (4,2,2),
                                (5,3,1),
                                (6,3,2),
                                (7,4,1),
                                (8,4,2),
                                (9,1,1),
                                (10,1,2),
                                (11,2,1);
                                
                                
   create table cirtificate_log(id int,sid int,cid int,date date,primary key (id),
   foreign key(sid) references student(id),foreign key(cid) references cirtificates(id));  
   insert into cirtificate_log values(6,5,1,'2023-12-23');
                                     
   select * from cirtificate_log;

