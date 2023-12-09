create database EmployeeManagementSystem;
use EmployeeManagementSystem;
create table Trainee(traineeId int,traineeName varchar(50),traineeEmail varchar(100),primary key(traineeId));
select * from Trainee;

create table Course(courseId int,courseName varchar(100),primary key(courseId));
insert into Course values(1,'JAVA'),
						(2,'HTML'),
                        (3,'CSS'),
                        (4,'JAVASCRIPT');
  create table Module(moduleId int,moduleName varchar(100),primary key(moduleId),courseId int,
  foreign Key(courseId) references Course(courseId));
  
  insert into Module values(1,'Oops',1),
							(2,'collections',1),
                            (3,'Exceptions',1),
                            (4,'tags',2);
	create table Topics(topicId int,topicName varchar(100),moduleId int,primary key(topicId),
    foreign key(moduleId) references Module(moduleId));
    
    insert into Topic values(1,'inheritence',1),
							(2,'polymerphrism',1),
                            (3,'List',2),
                            (4,'ExceptionHandling',3),
                            (5,'closingtags',4);
                            select * from topic;
                            
                             
                            
                            