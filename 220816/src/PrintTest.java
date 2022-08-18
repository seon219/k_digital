public class PrintTest {
	
	public static void main(String[] args) {
		
		// 자바는 +가 두가지 용도로 사용됨
		// + 양쪽이 모두 숫자일 경우 덧셈
		// + 한쪽이라도 문자열이 나오면 이어붙이는 문자열 연결 연산자로 사용
		System.out.println(5 + " + " + 3);
		System.out.println(5 + " + " + 3 + " = " + 5 + 3);
		System.out.println(5 + " + " + 3 + " = " + (5 + 3));
		System.out.println(5 + " - " + 3 + " = " + (5 - 3));
		
		// 정수와 정수의 연산의 결과는 정수
		System.out.println(5 + " / " + 3 + " = " + (5 / 3));
		System.out.println(5. + " / " + 3 + " = " + (5. / 3));
		System.out.println(5 + " / " + 3. + " = " + (5 / 3.));
		System.out.println(5. + " / " + 3. + " = " + (5. / 3.));
		
		// 자바가 제공하는 기본 자료형
		// boolean : 1바이트(8비트), 논리값(true/false)
		// byte : 1바이트, 데이터 전송에 사용
		// char : 2바이트, 문자 1개
		// short : 2바이트, -32768 ~ 32767 사이의 정수
		// int : 4바이트, -2147483648 ~ 2147483647 사이의 정수
		// long : 8바이트, -2의 63승 ~ 2의 63승-1 사이의 정수
		// float : 4바이트, 단정도 실수, 소수점 아래 약 6자리
		// double : 8바이트, 배정도 실수, 소수점 아래 약 16자리
		
		// 묵시적(암시적) 형변환
		// 정수는 실수로, 자료형의 크기가 서로 다른 자료의 연산결과는 크기가 큰 자료형으로 자동 변환
		// byte => short(char) => int => long => float => double
		System.out.println(5. + " / " + 3 + " = " + (5. / 3));
		System.out.println('A' + " + " + 32 + " = " + ('A' + 32)); //A:문자, 2바이트, 32:정수, 4바이트 => 정수로 바뀜
		System.out.println('a' + " - " + 32 + " = " + ('a' - 32)); //A:문자, 2바이트, 32:정수, 4바이트 => 정수로 바뀜
		
		// 명시적 형변환(casting)
		// 프로그래머가 그 순간의 자료형을 지정할 수 있음
		System.out.println(5 + " / " + 3 + " = " + (double) 5 / 3);
		System.out.println('A' + " + " + 32 + " = " + (char) ('A' + 32)); 
		System.out.println('a' + " - " + 32 + " = " + (char) ('a' - 32));
		System.out.println("==========================================");
		
		// 서식있는 출력
		// printf("출력 서식", 출력할 데이터)
		// 출력 서식은 서식 문자를 제외한 나머지 내용은 입력한 그대로 출력
		// 출력 서식 문자 : d(정수), f(실수), s(문자열), c(문자)
		// 출력 서식의 형식 : %[-][0][n][.m]서식문자
		// n: 출력할 전체 자리수, 전체 자리수가 지정되면 오른쪽에 맞춰 출력
		// -: 전체 자리수가 지정된 경우 윈쪽에 맞춰 출력
		// 0: 전체 자리수가 지정된 경우 남는 자리에 "0"을 채워 출력
		// .m: 소수점 아래 자리수, 잘리는 자리에서 반올림 해서 출력
		System.out.println(100);
		System.out.println(1);
		System.out.println(10000);
		
		System.out.printf("%d \n", 100);
		System.out.printf("%d \n", 1);
		System.out.printf("%d \n", 10000);
		
		System.out.printf("%5d \n", 100);
		System.out.printf("%5d \n", 1);
		System.out.printf("%-5d \n", 1); //왼쪽정렬
		System.out.printf("%05d \n", 1); //공백에 0
		System.out.printf("%5d \n", 10000);
		System.out.println("==========================================");

		System.out.println("asd");
		System.out.println("a");
		System.out.println("asdfg");
		
		System.out.printf("%s \n", "asd");
		System.out.printf("%s \n", "a");
		System.out.printf("%s \n", "asdfg");
		
		System.out.printf("%5s \n", "asd");
		System.out.printf("%5s \n", "a");
		System.out.printf("%-5s \n", "a");
		System.out.printf("%5s \n", "asdfg");
		
		// 문자열 출력시 "0"을 사용하면 예외 에러 발생
	    // System.out.printf("%05s \n", "a");
		System.out.println("==========================================");

		// 출력 서식 문자(%f)와 출력할 데이터 타입(정수(100))이 다르면 에러 발생
		// System.out.printf("%f \n", 100);
		System.out.printf("%f \n", 100.);
		System.out.printf("%6.2f \n", 65.12);
		System.out.printf("%6.2f \n", 65.1);
		System.out.printf("%6.2f \n", 65.125); //잘리는 자리에서 반올림
		System.out.printf("%6.0f \n", 59.5);
		System.out.println("==========================================");

		System.out.println('A' + 32);
		System.out.printf("%d \n", 'A' + 32);
		System.out.println((char)'A' + 32);
		System.out.printf("%c \n", 'A' + 32);
		System.out.println("==========================================");

		System.out.printf("%d + %d = %d \n", 5, 3, 5 + 3);
		System.out.printf("%d / %d = %f \n", 5, 3, 5 / 3.);
		// 출력 서식에 "%" 자체를 출력하려면 "%%"로 입력
		System.out.printf("%d %% %d = %d \n", 5, 3, 5 % 3);
		System.out.println("==========================================");

		// 출력 서식의 개수보다 데이터가 많으면 남는 데이터는 무시
		// 출력 서식의 개수보다 데이터가 적으면 예외(에러) 발생
		
	}

}
