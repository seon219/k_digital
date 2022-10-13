SELECT * FROM memolist;
SELECT * FROM memolist ORDER BY idx DESC;
SELECT COUNT(*) FROM memolist;

INSERT INTO memolist (NAME, PASSWORD, memo, ip) VALUES ('홍길동', '1111', '1등', '192.168.100.001');
INSERT INTO memolist (NAME, PASSWORD, memo, ip) VALUES ('임꺽정', '2222', '2등', '192.168.100.002');
INSERT INTO memolist (NAME, PASSWORD, memo, ip) VALUES ('장길산', '3333', '3등', '192.168.100.003');
INSERT INTO memolist (NAME, PASSWORD, memo, ip) VALUES ('일지매', '4444', '4등', '192.168.100.004');

DELETE FROM memolist;
ALTER TABLE memolist AUTO_INCREMENT = 1;