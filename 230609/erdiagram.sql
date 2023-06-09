
/* Drop Triggers */

DROP TRIGGER TRI_JOB_HISTORY_HIS_NO;
DROP TRIGGER TRI_POSITION_PNO;
DROP TRIGGER TRI_REVIEW_REVIEW_NO;
DROP TRIGGER TRI_SALARY_PAYMENT_SALPAY_NO;
DROP TRIGGER TRI_YEARS_YEARS_NO;
DROP TRIGGER TRI_YEARS_YEAR_NO;
DROP TRIGGER TRI_YEAR_YEAR_NO;



/* Drop Tables */

DROP TABLE JOB_HISTORY CASCADE CONSTRAINTS;
DROP TABLE REVIEW CASCADE CONSTRAINTS;
DROP TABLE SALARY_INFO CASCADE CONSTRAINTS;
DROP TABLE SALARY_PAYMENT CASCADE CONSTRAINTS;
DROP TABLE WORK CASCADE CONSTRAINTS;
DROP TABLE YEARS CASCADE CONSTRAINTS;
DROP TABLE EMPLOYEES CASCADE CONSTRAINTS;
DROP TABLE DEPARTMENTS CASCADE CONSTRAINTS;
DROP TABLE HR_SYSTEM CASCADE CONSTRAINTS;
DROP TABLE SALARY_STEP CASCADE CONSTRAINTS;
DROP TABLE POSITION CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_JOB_HISTORY_HIS_NO;
DROP SEQUENCE SEQ_POSITION_PNO;
DROP SEQUENCE SEQ_REVIEW_REVIEW_NO;
DROP SEQUENCE SEQ_SALARY_PAYMENT_SALPAY_NO;
DROP SEQUENCE SEQ_YEARS_YEARS_NO;
DROP SEQUENCE SEQ_YEARS_YEAR_NO;
DROP SEQUENCE SEQ_YEAR_YEAR_NO;




/* Create Sequences */

CREATE SEQUENCE SEQ_JOB_HISTORY_HIS_NO INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_POSITION_PNO INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_REVIEW_REVIEW_NO INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_SALARY_PAYMENT_SALPAY_NO INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_YEARS_YEARS_NO INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_YEARS_YEAR_NO INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_YEAR_YEAR_NO INCREMENT BY 1 START WITH 1;



/* Create Tables */

-- 부서
CREATE TABLE DEPARTMENTS
(
	-- 부서번호
	DNO varchar2(10) NOT NULL,
	-- 부서이름
	DNAME varchar2(30) NOT NULL UNIQUE,
	PRIMARY KEY (DNO)
);


-- 직원 정보
CREATE TABLE EMPLOYEES
(
	-- 직원번호
	EMID varchar2(10) NOT NULL,
	-- 직급이름
	POSITION varchar2(10) NOT NULL UNIQUE,
	-- 부서이름
	DNAME varchar2(30) NOT NULL UNIQUE,
	-- 직원이름
	NAME varchar2(30) NOT NULL,
	-- 생년월일
	BIRTH date NOT NULL,
	-- 전화번호
	TEL varchar2(30) NOT NULL,
	-- 성별
	GEN varchar2(10) NOT NULL,
	-- 입사일자
	JOIN date NOT NULL,
	PRIMARY KEY (EMID)
);


-- 로그인 계정
CREATE TABLE HR_SYSTEM
(
	-- 아이디
	ID varchar2(30) NOT NULL,
	-- 비밀번호
	PW varchar2(30) NOT NULL,
	PRIMARY KEY (ID)
);


-- 히스토리
CREATE TABLE JOB_HISTORY
(
	-- 히스토리 번호
	HIS_NO number NOT NULL,
	-- 부서이름
	DNAME varchar2(30) NOT NULL UNIQUE,
	-- 직급이름
	POSITION varchar2(10) NOT NULL UNIQUE,
	-- 직원번호
	EMID varchar2(10) NOT NULL,
	-- 시작일자
	LEAVESTART date NOT NULL,
	-- 종료일자
	LEAVEFIN date NOT NULL,
	-- 구분
	REMARK varchar2(100) NOT NULL,
	PRIMARY KEY (HIS_NO)
);


