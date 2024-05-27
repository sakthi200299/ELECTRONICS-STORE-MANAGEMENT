function addProduct(event) {
    event.preventDefault();

    const serviceTag = document.getElementById('serviceTag').value;
    const productName = document.getElementById('productName').value;
    const productCost = document.getElementById('productCost').value;

    if (serviceTag.trim() === '' || productName.trim() === '' || productCost.trim() === '') {
        alert('Please fill out all fields');
        return;
    }

    const newProduct = {
        serviceTag : serviceTag,
        productName: productName,
        productCost: parseFloat(productCost)
    };
    console.log(newProduct);

    fetch('http://localhost:8356/product/add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newProduct)
    })
    .then(function(response) {
        if (!response.ok) {
            throw new Error('add product');
        }
        // Check if response is not empty before parsing JSON
        if (response.status === 204) { // 204 No Content status means empty response
            // Handle empty response
            return null;
        } else {
            return response.json(); // Parse JSON if response is not empty
        }
    })
    .then(function(data) {
        if (data === null) {
            alert('Product added successfully');
        } else {
            alert('Product added successfully with data: ' + JSON.stringify(data));
        }
        // Clear the form fields after successful addition
        document.getElementById('serviceTag').value = '';
        document.getElementById('productName').value = '';
        document.getElementById('productCost').value = '';
    })
    .catch(function(error) {
        //console.error('Error adding product:', error.message); // Log the error message only
        alert(' add product. Please try again.'); // Display a generic error message to the user
    });
}
// Update Product Function
function updateProduct(event) {
    event.preventDefault(); // Prevent the form from submitting in the traditional way

    // Collect the form data
    const productId = document.getElementById('updateProductId').value;
    const serviceTag = document.getElementById('updateServiceTag').value;
    const productName = document.getElementById('updateProductName').value;
    const productCost = document.getElementById('updateProductCost').value;

    fetch(`http://localhost:8356/product/update/${productId}`, {
        method: 'PUT', // Assuming your API uses PUT method for updates
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            serviceTag: serviceTag,
            productName: productName,
            productCost: productCost
        }),
    })
    .then(response => {
        if (response.ok) {
            // Product updated successfully, handle accordingly (e.g., show a success message)
            alert('Product updated successfully');
            fetchProducts(); // Refresh product list after update
        } else {
            // Product update failed, handle accordingly (e.g., show an error message)
            console.error('Failed to update product');
        }
    })
    .catch(error => {
        console.error('Error updating product:', error);
    });
}

// Delete Product Function
function deleteProduct(event) {
    event.preventDefault();
    const productId = document.getElementById('deleteProductId').value;
    if (!productId) {
        alert('Please enter a product ID');
        return;
    }
    if (confirm('Are you sure you want to delete this product?')) {
        fetch(`http://localhost:8356/product/delete/${productId}`, {
            method: 'DELETE'
        })
        .then(response => {
            if (response.ok) {
                alert('Product deleted successfully');
                fetchProducts(); // Refresh product list after deletion
            } else {
                throw new Error('delete product');
            }
        })
        .catch(error => {
            console.error('Error deleting product:', error);
            alert('Failed to delete product. Please try again later.');
        });
    }
}

// Function to fetch and display products
function fetchProducts() {
    fetch('http://localhost:8356/product/all')
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to fetch products. Server responded with status: ' + response.status);
            }
            return response.json(); // Assuming the response is JSON
        })
        .then(data => {
            displayProductData(data);
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
            alert('Failed to fetch products. Please try again later.');
        });
}
function createActionButton(productId) {
    const button = document.createElement('button');
    button.textContent = 'Action';
    button.addEventListener('click', function() {
        performAction(productId);
    });
    const container = document.createElement('div');
    container.classList.add('action-button-container');
    container.appendChild(button);
    return container;
}
// Function to display product data
function displayProductData(data) {
    const tbody = document.getElementById('productTableBody');
    tbody.innerHTML = ''; // Clear existing rows
    data.forEach(product => {
        const row = `
            <tr>
                <td>${product.productId}</td>
                <td>${product.serviceTag || ''}</td>
                <td>${product.productName || ''}</td>
                <td>${product.productCost}</td>
                <td><button onclick="selectOrder(${product.productId}, '${product.productName}', ${product.productCost})">Select Order</button></td>
            </tr>
        `;
        tbody.innerHTML += row;
    });
}
function selectOrder(productId, productName, productCost) {
    const url= `customers.html?productId=${productId}&productName=${encodeURIComponent(productName)}&productCost=${productCost}`;
    window.location.href = url;
}
// Call fetchProducts when the page loads to initially display the products
window.onload = fetchProducts;
// Function to fetch products from the server

