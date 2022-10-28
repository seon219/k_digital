CREATE TABLE "FILEUPDOWNLOAD" (	
    "IDX" NUMBER(*,0) NOT NULL , 
	"FILENAME" VARCHAR2(255 BYTE), 
	"FILEREALNAME" VARCHAR2(255 BYTE), 
	"DOWNLOADCOUNT" NUMBER(*,0) DEFAULT 0, 
	 CONSTRAINT "FILEUPDOWNLOAD_PK" PRIMARY KEY ("IDX")
);


delete from fileupdownload;
drop sequence fileupdownload_idx_seq;
create SEQUENCE fileupdownload_idx_seq;