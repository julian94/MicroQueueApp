package no.julian.microqueue.util;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Queue {
	@Expose
	@SerializedName("id")
	private String id;

	@Expose
	@SerializedName("name")
	private String name;


	@Expose
	@SerializedName("users")
	private User[] users;

	@Expose
	@SerializedName("isopen")
	private boolean isOpen;

	@Expose
	@SerializedName("isactive")
	private boolean isActive;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User[] getUsers() {
		return users;
	}

	public void setUsers(User[] users) {
		this.users = users;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean open) {
		isOpen = open;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}
}
