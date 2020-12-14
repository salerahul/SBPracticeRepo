package com.rahul.helper;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class ProductServiceControllerTest extends AbstractTest {
	
	@Before
	@Override
	protected void setUp() {
		super.setUp();
	}
	
	@Test
	public void getProductList() throws Exception {
		String url = "/products";
		
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();
	      Product[] productlist = super.mapFromJson(content, Product[].class);
	      assertTrue(productlist.length > 0);
	}
	
	@Test
	   public void createProduct() throws Exception {
	      String uri = "/products";
	      Product product = new Product();
	      product.setId("3");
	      product.setName("Ginger");
	      String inputJson = super.mapToJson(product);
	      MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(201, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "Product is created successfully");
	   }

}