-- 직급
CREATE TABLE POSITION
(
	-- 직급번호
	PNO number NOT NULL,
	-- 직급이름
	POSITION varchar2(10) NOT NULL UNIQUE,
	PRIMARY KEY (PNO)
);


-- 인사고과 기록
CREATE TABLE REVIEW
(
	-- 인사고과번호
	REVIEW_NO number NOT NULL,
	-- 직원번호
	EMID varchar2(10) NOT NULL,
	-- 평가항목1
	EVAL1 number NOT NULL,
	-- 평가항목2
	EVAL2 number NOT NULL,
	-- 평가항목3
	EVAL3 number NOT NULL,
	-- 평가항목4
	EVAL4 number NOT NULL,
	-- 평가항목5
	EVAL5 number NOT NULL,
	-- 평가 총점수
	EVAL_TOT number NOT NULL,
	-- 평가 등급
	GRADE varchar2(10) NOT NULL,
	-- 비고
	REMARK varchar2(100),
	-- 평가일자
	EVAL_DATE date NOT NULL,
	PRIMARY KEY (REVIEW_NO)
);


-- 급여 정보
CREATE TABLE SALARY_INFO
(
	-- 직원번호
	EMID varchar2(10) NOT NULL,
	-- 은행명
	BANK varchar2(30) NOT NULL,
	-- 예금주
	DEPOSITOR varchar2(30) NOT NULL,
	-- 계좌번호
	ACCOUNT varchar2(30) NOT NULL,
	PRIMARY KEY (EMID)
);


-- 급여 지급 내역
CREATE TABLE SALARY_PAYMENT
(
	-- 급여지급번호
	SALPAY_NO number NOT NULL,
	-- 직원번호
	EMID varchar2(10) NOT NULL,
	-- 급여지급일자
	PAY_DATE date NOT NULL,
	-- 상여금
	BONUS number NOT NULL,
	-- 총급여
	TOTAL number NOT NULL,
	PRIMARY KEY (SALPAY_NO)
);


-- 호봉
CREATE TABLE SALARY_STEP
(
	-- 호봉
	SAL_GRADE number NOT NULL,
	-- 직급이름
	POSITION varchar2(10) NOT NULL UNIQUE,
	-- 기본급
	SAL number NOT NULL,
	PRIMARY KEY (SAL_GRADE)
);


-- 근태 기록
CREATE TABLE WORK
(
	-- 직원번호
	EMID varchar2(10) NOT NULL,
	-- 근속년수
	CONT number NOT NULL,
	-- 지각일수
	LATE number NOT NULL,
	-- 조퇴일수
	EARLY number NOT NULL,
	-- 결근일수
	ABS number NOT NULL,
	-- 사용가능연차일수
	AV_ANN number NOT NULL,
	-- 사용한연차일수
	USED_ANN number NOT NULL,
	-- 잔여연차일수
	UNUSED_ANN number NOT NULL,
	PRIMARY KEY (EMID)
);


-- 연차 승인 내역
CREATE TABLE YEARS
(
	-- 연차승인번호
	YEARS_NO number NOT NULL,
	-- 직원번호
	EMID varchar2(10) NOT NULL,
	-- 연차사용일자
	YEARS_DATE date NOT NULL,
	-- 연차사용일수
	YEARS_CNT number NOT NULL,
	-- 연차승인자
	APP varchar2(30) NOT NULL,
	-- 연차승인일자
	APP_DATE date NOT NULL,
	PRIMARY KEY (YEARS_NO)
);



/* Create Foreign Keys */

ALTER TABLE EMPLOYEES
	ADD FOREIGN KEY (DNAME)
	REFERENCES DEPARTMENTS (DNAME)
;


ALTER TABLE JOB_HISTORY
	ADD FOREIGN KEY (DNAME)
	REFERENCES DEPARTMENTS (DNAME)
;


ALTER TABLE JOB_HISTORY
	ADD FOREIGN KEY (EMID)
	REFERENCES EMPLOYEES (EMID)
;


ALTER TABLE REVIEW
	ADD FOREIGN KEY (EMID)
	REFERENCES EMPLOYEES (EMID)
;


