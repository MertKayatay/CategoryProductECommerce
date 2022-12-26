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

import com.example.Category_Product_Envanter.business.abstarcts.IProductService;
import com.example.Category_Product_Envanter.business.requests.CategoryRequests.DeleteCategoryRequest;
import com.example.Category_Product_Envanter.business.requests.ProductRequests.CreateProductRequest;
import com.example.Category_Product_Envanter.business.requests.ProductRequests.DeleteProductRequest;
import com.example.Category_Product_Envanter.business.requests.ProductRequests.UpdateProductRequest;
import com.example.Category_Product_Envanter.business.responses.ProductResponses.GetAllProductResponse;
import com.example.Category_Product_Envanter.business.responses.ProductResponses.GetByIdProductResponse;
import com.example.Category_Product_Envanter.core.utilities.results.DataResult;
import com.example.Category_Product_Envanter.core.utilities.results.Result;
@RestController
@RequestMapping("/api/products")
public class ProductsController {
	private IProductService productService;
	@Autowired
	public ProductsController(IProductService productService) {
		this.productService = productService;
	}
	@GetMapping("/getall")
	public DataResult<List<GetAllProductResponse>> getAll(){
		return productService.getAll();
	}
	@GetMapping("/getbyid/{id}")
	public DataResult<GetByIdProductResponse> getById(@RequestParam int id) {
		return productService.getById(id);
	}
	@PostMapping("/add")
	public Result add(@RequestBody CreateProductRequest createProductRequest) {
		return productService.add(createProductRequest);
		
	}
	@PostMapping("/update")
	public Result update(@RequestBody UpdateProductRequest updateProductRequest) {
		return productService.update(updateProductRequest);
	}
	@DeleteMapping("/delete")
	public Result delete(@RequestBody DeleteProductRequest deleteProductRequest) {
		return productService.delete(deleteProductRequest);
	}

}
