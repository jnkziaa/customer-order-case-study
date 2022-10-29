import React, {useState} from 'react';
import Link from "next/link";
import Layout from "../../components/Layout";





const ActualItems = ({products}) => {

    const [quantity, setQuantity] = useState([]);
    const name = products.productName;
    const submitProduct = async () => {
        const response = await fetch('http://localhost:9090/api/addToCart', {
            method: 'POST',
            body: JSON.stringify({
                cartItemsInfo: {
                    "productName": name,
                    "productQuantityAmount": quantity,
                    "cid": 1
                }
            }),
            headers: {
                'Content-Type': 'application/json'
            },

        })
    }

        return (
            <Layout>
                <div className="p-5">
                    <Link href="/Products" className="text-gray-500 font-bold"> Back to Product Page</Link>
                    <div className="grid md:grid-cols-4 md:gap-3 pt-14">
                        <div className="md:col-span-2 rounded ">
                            <img src={products.productImage} className="rounded shadow shadow-indigo-600 w-3/4 h-full"/>
                        </div>
                        <div className="card p-5 shadow-md shadow-indigo-600 bg-gray-200">
                            <div className="flex justify-center pb-5">
                                <h1 className="text-3xl pt-4 font-extrabold text-blue-600 ">{products.productName}</h1>
                            </div>
                            <div className="mb-2 flex justify-between">
                                <div className="text-2xl text-gray-500"> Price :</div>
                                <div className="text-2xl font-bold text-red-500"> ${products.productPrice}</div>
                            </div>
                            <div className="mb-2 flex justify-between">
                                <div className="text-2xl text-gray-500"> Quantity :</div>
                                <div
                                    className="text-2xl font-bold text-orange-400"> {products.productAvailableQuantity} left
                                </div>
                            </div>
                            <div className="mb-2 flex justify-between">
                                <div className="text-2xl text-gray-500"> Status :</div>
                                <div
                                    className=" text-2xl font-bold text-green-400">{products.productAvailableQuantity > 0 ? "In Stock" : "Unavailable"}</div>
                            </div>
                            <input className="mb-2 flex w-full shadow-inner p-5 rounded outline outline-blue-300"
                                   type="number"
                                   value={quantity}
                                   onChange={(e) => setQuantity(e.target.value)}
                                   placeholder="Quantity : 1">
                            </input>
                            <button
                                className="rounded bg-green-400 py-2 px-4 shadow outline-none hover:bg-green-400 active:bg-green-700 w-full"
                                onClick={submitProduct}
                            >
                                Add to cart
                            </button>

                        </div>
                    </div>
                </div>
            </Layout>
        )
    }


export async function getStaticPaths() {
    const res = await fetch('http://localhost:9090/api/products')
    const productIDs = await res.json()

    const paths = productIDs.map((productID) => ({
        params: {pid: productID.pid.toString()},
    }))

    return {paths, fallback: false}
}


export async function getStaticProps({params}) {
    const res = await fetch(`http://localhost:9090/api/products/${params.pid}`)
    const products = await res.json()

    return {props: {products}}
}

export default ActualItems;


