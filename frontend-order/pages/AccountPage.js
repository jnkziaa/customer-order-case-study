import Layout from "../components/Layout";
import YouTube from "react-youtube";
import React from "react";


function AccountPage() {
    const videoOptions = {
        height: '983',
        width: '2133',
        playerVars: {
            autoplay: 1,
            controls: 1,
            rel: 0,
            showinfo: 0,
            mute: 0,
            loop: 1
        }
    }
    return (
       <Layout>
               <div className="flex justify-center">
                   <img src="https://images.hdqwalls.com/download/minion-bananas-2932x2932.jpg" />
               </div>
       </Layout>
    );
}

export default AccountPage;