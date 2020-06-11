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
)charset utf8;

CREATE TABLE `oauth_access_token` (
                                      `token_id` varchar(255) DEFAULT NULL,
                                      `token` blob,
                                      `authentication_id` varchar(255) NOT NULL,
                                      `user_name` varchar(255) DEFAULT NULL,
                                      `client_id` varchar(255) DEFAULT NULL,
                                      `authentication` blob,
                                      `refresh_token` varchar(255) DEFAULT NULL,
                                      PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `oauth_refresh_token` (
                                       `token_id` varchar(255) NOT NULL,
                                       `token` blob,
                                       `authentication` blob,
                                       PRIMARY KEY (`token_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;