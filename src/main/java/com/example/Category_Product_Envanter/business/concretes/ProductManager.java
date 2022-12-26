package com.example.Category_Product_Envanter.business.concretes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Category_Product_Envanter.business.abstarcts.IProductService;
import com.example.Category_Product_Envanter.business.requests.ProductRequests.CreateProductRequest;
import com.example.Category_Product_Envanter.business.requests.ProductRequests.DeleteProductRequest;
import com.example.Category_Product_Envanter.business.requests.ProductRequests.UpdateProductRequest;
import com.example.Category_Product_Envanter.business.responses.CategoryResponses.GetAllCategoryResponse;
import com.example.Category_Product_Envanter.business.responses.ProductResponses.GetAllProductResponse;
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
public class ProductManager implements IProductService {
	private CategoryRepository _categoryRepository;
	private ProductRepository _productRepository;
	
	@Autowired 
	public ProductManager(CategoryRepository categoryRepository, ProductRepository productRepository) {
		_categoryRepository = categoryRepository;
		_productRepository = productRepository;
	}
	
	@Override
	public DataResult<List<GetAllProductResponse>> getAll() {
		List<Product> products = _productRepository.findAll();
		List<GetAllProductResponse> productResponses = new ArrayList<>();
		
	    for (Product product : products) {
	    	GetAllProductResponse responseItem = new GetAllProductResponse();
	    	responseItem.setId(product.getId());
	    	responseItem.setName(product.getName());
	    	responseItem.setCategoryName(product.getCategory().getCategoryName());
			productResponses.add(responseItem);
		}
		
		
		return new SuccessDataResult<List<GetAllProductResponse>>(productResponses, "Listelendi");
	}

	@Override
	public DataResult<GetByIdProductResponse> getById(int id) {
		Product products = _productRepository.findById(id).get();
		GetByIdProductResponse responseItem = new GetByIdProductResponse();
		responseItem.setId(products.getId());
		responseItem.setName(products.getName());
		responseItem.setCategoryName(products.getCategory().getCategoryName());
		return new SuccessDataResult<GetByIdProductResponse>(responseItem, "ıd ye gore getirildi");
	}

	@Override
	public Result add(CreateProductRequest createProductRequest) {
		Product product = new Product();
		Category category = _categoryRepository.findById(createProductRequest.getCategoryId()).get();
		//product.setId(createProductRequest.getId());
		product.setName(createProductRequest.getName());
		product.setCategory(category);
		_productRepository.save(product);
		return new SuccessResult("Eklendi");
	}

	@Override
	public Result delete(DeleteProductRequest deleteProductRequest) {
		_productRepository.deleteById(deleteProductRequest.getId());
		return new SuccessResult("Silindi");
		
	}

	@Override
	public Result update(UpdateProductRequest updateProductRequest) {
		Product product = _productRepository.findById(updateProductRequest.getId()).get();
		Category category = _categoryRepository.findById(updateProductRequest.getCategoryId()).get();
		
		product.setName(updateProductRequest.getName());
		product.setCategory(category);
		_productRepository.save(product);
		return new SuccessResult("Güncellendi");
		
	}
	public void checkEmptyProductName(String name) throws Exception{
		if(name.isEmpty()) {
			throw new Exception("cannot be empty");
		}
	}

}
