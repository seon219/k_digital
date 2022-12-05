CREATE TABLE "CARD" (
    "CONSUMERID" VARCHAR2(200 BYTE), 
	"AMOUNT" VARCHAR2(200 BYTE)
);

CREATE TABLE "TICKET" (
    "CONSUMERID" VARCHAR2(200 BYTE), 
	"COUNTNUM" VARCHAR2(200 BYTE), 
	CONSTRAINT "CK_TICKET_COUNTNUM" CHECK (countnum < 5)
);


insert into card (CONSUMERID, AMOUNT) VALUES ('aaa', '4');
insert into ticket (CONSUMERID, COUNTNUM) VALUES ('aaa', '4');
insert into card (CONSUMERID, AMOUNT) VALUES ('bbb', '5');
insert into ticket (CONSUMERID, COUNTNUM) VALUES ('bbb', '5');

select * from card;
select * from ticket;

delete from card;
delete from ticket;
