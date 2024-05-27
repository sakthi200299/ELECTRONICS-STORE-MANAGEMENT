// Function to add a new order
function addOrder(event) {
    event.preventDefault();


    const customerName = document.getElementById('customerName').value;
    const orderCost = document.getElementById('orderCost').value;
    const totalQuantity = document.getElementById('totalQuantity').value;

    if (customerName.trim() === '' || orderCost.trim() === '' || totalQuantity.trim() === '') {
        alert('Please fill out all fields');
        return;
    }

    const newOrder = {
     
        customerName: customerName,
        orderCost: orderCost * totalQuantity,
        totalQuantity: totalQuantity,
        status: 'pending' // Set status to pending by default
    };

    fetch('http://localhost:8356/orders/add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newOrder)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to add order');
        }
        return response.json();
    })
    .then(data => {
        alert('Order added successfully');
     
        document.getElementById('customerName').value = '';
        document.getElementById('orderCost').value = '';
        document.getElementById('totalQuantity').value = '';
    })
    .catch(error => {
        alert('order add');
    });
}
