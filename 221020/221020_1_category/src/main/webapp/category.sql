CREATE TABLE "CATEGORY" 
   (	"IDX" NUMBER(*,0) NOT NULL, 
	"CATEGORY" VARCHAR2(100 BYTE) NOT NULL, 
	"GUP" NUMBER(*,0), -- ī�װ� �׷�
	"LEV" NUMBER(*,0), -- ī�װ� ����
	"SEQ" NUMBER(*,0), -- ���� ī�װ� �׷쿡�� ī�װ� ��� ���� 
     CONSTRAINT "CATEGORY_PK" PRIMARY KEY ("IDX")
   ) ;
   
   
delete from category;
drop SEQUENCE category_idx_seq;
create SEQUENCE category_idx_seq;
   
   
insert into CATEGORY (IDX, CATEGORY, GUP, LEV, SEQ)
   values (category_idx_seq.nextval, '��Ʈ��', category_idx_seq.currval, 0, 0);

select * from category order by gup desc, seq asc;

commit;


