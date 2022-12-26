package com.example.Category_Product_Envanter.business.abstarcts;

import java.util.List;

import com.example.Category_Product_Envanter.business.requests.ProductRequests.CreateProductRequest;
import com.example.Category_Product_Envanter.business.requests.ProductRequests.DeleteProductRequest;
import com.example.Category_Product_Envanter.business.requests.ProductRequests.UpdateProductRequest;
import com.example.Category_Product_Envanter.business.responses.ProductResponses.GetAllProductResponse;
import com.example.Category_Product_Envanter.business.responses.ProductResponses.GetByIdProductResponse;
import com.example.Category_Product_Envanter.core.utilities.results.DataResult;
import com.example.Category_Product_Envanter.core.utilities.results.Result;

public interface IProductService {
	DataResult<List<GetAllProductResponse>> getAll();
	DataResult<GetByIdProductResponse> getById(int id);
	
	Result add(CreateProductRequest createProductRequest);
	Result delete(DeleteProductRequest deleteProductRequest);
	Result update(UpdateProductRequest updateProductRequest);

}
