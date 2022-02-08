DROP TABLE members;

/* members테이블 생성 */
CREATE TABLE members(
memberNum NUMBER(6) PRIMARY KEY,
memberId VARCHAR2(50) UNIQUE,
memberPassword VARCHAR2(100) NOT NULL,
memberName VARCHAR2(100) NOT NULL,
memberEmail VARCHAR2(200),
memberPhone VARCHAR2(13) NOT NULL);

DROP SEQUENCE members_seq;

/* members시퀀스 */
CREATE SEQUENCE members_seq
START WITH 10001
NOCACHE;

/* members 샘플 데이터 */
INSERT INTO members
VALUES(members_seq.NEXTVAL,'admin','1234','관리자','admin@green.com','010-1234-5678');
INSERT INTO members
VALUES(members_seq.NEXTVAL,'park','1234','박민준','park@green.com','010-1234-5679');
INSERT INTO members
VALUES(members_seq.NEXTVAL,'kim','1234','김서연','kim@green.com','010-1234-4680');
INSERT INTO members
VALUES(members_seq.NEXTVAL,'lee','1234','이서준','lee@green.com','010-1234-5681');
INSERT INTO members
VALUES(members_seq.NEXTVAL,'jung','1234','정서윤','jung@green.com','010-1234-5682');
INSERT INTO members
VALUES(members_seq.NEXTVAL,'choi','1234','최예준','choi@green.com','010-1234-5683');
INSERT INTO members
VALUES(members_seq.NEXTVAL,'jo','1234','조지우','jo@green.com','010-1234-5684');

SELECT * FROM members;

DROP TABLE boards;

/* boards테이블 생성 */
CREATE TABLE boards(
qnaBoardNum NUMBER(6) PRIMARY KEY,
memberNum NUMBER(6) NOT NULL,
qnaBoardTitle VARCHAR2(1000) NOT NULL,
qnaBoardContent VARCHAR2(4000),
qnaBoardRegdate DATE DEFAULT SYSDATE,
qnaBoardCount NUMBER(10) DEFAULT 0,
CONSTRAINT FK_BOARDS FOREIGN KEY(memberNum)
REFERENCES members(memberNum)
);

DROP SEQUENCE boards_seq;

/* boards시퀀스 */
CREATE SEQUENCE boards_seq
START WITH 101
NOCACHE;

/* boards샘플 데이터 */
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10002,'질문이 있습니다.','프로토콜에는 어떤 것이 있나요?','2020-09-15',5);
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10003,'DB 질문이 있습니다','인덱스를 만드는 이유는 무엇인가요?','2020-10-13',4);
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10007,'스프링에 관련해서 질문이 있습니다.','스프링과 스프링 부트의 차이가 무엇인가요?','2020-10-21',6);
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10005,'서블릿 궁금한 게 있어요','어노테이션 없이 매핑을 어떻게 하나요?','2020-11-03',3);
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10004,'HTML에 궁금한 게 있습니다.','meta태그는 무엇이며 어떤 내용을 담고 있나요?','2020-11-16',7);
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10003,'DB 관련 질문이 있습니다.','조인과 서브 쿼리는 어떤 경우에 사용하나요?','2020-11-27',5);
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10004,'CSS가 어려워요','텍스트를 상하 가운데 정렬을 하고 싶은데 어떻게 하나요?','2020-12-05',6);
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10006,'자바 스크립트 질문이요','selectQuery와 getElementById의 차이와 어떤 경우에 사용하는 지 궁금합니다.','2020-12-13',4);
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10002,'질문이 있습니다.','URL과 URI의 차이는 무엇인가요?','2021-01-07',7);
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10005,'JSP에서 페이지 이동에 관련해서 질문이 있습니다.','포워드와 리다이렉트의 차이와 어떤 경우에 사용되는지 알려주세요.','2021-01-18',3);
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10006,'DOM에 관련해서 질문이 있어요','새로 만든 노드를 화면에 만들고 싶은데 어떻게 끼워 넣어야 하나요?','2021-02-20',4);
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10007,'스프링 어려워요','제어의 역전이 무엇이고 어떻게 사용하는 건가요?','2020-03-02',5);

SELECT * FROM boards;

DROP TABLE comments;

/* comments테이블 생성 */
CREATE TABLE comments(
commentNum NUMBER(6) PRIMARY KEY,
qnaBoardNum NUMBER(6) NOT NULL,
commentContent VARCHAR2(4000),
commentRegdate DATE DEFAULT SYSDATE,
CONSTRAINT FK_COMMENTS FOREIGN KEY(qnaBoardNum)
REFERENCES boards(qnaBoardNum)
);

DROP SEQUENCE comments_seq;

/* comments시퀀스 */
CREATE SEQUENCE comments_seq
START WITH 1
NOCACHE;

/* comments샘플 데이터 */
INSERT INTO comments
VALUES(comments_seq.NEXTVAL,101,'프로토콜에는 HTTP,HTTPS등이 있습니다.','2020-09-16');
INSERT INTO comments
VALUES(comments_seq.NEXTVAL,102,'빠른 데이터 검색을 위해서 필요합니다.','2020-10-14');
INSERT INTO comments
VALUES(comments_seq.NEXTVAL,105,'meta 태그는 화면에 노출되지 않는 문서의 기본정보를 작성합니다.','2020-11-17');
INSERT INTO comments
VALUES(comments_seq.NEXTVAL,104,'web.xml을 이용합니다.','2020-11-17');
INSERT INTO comments
VALUES(comments_seq.NEXTVAL,103,'스프링 설정을 보다 간소화 한 것이 스프링 부트입니다.','2020-11-17');

SELECT * FROM comments;

SELECT qnaBoardNum,qnaBoardTitle,memberName,qnaBoardRegdate,qnaBoardCount
FROM boards b join members m on b.memberNum = m.memberNum
ORDER BY qnaBoardNum ASC;

SELECT qnaBoardNum FROM commets;