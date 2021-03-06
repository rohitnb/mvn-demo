package com.demo.userDemoApp;

import java.util.ArrayList;
import java.util.List;

public class UsersRepository {

	List<User> users;

	public UsersRepository() {
		users = new ArrayList<>();
		User u1 = new User();
		u1.setId(1);
		u1.setName("random2");
		u1.setPhoneNo("1234567");
		u1.setEmailId("random@random3.com");

		User u2 = new User();
		u2.setId(2);
		u2.setName("random");
		u2.setPhoneNo("123456");
		u2.setEmailId("ramdom@random.com");

		users.add(u1);
		users.add(u2);
	}

	public List<User> getUsers() {
		return users;
	}

	public User createUser(User newUser) {
		users.add(newUser);

		return newUser;
	}

	public List<User> updateUser(User updateUserData) {
		int index = -1;
		boolean existingUserflag = false;
		for (User u : users) {
			if (updateUserData != null && updateUserData.getId() != null && u.getId().equals(updateUserData.getId())) {
				index = users.indexOf(u);
				existingUserflag = true;
				break;
			}
		}
		if (existingUserflag = true && index >= 0) {
			users.set(index, updateUserData);
		} else {
			users.add(updateUserData);
		}
		return users;

	}

	public User getUserById(int id) {

		for (User u : users) {
			if (u.getId().equals(id)) {
				return u;
			}
		}
		return null;
	}

	public boolean deleteUser(User userTobeDelete) {
		boolean deletedFlag = false;
		for (User u : users) {
			if (u.getId().equals(userTobeDelete.getId())) {
				users.remove(userTobeDelete);
				deletedFlag = true;
				return deletedFlag;
			}
		}
		return deletedFlag;

	}
}
