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
```

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
        "cartItemID": "3ee53168-7009-4d14-8e20-95cafeabd673",
        "productID": 10,
        "productName": "Coconut",
        "productQuantityAmount": 5,
        "totalCost": 42.45
    },
    {
        "cartItemID": "4c2c9690-92cb-464a-8ac3-e7af0821cec8",
        "productID": 22,
        "productName": "Banana",
        "productQuantityAmount": 5,
        "totalCost": 42.45
    },
    {
        "cartItemID": "5528b80e-397a-4866-bcb2-7d8ab00ce330",
        "productID": 22,
        "productName": "Banana",
        "productQuantityAmount": 5,
        "totalCost": 42.45
    },
    {
        "cartItemID": "f761834b-6254-4f9a-b54a-b1c5ee924cdf",
        "productID": 2,
        "productName": "Apples",
        "productQuantityAmount": 20,
        "totalCost": 79.80000000000001
    },
    {
        "cartItemID": "f7cef18f-a3f2-4d94-9d6a-fa4ac23d8fab",
        "productID": 3,
        "productName": "Oranges",
        "productQuantityAmount": 15,
        "totalCost": 52.35
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
    "invoiceNumber": "e522feb0-d728-48cf-9d14-33e1e351d882",
    "amount": 259.50000000000006,
    "date": "Sat Oct 22 19:14:16 PDT 2022",
    "orderDescription": "Groceries",
    "oid": 42
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
            "cartItemID": "3ee53168-7009-4d14-8e20-95cafeabd673",
            "productID": 10,
            "productName": "Coconut",
            "productQuantityAmount": 5,
            "totalCost": 42.45
        },
        {
            "cartItemID": "4c2c9690-92cb-464a-8ac3-e7af0821cec8",
            "productID": 22,
            "productName": "Banana",
            "productQuantityAmount": 5,
            "totalCost": 42.45
        },
        {
            "cartItemID": "5528b80e-397a-4866-bcb2-7d8ab00ce330",
            "productID": 22,
            "productName": "Banana",
            "productQuantityAmount": 5,
            "totalCost": 42.45
        },
        {
            "cartItemID": "f761834b-6254-4f9a-b54a-b1c5ee924cdf",
            "productID": 2,
            "productName": "Apples",
            "productQuantityAmount": 20,
            "totalCost": 79.80000000000001
        },
        {
            "cartItemID": "f7cef18f-a3f2-4d94-9d6a-fa4ac23d8fab",
            "productID": 3,
            "productName": "Oranges",
            "productQuantityAmount": 15,
            "totalCost": 52.35
        }
    ],
    "totalCostOfCart": 259.50000000000006,
    "customer": {
        "username": "johnjake17",
        "email": "john.albesa12@email.com",
        "currentBalance": 2240.5,
        "cid": 41
    },
    "oid": 42
}
```
