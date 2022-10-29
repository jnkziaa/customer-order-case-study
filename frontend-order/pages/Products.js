import React from 'react';
import Layout from "../components/Layout";
import ProductItem from "../components/ProductItem";



export async function getStaticProps() {
    const res = await fetch("http://localhost:9090/api/products");
    const prods= await res.json();

    return {
        props: {
            prods,
        },
    }
}


function Products({prods}) {
    return (
        <Layout>
            <div className="grid grid-cols-1 gap-4 md:grid-cols-3 lg:grid-cols-4">
                {prods?.map((product) => (
                    <ProductItem product={product} key={product.pid}></ProductItem>
                ))
                }
            </div>
        </Layout>
    );
}

export default Products;