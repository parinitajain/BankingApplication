package com.banking.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.banking.request.LoginUser;
import com.banking.request.UserAccount;
import com.banking.request.UserRequest;
@Path("/userManagement")
public interface MyBanking {
	
	/**
	 * Creates user
	 * @param userRequest
	 * @return Username,Account number
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/createUser")
	public Response createUser(UserRequest userRequest);
	
	/**
	 * To get user details
	 * @param username
	 * @return user account balance
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getUser/{id}")
	public Response getUser(@PathParam("id") int id);
	
	/** Validates username with password
	 * @param loginUser
	 * @return Login successful or not
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/login")
	public Response loginUser(LoginUser loginUser);
	
	/** Credit user balance. if account number is invalid or not present,then throw error
	 * @param id
	 * @param userRequest
	 * @return Balance
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addBalance/{id}")
	public Response creditBalance(@PathParam("id") int id,UserAccount userRequest);
	
	/** Debit user balance. if account number is invalid or not present,then throw error
	 * @param id
	 * @param userRequest
	 * @return Balance
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/deductBalance/{id}")
	public Response debitBalance(@PathParam("id") int id,UserAccount userRequest);

}
