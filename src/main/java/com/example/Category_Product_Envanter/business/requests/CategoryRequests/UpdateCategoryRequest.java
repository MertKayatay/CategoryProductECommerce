package com.example.Category_Product_Envanter.business.requests.CategoryRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateCategoryRequest {
	private String name;
	private int id;

}
