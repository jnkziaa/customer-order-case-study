import React, {useState} from 'react';
import Layout from "../components/Layout";
import ShoppingCart from "../components/ShoppingCart";
import {useRouter} from "next/router";




function CartItems({accountCart}) {
    const router = useRouter()
    let subtotal = 0;
    var brack = {}
    var cartItems = [];
    brack.cartItems = cartItems;
    var items = {}
    for (let i = 0; i < accountCart.length; i++) {
        subtotal += accountCart[i].totalCost;
        console.log(accountCart[i].productCount)
        items = {
            "productID" : accountCart[i].productID, "productCount": accountCart[i].productQuantityAmount
        }
        brack.cartItems.push(items);
    }

    console.log("WATCH THIS")
    const stringified = JSON.stringify(brack);

    console.log(stringified);
    let fixedSub = subtotal.toFixed(2);

    const [description, setDescription] = useState([]);

    const submitCheckout = async () => {
        const response = await fetch('http://localhost:9090/api/placeOrder', {
            method: 'POST',
            body: JSON.stringify(
                {
                    "orderDescription": description,
                    "cartItems": brack.cartItems,
                    "totalCostOfCart": fixedSub,
                    "cid":2,
                    "customerEmail": "john.albesa@email.com",
                    "customerUsername": "johnjake14"
                }
            ),
            headers: {
                'Content-Type': 'application/json'
            },

        })
        if(response.ok){
            await router.push("/Checkout")
        }

    }


    return (
        <Layout>
            <div className="flex px-20 py-20">
                <div className="w-1/2 h-1/2 grid grid-rows-3 md:grid-rows-3 lg:grid-rows-4">
                    {accountCart?.map((cart) => (
                        <ShoppingCart cart={cart} key={cart.cartItemID}></ShoppingCart>
                    ))
                    }
                </div>
                <div
                    className="w-2/7 h-1/2 bg-gradient-to-r from-blue-400 to-red-300  rounded-lg shadow-lg flex flex-row gap-20">
                    <div className="flex flex-col">
                        <h1 className="text-white font-bold text-2xl font-unis tracking-wide justify-center whitespace-nowrap flex px-28 pt-10"> Cart
                            Details</h1>
                        <h2 className="text-gray-200 text-18 font-unis tracking-wide flex px-16 justify-center"> We're
                            so excited to serve
                            you again!</h2>
                        <div className="pt-8 font-semibold text-gray-200 px-10 flex flex-col">
                            <label className="text-gray-300 text-sm "> Order Description</label>
                            <input className="pl-5 w-96 flex-1 py-2 rounded-lg border-b-2 border-gray-400 focus:border-green-400
                                                    text-black placeholder-black outline-none" type="text"
                                   placeholder="" value={description} onChange={(e) => setDescription(e.target.value)}/>
                            <label className="pt-5 text-gray-300 text-sm text-xl"> Subtotal : </label>
                            <div>
                                <br/>
                                <div className="flex justify-center text-4xl">
                                    ${fixedSub}
                                </div>
                                <br/><br/>
                            </div>
                            <button className="bg-orange-500 p-3 rounded-lg text-xs px-3 md:text-sm focus:outline-none
                 hover:shadow-2xl font-semibold hover:text-blue-600 transition duration-200 ease-in-out
                 whitespace-nowrap text-blue-800" onClick={submitCheckout}> Checkout
                            </button>

                            <div className="pt-5">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </Layout>
    );
}


export async function getStaticProps() {
    const res = await fetch(`http://localhost:9090/api/getAllItemsInCart/2`)
    const accountCart = await res.json()

    return {props: {accountCart}}
}


export default CartItems;