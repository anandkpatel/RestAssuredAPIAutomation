package com.sample.testBase;


import com.sample.utilities.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;


public class BaseClass {

    // Shared references
    public static RequestSpecification httpRequest;
    public static Response response;


    public Logger logger;


    @BeforeClass
    public void setup(){

        // Log Configuration
        logger=Logger.getLogger("Sample API Testing");
        PropertyConfigurator.configure("src\\test\\resources\\log4j.properties");
        logger.setLevel(Level.DEBUG);

        // Configure BaseURI To send the request
        RestAssured.baseURI = PropertyReader.getProp("BaseURI");
        System.out.println("Base URI For the Test --> " +RestAssured.baseURI );
        httpRequest = RestAssured.given();


    }




}
