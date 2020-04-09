create table user(
  id int primary key auto_increment,
  username varchar(100),
  password varchar(100)
)charset utf8;

create table user_to_roles(
  id int primary key auto_increment,
  user_id int,
  role_id varchar(200)
)charset utf8;

create table role(
  id int primary key auto_increment,
  role_name varchar(200)
)charset utf8;

create table functions(
  id int primary key auto_increment,
  function_name varchar(200)
)charset utf8;

create table role_to_functions(
  id int primary key auto_increment,
  role_id int,
  function_id int
)