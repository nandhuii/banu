package com.omrbranch.AddAddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchProduct_Output_Pojo {
	private String image;
    private String type;
    private String text;
    private int id;
    private int category_id;

}
