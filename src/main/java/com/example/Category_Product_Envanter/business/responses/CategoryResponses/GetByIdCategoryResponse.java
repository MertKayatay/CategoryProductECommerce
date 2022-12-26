package com.example.Category_Product_Envanter.business.responses.CategoryResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetByIdCategoryResponse {
	private int id;
	private String name;

}
