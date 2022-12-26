package com.example.Category_Product_Envanter.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Category_Product_Envanter.business.abstarcts.ICategoryService;
import com.example.Category_Product_Envanter.business.requests.CategoryRequests.CreateCategoryRequest;
import com.example.Category_Product_Envanter.business.requests.CategoryRequests.DeleteCategoryRequest;
import com.example.Category_Product_Envanter.business.requests.CategoryRequests.UpdateCategoryRequest;
import com.example.Category_Product_Envanter.business.responses.CategoryResponses.GetAllCategoryResponse;
import com.example.Category_Product_Envanter.business.responses.CategoryResponses.GetAllCategoryWithProductResponse;
import com.example.Category_Product_Envanter.business.responses.CategoryResponses.GetByIdCategoryResponse;
import com.example.Category_Product_Envanter.business.responses.ProductResponses.GetByIdProductResponse;
import com.example.Category_Product_Envanter.core.utilities.results.DataResult;
import com.example.Category_Product_Envanter.core.utilities.results.Result;
import com.example.Category_Product_Envanter.core.utilities.results.SuccessDataResult;
import com.example.Category_Product_Envanter.core.utilities.results.SuccessResult;
import com.example.Category_Product_Envanter.dataAccess.abstracts.CategoryRepository;
import com.example.Category_Product_Envanter.dataAccess.abstracts.ProductRepository;
import com.example.Category_Product_Envanter.entities.concretes.Category;
import com.example.Category_Product_Envanter.entities.concretes.Product;
@Service
public class CategoryManager implements ICategoryService {
	private CategoryRepository _categoryRepo;
	private ProductRepository _productRepo;
	@Autowired
	 public CategoryManager(CategoryRepository _categoryRepo , ProductRepository _productRepo) {
                this._categoryRepo = _categoryRepo;
                this._productRepo = _productRepo;
		 
	 }


	@Override
	public DataResult<List<GetAllCategoryResponse>> getAll() {
		List<Category> categories = _categoryRepo.findAll();
		List<GetAllCategoryResponse> categoryResponse = new ArrayList<>();
		
	for (Category category : categories) {
		GetAllCategoryResponse responseItem = new GetAllCategoryResponse();
		responseItem.setId(category.getId());
		responseItem.setName(category.getCategoryName());
		categoryResponse.add(responseItem);
		
	}
	return new SuccessDataResult<List<GetAllCategoryResponse>>(categoryResponse,"Listelendi");
		
	}
	
	
	public DataResult<List<GetAllCategoryWithProductResponse>> getAllCategoryWithProductResponses(){
		List<Category> categories = _categoryRepo.findAll();
		List<Product> products = _productRepo.findAll();
		List<GetAllCategoryWithProductResponse> categoriesWithProducts = new ArrayList<GetAllCategoryWithProductResponse>();
		
		for (Category category: categories) {
			GetAllCategoryWithProductResponse responseItem = new GetAllCategoryWithProductResponse();
			responseItem.setId(category.getId());
			responseItem.setName(category.getCategoryName());
			categoriesWithProducts.add(responseItem);
		}
		return new SuccessDataResult<List<GetAllCategoryWithProductResponse>>(categoriesWithProducts,"Listelendi");
	}
	
	

	@Override
	public DataResult<GetByIdCategoryResponse> getById(int id) {
		Category category = _categoryRepo.findById(id).get();
		GetByIdCategoryResponse responseItem = new GetByIdCategoryResponse();
		responseItem.setId(category.getId());
		responseItem.setName(category.getCategoryName());
	
		return new SuccessDataResult<GetByIdCategoryResponse>(responseItem, "ıd ye gore getirildi");
	}

	@Override
	public Result add(CreateCategoryRequest createCategoryRequest) {
		Category category= new Category();
		category.setCategoryName(category.getCategoryName());
		_categoryRepo.save(category);
		return new SuccessResult("Eklendi");
	
		
	}

	@Override
	public Result delete(DeleteCategoryRequest deleteCatgoryRequest) {
		_categoryRepo.deleteById(deleteCatgoryRequest.getId());
		return new SuccessResult("Silindi");
	
		
	}

	@Override
	public Result update(UpdateCategoryRequest updateCategoryRequest) {
		Category category = _categoryRepo.findById(updateCategoryRequest.getId()).get();
		_categoryRepo.save(category);
		return new SuccessResult("Güncellendi");
	
		
	}

}
