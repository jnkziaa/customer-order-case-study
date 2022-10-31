import Link from "next/link";


function Navbar({output}) {

    console.log({output});
    return (
        <nav
            className="flex h-16 items-center px-4 justify-between shadow-md bg-gray-800">
            <div className="flex h-16 items-center px-4 justify-between bg-gray-800">
                <Link href="/">
                    <img
                        src="https://www.designfreelogoonline.com/wp-content/uploads/2019/09/00677-APPLE-03.png"
                        alt=""
                        className="w-32 h-12 object-contain" />
                </Link>
            </div>
            <div className="hidden lg:flex space-x-8 text-blue-500 flex items-center text-white">
                <Link href="/Home" className="cursor-pointer font-semibold text-lg hover:underline">Home</Link>
                <Link href="/Products" className="cursor-pointer font-semibold text-lg hover:underline">Products</Link>
                <Link href="/CartItems" className="cursor-pointer font-semibold text-lg hover:underline">Shopping Cart</Link>
                <Link href="/Checkout" className="cursor-pointer font-semibold text-lg hover:underline">Checkout</Link>
                <Link href="/" className="cursor-pointer font-semibold text-lg hover:underline">Blog</Link>
            </div>
            <div className="flex space-x-4">
                <Link href="/SignIn">
                    <button className="bg-green-400 p-3 rounded-full text-xs px-6 md:text-sm focus:outline-none
                 hover:shadow-2xl font-semibold hover:text-discord_blurple transition duration-200 ease-in-out
                 whitespace-nowrap"
                    >Account
                    </button>
                </Link>

            </div>
        </nav>
    );
}


export default Navbar;