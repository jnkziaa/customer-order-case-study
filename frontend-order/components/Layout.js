import React from 'react';
import Navbar from "./Navbar";
import Head from "next/head";
import ProductsList from "./ProductsList";


function Layout() {
    return (
        <>
            <Head>
                <title> Order Management Application</title>
                <meta name="description" content="Fruit Selling Website"/>
            </Head>
            <div className="flex min-h-screen flex-col justify-between">
                <header>
                    <Navbar/>
                </header>
                <main className="container m-auto mt-4 px-4">
                    <HomePage/>
                    <ProductsList/>
                </main>
                <footer className="flex h-10 justify-center items-center shadow-inner">
                    Copyright 2022 GENERIC FRUIT NAME
                </footer>
            </div>
        </>
    );
}

export default Layout;