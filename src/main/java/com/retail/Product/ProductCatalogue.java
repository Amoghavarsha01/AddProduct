package com.retail.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ProductCatalogue {
	@Autowired
	MongoTemplate mongoTemplate;
	
	@RequestMapping(consumes="application/json", method=RequestMethod.POST, name="AddProduct", produces = "application/json" )
	public String addProduct(@RequestBody Product product){
		System.out.println(product);
		/*Query query = new Query(Criteria.where("name").is("Effective Java"));
		List<Product> productResult = mongoTemplate.find(query, Product.class);*/
		//System.out.println(productResult.get(0).getCategory());
		mongoTemplate.save(product, "product");
	    return "Success";
	}
}
