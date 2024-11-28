package com.omrbranch.AddAddress;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class StateListAndCityList_Output_Pojo {
	 private int status;
	    private String message;
	    private ArrayList<Datum> data;
}
