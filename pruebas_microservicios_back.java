package com.bancolombia.pfm.TestBack;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.http.Header;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.response.Response.*;


public class pruebas_microservicios_back {
	private static final Logger logger = Logger.getLogger(pruebas_microservicios_back.class);

	@Test
	public void testResponseCodeLz() {
		int code = given().header("x-api-key", "mada2h8NWR7Ceg3ZB4Vb7nFcnjtpnFG1a9CcriGd").when().get(" https://g12avth2t9.execute-api.us-east-1.amazonaws.com/productizar-int-api-pfm-consolidado/productizar-pfm?tipo_doc=1&periodo=m&documento=185763766648698279").getStatusCode();
		System.out.println("status Code is " +  code);
		Assert.assertEquals(200, code);
	}
	
	@Test
	public void testIngresos() {
		
		given().header("x-api-key", "mada2h8NWR7Ceg3ZB4Vb7nFcnjtpnFG1a9CcriGd").when().get(" https://g12avth2t9.execute-api.us-east-1.amazonaws.com/productizar-int-api-pfm-consolidado/productizar-pfm").then().body("documento",EqualTo("185763766648698279"));
		
	}
	
	@Test
	public void testDataLz() {
		String data =given().header("x-api-key", "mada2h8NWR7Ceg3ZB4Vb7nFcnjtpnFG1a9CcriGd").when().get(" https://g12avth2t9.execute-api.us-east-1.amazonaws.com/productizar-int-api-pfm-consolidado/productizar-pfm?tipo_doc=1&periodo=m&documento=185763766648698279").asString();
		long time = given().header("x-api-key", "mada2h8NWR7Ceg3ZB4Vb7nFcnjtpnFG1a9CcriGd").when().get(" https://g12avth2t9.execute-api.us-east-1.amazonaws.com/productizar-int-api-pfm-consolidado/productizar-pfm?tipo_doc=1&periodo=m&documento=185763766648698279").getTime();
		System.out.println("Data is " +  data);
		System.out.println("Response time " +  time);	
		logger.debug(data);
		if(!data.isEmpty()) {
			System.out.println("true");
		}	
	}
	
	
	
}
