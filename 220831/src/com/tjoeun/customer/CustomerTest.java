package com.tjoeun.customer;

public class CustomerTest {

	public static void main(String[] args) {
		
		// 일반고객 객체생성
		Customer customerLee = new Customer();
		customerLee.setId(10010);
		customerLee.setName("이몽룡");
		customerLee.setPoint(1000);

		System.out.println("회원정보: " + customerLee.showCustomerInfo());
		System.out.println("보너스 포인트: " + customerLee.calcBonus(35000));
		System.out.println("누적 보너스 포인트: " + customerLee.calcPrice(35000));
		System.out.println("===============================");
		
		
		VIPCustomer customerLim = new VIPCustomer();
		customerLim.setId(50050);
		customerLim.setName("임꺽정");
		customerLim.setPoint(10000);
		
		System.out.println("회원정보: " + customerLim.showCustomerInfo());
		System.out.println("실 구매금액: " + customerLim.calcSales(10000));
		System.out.println("보너스 포인트: " + customerLim.calcBonus(10000));
		System.out.println("누적 보너스 포인트: " + customerLim.calcPrice(10000));
		
		
	}

}
