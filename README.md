# REST-Assured API Automation Framework
# Steps to Import the project in eclipse and execute test suite 

**Technology Used:**
1. RestAssured Java API
2. TestNG Framework 
3. Report and logger for generating reports and logs.

**Steps to import project**
- Download repo from [https://github.com/anandkpatel/RestAssuredAPIAutomation] and unzip it
- Go to Eclipse > File > Import > Existing Projects into Workspace
- Click on Next 
- Click on Browse
- Select the Folder “RestAssuredAPIAutomation”
- Click on Open
- Click Finish

Note: Once you Imported the project in eclipse Make sure the project directory is there. 

**Note:**
Once you have folder structure imported wait for a while until maven download all the dependencies. 

**Now you all set to run the project.**

### It has following this implemented. 
1. Get All Employee Test Case Class
2. Get Single Employee Test Case Class
3. Create Employee Record Test Case Class
4. Update Employee Record Test Case Class
5. Delete Employee Record Test Case Class

**1. Steps to Run the Test suite using Maven**

------------


- Right click on pom.xml file in the project directory level
- Select Run As > 6.Maven Test

*Note: Now your test suit is running. It will log all the success or errors on the eclipse console*

**2. Steps to Run the Test suite using TestNG**

------------



- Right click on testng.xml file in the project directory level
Select Run As >  TestNG Suite

*Note: Now your test suit is running. It will log all the success or errors on the eclipse console*



**Note:**
- Entire test suite is verified and work as expected with no errors. 
- you might see authentication key error or email id errors. make sure to update those


Regards,
Anand 


