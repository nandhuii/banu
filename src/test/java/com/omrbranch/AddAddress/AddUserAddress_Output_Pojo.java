
package com.omrbranch.AddAddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddUserAddress_Output_Pojo {
	private int status;
	private String message;
	private String address_id;
}
