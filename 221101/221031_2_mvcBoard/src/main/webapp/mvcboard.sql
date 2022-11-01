CREATE TABLE "MVCBOARD" (	
    "IDX" NUMBER(*,0) NOT NULL , 
	"NAME" VARCHAR2(20 BYTE) NOT NULL , 
	"SUBJECT" VARCHAR2(200 BYTE) NOT NULL , 
	"CONTENT" VARCHAR2(3000 BYTE) NOT NULL , 
	"GUP" NUMBER(*,0), 
	"LEV" NUMBER(*,0), 
	"SEQ" NUMBER(*,0), 
	"HIT" NUMBER(*,0) DEFAULT 0, 
	"WRITEDATE" TIMESTAMP (6) DEFAULT sysdate, 
	 CONSTRAINT "MVCBOARD_PK" PRIMARY KEY ("IDX")
   );
   
   
delete from mvcboard;
drop sequence mvcboard_idx_seq;
create sequence mvcboard_idx_seq;


select * from mvcboard order by gup desc, seq;
select count(*) from mvcboard;

insert into mvcboard(idx, name, subject, content, gup, lev, seq)
values (mvcboard_idx_seq.nextval, 'ȫ�浿', '1��', '1111', mvcboard_idx_seq.currval, 0, 0);
insert into mvcboard(idx, name, subject, content, gup, lev, seq)
values (mvcboard_idx_seq.nextval, '�Ӳ���', '2��', '2222', mvcboard_idx_seq.currval, 0, 0);
insert into mvcboard(idx, name, subject, content, gup, lev, seq)
values (mvcboard_idx_seq.nextval, '����', '3��', '3333', mvcboard_idx_seq.currval, 0, 0);
insert into mvcboard(idx, name, subject, content, gup, lev, seq)
values (mvcboard_idx_seq.nextval, '������', '4��', '4444', mvcboard_idx_seq.currval, 0, 0);

commit;