import React from 'react';

function OrderedItems({items}) {
    let nums = items.totalCost;
    let numsOutput = nums.toFixed(2)
    return (
        <tr key={items.archivedOrderID} className="shadow-sm">
            <td className="text-left px-6 py-4 whitespace-nowrap">
                <div className="text-md font-bold text-gray-200">{items.productName}</div>
            </td>
            <td className="text-left px-6 py-4 whitespace-nowrap">
                <div className="text-md font-bold text-gray-200">{items.productQuantityAmount} Pieces</div>
            </td>
            <td className="text-left px-6 py-4 whitespace-nowrap">
                <div className="text-md font-bold text-gray-200">${numsOutput}</div>
            </td>
        </tr>
    );
}

export default OrderedItems;