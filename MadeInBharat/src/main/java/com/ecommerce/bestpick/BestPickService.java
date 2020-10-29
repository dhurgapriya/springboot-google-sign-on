package com.ecommerce.bestpick;

import java.util.List;

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
	 * Called to find the user details in the database
	 * 
	 * @param userId
	 *            the email id of the google user*
	 */
	public UserDetails findUser(String userId) {
		List<UserDetails> userDetails = userRepo.findAll();
		// System.out.println("count : " + userRepo.count());
		// System.out.println("userId : " + userId);
		if (0 != userRepo.count() && userId != null) {
			for (UserDetails userDetail : userDetails) {
				if (userId.equalsIgnoreCase(userDetail.getUserId())) {
					return userDetail;
				}
			}
		}
		return null;
	}
}
