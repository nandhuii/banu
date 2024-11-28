package com.omrbranch.product;

import com.omrbranch.AddAddress.SearchProduct_Input_Pojo;

public class ProductPayload {
public SearchProduct_Input_Pojo addProductSearchPayload(String text) {
	SearchProduct_Input_Pojo searchProduct=new SearchProduct_Input_Pojo(text);
	return searchProduct;
}

}
