/*
	프로젝트명: Project02_Board_Basic_Model2
	작업명: JSP기초DB접속 CRUD + 게시판 만들기
	로그인 테이블명: b_users
	게시판 테이블명: b_board
*/
-- 기존 테이블 있는지 확인후 존재하면 삭제
DROP TABLE b_users;
DROP TABLE b_board;

SELECT * FROM b_users;
SELECT * FROM b_board;

-- b_users 테이블 만들기
-- 컬럼명 = id, password, name, role
-- 타입 = 모두 문자타입
-- pk = id
-- nn = password, name
-- default = role | User
CREATE TABLE b_users(
    id          VARCHAR2(20)    PRIMARY KEY,
    password    VARCHAR2(10)    NOT NULL,
    name        VARCHAR2(30)    NOT NULL,
    role        VARCHAR2(10)    DEFAULT 'User'
);

INSERT INTO b_users VALUES('kay','1234','엄경섭','Admin' );

SELECT * FROM b_users;
    
DESC b_users;

COMMIT;

-- b_board 테이블 만들기
-- 컬럼명 = seq, title, nickname, content, regdate, cnt, userid
-- 타입 = 별도 지정 이외에는 문자타입
--seq = 숫자, regdate = date 디폴트 sysdate, cnt 숫자 디폴트 0
-- pk = seq
-- nn =  title, nickname, content

CREATE TABLE b_board(
    seq         NUMBER(5)       PRIMARY KEY,    -- 글번호가 PK 된다.
    title       VARCHAR2(200)   NOT NULL,
    nickname    VARCHAR2(30)    NOT NULL,
    content     VARCHAR2(2000)  NOT NULL,
    regdate     DATE            DEFAULT sysdate,
    cnt         NUMBER(5)       DEFAULT 0,
    userid      VARCHAR2(8)
);
-- 테스트 벨류 인서트
INSERT INTO b_board(seq, title, nickname, content, regdate, userid)
VALUES(
    1,'첫번째 게시물','카윰','첫번째 게시물 내용','2023-04-20','kay'
);

SELECT * FROM b_board;
    
DESC b_board;
-- 최종 적용
COMMIT;



INSERT INTO b_board(seq, title, nickname, content) VALUES ((SELECT nvl(MAX(seq),0)+1 FROM b_board),'타이틀','글쓴이','글내용');



SELECT * FROM b_users WHERE id='kay' AND password = '1234';

SELECT * FROM b_board ORDER BY seq desc; -- seq의 내림차순(desc)로 정렬(order by)한다.


-- 조회수 증가 쿼리
-- 글번호 2번에 cnt 1이 되도록 쿼리문 작성
UPDATE b_board SET cnt = (SELECT cnt+1 FROM b_board WHERE seq = 2) WHERE seq = 2;
-- cnt = 서브쿼리문으로 만든다. 서브쿼리 = 조건식이며 select만 존재

UPDATE b_board SET cnt = 0;

-- 해당 글번호 2번 레코드 셋 조회
SELECT * FROM b_board WHERE seq = 2;


-- 업데이트 쿼리문
UPDATE b_board SET title = '타이틀변경', content = '내용 변경' WHERE seq = 2;
-- 삭제 쿼리문
DELETE FROM b_board WHERE seq = 1;

-- 최종 적용
COMMIT;