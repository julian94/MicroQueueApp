package no.julian.microqueue.util;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResult {
	@Expose
	@SerializedName("token")
	private String token;
	
	@Expose
	@SerializedName("user")
	private User user;
	
	public String getToken() {
		return token;
	}
	
	public User getUser() {
		return user;
	}
	
}
