import React from 'react';
import Layout from "../components/Layout";
import OrderedItems from "../components/OrderedItems";
import ProductItem from "../components/ProductItem";


function Checkout({orderDeets}) {

    let num = orderDeets.totalCostOfCart;
    let outputNum = num.toFixed(2)

    return (
        <Layout>
            <div className="bg-gray-600 h-screen w-screen bg-cover flex justify-center items-center">
                <div className="w-1/2 h-3/4 bg-gray-500  rounded-lg shadow flex flex-col gap-10">
                    <div className="flex flex-row shadow-md">
                        <div className="flex flex-col">
                            <h1 className="text-white font-bold text-2xl font-unis justify-left whitespace-nowrap flex px-10 pt-10">
                                Order ID: {orderDeets.invoiceNumber.substring(0, 8)}
                            </h1>
                            <p className="text-white font-bold text-md font-unis tracking-wide justify-left whitespace-nowrap flex px-10 pt-3">
                                Order Date: {orderDeets.orderDate.substring(4, 10)}, 2022</p>
                        </div>
                    </div>
                    <table className="min-w-full shadow-md">
                        <thead className="bg-gray-500 shadow-md">
                            <tr>
                                <th className="text-left justify-start font-medium text-gray-200 uppercase tracking-wide px-6">
                                    Items
                                </th>
                                <th className="text-left font-medium text-gray-200 uppercase tracking-wide py-3 px-6">
                                    Quantity
                                </th>
                                <th className="text-left font-medium text-gray-200 uppercase tracking-wide py-3 px-6">
                                    Cost
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            {orderDeets?.cartItems?.map((items) => (
                                <OrderedItems items={items} key={items.archivedOrderID}></OrderedItems>
                            ))
                            }
                        </tbody>
                    </table>
                    <div className="flex flex-row inline-block gap-72">
                        <div className="pl-5 font-semibold flex flex-col text-gray-300">
                            <h1 className="font-bold text-gray-700">Deliver To : </h1>
                            <p> {orderDeets.customer.username}</p>
                            <p> {orderDeets.customer.email}</p>
                            <p> {orderDeets.customer.phoneNumber}</p>
                            <p> {orderDeets.customer.city}, {orderDeets.customer.state}</p>
                        </div>
                        <div className="text-gray-300">
                            <h1 className="font-bold text-gray-200"> Order Summary </h1>
                            <h2 className="pt-5 flex flex-col text-2xl"> Order Description:
                                <p className="text-lg flex justify-center"> {orderDeets.orderDescription}</p>
                            </h2>
                            <h2 className="pt-5 flex flex-row gap-32 text-3xl"> Subtotal:
                                <p className="text-3xl"> ${outputNum}</p>
                            </h2>
                        </div>
                    </div>
                </div>
            </div>
        </Layout>
    );
}



export async function getStaticProps() {
    const orderLengthFetcher = await fetch('http://localhost:9090/api/getOrder')
    const actualLength = await orderLengthFetcher.json();
    const lastOrder = actualLength.length;
    console.log(lastOrder);
    const res = await fetch(`http://localhost:9090/api/getOrder/${lastOrder}`)
    const orderDeets = await res.json()

    return {props: {orderDeets}}
}


export default Checkout;