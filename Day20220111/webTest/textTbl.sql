CREATE TABLE texttbl(
    code number PRIMARY KEY,
    title NVARCHAR2(100),
    contents NVARCHAR2(2000),
    regdate date
);

CREATE SEQUENCE text_seq
NOCACHE;

INSERT INTO texttbl
VALUES(text_seq.nextval,'첫번째','글 내용',sysdate);

COMMIT;

SELECT * FROM texttbl;