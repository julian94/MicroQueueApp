package no.julian.microqueue.util;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginCredentials {
	
	@Expose
	@SerializedName("id")
	private String id;
	
	@Expose
	@SerializedName("hashedPassword")
	private String hashedPassword;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getHashedPassword() {
		return hashedPassword;
	}
	
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
}
