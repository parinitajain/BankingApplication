package com.banking.controller.impl;

import java.util.Random;

import javax.ws.rs.core.Response;
import org.springframework.stereotype.Service;

import com.banking.controller.MyBanking;
import com.banking.dao.impl.UserDaoImpl;
import com.banking.dto.User;
import com.banking.request.LoginUser;
import com.banking.request.UserAccount;
import com.banking.request.UserRequest;
import com.banking.response.LoginUserResponse;
import com.banking.response.UserResponse;

@Service
public class MyBankingImpl implements MyBanking {

	private UserDaoImpl userDao;

	@Override
	public Response createUser(UserRequest userRequest) {
		UserResponse user = new UserResponse();
		User userDto = new User();
		userDto = setUserObjectForCreate(userRequest);
		int userId = userDao.addUser(userDto);
		userDto = userDao.getUserById(userId);
		if (userDto != null) {
			user.setUsername(userDto.getId());
			user.setAccountNumber(userDto.getAcc_num());
		} else {
			user.setMessage("Problem Creating User");
		}
		return Response.ok().entity(user).build();
	}

	@Override
	public Response getUser(int id) {
		UserResponse user = new UserResponse();
		User userDto = userDao.getUserById(id);
		if (userDto != null) {
			user.setUsername(userDto.getId());
			user.setAccountNumber(userDto.getAcc_num());
			user.setBalance(userDto.getBalance());
		} else {
			user.setMessage("Invalid User Details");
		}
		return Response.ok().entity(user).build();
	}

	@Override
	public Response loginUser(LoginUser loginUser) {
		LoginUserResponse login = new LoginUserResponse();
		User userDto = userDao.getUserById(loginUser.getUserName());
		if (loginUser.getPassword().equalsIgnoreCase(userDto.getPassword())) {
			login.setMessage("Login Successful");
		} else {
			login.setMessage("Login failed");
		}
		return Response.ok().entity(login).build();
	}

	@Override
	public Response creditBalance(int id, UserAccount userRequest) {
		User userDto = userDao.getUserById(id);
		UserResponse user = new UserResponse();
		if (userDto != null && userRequest.getAccountNumber() != null
				&& userRequest.getAccountNumber().equalsIgnoreCase(userDto.getAcc_num())) {
			float balance = userDto.getBalance();
			balance = balance + userRequest.getBalance();
			userDto.setBalance(balance);
			int rowsUpdated = userDao.updateUserBalance(userDto);
			if (rowsUpdated >= 1) {
				user.setBalance(balance);
				user.setAccountNumber(userDto.getAcc_num());
				user.setUsername(id);
				user.setMessage("Amount successfully credited");
			} else {
				user.setMessage("Problem in crediting balance");
			}
		} else {
			user.setMessage("Invalid User Details");
		}
		return Response.ok().entity(user).build();
	}

	@Override
	public Response debitBalance(int id, UserAccount userRequest) {
		User userDto = userDao.getUserById(id);
		UserResponse user = new UserResponse();
		if (userDto != null && userRequest.getAccountNumber() != null
				&& userRequest.getAccountNumber().equalsIgnoreCase(userDto.getAcc_num())) {
			float balance = userDto.getBalance();
			if (balance >= userRequest.getBalance()) {
				balance = balance - userRequest.getBalance();
				userDto.setBalance(balance);
				int rowsUpdated = userDao.updateUserBalance(userDto);
				if (rowsUpdated >= 1) {
					user.setBalance(balance);
					user.setAccountNumber(userDto.getAcc_num());
					user.setUsername(id);
					user.setMessage("Amount successfully debited");
				} else {
					user.setMessage("Problem in debiting balance");
				}
			} else {
				user.setMessage("Account does not have sufficient balance");
			}
		} else {
			user.setMessage("Invalid User Details");
		}
		return Response.ok().entity(user).build();
	}

	public UserDaoImpl getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

	public User setUserObjectForCreate(UserRequest userRequest) {
		User user = new User();
		Random rand = new Random();
		int rand1 = rand.nextInt(1000);
		user.setFirst_name(userRequest.getGivenName());
		user.setLast_name(userRequest.getLastName());
		user.setAcc_type(userRequest.getType());
		user.setAddress(userRequest.getAddress());
		user.setCity(userRequest.getCity());
		user.setEmail(userRequest.getEmail());
		user.setPan_number(userRequest.getPanNumber());
		user.setPincode(userRequest.getPinCode());
		user.setState_id(userRequest.getState());
		user.setAcc_num(userRequest.getLastName() + "_" + rand1);
		user.setBalance(0);
		user.setPassword(userRequest.getPassword());
		return user;
	}

}