ALTER TABLE SALARY_INFO
	ADD FOREIGN KEY (EMID)
	REFERENCES EMPLOYEES (EMID)
;


ALTER TABLE SALARY_PAYMENT
	ADD FOREIGN KEY (EMID)
	REFERENCES EMPLOYEES (EMID)
;


ALTER TABLE WORK
	ADD FOREIGN KEY (EMID)
	REFERENCES EMPLOYEES (EMID)
;


ALTER TABLE YEARS
	ADD FOREIGN KEY (EMID)
	REFERENCES EMPLOYEES (EMID)
;


ALTER TABLE EMPLOYEES
	ADD FOREIGN KEY (POSITION)
	REFERENCES POSITION (POSITION)
;


ALTER TABLE JOB_HISTORY
	ADD FOREIGN KEY (POSITION)
	REFERENCES POSITION (POSITION)
;


ALTER TABLE SALARY_STEP
	ADD FOREIGN KEY (POSITION)
	REFERENCES POSITION (POSITION)
;



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_JOB_HISTORY_HIS_NO BEFORE INSERT ON JOB_HISTORY
FOR EACH ROW
BEGIN
	SELECT SEQ_JOB_HISTORY_HIS_NO.nextval
	INTO :new.HIS_NO
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_POSITION_PNO BEFORE INSERT ON POSITION
FOR EACH ROW
BEGIN
	SELECT SEQ_POSITION_PNO.nextval
	INTO :new.PNO
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_REVIEW_REVIEW_NO BEFORE INSERT ON REVIEW
FOR EACH ROW
BEGIN
	SELECT SEQ_REVIEW_REVIEW_NO.nextval
	INTO :new.REVIEW_NO
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_SALARY_PAYMENT_SALPAY_NO BEFORE INSERT ON SALARY_PAYMENT
FOR EACH ROW
BEGIN
	SELECT SEQ_SALARY_PAYMENT_SALPAY_NO.nextval
	INTO :new.SALPAY_NO
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_YEARS_YEARS_NO BEFORE INSERT ON YEARS
FOR EACH ROW
BEGIN
	SELECT SEQ_YEARS_YEARS_NO.nextval
	INTO :new.YEARS_NO
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_YEARS_YEAR_NO BEFORE INSERT ON YEARS
FOR EACH ROW
BEGIN
	SELECT SEQ_YEARS_YEAR_NO.nextval
	INTO :new.YEAR_NO
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_YEAR_YEAR_NO BEFORE INSERT ON YEAR
FOR EACH ROW
BEGIN
	SELECT SEQ_YEAR_YEAR_NO.nextval
	INTO :new.YEAR_NO
	FROM dual;
END;

/




/* Comments */

