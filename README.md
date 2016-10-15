#QA Group - 14 October meeting

This project contains code developed and demonstrated during a class on Web automation in Quality Assurance Group.

The goal is to demonstrate the possibility to start and control browser from code.

It consists of a single test class. The code opens browser, navigates to Google home page, types 'selenium ide' into search field, clicks 'Search' button, finds link with text 'Selenium IDE Plugins' and clicks it, and finally on Selenium project web-site selects 'Downloads' tab. 
It then asserts that browser title is equal to 'Downloads'.

###Used Libraries

This is a Maven project, with the following libraries included:

- Selenium WebDriver
- TestNG
- Allure test report

### Required Software
To execute the test locally, you need installed:

- Java 8 (jdk1.8.***)
- Maven

### Run

To start it from command line, navigate to the project directory (the one where pom.xml file resides) and run:

`
$ mvn clean && mvn test && mvn site
`

The command will clean the project before running test, then run test, and then generate Allure report.
The report itself may be found in the project directory by the relative path `/target/site/allure-maven-plugin.html`.