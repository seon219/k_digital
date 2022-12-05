CREATE TABLE "CARD" (
    "CONSUMERID" VARCHAR2(200 BYTE), 
	"AMOUNT" VARCHAR2(200 BYTE)
);

CREATE TABLE "TICKET" (
    "CONSUMERID" VARCHAR2(200 BYTE), 
	"COUNTNUM" VARCHAR2(200 BYTE), 
	CONSTRAINT "CK_TICKET_COUNTNUM" CHECK (countnum < 5)
);


