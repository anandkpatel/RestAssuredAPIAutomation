package com.sample.testCases;

import com.sample.testBase.BaseClass;
import com.sample.utilities.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC001_Get_All_Employee  extends BaseClass {

    @BeforeClass
    public void getAllEmployee() throws InterruptedException
    {
        logger.info("********* Started TC001_Get_All_Employee  **********");


        // Send request and record response
        System.out.println();
        response = httpRequest.request(Method.GET, PropertyReader.getProp("Parameter1"));
        System.out.println("Parameter for the request --> " + PropertyReader.getProp("Parameter1"));
        Thread.sleep(5000);

    }


    @Test(priority = 1)
    public void checkResposeBody()
    {
        logger.info("********* Checking Response Body  **********");
        String responseBody = response.getBody().asString(); // Getting Response Body
        logger.info("Response Body --> " + responseBody);
        System.out.println("responseBody is :" + responseBody);
        Assert.assertTrue(responseBody!= null);

    }

    @Test(priority = 2)
    public void checkStatusCode()
    {
        logger.info("********* Checking Status Code  **********");
        int statusCode = response.getStatusCode(); // Gettng status code
        Assert.assertEquals(statusCode, 200);
    }

    @Test(priority = 3)
    public void checkstatusLine()
    {
        logger.info("********* Checking Status Line  **********");
        String statusLine = response.getStatusLine(); // get the  status Line
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

    }

    @Test(priority = 4)
    public void checkContentType()
    {
        logger.info("********* Checking Content Type  **********");
        String contentType = response.header("Content-Type"); // Getting Content Type
        Assert.assertEquals(contentType, "application/json");
    }

    @Test(priority = 5)
    public void checkResponseTime()
    {
        logger.info("********* Checking Response Time  **********");
        long responseTime = response.getTime(); // Getting response Time
        logger.info("Response Time is --> " + responseTime);
        if(responseTime>2000)
        {
            logger.warn("Response time is greater than 2000");
        }

        Assert.assertTrue(responseTime<2000);
    }



    @AfterClass
    void tearDown()
    {
        logger.info("*********  Completed TC001_Get_All_Employee **********");
    }


}
