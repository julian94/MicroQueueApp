package no.julian.microqueue.util;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
	@Expose
	@SerializedName("id")
	private String id;

	@Expose
	@SerializedName("name")
	private String name;

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
}
