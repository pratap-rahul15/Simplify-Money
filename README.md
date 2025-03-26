# 🚀 Insurance Purchase API

A Spring Boot REST API that allows users to **view available insurance policies, purchase an insurance policy, and download a sample policy document**.

## 📌 Features
- 🔍 **List Available Insurances**: Fetch all available insurance policies.
- 🛒 **Purchase Insurance**: Buy an insurance policy (simulating a successful payment).
- 📄 **Download Policy Document**: Download a sample policy document (PDF).
- 🎯 **Curated Recommendations** *(Bonus Feature)*: Recommend insurance policies based on user attributes (age, gender, income).


## 🛠️ Tech Stack
- **Backend**: Spring Boot (Java)
- **Database**: MySQL
- **Testing**: JUnit, Mockito

---

## 🚀 Setup & Installation

### 📋 Prerequisites
- **Java 17+**
- **MySQL**
- **Maven**
- **Git**

### 📥 Clone the Repository
```sh
git clone https://github.com/your-username/insurance-api.git
cd insurance-api

# 📄 Insurance Purchase API - cURL Requests  

This document provides `cURL` commands to test the **Insurance Purchase API**.

---

## 📌 1. Get All Available Insurance  


curl -X GET "http://your-deployed-url.com/api/insurances" -H "Content-Type: application/json"

[
  {
    "id": 1,
    "name": "Health Guard",
    "type": "Health",
    "price": 5000.0,
    "description": "Covers medical expenses"
  },
  {
    "id": 2,
    "name": "Life Secure",
    "type": "Life",
    "price": 7000.0,
    "description": "Life coverage and benefits"
  }
]

*** 📌 2. Purchase an Insurance Policy


curl -X POST "http://your-deployed-url.com/api/insurances/1/purchase" \
     -H "Content-Type: application/json" \
     -d '{
           "buyerName": "Rahul Singh",
           "email": "rahul@example.com"
         }'
Response

{
  "id": 101,
  "insurance": {
    "id": 1,
    "name": "Health Guard",
    "type": "Health",
    "price": 5000.0,
    "description": "Covers medical expenses"
  },
  "buyerName": "Rahul Singh",
  "email": "rahul@example.com",
  "purchaseDate": "2025-03-26T14:00:00",
  "policyDocumentUrl": "/api/insurances/download-policy/1"
}

📌 3. Download the Policy Document

curl -X GET "http://your-deployed-url.com/api/insurances/Insurance Policy/1" -o policy_sample.pdf


```sh
