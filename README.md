# 🧾 Item Management REST API – Usage Guide

This is a simple **Spring Boot REST API** deployed on **Render** that allows you to **add items** and **fetch items by ID**. The application uses **in-memory storage**, so data resets when the server restarts.

🌐 **Base URL**

```
https://api-3q2w.onrender.com
```

---

## 🚀 How to Use the API

All endpoints are prefixed with:

```
/api/item
```

---

## ➕ Add a New Item

### Endpoint

```
POST /api/item/add
```

### Full URL

```
https://api-3q2w.onrender.com/api/item/add
```

### Headers

```
Content-Type: application/json
```

### Request Body (JSON)

```json
{
  "id": 1,
  "name": "Laptop",
  "description": "Gaming Laptop",
  "cost": 75000
}
```

### Success Response

```
200 OK
Item Added Successfully!
```

### Error Response

```
400 Bad Request
Item ID already exists or required fields are missing!
```

---

## 🔍 Get Item by ID

### Endpoint

```
GET /api/item/{id}
```

### Example Request

```
https://api-3q2w.onrender.com/api/item/1
```

### Success Response

```json
{
  "id": 1,
  "name": "Laptop",
  "description": "Gaming Laptop",
  "cost": 75000.0
}
```

### Error Response

```
404 Not Found
```

---

## 🧪 How to Test the API

### Option 1: Using Postman (Recommended)

1. Open Postman
2. Select HTTP method (`POST` or `GET`)
3. Paste the API URL
4. For POST requests, set body to **raw → JSON**
5. Click **Send**

---

### Option 2: Using curl (Terminal)

**Add Item**

```bash
curl -X POST https://api-3q2w.onrender.com/api/item/add \
-H "Content-Type: application/json" \
-d '{
  "id": 1,
  "name": "Laptop",
  "description": "Gaming Laptop",
  "cost": 75000
}'
```

**Get Item**

```bash
curl https://api-3q2w.onrender.com/api/item/1
```

---

## ⚠️ Important Notes (Read This)

* The API uses **in-memory storage (`ArrayList`)**
* Data is **NOT persistent**
* On Render free tier:

  * The app sleeps when idle
  * App restarts clear all stored items

This behavior is expected and not a bug.

---

## 🧠 Implementation Overview

* **Controller Layer**: Handles HTTP requests
* **Service Layer**: Contains business logic
* **Model Layer**: Represents item data
* **Storage**: In-memory (no database)

---

## 🚧 Limitations

* No database integration
* No update or delete APIs
* No global exception handling
* No input validation annotations

---

## 🚀 Possible Improvements

* Add database support (H2 / MySQL)
* Add Swagger UI for browser testing
* Add PUT & DELETE endpoints
* Add validation using `@Valid`
* Add global exception handling

---

## 🎯 Purpose

This project is intended for:

* Learning Spring Boot REST basics
* Understanding controller-service design
* Demonstrating API deployment on Render
* Portfolio and interview demonstration
