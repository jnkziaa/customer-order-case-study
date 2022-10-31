import {useRouter} from "next/router"
import {useState} from "react"
import Layout from "../components/layout"
import styles from "../styles/styles.module.css"
import Link from "next/link";
import AccountLayout from "../components/AccountLayout";

export default function SignIn() {
    const router = useRouter()

    const [state, setState] = useState({
        username: "",
        password: ""
    })

    function handleChange(e) {
        const copy = {...state}
        copy[e.target.name] = e.target.value
        setState(copy)
    }

    async function handleSubmit() {
        const res = await fetch(`http://localhost:9090/api/auth/signin`, {
            method: "POST",
            body: JSON.stringify(state),
            headers: {
                "Content-Type": "application/json"
            }
        })
        if (res.ok) {
            const json = await res.json()
            localStorage.setItem("token", json.token)
            router.push("/Home")
        } else {
            alert("Bad credentials")
        }
    }

    return (
        <div className={styles.container}>
            <div
                className="bg-[url('https://images.wallpaperscraft.com/image/single/fruit_exotic_pineapple_apple_avocado_kiwi_43771_3840x2400.jpg')] h-screen w-screen bg-cover flex flex-row justify-center items-center">
                <div
                    className="w-1/4 h-1/2 bg-gradient-to-r from-blue-400 to-red-300  rounded-lg shadow-lg flex flex-row gap-20">
                    <div className="flex flex-col">
                        <h1 className="text-white font-bold text-2xl font-unis tracking-wide justify-center whitespace-nowrap flex px-28 pt-10"> Welcome
                            Back! </h1>
                        <h2 className="text-gray-200 text-18 font-unis tracking-wide flex px-16 justify-center"> We're
                            so excited to see
                            you again!</h2>
                        <div className="pt-8 font-semibold text-gray-200 px-10 flex flex-col">
                            <label className="text-gray-300 text-sm "> EMAIL OR USERNAME *</label>
                            <input className="pl-5 w-96 flex-1 py-2 rounded-lg border-b-2 border-gray-400 focus:border-green-400
                                                    text-black placeholder-black outline-none" type="text" id="username"
                                   name="username" placeholder="" value={state.username}
                                   onChange={handleChange}/>
                            <label className="pt-5 text-gray-300 text-sm "> PASSWORD *</label>
                            <input className="pl-5 w-96 flex-1 py-2 rounded-lg border-b-2 border-gray-400 focus:border-green-400
                                                  text-black placeholder-black outline-none" type="password"
                                   id="password" name="password" placeholder="" value={state.password}
                                   onChange={handleChange}/>
                            <label className="pt-5 pb-5 text-discord_blurple"> Forgot your password?</label>
                            <button className="bg-green-400 p-3 rounded-lg text-xs px-6 md:text-sm focus:outline-none
                 hover:shadow-2xl font-semibold hover:text-blue-600 transition duration-200 ease-in-out
                 whitespace-nowrap text-blue-800" onClick={handleSubmit}> Log in
                            </button>

                            <div className="pt-5">
                                <label> Need an account ? </label>
                                <Link href="/SignUp">
                                    <label
                                        className="hover:text-teal-700 text-red-800 cursor-pointer focus:outline-none"> Register </label>
                                </Link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    )
}