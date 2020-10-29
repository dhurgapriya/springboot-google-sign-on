package com.ecommerce.bestpick;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller class to redirect to respective endpoints
 */
@Controller
public class UserController {

	private static final String USER_DETAILS = "userDetails";
	private static final String SELLER = "seller";
	private static final String CONSUMER = "consumer";

	@Autowired
	private BestPickService bestPickService;

	/**
	 * Called to redirect to consumer page using user Id and user name.
	 * 
	 * @param model
	 *            a holder for model attributes*
	 * 
	 * @param userName
	 *            the user name of the google user*
	 * 
	 * @param userId
	 *            the email id of the google user*
	 */
	@GetMapping("/consumer/{userName}/{userId}")
	public String consumer(Model model, @PathVariable("userName") String userName,
			@PathVariable("userId") String userId) {

		// System.out.println("consumer username :" + userName);
		// System.out.println("consumer userId :" + userId);

		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(userId);
		userDetails.setUserName(userName);
		model.addAttribute(USER_DETAILS, userDetails);
		return CONSUMER;
	}

	/**
	 * Called to redirect to seller page using user Id and user name.
	 * 
	 * @param model
	 *            a holder for model attributes*
	 * 
	 * @param userName
	 *            the user name of the google user*
	 * 
	 * @param userId
	 *            the email id of the google user*
	 */
	@GetMapping("/seller/{userName}/{userId}")
	public String seller(Model model, @PathVariable("userName") String userName,
			@PathVariable("userId") String userId) {

		// System.out.println("seller username :" + userName);
		// System.out.println("seller userId :" + userId);

		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(userId);
		userDetails.setUserName(userName);
		model.addAttribute(USER_DETAILS, userDetails);
		return SELLER;
	}

	/**
	 * Called to redirect to edit page to assign/modify the role of the user.
	 * 
	 * @param model
	 *            a holder for model attributes*
	 * 
	 * @param userName
	 *            the user name of the google user*
	 * 
	 * @param userId
	 *            the email id of the google user*
	 */
	@GetMapping("/edit/{userName}/{userId}")
	public String edit(Model model, @PathVariable("userName") String userName, @PathVariable("userId") String userId) {

		// System.out.println("edit username :" + userName);
		// System.out.println("edit userId :" + userId);

		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(userId);
		userDetails.setUserName(userName);
		model.addAttribute(USER_DETAILS, userDetails);
		return "edit";
	}

	/**
	 * Called to save/update the role of the user and redirect to seller/consumer
	 * page based on the user role.
	 * 
	 * @param model
	 *            a holder for model attributes*
	 * 
	 * @param userName
	 *            the user name of the google user*
	 * 
	 * @param userId
	 *            the email id of the google user*
	 * 
	 * @param userDetails
	 *            the user details of the authenticated user*
	 * 
	 * @param bindingResult
	 *            the buildingResult in a model*
	 */
	@PostMapping("/update/{userName}/{userId}")
	public String update(@PathVariable("userName") String userName, @PathVariable("userId") String userId,
			@Valid UserDetails userDetails, BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			// System.out.println("update username :" + userName);
			// System.out.println("update userId :" + userId);
			userDetails.setUserId(userId);
			userDetails.setUserName(userName);
			// save the user role in db
			bestPickService.save(userDetails);
			// redirect the user for the role
			if (SELLER.equalsIgnoreCase(userDetails.getRole())) {
				return SELLER;
			} else if (CONSUMER.equalsIgnoreCase(userDetails.getRole())) {
				return CONSUMER;
			}
		}
		return "edit";
	}

}
