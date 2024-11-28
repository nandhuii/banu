package com.omrbranch.GlobalData;


import lombok.Data;

import io.restassured.response.Response;

@Data
public class GlobalData {
private Response response;
private String logToken;
private String stateId;
private String stateIdText;
private int cityIdNum;
//private int address_id;
private int id;
private String valueOf;
private int stausCode;
private String address;
}
