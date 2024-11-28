package com.omrbranch.AddAddress;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchProduct_Output {
	private int status;
   private String message;
    private ArrayList<SearchProduct_Output_Pojo> data;
private String currency;
}
