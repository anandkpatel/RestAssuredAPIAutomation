package com.sample.testCases;

import com.sample.testBase.BaseClass;
import com.sample.utilities.PropertyReader;
import com.sample.utilities.RandomGenerator;
import com.sample.utilities.XlUtils;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC003_Post_Create_Employee extends BaseClass
{
        @Test(dataProvider = "EmployeeRecords", priority = 1)
        void prepareRequestParams(String empName, String empSalary, String empAge) throws InterruptedException
        {
            logger.info("*********Started TC003_Post_Create_Employee **********");

            // Adding Random Functionality So everytime We don't have to change values in excel file
            String employeeName = empName + RandomGenerator.empNameRandom();
            System.out.println("Complete emp name --> " + employeeName);
            String employeeSalary = empSalary + RandomGenerator.empSalRandom();
            String employeeAge = empAge + RandomGenerator.empAgeRandom();

            // JSONObject is a class that represents a simple JSON. We can add Key-Value pairs using the put method
            //{"name":"abc","salary":"123","age":"23"}
            JSONObject requestParams = new JSONObject();
            requestParams.put("name", employeeName);
            requestParams.put("salary", employeeSalary);
            requestParams.put("age", employeeAge);

            // Add a header stating the Request body is a JSON
            httpRequest.header("Content-Type", "application/json");

            // Add the Json to the body of the request
            httpRequest.body(requestParams.toJSONString());

            response = httpRequest.request(Method.POST, PropertyReader.getProp("Parameter3"));

            Thread.sleep(5000);

            // check Respose Body
            String responseBody = response.getBody().asString();
            Assert.assertEquals(responseBody.contains(employeeName), true);
            Assert.assertEquals(responseBody.contains(employeeSalary), true);
            Assert.assertEquals(responseBody.contains(employeeAge), true);


            // check Status Code
            int statusCode = response.getStatusCode(); // Gettng status code
            Assert.assertEquals(statusCode, 200);

            //check status Line
            String statusLine = response.getStatusLine(); // Gettng status Line
            Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

            // check Content Type
            String contentType = response.header("Content-Type");
            Assert.assertEquals(contentType, "application/json");

            // check server Type
            String serverType = response.header("Server");
            Assert.assertEquals(serverType, "cloudflare");




        }

        // data provider to fetch data from excel file and feed to the test method
        @DataProvider(name = "EmployeeRecords")
        public static Object[][] getUserData() throws Exception {
            String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\sample\\testData\\EmployeeRecords.xlsx";
            Object[][] userData = XlUtils.getData(path, "Sheet1");
            return userData;
        }

        @AfterClass
        void tearDown()
        {
            logger.info("*********  Finished TC003_Post_Create_Employee **********");
        }

}
