import React from 'react';
import Link from "next/link";



function ShoppingCart({cart}) {

    let num = cart.totalCost;
    let fixedNum = num.toFixed(2);
    return (
        <div>
            <div className="card shadow-md bg-gray-200 flex justify left w-1/3 h-3/4">
                <div className="flex flex-col items-center justify-center p-5">
                    <Link href={`/product/${cart.productName}`}>
                    </Link>
                    <p className="mb-2 text-lg font-bold text-indigo-600">{cart.productName}</p>
                    <p className="mb-2 font-bold text-md font-bold text-orange-400 justify-left">Cart Quantity
                        : {cart.productQuantityAmount}</p>
                    <p className="font-extrabold pb-4 text-red-500">Product Total Cost : ${fixedNum}</p>
                </div>
            </div>
        </div>

    );
}

export default ShoppingCart;