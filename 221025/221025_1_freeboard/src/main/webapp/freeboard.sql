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
values (freeboard_idx_seq.nextval, 'È«±æµ¿', '1111', '1', '11', 'no', '192.168.100.001');
insert into freeboard (idx, name, password, subject, content, notice, ip) 
values (freeboard_idx_seq.nextval, 'ÀÓ²©Á¤', '2222', '2', '22', 'no', '192.168.100.002');
insert into freeboard (idx, name, password, subject, content, notice, ip) 
values (freeboard_idx_seq.nextval, 'Àå±æ»ê', '3333', '3', '33', 'no', '192.168.100.003');
insert into freeboard (idx, name, password, subject, content, notice, ip) 
values (freeboard_idx_seq.nextval, 'ÀÏÁö¸Å', '4444', '4', '44', 'no', '192.168.100.004');

select * from freeboard order by idx desc;
select count(*) from freeboard;
update freeboard set hit = 11 where name='È«±æµ¿';


commit;