
# Norwegian Income Tax Calculator & Job Offer Comparator

A Java and Spring Boot web application for estimating Norwegian net income and comparing the financial impact of two job offers.

The project is being extended with AI-assisted analysis to explain financial trade-offs using results calculated by the Java application.

### Norwegian Income Tax Calculator

- Accepts an annual gross salary.
- Supports NOK, HUF, EUR and USD input currencies.
- Converts supported currencies to NOK using an external exchange-rate service.
- Provides a progressive tax calculation.
- Includes an alternative fixed-percentage tax-card calculation mode.
- Displays estimated net income and individual tax components.

### Job Offer Comparison

The comparison page allows users to enter two hypothetical Norwegian job offers.

For each offer, users provide:

- Annual gross salary in NOK.
- Monthly housing costs.
- Other monthly living costs.

The application calculates an estimated monthly net salary, subtracts the stated monthly costs and compares the remaining amounts.

The comparison uses the existing Java tax-calculation logic rather than asking an AI model to calculate taxes.

### AI-Assisted Analysis — In Progress

The project includes a Spring AI service designed to explain the comparison results in clear English.

The planned analysis includes:

- Explaining the difference in estimated monthly disposable income.
- Highlighting the trade-off between gross salary and living costs.
- Identifying missing information that may affect the comparison.

**Current status:** The AI integration is implemented in the code but has not yet been tested end to end. Integration with an existing Azure agent is planned.

The deterministic Java calculation remains separate from the AI-generated explanation.

## Technology Stack

- Java 17
- Spring Boot 4.1.0
- Spring MVC
- Thymeleaf
- Spring AI 2.0.2
- OpenAI model integration through Spring AI
- Maven
- Jakarta Bean Validation
- Lombok
- External exchange-rate API

## Project Structure

```text
src/main/java/com/example/demo/
├── controller/
│   └── WebController.java
├── service/
│   └── OfferAnalysisService.java
├── util/
│   └── ExchangeRate.java
└── TaxCalculator.java

src/main/resources/
├── templates/
│   ├── fragments/
│   │   └── calculate_main.html
│   ├── index.html
│   ├── calculate.html
│   ├── calculate_withcard.html
│   └── compare.html
└── application.properties
```

### Requirements

- JDK 17 or a compatible configured Java development environment.
- Maven.
- IntelliJ IDEA or another Java IDE.
- Internet access for external API calls.


## Limitations and Disclaimer

- Tax thresholds and rates are currently hard-coded in the application and must be verified for the relevant Norwegian tax year.
- The calculator is an educational estimation tool, not a substitute for official Norwegian tax calculations or professional advice.
- Actual take-home pay may differ because of tax-card settings, deductions, benefits, pension contributions and other payroll-specific factors.
- The job comparison only accounts for the costs entered by the user. Other benefits and expenses are not yet included.
- The AI integration has not yet passed an end-to-end test.

## Planned Improvements

- Integrate the existing Azure agent with the Spring Boot application.
- Improve input validation and error handling.
- Add automated tests for the comparison calculations and service layer.
- Add a more detailed comparison of benefits and living costs.
- Improve the presentation and formatting of monetary values.
- Validate the tax calculation logic against official, year-specific Norwegian tax rules.

## Purpose

This project demonstrates ongoing practical work with Java, Spring Boot, web application development, external API integration, validation and AI-assisted application design.



    
