import {useRouter} from "next/router"
import {useState} from "react"
import Link from "next/link";
import AccountLayout from "../components/AccountLayout";

export default function SignUp() {
    const router = useRouter()

    const [state, setState] = useState({
        username: "",
        email: "",
        password: "",
        city: "",
        stateFrom: ""
    })

    function handleChange(e) {
        const copy = {...state}
        copy[e.target.name] = e.target.value
        setState(copy)
    }

    async function handleSubmit() {
        const res = await fetch(`http://localhost:9090/api/auth/signup`, {
            method: "POST",
            body: JSON.stringify(state),
            headers: {
                "Content-Type": "application/json"
            }
        })
        if (res.ok) {
            alert("user registered success")
            console.log("well it got there")
            router.push("/SignIn")
        }
    }

    return (
        <AccountLayout>
            <div
                className="bg-[url('https://i.pinimg.com/originals/80/ac/3e/80ac3ee1594b83b98d580e2f4cb058cf.jpg')] h-screen w-screen bg-cover flex flex-row justify-center items-center">
                <div
                    className="w-1/4 h-2/3 bg-gradient-to-r from-gray-400 to-gray-500 pl-3 opacity-80 rounded-lg shadow-lg flex flex-row gap-20">
                    <div className="flex flex-col">
                        <h1 className="text-white font-bold text-3xl font-unis tracking-wide justify-center whitespace-nowrap flex px-28 pt-5 text-yellow-400"> Create
                            an Account </h1>
                        <div className="pt-8 font-semibold text-gray-200 px-10 flex flex-col">
                            <label className="text-gray-300 text-sm "> USERNAME *</label>
                            <input type="text" id="username" name="username" placeholder=" " value={state.username}
                                   onChange={handleChange}
                                   className=" pl-5 w-96 flex-1 py-2 rounded-lg border-b-2 border-gray-400 focus:border-green-400
                      text-black placeholder-black
                      outline-none"/>
                            <label className="text-gray-300 text-sm "> EMAIL *</label>
                            <input type="text" id="email" name="email" placeholder=" " value={state.email}
                                   onChange={handleChange}
                                   className=" pl-5 w-96 flex-1 py-2 rounded-lg border-b-2 border-gray-400 focus:border-green-400
                      text-black placeholder-black
                      outline-none"/>
                            <label className="text-gray-300 text-sm "> PASSWORD *</label>
                            <input type="password" id="password" name="password" placeholder="" value={state.password}
                                   onChange={handleChange}
                                   className=" pl-5 w-96 flex-1 py-2 rounded-lg border-b-2 border-gray-400 focus:border-green-400
                      text-black placeholder-black
                      outline-none"/>
                            <label className="text-gray-300 text-sm "> CONFIRM PASSWORD *</label>
                            <input type="password" id="confirmPassword" name="confirmPassword" placeholder=" "
                                   className=" pl-5 w-96 flex-1 py-2 rounded-lg border-b-2 border-gray-400 focus:border-green-400
                      text-black placeholder-black
                      outline-none"/>
                            <label className="text-gray-300 text-sm "> City*</label>
                            <input type="text" id="city" name="city" placeholder="" value={state.city}
                                   onChange={handleChange}
                                   className=" pl-5 w-96 flex-1 py-2 rounded-lg border-b-2 border-gray-400 focus:border-green-400
                      text-black placeholder-black
                      outline-none"/>
                            <label className="text-gray-300 text-sm "> State*</label>
                            <input type="text" id="stateFrom" name="stateFrom" placeholder=" " value={state.stateFrom}
                                   onChange={handleChange}
                                   className=" pl-5 w-96 flex-1 py-2 rounded-lg border-b-2 border-gray-400 focus:border-green-400
                      text-black placeholder-black
                      outline-none"/>
                            <div className="pt-5">
                                <button
                                    className="py-3 pl-5 w-96 bg-green-400 rounded-lg border-b-2 border-gray-400 hover:text-teal-700 text-gray-500"
                                    onClick={handleSubmit}> Register
                                </button>
                            </div>


                            <div className="pt-5">
                                <label> Already have an account? </label>
                                <Link href="/SignIn">
                                    <label
                                        className="hover:text-teal-700 text-red-800 cursor-pointer focus:outline-none"> Login </label>
                                </Link>
                            </div>
                        </div>


                    </div>
                </div>

            </div>
        </AccountLayout>
    )
}