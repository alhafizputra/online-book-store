package com.glints.onlinebookstore.payload;

import javax.validation.constraints.NotBlank;

public class BookCategoryPayload {
	
	@NotBlank(message = "name is mandatory")
	private String name;

	@NotBlank(message = "code is mandatory")
	private String code;

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

}
