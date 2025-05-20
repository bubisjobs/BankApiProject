# Banking Transactions API

A simple in-memory banking system built with Java and Spring Boot. This RESTful API supports basic banking operations such as account creation, money transfers, and transaction history retrieval.



## 📌 Features

- Create a new bank account with an initial balance.
- Transfer funds between accounts.
- Retrieve transaction history for a given account.
- View a list of all existing accounts.

## 📬 API Endpoints
- POST /accounts/createAccount  
  Create a new account  
  Body: { "id": "90", "balance": 5000 }

- GET /accounts/getAllAccounts  
  Retrieve all accounts

- POST /accounts/transfer  
  Transfer funds between accounts  
  Body: { "fromAccountId": "90", "toAccountId": "12", "amount": 120 }

- GET /accounts/{accountId}/transactions  
  Retrieve transaction history for a specific account




- Error handling for:
  - Insufficient funds
  - Invalid account IDs
  - No accounts created
  - You cannot transfer money between the same account.
  - Account has no transactions yet.

---

## ⚙️ Technologies Used

- Java 24
- Spring Boot
- Jakarta Bean Validation
- Lombok
- In-memory storage (no database)

---

## 🚀 Getting Started

### Prerequisites

- Java 24
- Maven

### Build and Run

# Link to the Project
https://github.com/bubisjobs/BankApiProject/tree/master

```bash
# Clone the repository
git clone https://github.com/bubisjobs/banking-transactions-api.git
cd banking-transactions-api

# Build the project
./mvnw clean install

# Run the application
./mvnw spring-boot:run
