# customer-order-case-study
READ ME

UML for the following Project
![image](https://user-images.githubusercontent.com/107880782/197141984-046080f2-991e-4aee-ba52-712b875c2a31.png)

1. POST http://localhost:8080/api/addProduct

Description : using talend API tester or Postman, we can add products to the database using a JSON file following 
```
Body:
{
  "productInfo": {
    "productName": "ZOOM TKL",
    "productAvailableQuantity": 55,
    "productPrice": 179.99
  }
}

and 

Body:
{
  "productInfo": {
    "productName": "AR87",
    "productAvailableQuantity": 55,
    "productPrice": 314.99
  }
}

```



2. GET  http://localhost:8080/api/getAllProducts

Description : After using http://localhost:8080/api/addProduct, we can show all the available products using GET which would result in the following
Response : 
```
[
    {
        "productName": "ZOOM TKL",
        "productAvailableQuantity": 55,
        "productPrice": 179.99,
        "pid": 1
    },
    {
        "productName": "AR87",
        "productAvailableQuantity": 55,
        "productPrice": 314.99,
        "pid": 2
    }
]
```

3. POST http://localhost:9090/api/placeOrder
Description: Placing an order should follow something like this, by using the product ID that we can retrieve from
http://localhost:8080/api/getAllProducts, we can put these products into a list of products which would be stored in a shopping cart, we can also specify how many items we want to buy.
This following JSON
```
{
  "orderDescription": "Buying keyboards just cuz",
  "cartItems":[
    {
      "productID" : 1,
      "productCount": 5
    },
    {
      "productID": 2,
      "productCount": 1
    },
    {
      "productID": 4,
      "productCount": 1
    }
  ],
  "customerEmail": "john.albesa@email.com",
  "customerUsername": "johnjake14"
}
```

Would result in 

```
{
    "amount": 1295.93,
    "invoiceNumber": 22654,
    "date": "22",
    "orderDescription": "Buying keyboards just cuz",
    "orderID": 29
}
```
which contains the total amount of in dollars of the products we had in the shopping cart, contains a random invoiceNumber, the purchase date, and the order optional order description we wanted.

4. GET http://localhost:9090/api/getOrder/27

Description : By grabbing the OrderID from the previous step, we can retrieve the whole order information which contains the productName, the amount of quantities we bought, contains the the total cost, the optional orderDescription, customer's username, customer's email and lastly (supposedly) the customer's current remaining balance.

```
{
    "orderDescription": "Buying keyboards just cuz",
    "cartItems": [
        {
            "productID": 4,
            "productName": "Goose Orion",
            "productCount": 1,
            "totalCost": 80.99,
            "oid": "92e959ef-9ef3-4868-aefa-1256bd5e229a"
        },
        {
            "productID": 1,
            "productName": "ZOOM TKL",
            "productCount": 5,
            "totalCost": 899.95,
            "oid": "b18265a8-aee1-40bd-a125-c9b1c8d8b67a"
        },
        {
            "productID": 2,
            "productName": "AR87 TKL",
            "productCount": 1,
            "totalCost": 314.99,
            "oid": "bc9d28ba-cb96-4af2-9b3d-2f984e479441"
        }
    ],
    "customer": {
        "username": null,
        "email": "john.albesa@email.com",
        "currentBalance": 10000.0,
        "cid": 7
    },
    "oid": 27
}
```
