package com.example.Category_Product_Envanter.business.abstarcts;

import java.util.List;

import com.example.Category_Product_Envanter.business.requests.CategoryRequests.CreateCategoryRequest;
import com.example.Category_Product_Envanter.business.requests.CategoryRequests.DeleteCategoryRequest;
import com.example.Category_Product_Envanter.business.requests.CategoryRequests.UpdateCategoryRequest;
import com.example.Category_Product_Envanter.business.responses.CategoryResponses.GetAllCategoryResponse;
import com.example.Category_Product_Envanter.business.responses.CategoryResponses.GetByIdCategoryResponse;
import com.example.Category_Product_Envanter.core.utilities.results.DataResult;
import com.example.Category_Product_Envanter.core.utilities.results.Result;

public interface ICategoryService {
	DataResult<List<GetAllCategoryResponse>> getAll();
	DataResult<GetByIdCategoryResponse> getById(int id);
	
	Result add(CreateCategoryRequest createCategoryRequest);
	Result delete(DeleteCategoryRequest deleteCatgoryRequest);
	Result update(UpdateCategoryRequest updateCategoryRequest);

}
