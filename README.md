# customer-order-case-study
READ ME

UML for the following Project
![image](https://user-images.githubusercontent.com/107880782/197141984-046080f2-991e-4aee-ba52-712b875c2a31.png)

1. POST http://localhost:8080/api/addProduct

Description : using talend API tester or Postman, we can add products to the database using a JSON file following format
```
{
    "productInfo": {
    "productName": "Strawberry",
    "productAvailableQuantity": 75,
    "productPrice": 7.99
    }
}

2. GET  http://localhost:8080/api/getAllProducts

Description : After using http://localhost:8080/api/addProduct, we can show all the available products using GET which would result in the following
Response : 
```
[
    {
        "productName": "Grapes",
        "productAvailableQuantity": 375,
        "productPrice": 5.99,
        "pid": 1
    },
    {
        "productName": "Apples",
        "productAvailableQuantity": 300,
        "productPrice": 3.99,
        "pid": 2
    },
    {
        "productName": "Oranges",
        "productAvailableQuantity": 275,
        "productPrice": 3.49,
        "pid": 3
    },
    {
        "productName": "Pears",
        "productAvailableQuantity": 200,
        "productPrice": 1.49,
        "pid": 4
    },
    {
        "productName": "Coconut",
        "productAvailableQuantity": 500,
        "productPrice": 8.49,
        "pid": 10
    },
    {
        "productName": "Banana",
        "productAvailableQuantity": 150,
        "productPrice": 8.49,
        "pid": 22
    },
    {
        "productName": "Strawberry",
        "productAvailableQuantity": 75,
        "productPrice": 7.99,
        "pid": 34
    }
]
```

3. POST http://localhost:9090/api/addToCart

Description: We have added the ability of adding single items into the shopping cart by following this format:

```
{
    "cartItemsInfo": {
        "productName": "Banana",
        "productQuantityAmount": 25
    }
}

or

{
    "cartItemsInfo": {
        "productID": "5",
        "productQuantityAmount": 25
    }
}

```

4. GET http://localhost:9090/api/getAllItemsInCart

Description: By adding to the cart using the previous step, by either using productName, or by using productID, these products are being accumulated in a single shopping cart and by GETMapping it, we will get the following:

```
[
    {
        "cartItemID": "10134ec9-2714-49e4-b078-37ec1046c7ab",
        "productID": 3,
        "productName": null,
        "productQuantityAmount": 25,
        "totalCost": 0.0
    },
    {
        "cartItemID": "2a269d4d-2c02-443f-92b0-32e794c71069",
        "productID": null,
        "productName": "Oranges",
        "productQuantityAmount": 25,
        "totalCost": 87.25
    },
    {
        "cartItemID": "8ac95b64-4c24-442d-8125-a5861401b2a5",
        "productID": 4,
        "productName": null,
        "productQuantityAmount": 25,
        "totalCost": 0.0
    }
]
```

5. POST http://localhost:9090/api/placeOrder
Description: Placing an order should follow something like this format, by using the productID or productName from the previous step that we can retrieve from
we can put these products into a list of products which would be stored in a shopping cart, we can also specify how many items we want to buy.
This following JSON
```
{
  "orderDescription": "Groceries",
  "customerEmail": "john.albesa@email.com",
  "customerUsername": "johnjake14"
}
```

Would result in 

```
{
    "invoiceNumber": "5fded267-9bcb-45bf-a9b6-8284db0700e6",
    "amount": 325.33,
    "date": "Sat Oct 22 18:07:33 PDT 2022",
    "orderDescription": "Groceries",
    "oid": 38
}

```
which contains the total amount of in dollars of the products we had in the shopping cart, contains a random invoiceNumber, the purchase date, and the order optional order description we wanted.

6. GET http://localhost:9090/api/getOrder/35

Description : By grabbing the OrderID from the previous step, we can retrieve the whole order information which contains the productName, the amount of quantities we bought, contains the the total cost, the optional orderDescription, customer's username, customer's email and lastly (supposedly) the customer's current remaining balance.

```
{
    "orderDescription": "Groceries",
    "cartItems": [
        {
            "cartItemID": "10134ec9-2714-49e4-b078-37ec1046c7ab",
            "productID": 3,
            "productName": null,
            "productQuantityAmount": 25,
            "totalCost": 0.0
        },
        {
            "cartItemID": "2a269d4d-2c02-443f-92b0-32e794c71069",
            "productID": null,
            "productName": "Oranges",
            "productQuantityAmount": 25,
            "totalCost": 87.25
        },
        {
            "cartItemID": "7194c253-37ca-4de8-be89-52141d0ed082",
            "productID": null,
            "productName": "Coconut",
            "productQuantityAmount": 5,
            "totalCost": 42.45
        },
        {
            "cartItemID": "88d6b366-b703-49da-a017-8a20af963183",
            "productID": null,
            "productName": "Apples",
            "productQuantityAmount": 25,
            "totalCost": 99.75
        },
        {
            "cartItemID": "8ac95b64-4c24-442d-8125-a5861401b2a5",
            "productID": 4,
            "productName": null,
            "productQuantityAmount": 25,
            "totalCost": 0.0
        },
        {
            "cartItemID": "d2bb41e5-3a80-46e0-b909-74a2b668a0b5",
            "productID": null,
            "productName": "Strawberry",
            "productQuantityAmount": 12,
            "totalCost": 95.88
        }
    ],
    "totalCostOfCart": 325.33,
    "customer": {
        "username": "johnjake15",
        "email": "john.albesa1@email.com",
        "currentBalance": 2174.67,
        "cid": 37
    },
    "oid": 38
}
```
