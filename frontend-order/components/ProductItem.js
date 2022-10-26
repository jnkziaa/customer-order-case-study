import React from 'react';
import Link from "next/link";

function ProductItem({products}) {

    return (
        <div className="card">
            <Link href={`/product/${products.pid}`}>

                <img
                    src={products.productImage}
                    className="rounded shadow"/>

            </Link>
            <div className="flex flex-col items-center justify-center p-5">
                <Link href={`/product/${products.pid}`}>
                </Link>
                <p className="mb-2 text-lg font-bold text-indigo-600">{products.productName}</p>
                <p className="mb-2">Availablel Quantity : {products.productAvailableQuantity}</p>
                <p>${products.productPrice}</p>
                <button className="primary-button" type="button">
                    Add to cart
                </button>
            </div>

        </div>
    );
}

export default ProductItem;