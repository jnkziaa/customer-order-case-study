import React from 'react';
import Link from "next/link";
import Layout from "../../components/Layout";


const ActualItems = ({products}) => {
    return (
        <Layout>
            <div className="py-2">
                <Link href="/" className="text-gray-500 font-bold"> Back to Product Page</Link>
                <div className="grid md:grid-cols-4 md:gap-3 pt-14">
                    <div className="md:col-span-2">
                        <img src={products.productImage} className="pl-10 rounded w-3/4 h-full"/>
                    </div>
                    <div className="card p-5 pt-14">
                        <div className="mb-2 flex justify-between">
                            <div className="text-2xl text-gray-500"> Price :</div>
                            <div className="text-2xl text-gray-500"> ${products.productPrice}</div>
                        </div>
                        <div className="mb-2 flex justify-between">
                            <div className="text-md font-bold text-orange-400"> Available Quantity :</div>
                            <div
                                className="text-md font-bold text-orange-400"> {products.productAvailableQuantity} pieces
                                left
                            </div>
                        </div>
                        <div className="mb-2 flex justify-between">
                            <div className="text-2xl text-gray-500"> Status :</div>
                            <div
                                className=" text-2xl text-green-400">{products.productAvailableQuantity > 0 ? "In Stock" : "Unavailable"}</div>
                        </div>
                        <input className="mb-2 flex w-full shadow-inner p-5 rounded outline outline-blue-300"
                               type="number" placeholder="Quantity : 1">
                        </input>
                        <button className="primary-button w-full">
                            Add to cart
                        </button>

                    </div>
                </div>
                <div>
                    <ul>
                        <li>
                            <h1 className="text-3xl pl-64 pt-4 font-extrabold text-blue-600">{products.productName}</h1>
                        </li>
                    </ul>
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


