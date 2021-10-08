package com.sample.testCases;

import com.sample.testBase.BaseClass;
import com.sample.utilities.PropertyReader;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC002_Get_Single_Employee extends BaseClass
{

    @BeforeClass
    public void TC002_getSingleEmployee() throws InterruptedException
    {
        logger.info("********* Started TC002_Get_Single_Employee  **********");


        // Send request and record response
        String parameter = PropertyReader.getProp("Parameter2") + PropertyReader.getProp("empID");
        response = httpRequest.request(Method.GET, parameter);
        System.out.println("Parameter for the request --> " + parameter);
        Thread.sleep(5000);

    }


    @Test(priority = 1)
    public void TC002_checkResposeBody()
    {
        logger.info("********* Checking Response Body  **********");
        String responseBody = response.getBody().asString(); // Getting Response Body
        logger.info("Response Body --> " + responseBody);
        System.out.println("responseBody is :" + responseBody);
        Assert.assertTrue(responseBody.contains(PropertyReader.getProp("empID")));
    }

    @Test(priority = 2)
    public void TC002_checkStatusCode()
    {
        logger.info("********* Checking Status Code  **********");
        int statusCode = response.getStatusCode(); // Gettng status code
        Assert.assertEquals(statusCode, 200);
    }

    @Test(priority = 3)
    public void TC002_checkstatusLine()
    {
        logger.info("********* Checking Status Line  **********");
        String statusLine = response.getStatusLine(); // get the  status Line
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

    }

    @Test(priority = 4)
    public void TC002_checkContentType()
    {
        logger.info("********* Checking Content Type  **********");
        String contentType = response.header("Content-Type"); // Getting Content Type
        Assert.assertEquals(contentType, "application/json");
    }

    @Test(priority = 5)
    public void TC002_checkResponseTime()
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
        logger.info("*********  Completed TC002_Get_Single_Employee **********");
    }





}
