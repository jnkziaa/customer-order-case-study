import React from 'react';
import Link from "next/link";


function ProductItem({product}) {

    return (
        <div className="card shadow-md bg-gray-300">
            <Link href={`/product/${product.pid}`}>

                <img
                    src={product.productImage}
                    className="rounded-t-lg shadow w-full h-3/5"/>

            </Link>
            <div className="flex flex-col items-center justify-center p-5">
                <Link href={`/product/${product.productName}`}>
                </Link>
                <p className="mb-2 text-lg font-bold text-indigo-600">{product.productName}</p>
                <p className="mb-2 font-bold text-md font-bold text-orange-400">Available Quantity
                    : {product.productAvailableQuantity}</p>
                <p className="font-extrabold pb-4 text-red-500">${product.productPrice}</p>
                <Link href={`/product/${product.pid}`}>
                    <button className="primary-button justify-center" type="button">
                        Add to cart
                    </button>
                </Link>
            </div>

        </div>
    );
}

export default ProductItem;