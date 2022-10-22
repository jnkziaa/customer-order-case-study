# customer-order-case-study
READ ME

Scuffed UML
![image](https://user-images.githubusercontent.com/107880782/197141984-046080f2-991e-4aee-ba52-712b875c2a31.png)

1. POST http://localhost:8080/api/addProduct

Description : using talend API tester or Postman, we can add products to the database using a JSON file following 

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



2. GET  http://localhost:8080/api/getAllProducts

Description : After using http://localhost:8080/api/addProduct, we can show all the available products using GET which would result in the following
Response : 

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
