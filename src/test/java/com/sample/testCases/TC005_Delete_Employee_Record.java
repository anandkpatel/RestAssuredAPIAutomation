package com.sample.testCases;

import com.sample.testBase.BaseClass;
import com.sample.utilities.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC005_Delete_Employee_Record extends BaseClass {

    @BeforeClass
    void TC005_deleteEmployee() throws InterruptedException
    {
        logger.info("*********Started TC005_Delete_Employee_Record **********");
        response = httpRequest.request(Method.DELETE, "/delete/"+ PropertyReader.getProp("EmployeeID")); //Pass ID to delete record

        Thread.sleep(3000);
    }

    @Test(priority = 1)
    void TC005_checkResposeBody()
    {
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("Successfully! Record has been deleted"));

    }

    @Test(priority = 2)
    void TC005_checkStatusCode()
    {
        int statusCode = response.getStatusCode(); // Gettng status code
        Assert.assertEquals(statusCode, 200);
    }

    @Test(priority = 3)
    void TC005_checkstatusLine()
    {
        String statusLine = response.getStatusLine(); // Gettng status Line
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

    }

    @Test(priority = 4)
    void TC005_checkContentType()
    {
        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType, "application/json");
    }

    @Test(priority = 5)
    void TC005_checkserverType()
    {
        String serverType = response.header("Server");
        Assert.assertEquals(serverType, "cloudflare");
    }

    @Test(priority = 6)
    void TC005_checkcontentEncoding()
    {
        String contentEncoding = response.header("Content-Encoding");
        Assert.assertEquals(contentEncoding, "gzip");

    }

    @AfterClass
    void tearDown()
    {
        logger.info("*********  Finished TC005_Delete_Employee_Record **********");
    }

}
