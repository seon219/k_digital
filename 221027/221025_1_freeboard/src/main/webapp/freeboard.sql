 CREATE TABLE "FREEBOARD" (	
    "IDX" NUMBER(*,0) NOT NULL , 
	"NAME" CHAR(20 BYTE) NOT NULL , 
	"PASSWORD" CHAR(20 BYTE) NOT NULL , 
	"SUBJECT" VARCHAR2(20 BYTE) NOT NULL , 
	"CONTENT" VARCHAR2(3000 BYTE) NOT NULL , 
	"writeDate" TIMESTAMP (6) DEFAULT sysdate, 
	"HIT" NUMBER(*,0) DEFAULT 0, 
	"NOTICE" CHAR(3 BYTE) DEFAULT 'no',
    "IP" CHAR(20 BYTE), 
	 CONSTRAINT "FREEBOARD_PK" PRIMARY KEY ("IDX")
    );
    
    
delete from freeboard;
drop SEQUENCE freeboard_idx_seq;
create SEQUENCE freeboard_idx_seq;


CREATE TABLE "FREEBOARDCOMMENT"(
    "IDX" NUMBER(*,0) NOT NULL , 
	"GUP" NUMBER(*,0), 
	"NAME" CHAR(20 BYTE) NOT NULL , 
	"PASSWORD" CHAR(20 BYTE) NOT NULL , 
	"CONTENT" VARCHAR2(2000 BYTE) NOT NULL , 
	"WRITEDATE" TIMESTAMP (6) DEFAULT sysdate, 
	"IP" CHAR(20 BYTE), 
	 CONSTRAINT "FREEBOARDCOMMENT_PK" PRIMARY KEY ("IDX")
);


delete from FREEBOARDCOMMENT;
drop SEQUENCE FREEBOARDCOMMENT_idx_seq;
create SEQUENCE FREEBOARDCOMMENT_idx_seq;



insert into freeboard (idx, name, password, subject, content, notice, ip) 
values (freeboard_idx_seq.nextval, '홍길동', '1111', '1', '1등', 'no', '192.168.100.001');
insert into freeboard (idx, name, password, subject, content, notice, ip) 
values (freeboard_idx_seq.nextval, '임꺽정', '2222', '2', '2등', 'no', '192.168.100.002');
insert into freeboard (idx, name, password, subject, content, notice, ip) 
values (freeboard_idx_seq.nextval, '장길산', '3333', '3', '3등', 'no', '192.168.100.003');
insert into freeboard (idx, name, password, subject, content, notice, ip) 
values (freeboard_idx_seq.nextval, '일지매', '4444', '4', '4등', 'no', '192.168.100.004');

select * from freeboard order by idx desc;
select count(*) from freeboard;
update freeboard set hit = 11 where name='홍길동';


select * from freeboardcomment order by idx desc;

commit;