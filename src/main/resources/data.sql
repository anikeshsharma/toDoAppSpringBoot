DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS authorities;

create table users (
    username varchar(50) not null primary key,
    password varchar(120) not null,
    enabled boolean not null
);

create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username)
);

 insert into users(username, password, enabled)values('anikesh','pwd123',true);
 insert into authorities(username,authority)values('anikesh','ROLE_USER');
 
 insert into users(username, password, enabled)values('test','pwd123',true);
 insert into authorities(username,authority)values('test','ROLE_USER');