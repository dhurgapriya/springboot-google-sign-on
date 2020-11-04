package com.ecommerce.bestpick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BestPickService {

	@Autowired
	private UserRepo userRepo;

	/**
	 * Called to save/update the user details in the database
	 * 
	 * @param userDetails
	 *            the user details of the user*
	 */
	public void save(UserDetails userDetails) {
		userRepo.save(userDetails);
		// System.out.println("saved :" + userDetails.toString());
	}

	/**
	 * Called to find the user role in the database
	 * 
	 * @param userId
	 *            the email id of the google user*
	 */
	public String findUser(String userId) {
		return userRepo.findRole(userId);
	}
}
