//import Products from "./Products";
import {useCallback, useEffect, useState} from "react";
import ProductItem from "./ProductItem";





const ProductsList = () => {
    const PRODUCT_LIST_API = "http://localhost:9090/api/getAllProducts";

    const [prods, setProds] = useState(null);

    const [loading, setLoading] = useState(true);

    const fetchData = useCallback(async () => {


        setLoading(true);
        try{
            const response = await fetch(PRODUCT_LIST_API, {
                method: "GET",
                headers: {
                    "Content-Type": "application/json",
                },

            });
            const products = await response.json();
            setProds(products);
        }catch (error) {
            console.log(error);
        }
        setLoading(false);
    }, []);

    useEffect(()=> {
        fetchData();
    }, [fetchData])


    return (
        <div className="grid grid-cols-1 gap-4 md:grid-cols-3 lg:grid-cols-4">
            {prods?.map((prods) => (<ProductItem products={prods} key={prods.pid}/>))}
        </div>
    );
}

export default ProductsList;