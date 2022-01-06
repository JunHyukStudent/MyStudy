DROP TABLE commenttbl;
CREATE TABLE commenttbl(
    C_code NUMBER PRIMARY KEY,
    B_code NUMBER NOT NULL,
    C_user VARCHAR2(20) NOT NULL,
    C_comment VARCHAR2(1000) NOT NULL,
    C_password VARCHAR2(10) NOT NULL,
    C_regDate DATE NOT NULL
);

DROP SEQUENCE comment_seq;
CREATE SEQUENCE comment_seq
NOCACHE;

INSERT INTO commenttbl
VALUES(comment_seq.nextval,0,'홍길동','안녕안녕','1234',SYSDATE);

SELECT * FROM commenttbl;

DELETE commenttbl;

DELETE FROM commenttbl where C_code=1 AND C_password=1234;