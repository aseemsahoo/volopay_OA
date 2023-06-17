# volopay_OA
Implementation of APIs

APIs are used to pull data from the SQL Server, the API makes sure the CRUD operation is invoked accordingly. For more information about APIs, please scroll down to the API section

The database has been hosted online (remote connection). Hence, no need to locally install the database. 


# API format for Postman usage

Username: aseem

Password: sahoo

| Method   | URL                                      | Use Cases                              |
| -------- | ---------------------------------------- | ---------------------------------------- |
| `GET`    | `/api/total_items/{startTime}/{endTime}/{dept}`          | Total item (total seats) sold in Marketting for last in q3 of the year?|
| `GET`    | `/api/nth_most_total_item/{amount}/{startTime}/{endTime}/{n}`      | What is the 2nd most sold item in terms of quantity/price sold in q4|
| `GET`   | `/api/percentage_of_department_wise_sold_items/{startTime}/{endTime}` | What is the percentage of sold items (seats) department wise?|
| `GET`   | `/api/monthly_sales/{software}/{year}`                | How does the monthly sales for any product look like?|

# Prerequisites
You need the following installed on your desktop:
- Java JDK 11 or Above
- IntelliJ
- Postman

# Installation
- Clone this repository
- Open this project in IntelliJ
- Run the Application
- Use the endpoints (mentioned above with credentials) for Postman testing
