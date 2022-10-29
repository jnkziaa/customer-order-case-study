import React from 'react';
import Layout from "../components/Layout";
import ShoppingCart from "../components/ShoppingCart";


function CartItems({accountCart}) {
    return (
        <Layout>
            <div className="grid grid-rows-1 gap-4 md:grid-rows-3 lg:grid-rows-4">
                {accountCart?.map((cart) => (
                    <ShoppingCart cart={cart} key={cart.cartItemID}></ShoppingCart>
                ))
                }
            </div>
        </Layout>
    );
}


export async function getStaticProps() {
    const res = await fetch(`http://localhost:9090/api/getAllItemsInCart/1`)
    const accountCart = await res.json()

    return {props: {accountCart}}
}



export default CartItems;