import React from 'react';
import Navbar from "./Navbar";
import Head from "next/head";


function Layout({children}) {
    return (
        <>
            <Head>
                <title> Order Management Application</title>
                <meta name="description" content="Fruit Selling Website"/>
            </Head>
            <div className="">
                <header>
                    <Navbar/>
                </header>
                <main>
                    {children}
                </main>
                <footer className="flex h-10 justify-center items-center shadow-inner">
                    Copyright 2022 GENERIC FRUIT NAME
                </footer>
            </div>
        </>
    );
}

export default Layout;