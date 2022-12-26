package com.example.Category_Product_Envanter.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Category_Product_Envanter.business.abstarcts.ICategoryService;
import com.example.Category_Product_Envanter.business.requests.CategoryRequests.CreateCategoryRequest;
import com.example.Category_Product_Envanter.business.requests.CategoryRequests.DeleteCategoryRequest;
import com.example.Category_Product_Envanter.business.requests.CategoryRequests.UpdateCategoryRequest;
import com.example.Category_Product_Envanter.business.responses.CategoryResponses.GetAllCategoryResponse;
import com.example.Category_Product_Envanter.business.responses.CategoryResponses.GetByIdCategoryResponse;
import com.example.Category_Product_Envanter.core.utilities.results.DataResult;
import com.example.Category_Product_Envanter.core.utilities.results.Result;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
	private ICategoryService categoryService;
	@Autowired
	public CategoriesController(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}
	@GetMapping("/getall")
	public DataResult<List<GetAllCategoryResponse>> getAll(){
		return categoryService.getAll();
	}
	@GetMapping("/getbyid/{id}")
	public DataResult<GetByIdCategoryResponse> getById(@RequestParam int id) {
		return categoryService.getById(id);
	}
	@PostMapping("/add")
	public Result add(@RequestBody CreateCategoryRequest createCategoryRequest) {
		return categoryService.add(createCategoryRequest);
	}
	@PostMapping("/update")
	public Result update(@RequestBody UpdateCategoryRequest updateCategoryRequest) {
		return categoryService.update(updateCategoryRequest);
	}
	@DeleteMapping("/delete")
	public Result delete(@RequestBody DeleteCategoryRequest deleteCategoryRequest) {
		return categoryService.delete(deleteCategoryRequest);
	}
}
