# Banking Transactions API

A simple in-memory banking system built with Java and Spring Boot. This RESTful API supports basic banking operations such as account creation, money transfers, and transaction history retrieval.

---
## 📁 Project Structure


com.example.bankingapi
│
├── controller
│   └── AccountController.java
│
├── service
│   └── AccountService.java
│   └── TransactionService.java
│
├── repository
│   └── InMemoryAccountRepository.java
│   └── InMemoryTransactionRepository.java
│
├── dto
│   └── AccountDTO.java
│   └── TransferRequestDTO.java
│   └── TransactionDTO.java
│
├── model
│   └── Account.java
│   └── Transaction.java
│
├── exception
│   └── GlobalExceptionHandler.java
│   └── AccountNotFoundException.java
│   └── InsufficientFundsException.java
│
└── BankingApiApplication.java


## 📌 Features

- Create a new bank account with an initial balance.
- Transfer funds between accounts.
- Retrieve transaction history for a given account.
- View a list of all existing accounts.
  
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

```bash
# Clone the repository
git clone https://github.com/bubisjobs/banking-transactions-api.git
cd banking-transactions-api

# Build the project
./mvnw clean install

# Run the application
./mvnw spring-boot:run
