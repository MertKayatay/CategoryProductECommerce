package com.example.Category_Product_Envanter.business.requests.ProductRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
	private String name;
	private int id;
	private int categoryId;

}
