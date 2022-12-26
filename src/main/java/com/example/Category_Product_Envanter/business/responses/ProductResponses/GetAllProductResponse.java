package com.example.Category_Product_Envanter.business.responses.ProductResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductResponse {
	
	private int id;
	private String name;
	private String categoryName;

}
