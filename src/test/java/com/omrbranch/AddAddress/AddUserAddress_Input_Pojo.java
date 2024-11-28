package com.omrbranch.AddAddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserAddress_Input_Pojo {
	private String first_name;
	private String last_name;
	private String mobile;
	private String apartment;
	private String state;
	private String city;
	private String country;
	private String zipcode;
	private String address;
	private String address_type;
}

