import React from 'react';
import Link from "next/link";


function ProductItem({product}) {

    return (
        <div className="card shadow-md">
            <Link href={`/product/${product.pid}`}>

                <img
                    src={product.productImage}
                    className="rounded-t-lg shadow w-full h-3/5"/>

            </Link>
            <div className="flex flex-col items-center justify-center p-5">
                <Link href={`/product/${product.productName}`}>
                </Link>
                <p className="mb-2 text-lg font-bold text-indigo-600">{product.productName}</p>
                <p className="mb-2 font-bold">Available Quantity : {product.productAvailableQuantity}</p>
                <p className="font-extrabold pb-4">${product.productPrice}</p>
                <button className="primary-button justify-center" type="button">
                    Add to cart
                </button>
            </div>

        </div>
    );
}

export default ProductItem;