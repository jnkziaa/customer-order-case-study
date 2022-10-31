import Layout from "../components/Layout";
import React from "react";
import Link from "next/link";

function Card1() {
    return (
        <div className=" pt-40 lg:flex-row flex inline-block justify-center gap-52">
            <img className="items-center justify-center pb-4 h-1/2 w-1/2" src="https://domf5oio6qrcr.cloudfront.net/medialibrary/11525/0a5ae820-7051-4495-bcca-61bf02897472.jpg" alt=""/>
            <div>
                <h1 className="font-extrabold text-5xl items-center justify-center pb-10"> "Apple a day<br/>
                    Keeps the doctor away"</h1>
                <h2 className="font-semibold tracking-wide"> Apples are loaded with important nutrients<br/>
                    including fiber, vitamins, minerals, and antioxidants.<br/>.</h2>
            </div>
        </div>
    )
}

function Card2() {
    return (
        <div className=" bg-gray-200 pt-40 lg:flex-row flex inline-block justify-center gap-52">
            <div>
                <h1 className="font-extrabold text-5xl items-center justify-center pb-10"> According to research<br/> eating bananas can lower<br/> the risk of strokes and
                heart attacks</h1>

            </div>
            <img className="items-center justify-center pb-4" src="https://c.tenor.com/Vb22ucIRvpUAAAAC/minions-despicableme.gif" alt=""/>
        </div>
    );
}

function Card3() {
    return (
        <div className=" pt-40 lg:flex-row flex inline-block justify-center gap-52">
            <img className="items-center justify-center pb-4 h-1/5 w-1/6" src="https://cdn11.bigcommerce.com/s-kc25pb94dz/images/stencil/1280w/products/197/954/Carrot__41894.1646667854.jpg" alt=""/>
            <div>

                <h1 className="font-extrabold text-5xl items-center justify-center pb-10"> According to research<br/> Carrots are not a fruit </h1>
            </div>
        </div>
    );
}

function Card4() {
    return (
        <div className="bg-white pt-20 pb-20 flex-col flex inline-block items-center justify-center gap-10">
            <h1 className="text-gray-800 text-5xl font-extrabold">SOMETHING SOMETHING HERE </h1>
            <h2 className="font-semibold text-lg text-center"> Honestly I want to add more stuff here but im running out of time so theres that<br/>
            this is pretty fun tho, but no ones gonna read this anyway, heres a picture of a broccoli for the lulz</h2>
            <img className="items-center justify-center pb-4 h-3/5 w-3/5" src="https://www.hopkinsmedicine.org/sebin/t/c/broccoli-og.jpg" alt=""/>
            <h1 className="text-gray-800 text-3xl font-extrabold">What a beautiful Broccoli</h1>
            <Link href="/SignIn">
                <button className="bg-gray-500 text-white gap-4 w-75 font-medium flex items-center justify-center rounded-full p-4 text-lg hover:shadow-2xl
                        hover:text-discord_blurple focus:outline-none whitespace-nowrap"> Login Now
                </button>
            </Link>
        </div>
    )
}

function HomeFruit() {
    return (
        <Layout>
            <div
                className='bg-[url("https://images8.alphacoders.com/107/1079173.jpg")] h-full w-full bg-cover pb-40 md:pb-0 text flex items-center justify-center'>
                <div className="p-7 py-40 h-screen:scale-100 md:flex relative">
                    <div className="flex flex-col gap-7 md:max-w-md lg:max-w-none">
                        <h1 className="text-7xl font-extrabold items-center justify-left text-white"> Fruit Facts</h1>
                        <h2 className="text-lg font-semibold tracking-wide lg:max-w-3xl w-full ">
                            <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                        </h2>

                    </div>
                </div>
            </div>
            <Card1/>
            <Card2/>
            <Card3/>
            <Card4/>
        </Layout>
    )
}

export default HomeFruit;