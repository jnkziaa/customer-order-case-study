import Head from "next/head";
import Layout from '../components/layout';
import CreateOrder from '../components/create-order';

export default function Home(){
    return(
        <div>
            <Head>
                <title>FruityZone</title>
                <meta name="description" content="Full Stack Fruit Seller "/>
                <link rel="icon" href="/favicon.ico"/>
            </Head>
            <Layout>
                <CreateOrder/>
            </Layout>
        </div>
    )
}