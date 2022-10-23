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
        "productName": "Apples",
        "productAvailableQuantity": 40,
        "productPrice": 4.49,
        "pid": 1
    },
    {
        "productName": "Banana",
        "productAvailableQuantity": 285,
        "productPrice": 5.49,
        "pid": 2
    },
    {
        "productName": "Carrots",
        "productAvailableQuantity": 500,
        "productPrice": 1.49,
        "pid": 3
    },
    {
        "productName": "Pineapple",
        "productAvailableQuantity": 750,
        "productPrice": 8.99,
        "pid": 4
    },
    {
        "productName": "Jello",
        "productAvailableQuantity": 654,
        "productPrice": 4.99,
        "pid": 5
    },
    {
        "productName": "Strawberry",
        "productAvailableQuantity": 75,
        "productPrice": 7.99,
        "pid": 6
    }
]
```

3. POST http://localhost:9090/api/addValidUser

Description: Added the ability to add customer informations to the database which is going to be used to isolate specific shopping cart for specific people.
We can add Customers Informations by following this format:

```
{
    "customerInfo": {
    "username": "johnjake14",
    "email": "john.albesa@email.com",
    "phoneNumber": "408-123-4567",
    "city": "Santa Clara",
    "state": "California",
    "currentBalance": 2500.0
    }
}
```

4. GET http://localhost:9090/api/ShowAllValidUsers

Description: By simply adding users, we should always have always have a way to retrieve them as a whole therefor we also added the abilityy to show all the valid users, and their current balances.

```
[
    {
        "username": "ninjin14",
        "email": "ninjin14@email.com",
        "phoneNumber": "408-566-3566",
        "city": "Santa Monica",
        "state": "California",
        "currentBalance": 1718.1100000000001,
        "cid": 1
    },
    {
        "username": "johnjake14",
        "email": "john.albesa@email.com",
        "phoneNumber": "408-123-4567",
        "city": "Santa Clara",
        "state": "California",
        "currentBalance": 1631.6999999999998,
        "cid": 2
    }
]
```

5. POST http://localhost:9090/api/addToCart

Description: We have added the ability of adding single items into the shopping cart by following this format, by using cid as the main isolator, for example Customer 1 refers to the first person in the database, that means every single item being added to the shopping cart will have a tag "cid":1 making them easier to retreieve for checkout.

```
{
    "cartItemsInfo": {
        "productName": "Apples",
        "productQuantityAmount": 65, 
        "cid": 1
    }
}
```

6. GET http://localhost:9090/api/getAllItemsInCart/1

Description: By adding to the cart using the previous step, by either using productName, or by using productID, these products are being accumulated in a single shopping cart and by GETMapping it, we will get the following:

```
[
    {
        "cartItemID": "23571634-eb14-4e80-b040-1b517d9d6222",
        "productID": 1,
        "productName": "Apples",
        "productQuantityAmount": 65,
        "totalCost": 291.85,
        "cid": 1
    },
    {
        "cartItemID": "c0017156-d0de-45f1-8f86-139faa8867b4",
        "productID": 2,
        "productName": "Banana",
        "productQuantityAmount": 55,
        "totalCost": 301.95,
        "cid": 1
    },
    {
        "cartItemID": "c3d1b0f9-73c6-481d-8907-1a91edde2a5e",
        "productID": 1,
        "productName": "Apples",
        "productQuantityAmount": 43,
        "totalCost": 193.07000000000002,
        "cid": 1
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
  "cid": 1
}
```

Would result in 

```
{
    "invoiceNumber": "be380393-36fd-49b6-a116-9dc2da786d35",
    "amount": 786.87,
    "date": "Sat Oct 22 22:52:33 PDT 2022",
    "orderDescription": "Groceries",
    "oid": 3
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
            "cartItemID": "23571634-eb14-4e80-b040-1b517d9d6222",
            "productID": 1,
            "productName": "Apples",
            "productQuantityAmount": 65,
            "totalCost": 291.85,
            "cid": 1
        },
        {
            "cartItemID": "c0017156-d0de-45f1-8f86-139faa8867b4",
            "productID": 2,
            "productName": "Banana",
            "productQuantityAmount": 55,
            "totalCost": 301.95,
            "cid": 1
        },
        {
            "cartItemID": "c3d1b0f9-73c6-481d-8907-1a91edde2a5e",
            "productID": 1,
            "productName": "Apples",
            "productQuantityAmount": 43,
            "totalCost": 193.07000000000002,
            "cid": 1
        }
    ],
    "totalCostOfCart": 786.87,
    "customer": {
        "username": "ninjin14",
        "email": "ninjin14@email.com",
        "phoneNumber": "408-566-3566",
        "city": "Santa Monica",
        "state": "California",
        "currentBalance": 1718.1100000000001,
        "cid": 1
    },
    "oid": 3
}
```
