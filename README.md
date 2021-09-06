## Web Automation with Selenium for Github 

### Technology Stack
![Selenium WebDriver](readme/Selenium.png)
![Java](readme/Java.png)
![JUnit5](readme/JUnit5.png)
![Allure_Report](readme/Allure_Report.png)
![Gradle](readme/Gradle.png)
![Selenoid](readme/Selenoid.png)
![Browserstack](readme/Browserstack.png)
- Selenium WebDriver
- Java
- Junit5
- Allure Report
- Gradle
- Selenoid
- Browserstack

### Run tests
Copy-paste and fill configs from `resources/*.properties.example` files to `*.properties` files

Run locally: `gradlew test -Ddriver=local`

Run on selenoid: `gradlew test -Ddriver=selenoid` 

Run on browserstack: `gradlew test -Ddriver=browserstack` 

### Allure report
![Allure](readme/Selenium_Allure.gif)
### Selenoid
![Selenoid](readme/Selenium_Selenoid.gif)
### Browserstack
![Browserstack](readme/Selenium_Browserstack.gif)






