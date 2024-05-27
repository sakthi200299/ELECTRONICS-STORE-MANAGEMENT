function fetchAllData() {
    fetch('http://localhost:8356/orders/getall')
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to fetch Orders. Server responded with status: ' + response.status);
            }
            return response.json(); // Assuming the response is JSON
        })
        .then(orders => {
            // Display the data
            displayData(orders);
        })
        .catch(error => {
            alert('Failed to fetch data. Please try again later.');
        });
}

// Function to display the data in the table
function displayData(data) {
    const tbody = document.getElementById('OrdersTableBody');
    tbody.innerHTML = ''; // Clear existing rows

    // Display only the last order
    const lastOrder = data[data.length - 1];
    const row = `
        <tr>
            <td>${lastOrder.orderId}</td>
            <td>${new Date(lastOrder.orderDate).toLocaleString() || ''}</td>
            <td>${lastOrder.orderCost}</td>
            <td>${lastOrder.totalQuantity}</td>
            <td>${lastOrder.customerName}</td>
            <td>${lastOrder.status}</td>
            <td>
             
                <button onclick="cancelOrder(${lastOrder.orderId})">Cancel</button>
                <button onclick="makeOffer(${lastOrder.orderId})">Offer</button>
                <button onclick="makePayment(${lastOrder.orderId})">Payment</button>
            </td>
        </tr>
    `;
    tbody.innerHTML = row;
}

// Function to handle payment
function makePayment(orderId) {
    // Redirect to payment.html with order ID appended as query parameter
    window.location.href = `payment.html?orderId=${orderId}`;
    alert(`Payment initiated for order ${orderId}`);
}

// Function to handle order cancellation
function cancelOrder(orderId) {
    // Implement order cancellation logic here
    alert(`Order ${orderId} canceled`);
}
function makeOffer(orderId) {
    // Implement offer creation logic here
    // Redirect to offer.html with order ID appended as query parameter
    window.location.href = `offer.html?orderId=${orderId}`;
    alert(`Offer made for order ${orderId}`);
}


// Fetch all data when the page loads
window.onload = fetchAllData;
