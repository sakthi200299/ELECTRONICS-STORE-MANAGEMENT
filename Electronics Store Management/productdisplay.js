function fetchAllProducts() {
    fetch('http://localhost:8356/product/all')
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to fetch products. Server responded with status: ' + response.status);
            }
            return response.json(); // Assuming the response is JSON
        })
        .then(data => {
            renderProductTable(data);
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
            alert('Failed to fetch products. Please try again later.');
        });
}

// Function to render product data in the table
function renderProductTable(products) {
    const tbody = document.getElementById('producttableBody');
    tbody.innerHTML = ''; // Clear existing rows
    products.forEach(product => {
        const row = `
            <tr>
                <td>${product.productId}</td>
                <td>${product.serviceTag || ''}</td>
                <td>${product.productName || ''}</td>
                <td>${product.productCost}</td>
            
        `;
        tbody.innerHTML += row;
    });
}

// Function to handle order selection


// Call fetchAllProducts when the page loads to initially display the products
window.onload = fetchAllProducts;