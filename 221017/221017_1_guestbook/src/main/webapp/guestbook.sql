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

insert into guestbook (idx, name, password, memo, ip)
values (guestbook_idx_seq.nextval, '홍길동', '1111', '1등', '192.168.100.001');
insert into guestbook (idx, name, password, memo, ip)
values (guestbook_idx_seq.nextval, '임꺽정', '2222', '2등', '192.168.100.002');
insert into guestbook (idx, name, password, memo, ip)
values (guestbook_idx_seq.nextval, '장길산', '3333', '3등', '192.168.100.003');
insert into guestbook (idx, name, password, memo, ip)
values (guestbook_idx_seq.nextval, '일지매', '4444', '4등', '192.168.100.004');



