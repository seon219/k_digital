package com.tjoeun.shareAreaTest;

// CalculatorThread와 PrintTread 클래스에서 공유 영역으로 사용할 클래스
public class ShareArea {

	double result; // 0.0으로 자동초기화, 연산결과를 기억
	boolean ready; // false로 자동초기화, CalculatorThread의 계산완료 여부 기억

}
