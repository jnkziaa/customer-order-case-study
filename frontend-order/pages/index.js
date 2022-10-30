import React from 'react';

//import Layout from "../components/Layout";
import SmolLayout from "../components/SmolLayout";
import Link from "next/link";


export default function Home() {
    return (
        <SmolLayout>
            <p><Link href="/SignUp">Sign Up</Link></p>
            <p><Link href="/SignIn">Sign In</Link></p>
        </SmolLayout>
    );
}