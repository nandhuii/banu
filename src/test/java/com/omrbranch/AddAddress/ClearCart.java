package com.omrbranch.AddAddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClearCart {
    public int status;
    public String message;
    public int cart_count;
}

