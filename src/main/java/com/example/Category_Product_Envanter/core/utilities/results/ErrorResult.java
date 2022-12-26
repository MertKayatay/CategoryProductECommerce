package com.example.Category_Product_Envanter.core.utilities.results;

public class ErrorResult extends Result {
	public ErrorResult() {
		super(false);
	}
	
    public ErrorResult(String message) {
		super(false, message);
	}

}
