CREATE TABLE members(
    id number(5) PRIMARY KEY,
    email VARCHAR2(255) UNIQUE,
    password VARCHAR2(100),
    name NVARCHAR2(50),
    regdate DATE
);

CREATE SEQUENCE members_seq
NOCACHE;

INSERT INTO members
VALUES(members_seq.nextval,'kim@naver.com','1234','김길동','2020/05/13');
INSERT INTO members
VALUES(members_seq.nextval,'lee@naver.com','1234','이길동','2020/07/12');
INSERT INTO members
VALUES(members_seq.nextval,'park@naver.com','1234','박길동','2020/04/04');
INSERT INTO members
VALUES(members_seq.nextval,'hwang@naver.com','1234','황길동','2020/10/03');

COMMIT;

SELECT * FROM members;