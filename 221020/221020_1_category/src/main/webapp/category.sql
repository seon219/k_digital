CREATE TABLE "CATEGORY" 
   (	"IDX" NUMBER(*,0) NOT NULL, 
	"CATEGORY" VARCHAR2(100 BYTE) NOT NULL, 
	"GUP" NUMBER(*,0), -- 카테고리 그룹
	"LEV" NUMBER(*,0), -- 카테고리 레벨
	"SEQ" NUMBER(*,0), -- 같은 카테고리 그룹에서 카테고리 출력 순서 
     CONSTRAINT "CATEGORY_PK" PRIMARY KEY ("IDX")
   ) ;
   
   
delete from category;
drop SEQUENCE category_idx_seq;
create SEQUENCE category_idx_seq;
   
   
insert into CATEGORY (IDX, CATEGORY, GUP, LEV, SEQ)
   values (category_idx_seq.nextval, '노트북', category_idx_seq.currval, 0, 0);

select * from category order by gup desc, seq asc;

commit;


