package com.tjoeun.InterfaceTest2;

public class UserInfoMySqlDAO implements UserInfoDAO {

	@Override
	public void insertUserInfo(UserInfoVO userInfoVO) {
		System.out.println("insert into MYSQL DB user id = " + userInfoVO.getUserId());
	}

	@Override
	public void updateUserInfo(UserInfoVO userInfoVO) {
		System.out.println("update into MYSQL DB user id = " + userInfoVO.getUserId());
	}

	@Override
	public void deleteUserInfo(UserInfoVO userInfoVO) {
		System.out.println("delete into MYSQL DB user id = " + userInfoVO.getUserId());		
	}

}
