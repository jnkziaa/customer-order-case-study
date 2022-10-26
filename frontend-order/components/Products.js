import React from 'react';

function Products({products}) {
    return (

          <tr key={products.pid}>
              <td className="text-left px-6 py-4 whitespace-nowrap">
                  <div className="text-sm text-gray-500">{products.productName}</div>
              </td>
              <td className="text-left px-6 py-4 whitespace-nowrap">
                  <div className="text-sm text-gray-500 pl-10">${products.productPrice}</div>
              </td>
              <td className="text-left px-6 py-4 whitespace-nowrap">
                  <div className="text-sm text-gray-500 pl-10">{products.productAvailableQuantity}</div>
              </td>
              <td className="text-right px-6 py-4 whitespace-nowrap">
                  <a href="#" className="text-lg text-indigo-600 hover:text-indigo-800 hover:cursor-pointer pr-10">Buy</a>
              </td>
          </tr>

    );
}

export default Products;