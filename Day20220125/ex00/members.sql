CREATE TABLE members(
ID number primary key,
EMAIL varchar2(255) unique,
PASSWORD varchar2(100),
NAME varchar2(100),
REGDATE date);