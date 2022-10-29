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
                   <YouTube videoId="b165xRXy2Oc" opts={videoOptions} />
               </div>
       </Layout>
    );
}

export default AccountPage;