COMMENT ON TABLE DEPARTMENTS IS '부서';
COMMENT ON COLUMN DEPARTMENTS.DNO IS '부서번호';
COMMENT ON COLUMN DEPARTMENTS.DNAME IS '부서이름';
COMMENT ON TABLE EMPLOYEES IS '직원 정보';
COMMENT ON COLUMN EMPLOYEES.EMID IS '직원번호';
COMMENT ON COLUMN EMPLOYEES.POSITION IS '직급이름';
COMMENT ON COLUMN EMPLOYEES.DNAME IS '부서이름';
COMMENT ON COLUMN EMPLOYEES.NAME IS '직원이름';
COMMENT ON COLUMN EMPLOYEES.BIRTH IS '생년월일';
COMMENT ON COLUMN EMPLOYEES.TEL IS '전화번호';
COMMENT ON COLUMN EMPLOYEES.GEN IS '성별';
COMMENT ON COLUMN EMPLOYEES.JOIN IS '입사일자';
COMMENT ON TABLE HR_SYSTEM IS '로그인 계정';
COMMENT ON COLUMN HR_SYSTEM.ID IS '아이디';
COMMENT ON COLUMN HR_SYSTEM.PW IS '비밀번호';
COMMENT ON TABLE JOB_HISTORY IS '히스토리';
COMMENT ON COLUMN JOB_HISTORY.HIS_NO IS '히스토리 번호';
COMMENT ON COLUMN JOB_HISTORY.DNAME IS '부서이름';
COMMENT ON COLUMN JOB_HISTORY.POSITION IS '직급이름';
COMMENT ON COLUMN JOB_HISTORY.EMID IS '직원번호';
COMMENT ON COLUMN JOB_HISTORY.LEAVESTART IS '시작일자';
COMMENT ON COLUMN JOB_HISTORY.LEAVEFIN IS '종료일자';
COMMENT ON COLUMN JOB_HISTORY.REMARK IS '구분';
COMMENT ON TABLE POSITION IS '직급';
COMMENT ON COLUMN POSITION.PNO IS '직급번호';
COMMENT ON COLUMN POSITION.POSITION IS '직급이름';
COMMENT ON TABLE REVIEW IS '인사고과 기록';
COMMENT ON COLUMN REVIEW.REVIEW_NO IS '인사고과번호';
COMMENT ON COLUMN REVIEW.EMID IS '직원번호';
COMMENT ON COLUMN REVIEW.EVAL1 IS '평가항목1';
COMMENT ON COLUMN REVIEW.EVAL2 IS '평가항목2';
COMMENT ON COLUMN REVIEW.EVAL3 IS '평가항목3';
COMMENT ON COLUMN REVIEW.EVAL4 IS '평가항목4';
COMMENT ON COLUMN REVIEW.EVAL5 IS '평가항목5';
COMMENT ON COLUMN REVIEW.EVAL_TOT IS '평가 총점수';
COMMENT ON COLUMN REVIEW.GRADE IS '평가 등급';
COMMENT ON COLUMN REVIEW.REMARK IS '비고';
COMMENT ON COLUMN REVIEW.EVAL_DATE IS '평가일자';
COMMENT ON TABLE SALARY_INFO IS '급여 정보';
COMMENT ON COLUMN SALARY_INFO.EMID IS '직원번호';
COMMENT ON COLUMN SALARY_INFO.BANK IS '은행명';
COMMENT ON COLUMN SALARY_INFO.DEPOSITOR IS '예금주';
COMMENT ON COLUMN SALARY_INFO.ACCOUNT IS '계좌번호';
COMMENT ON TABLE SALARY_PAYMENT IS '급여 지급 내역';
COMMENT ON COLUMN SALARY_PAYMENT.SALPAY_NO IS '급여지급번호';
COMMENT ON COLUMN SALARY_PAYMENT.EMID IS '직원번호';
COMMENT ON COLUMN SALARY_PAYMENT.PAY_DATE IS '급여지급일자';
COMMENT ON COLUMN SALARY_PAYMENT.BONUS IS '상여금';
COMMENT ON COLUMN SALARY_PAYMENT.TOTAL IS '총급여';
COMMENT ON TABLE SALARY_STEP IS '호봉';
COMMENT ON COLUMN SALARY_STEP.SAL_GRADE IS '호봉';
COMMENT ON COLUMN SALARY_STEP.POSITION IS '직급이름';
COMMENT ON COLUMN SALARY_STEP.SAL IS '기본급';
COMMENT ON TABLE WORK IS '근태 기록';
COMMENT ON COLUMN WORK.EMID IS '직원번호';
COMMENT ON COLUMN WORK.CONT IS '근속년수';
COMMENT ON COLUMN WORK.LATE IS '지각일수';
COMMENT ON COLUMN WORK.EARLY IS '조퇴일수';
COMMENT ON COLUMN WORK.ABS IS '결근일수';
COMMENT ON COLUMN WORK.AV_ANN IS '사용가능연차일수';
COMMENT ON COLUMN WORK.USED_ANN IS '사용한연차일수';
COMMENT ON COLUMN WORK.UNUSED_ANN IS '잔여연차일수';
COMMENT ON TABLE YEARS IS '연차 승인 내역';
COMMENT ON COLUMN YEARS.YEARS_NO IS '연차승인번호';
COMMENT ON COLUMN YEARS.EMID IS '직원번호';
COMMENT ON COLUMN YEARS.YEARS_DATE IS '연차사용일자';
COMMENT ON COLUMN YEARS.YEARS_CNT IS '연차사용일수';
COMMENT ON COLUMN YEARS.APP IS '연차승인자';
COMMENT ON COLUMN YEARS.APP_DATE IS '연차승인일자';



