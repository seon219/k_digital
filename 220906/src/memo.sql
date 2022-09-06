# INSERT INTO 테이블이름(필드이름, ...) VALUES (데이터, ...);
# 문자열 데이터는 작은따옴표로 묶어준다.
INSERT INTO memo(NAME, PASSWORD, memo) VALUES('홍길동', '1111', '1등');
INSERT INTO memo(NAME, PASSWORD, memo) VALUES('임꺽정', '2222', '2등');
INSERT INTO memo(NAME, PASSWORD, memo) VALUES('장길산', '3333', '3등');
INSERT INTO memo(NAME, PASSWORD, memo) VALUES('일지매', '4444', '4등');
INSERT INTO memo(NAME, PASSWORD, memo) VALUES('길홍동', '5555', '5등');
INSERT INTO memo(NAME, PASSWORD, memo) VALUES('홍동길', '6666', '6등');



# SELECT [DISTINCT] 필드이름 또는 *(모든필드) FROM 테이블이름;
SELECT * FROM MEMO; # MEMO 테이블의 모든 필드 검색
SELECT NAME, MEMO FROM MEMO; # MEMO 테이블의 NAME, MEMO 필드 검색

# DISTINCT 옵션은 중복되는 데이터는 1번만 출력
SELECT DISTINCT * FROM MEMO;



# SELECT * FORM 테이블이름 ORDER BY 필드이름 [ASC/DESC]; 
# ORDER BY는 지정한 필드를 기준으로 정렬
# 정렬 방식 생략시 오름차순인 ASC가 기본값으로 사용. DESC 사용시 내림차순 정렬
SELECT * FROM MEMO ORDER BY IDX # IDX 필드를 오름차순으로 정렬
SELECT * FROM MEMO ORDER BY IDX DESC; # IDX 필드를 내림차순으로 정렬 = 최신글 순으로 정렬

# NAME 필드의 오름차순 정렬, IDX의 내림차순 정렬
SELECT * FROM MEMO ORDER BY NAME, IDX DESC;



# SELECT * FROM 테이블이름 WHERE 조건식;
# WHERE 뒤의 조건에 만족하는 데이터만 검색한다.
# 조건의 종류는 AND, OR, LIKE(부분일치)가 있다.

# 단순조건: 조건 1개
SELECT * FROM MEMO WHERE IDX = 15; # 같다 조건은 '='을 하나만 사용
SELECT * FROM MEMO WHERE NAME = '홍길동';

# 복합조건: 조건 여러개 (AND, OR, LIKE(부분일치))
# AND
SELECT * FROM MEMO WHERE IDX>=10 AND IDX<=15;
SELECT * FROM MEMO WHERE IDX>=12 && IDX<=17;
# BETWEEN 연산자는 ~이상이고 ~이하인 데이터를 얻어올 수 있다. 이상, 이하 조건만 가능
SELECT * FROM MEMO WHERE IDX BETWEEN 10 AND 15; 

# OR
SELECT * FROM MEMO WHERE NAME = '홍길동' OR NAME = '임꺽정';
SELECT * FROM MEMO WHERE NAME = '장길산' || NAME = '일지매';
# IN 연산자 : () 내부에 있는 데이터만 얻어옴
SELECT * FROM MEMO WHERE NAME IN ('홍길동', '임꺽정', '장길산');
# NOT IN 연산자 : ()내부에 없는 데이터만 얻어옴
SELECT * FROM MEMO WHERE NAME NOT IN ('홍길동', '임꺽정', '장길산');

# LIKE(부분일치) 조건 : 와일드카드(대체) 문자와 같이 사용
# 와일드 카드 문자는 '_'와 '%'RK DLtRH '_'는 1문자를, '%'는 여러 문자를 대체 가능
# 종로_가: 종로1가, 종로2가, 종로3가, 종로4가, 종로5가, 종로6가 처럼 _자리에 어떤 문자가 나와도 상관 없음
# '_'는 글자수를 제한하는 조건에도 사용. '김__' => 김으로 시작하는 3글자
# '홍%' : 홍으로 시작하는
# '%홍" : 홍으로 끝나는
# '%홍%' : 홍을 포함하는

SELECT * FROM MEMO WHERE NAME LIKE '홍%';
SELECT * FROM MEMO WHERE NAME LIKE '%홍';
SELECT * FROM MEMO WHERE NAME LIKE '%홍%';



# LIMIT를 이용해서 특정 INDEX부터 원하는 개수를 지정해서 검색 가능
# INDEX는 SELECT SQL 명령을 실행했을 때 출력 결고의 1번쨰 데이터의 IDDEX가 0부터 시작
# 오라클은 INDEX가 1부터 시작
# LIMIT 시작인덱스, 개수
SELECT * FROM MEMO ORDER BY IDX DESC 0, 10; # 1페이지 분량의 글 목록을 얻어온다.



# 그룹함수 : SUM(합계), AVG(평균), MAX(최대값), MIN(최소값), COUNT(개수)
SELECT SUM(IDX) FROM MEMO WHERE IDX <= 10;
SELECT AVG(IDX) FROM MEMO WHERE IDX <= 10;
SELECT MAX(IDX) FROM MEMO WHERE IDX <= 10;
SELECT MIN(IDX) FROM MEMO WHERE IDX <= 10;
SELECT COUNT(IDX) FROM MEMO WHERE IDX <= 10;
# 개수는 어떤 필드의 개수를 세더라도 같은 결과가 나오기 때문에 인수로 '*'을 사용
SELECT COUNT(*) FROM MEMO WHERE IDX <= 10;

# 그룹 함수를 실행한 결과나 필드 이름을 다른 이름으로 변경해서 보려면 as 예약어를 사용해서 별명을 지정할 수 있다.
SELECT COUNT(*) AS '인원수' FROM MEMO WHERE IDX <= 10;



# GROUP BY를 사용해서 그룹화 할 수 있다 => 그룹별 소개
# SELECT 그룹함수(필드이름) FROM 테이블이름 WHERE 전체조건 GROUP BY 그룹화할 필드이름 [HAVING 그룹조건];
SELECT COUNT(*) FROM MEMO; # 테이블에 저장된 전체 데이터의 개수를 얻어온다.
# NAME과 개수를 MEMO 테이블에서 NAME별로 그룹화해서 검색
SELECT NAME, COUNT(*) FROM MEMO GROUP BY NAME;
# NAME과 개수를 MEMO 테이블에서 NAME별로 그룹화해서 그룹화된 데이터의 개수가 10가 이상인 것만 검색
SELECT NAME, COUNT(*) FROM MEMO GROUP BY NAME HAVING COUNT(*) >= 10;
# NAME과 개수를 MEMO 테이블에서 NAME에 '길'을 포함하는 NAME별로 그룹화해서 그룹화된 데이터의 개수가 10개 이상인 것만 검색
SELECT NAME, COUNT(*) FROM MEMO WHERE NAME LIKE '%길%' GROUP BY NAME HAVING COUNT(*) >= 10;


# UPDATE 테이블이름 SET 수정할내용[, 수정할내용, ....] [WHERE 조건식];

# DELETE FROM 테이블이름;
DELETE FROM MEMO WHERE NAME = '동홍길';
SELECT * FROM MEMO;



# 자동증가를 1부터 다시시작 => 테이블에 데이터가 없어야 함
DELETE FROM MEMO;
ALTER TABLE memo AUTO_INCREMENT = 1;