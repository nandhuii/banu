package com.omrbranch.payload.address;

import com.omrbranch.pojo.address.AddUserAddress_Input_Pojo;
import com.omrbranch.pojo.address.CityList_Input_Pojo;
import com.omrbranch.pojo.address.DeleteAddress_Input_Pojo;
import com.omrbranch.pojo.address.UpdateUserAddress_Input_Pojo;

public class AddressPayload {

		public CityList_Input_Pojo addCityPayload(String valueOf) {
			CityList_Input_Pojo cityList_Input_Pojo = new CityList_Input_Pojo(valueOf);
			return cityList_Input_Pojo;

		}

		public AddUserAddress_Input_Pojo addAddressPayload(String fistName, String lastName, String mobileNo,
				String apptName, String stateId, String cityId, String countryId, String zipCode, String address,String addressType) {
			AddUserAddress_Input_Pojo addUserAddress_Input_Pojo = new AddUserAddress_Input_Pojo(fistName, lastName,
					mobileNo, apptName, Integer.parseInt(stateId), Integer.parseInt(cityId), Integer.parseInt(countryId), zipCode, address, addressType);
			return addUserAddress_Input_Pojo;
		}

		public UpdateUserAddress_Input_Pojo updateAddressPayload(String addressId, String fistName, String lastName,
				String mobileNo, String apptName, String stateId, String cityId,String countryId, String zipCode, String address,String addressType) {
			UpdateUserAddress_Input_Pojo updateAddress_Input_Pojo = new UpdateUserAddress_Input_Pojo(addressId, fistName, lastName,
					mobileNo, apptName, Integer.parseInt(stateId), Integer.parseInt(cityId),Integer.parseInt(countryId), zipCode, address, addressType);
			return updateAddress_Input_Pojo;

		}

		public DeleteAddress_Input_Pojo deleteAddress(String addressId) {
			DeleteAddress_Input_Pojo deleteAddress_Input_Pojo = new DeleteAddress_Input_Pojo(addressId);
			return deleteAddress_Input_Pojo;

		}

	}


