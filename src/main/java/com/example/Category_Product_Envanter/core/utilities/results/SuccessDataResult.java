package com.example.Category_Product_Envanter.core.utilities.results;

public class SuccessDataResult<T> extends DataResult {

	public SuccessDataResult(T data, String message) {
		super(data, true, message);
	}
	
	public SuccessDataResult(T data) {
		super(data, true);
	}

}
