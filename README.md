# Selenium-Java Data-Driven Test Automation Framework

## 🎯 Overview
This is an **industry-standard, data-driven test automation framework** built with Selenium WebDriver, Java, TestNG, and Maven. The framework follows enterprise-level best practices including Page Object Model (POM), data-driven testing, comprehensive logging, and detailed reporting.

## 🏗️ Framework Architecture

### Design Patterns Used:
- **Page Object Model (POM)** - Separation of test logic and page elements
- **Singleton Pattern** - DriverManager and Report Manager
- **Factory Pattern** - Configuration management
- **Data-Driven Testing** - External JSON test data

### Key Features:
✅ **Selenium 4.16.1** - Latest WebDriver features  
✅ **TestNG 7.9.0** - Parallel execution support  
✅ **Log4j2** - Industry-standard logging  
✅ **ExtentReports** - Rich HTML reports with screenshots  
✅ **WebDriverManager** - Automatic browser driver management  
✅ **Jackson** - JSON data parsing  
✅ **Owner** - External configuration management  
✅ **AssertJ** - Fluent, readable assertions  

## 📁 Project Structure

```
selenium-java-framework/
├── src/main/java/com/demoapp/
│   ├── base/              # Base classes
│   ├── pages/             # Page Object classes
│   ├── utils/             # Utility classes
│   ├── constants/         # Framework constants
│   ├── enums/             # Type-safe enumerations
│   └── config/            # Configuration management
├── src/test/java/com/demoapp/
│   ├── tests/             # Test classes
│   └── listeners/         # TestNG listeners
├── src/test/resources/
│   └── testdata/          # JSON test data
├── logs/                  # Execution logs
├── screenshots/           # Failed test screenshots
└── test-output/reports/   # ExtentReports HTML
```

## 🚀 Getting Started

### Prerequisites:
- Java JDK 11 or higher
- Maven 3.6+
- IntelliJ IDEA / Eclipse IDE
- Chrome/Firefox browser

### Setup Instructions:

1. **Clone or create the project**
   ```bash
   mkdir selenium-java-framework
   cd selenium-java-framework
   ```

2. **Add pom.xml** to project root

3. **Create folder structure** as shown above

4. **Add configuration files:**
   - log4j2.xml (root directory)
   - config.properties (src/main/resources/)
   - .gitignore (root directory)

5. **Install dependencies**
   ```bash
   mvn clean install
   ```

## 🧪 Running Tests

### Via Maven:
```bash
# Run all tests
mvn clean test

# Run specific test
mvn test -Dtest=DemoAppTest

# Run with custom browser
mvn test -Dbrowser=chrome

# Run in headless mode
mvn test -Dheadless=true
```

### Via TestNG XML:
```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Via IDE:
- Right-click on `DemoAppTest.java` → Run as TestNG Test

## 📊 Reports

### ExtentReports:
- Location: `test-output/reports/ExtentReport.html`
- Features: Screenshots, test duration, pass/fail status
- Open in any browser for interactive report

### TestNG Reports:
- Location: `test-output/index.html`
- Default TestNG HTML report

### Logs:
- Location: `logs/automation.log`
- Rotating file appender (10MB size, 10 backups)

## 🔧 Configuration

Edit `config.properties` to customize:

```properties
# Application
app.url=https://your-app-url.com

# Browser (chrome, firefox, edge)
browser=chrome
headless=false

# Timeouts
explicit.wait=20
page.load.timeout=30

# Test Data
login.email=admin
login.password=password123
```

## 📝 Test Data Management

Test data is stored in `testData.json`:

```json
{
  "loginCredentials": {
    "email": "admin",
    "password": "password123"
  },
  "testCases": [
    {
      "testId": "TC001",
      "project": "Web Application",
      "task": "Implement user authentication",
      "column": "To Do",
      "tags": ["Feature", "High Priority"]
    }
  ]
}
```

## 🎯 Framework Components

### 1. **DriverManager**
- ThreadLocal WebDriver for parallel execution
- Automatic browser initialization
- Graceful driver cleanup

### 2. **BasePage**
- Common WebDriver operations
- Explicit wait strategies
- Element interaction methods

### 3. **Page Objects**
- LoginPage - Login functionality
- ProjectPage - Project and task verification

### 4. **JsonDataReader**
- Read test data from JSON
- POJO mapping with Jackson
- Type-safe data access

### 5. **ExtentReportManager**
- Test execution reporting
- Screenshot capture on failure
- Test step logging

### 6. **TestListener**
- ITestListener implementation
- Automatic screenshot on failure
- Test result logging

## 🏆 Best Practices Implemented

1. ✅ **Separation of Concerns** - Tests, pages, utilities separated
2. ✅ **DRY Principle** - Reusable components
3. ✅ **Explicit Waits** - No Thread.sleep()
4. ✅ **Parameterization** - External test data
5. ✅ **Logging** - Comprehensive Log4j2 logging
6. ✅ **Reporting** - Professional ExtentReports
7. ✅ **Version Control** - .gitignore configured
8. ✅ **Constants** - No hardcoded values
9. ✅ **Type Safety** - Enums for browser types
10. ✅ **Clean Code** - Meaningful names, proper indentation

## 🔍 CI/CD Integration

This framework is **Jenkins-ready**:

```groovy
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
    post {
        always {
            publishHTML([
                reportDir: 'test-output/reports',
                reportFiles: 'ExtentReport.html',
                reportName: 'Test Report'
            ])
        }
    }
}
```

## 📈 Extending the Framework

### Add New Page:
1. Create class in `pages/` package
2. Extend `BasePage`
3. Define locators as `By` objects
4. Implement action methods

### Add New Test:
1. Create class in `tests/` package
2. Extend `BaseTest`
3. Use `@Test` annotation
4. Add test data to JSON

### Add New Utility:
1. Create class in `utils/` package
2. Follow Singleton pattern if needed
3. Add logging statements

## 👨‍💻 Author
**Podsho Boshkhuja**  
SDET | Selenium | Java | TestNG  
Location: Ashburn, VA

## 📄 License
This is a practice framework for learning and portfolio purposes.

---

**Note:** This framework follows industry standards observed at companies like GEICO, Freedom Bank, and follows patterns recommended by Selenium, TestNG, and Java communities.