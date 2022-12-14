CREATE TABLE "TJOEUN"."GUESTBOOK"(	
    "IDX" NUMBER(*,0) NOT NULL ENABLE, 
	"NAME" CHAR(20 BYTE) NOT NULL ENABLE, 
	"PASSWORD" CHAR(20 BYTE) NOT NULL ENABLE, 
	"MEMO" VARCHAR2(1000 BYTE) NOT NULL ENABLE, 
	"WRITEDATE" TIMESTAMP (6) DEFAULT sysdate, 
	"IP" CHAR(20 BYTE), 
	 CONSTRAINT "GUESTBOOK_PK" PRIMARY KEY ("IDX")
);
   
   
-- 시퀀스 초기화 방법
-- 모든 데이터를 제거하고 시퀀스를 지우고 다시 만든다.
delete from guestbook;
drop SEQUENCE guestbook_idx_seq;
-- 자동으로 1씩 증가시키기 위해 시퀀스를 만든다.
create SEQUENCE guestbook_idx_seq;


SELECT * FROM guestbook;
SELECT count(*) FROM guestbook;
SELECT * FROM guestbook where idx = 10;

delete from guestbook where idx = 10;
update guestbook set name = '손오공', memo = '손오공' where idx = 11;
SELECT count(*) FROM guestbook where memo like '%1등%';


insert into guestbook (idx, name, password, memo, ip)
values (guestbook_idx_seq.nextval, '홍길동', '1111', '1등', '192.168.100.001');
insert into guestbook (idx, name, password, memo, ip)
values (guestbook_idx_seq.nextval, '임꺽정', '2222', '2등', '192.168.100.002');
insert into guestbook (idx, name, password, memo, ip)
values (guestbook_idx_seq.nextval, '장길산', '3333', '3등', '192.168.100.003');
insert into guestbook (idx, name, password, memo, ip)
values (guestbook_idx_seq.nextval, '일지매', '4444', '4등', '192.168.100.004');


-- 트랜젝션: 한 번에 모두 실행되어야 할 명령의 집합
-- 트리거: 특정 조건이 만족되면 실행
-- commit: 트랜젝션이 모두 정상적으로 처리되서 결과를 데이터베이스에 반영된다.
-- rollback: 트랜젝션이 모두 정상적으로 처리되지 않았을 경우 최초 실행 상태 이전으로 되돌린다.
-- oracle developer은 auto commit이 지원되지 않기 때문에 developer에서 진행한 작업이 jsp에 적용되게 하려면.
--   반드시 commit을 실행해야 한다.
commit; -- 정상종료

