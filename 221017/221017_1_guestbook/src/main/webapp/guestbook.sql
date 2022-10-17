CREATE TABLE "TJOEUN"."GUESTBOOK"(	
    "IDX" NUMBER(*,0) NOT NULL ENABLE, 
	"NAME" CHAR(20 BYTE) NOT NULL ENABLE, 
	"PASSWORD" CHAR(20 BYTE) NOT NULL ENABLE, 
	"MEMO" VARCHAR2(1000 BYTE) NOT NULL ENABLE, 
	"WRITEDATE" TIMESTAMP (6) DEFAULT sysdate, 
	"IP" CHAR(20 BYTE), 
	 CONSTRAINT "GUESTBOOK_PK" PRIMARY KEY ("IDX")
);
   
   
-- ������ �ʱ�ȭ ���
-- ��� �����͸� �����ϰ� �������� ����� �ٽ� �����.
delete from guestbook;
drop SEQUENCE guestbook_idx_seq;
-- �ڵ����� 1�� ������Ű�� ���� �������� �����.
create SEQUENCE guestbook_idx_seq;


SELECT * FROM guestbook;
SELECT count(*) FROM guestbook;

insert into guestbook (idx, name, password, memo, ip)
values (guestbook_idx_seq.nextval, 'ȫ�浿', '1111', '1��', '192.168.100.001');
insert into guestbook (idx, name, password, memo, ip)
values (guestbook_idx_seq.nextval, '�Ӳ���', '2222', '2��', '192.168.100.002');
insert into guestbook (idx, name, password, memo, ip)
values (guestbook_idx_seq.nextval, '����', '3333', '3��', '192.168.100.003');
insert into guestbook (idx, name, password, memo, ip)
values (guestbook_idx_seq.nextval, '������', '4444', '4��', '192.168.100.004');



