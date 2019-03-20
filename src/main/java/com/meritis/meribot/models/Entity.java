package com.meritis.meribot.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document(collection="entities")
public class Entity {
	@Id
	@ApiModelProperty(notes = "The database generated product ID")
	private String _id;
	
	@ApiModelProperty(notes = "The entity name")
	private String name;

	public String get_Id() {
		return _id;
	}

	public void set_Id(String id) {
		this._id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
