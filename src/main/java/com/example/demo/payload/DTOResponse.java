package com.example.demo.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DTOResponse<T> {
	T message;
	String status;

}
