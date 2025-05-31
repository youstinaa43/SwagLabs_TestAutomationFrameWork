# SwagLabs_TestAutomationFrameWork
# 🚀 SauceDemo Automation Framework

## 📌 Objective
Automate the login, cart, and checkout functionalities of [SauceDemo](https://www.saucedemo.com/v1/) using various test scenarios and credentials. Implement efficient execution with reusable action classes and robust reporting.

---

## 🧪 Scope of Automation

### ✅ Login Functionality
- Validate successful and failed login attempts.
- Handle locked-out and problem users.

### 🛒 Add Items to Cart
- Verify cart updates and behavior across different users.

### 💳 Complete Purchase
- Ensure seamless checkout for valid users with form validations.

### 🐞 Error Handling
- Capture and report unexpected UI/UX or functional issues.

---

## 🛠️ Framework Architecture

### 📂 Design Pattern
- **Page Object Model (POM)** to separate test logic from UI locators and actions.

### 🧩 Modules Included
- `base/` – Base test class with setup and teardown methods using ThreadLocal WebDriver.
- `pages/` – Page classes for different screens (LoginPage, CartPage, CheckoutPage, etc.).
- `tests/` – Test classes covering login, cart, and purchase flows.
- `utils/` – Reusable utility classes for:
  - Browser Actions
  - Element Actions
  - Property File Reading
- `listeners/` – Custom TestNG listeners integrated with **Allure** for enhanced reporting.
- `config/` – `.properties` file to store browser, URL, and other configurations.

### ⚙️ Features
- **Parallel Execution** using ThreadLocal and TestNG XML.
- **Properties-driven Config** for flexible test setups.
- **Allure Reporting** for clean, rich test result visualization.
- **Jenkins Integration** for CI/CD.

---

## 🧪 Technologies Used

| Tool / Tech      | Purpose                      |
|------------------|------------------------------|
| Java + Selenium  | Core automation logic        |
| TestNG           | Test management              |
| Maven            | Build and dependency mgmt    |
| Allure           | Test reporting               |
| ThreadLocal      | Parallel execution handling  |
| Jenkins          | Continuous Integration       |
| POM Design       | Scalable and clean structure |
| Properties File  | Environment configuration    |

---

## 🚀 How to Run the Project

### 🧰 Prerequisites
- Java 11+
- Maven
- ChromeDriver (configured in PATH)
- IDE (IntelliJ / Eclipse)

### ▶️ Execution Steps
```bash
git clone https://github.com/youstinaa43/SwagLabs_TestAutomationFrameWork.git
cd SwagLabs_TestAutomationFrameWork
mvn clean test
🖥️ To View Allure Report:
bash
Copy
Edit
mvn allure:serve
🤖 Jenkins CI/CD
Set up Maven project in Jenkins.

Configure GitHub webhook for auto-trigger.

Add Allure plugin for report display in build job.

📈 Reporting
Allure Reports: Integrated with TestNG listeners.

Logs: Captures browser and execution logs per test run.

👨‍💻 Author
Youstina Atef Salama 
Automation QA Engineer


