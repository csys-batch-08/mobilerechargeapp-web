create table admin(Admin_id int GENERATED ALWAYS AS IDENTITY START WITH 100 PRIMARY KEY ,Admin_emailid varchar2(50) not null,password varchar(50)not null);
select * from Admin;
desc  admin;
alter table admin drop column Admin_id;
alter table admin modify Admin_name varchar2(50) primary key; 
drop table admin;
insert into admin(admin_emailid,password)values('rrahul24799@gmail.com','143rahul');
select * from admin;
desc admin;
commit;
--------------------------------------------------------------------------------------------------------------------------------------------
--user table
select * from userlogin;
create table userlogin(user_id int GENERATED ALWAYS AS IDENTITY START WITH 01 PRIMARY KEY ,user_name VARCHAR2(40)not null,
Email_id varchar2(50) UNIQUE,phone_number varchar(40)not null,password varchar2(50)not null,wallet int not null,operator_id int,
foreign key(operator_id)references operator_details(operator_id));
desc userlogin;
drop table userlogin;
alter table userlogin modify wallet default 0;

select*from userlogin;
drop table userlogin CASCADE CONSTRAINTS;
desc userlogin;
truncate table userlogin;
------------------------------------------------------------------------------------------------------------------------
--operator table--erator
create table operator_details(operator_id int   PRIMARY KEY ,operator_name varchar2(100) not null);
desc operator_details;
drop table operator_details CASCADE CONSTRAINTS;
select * from operator_details;
insert into operator_details (operator_id,operator_name) values(101,'jio');
insert into operator_details(operator_id,operator_name)values(102,'Airtel');
insert into operator_details(operator_id,operator_name)values(103,'Vodafone');
insert into operator_details(operator_id,operator_name)values(104,'BSNL');
select * from operator_details where operator_name='jio';


-------------------------------------------------------------------------------------------------------------------
--jio user--
create table jio_plans(jioplan_id int  GENERATED ALWAYS AS IDENTITY START WITH 1000 INCREMENT by 1 PRIMARY KEY,plan_name varchar2(100) not null,price varchar(100) not null,
validity varchar(100) not null,benefits varchar(100) not null,operator_id int not null,foreign key(operator_id)references operator_details(operator_id));
desc jio_plans;
drop table jio_plans;
truncate table jio_plans;
insert into jio_plans (plan_name,price,validity,benefits)values('sportspack',199,'28days','unlimitedcalls');
------------------------------------------------------------------------------------------------------------------------------
--airtel_user
create table Airtel_plans(airtelplan_id int GENERATED ALWAYS AS IDENTITY START WITH 5000 INCREMENT by 1 PRIMARY KEY  ,plan_name varchar2(100) not null,price varchar(100) not null,
validity varchar(100) not null,benefits varchar(100)not null,operator_id int not null,foreign key(operator_id)references operator_details(operator_id));
desc airtel_plans;
drop table airtel_plans;
select * from airtel_plans;
delete from Airtel_plans ;
truncate table Airtel_plans;

commit;
-----------------------------------------------------------------------------------------------------------------------------------

--vodafone user
create table vodafone_plans(vodafoneplan_id int  GENERATED ALWAYS AS IDENTITY START WITH 7000 INCREMENT by 1 PRIMARY KEY ,plan_name varchar2(100)not null,price varchar(100)not null,
validity varchar(100)not null,benefits varchar(100)not null,operator_id int not null ,foreign key(operator_id)references operator_details(operator_id));
desc vodafone_plans;
drop table vodafone_plans;
select * from vodafone_plans;
truncate table Vodafone_plans;
---------------------------------------------------------------------------------------------------------------------------------------

--bsnl table
create table BSNL_plans (bsnlplan_id int GENERATED ALWAYS AS IDENTITY START WITH 500 INCREMENT by 1 PRIMARY KEY ,plan_name varchar2(100)not null,price varchar(100)not null,
validity varchar(100)not null,benefits varchar(100)not null,operator_id int not null,foreign key(operator_id)references operator_details(operator_id));
desc BSNL_plans;
drop table BSNL_plans;
truncate table bsnl_plans;



----------------------------------------------------------------------------------------------------------------------------------------

----user payment
--create table user_payment(payment_id int primary key not null,user_id int not null,Payment_type varchar(40) not null,Account_no varchar2(40) not null,
--ccv varchar2(10)not null,expiry date not null);
--desc user_payment;
--drop table user_payment;

--------------------------------------------------------------------------------------------------------------------------------------------------
----payment details
--create table Payment_details(payment_id int not null,Plan_id int not null,Amount varchar2(50) not null,
--Status varchar2(50)not null);
--desc payment_details;
--drop table payment_details;

------------------------------------------------------------------------------------------------------------------------------------------

--transctions details
create table history_details(history_id int GENERATED ALWAYS AS IDENTITY START WITH 1 INCREMENT by 1 PRIMARY KEY  ,user_id int ,operator_id int ,mobile_number number,
plan_id int  not null,Recharge_date date,Payment int not null, foreign key (user_id)references userlogin (user_id),foreign key (operator_id)references operator_details (operator_id));
desc history_details;
drop table history_details;
truncate table  history_details;
select * from history_details;
select u.user_name,o.operator_name,h.plan_id,h.Recharge_date,h.Payment from userlogin u join operator_details o  on 
u.operator_id=o.operator_id join  history_details h on h.user_id=u.user_id;

insert into history_details (user_id,operator_id,mobile_number,plan_id,recharge_date,payment)values (30,101,9994136328,1107,'20-12-2021',290);
--------------------------------------------------------------------------------------------------------------------
--create table offer_details(offer_id int GENERATED ALWAYS AS IDENTITY START WITH 500 INCREMENT by 1 PRIMARY KEY,offer_description varchar2 (100), plan_id int,operator_id int,
--foreign key (plan_id)references history_details(plan_id),foreign key (operator_id)references operator_details (operator_id));
select * from Admin;
desc Admin; 
select*from  userlogin;
select * from operator_details;
select * from jio_plans;

select * from Airtel_plans;
select * from vodafone_plans;
select * from BSNL_plans;
select * from history_details;
truncate table history_details;
commit;
select * from userlogin where user_id=28;
delete from jio_plans where jioplan_id=1105;
delete from airtel_plans where validity='30 days';
rollback;
 delete from history_details where plan_id=0;
 
 
 commit;
             