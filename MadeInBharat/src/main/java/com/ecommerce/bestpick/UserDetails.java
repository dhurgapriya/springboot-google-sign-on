package com.ecommerce.bestpick;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Table - UserDetails, 
 * Columns - user_id(primary key),user_name,role
 *
 */
@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

	/**
	 * userId holds the emailId of the google user
	 *
	 */
	@Id
	@Column(name = "user_id")
	private String userId;
	/**
	 * userName holds the user name of the google user
	 *
	 */
	@Column(name = "user_name")
	private String userName;
	/**
	 * role holds the custom role given the google user
	 *
	 */
	@Column(name = "role")
	private String role;

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", role=" + role + "]";
	}

}
