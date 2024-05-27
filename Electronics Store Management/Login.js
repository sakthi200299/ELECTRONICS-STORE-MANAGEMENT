// Function to handle authentication
function authenticateUser(username, password) {
    const loginData = {
        customerName: username,
        customerPassword: password
    };

    return fetch('http://localhost:8356/customer/authenticate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(loginData)
    })
    .then(response => {
        if (!response.ok) {
            return response.json().then(error => {
                throw new Error(error.message || 'Authentication failed');
            });
        }
        return response.json();
    });
}

// Function to fetch customer data and get customer ID
function fetchCustomerData(username) {
    return fetch('http://localhost:8356/customer/all')
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to fetch customer data');
        }
        return response.json();
    })
    .then(customers => {
        const customer = customers.find(cust => cust.customerName === username);
        if (!customer) {
            throw new Error('Customer not found');
        }
        return customer.customer_id;
    });
}

// Event listener for form submission
document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    authenticateUser(username, password)
    .then(data => {
        if (data.message === "Authentication successful") {
            const role = data.role; // Assuming the role is returned from the server
            if (role === "admin") {
                alert('Admins are not allowed to log in.');
                return; // Prevent further execution
            }
            return fetchCustomerData(username)
            .then(customerId => {
                window.location.href = `index.html?customerId=${customerId}`; // Redirect with customerId in the query string
            });
        } else {
            throw new Error('Login failed. Please check your username and password.');
        }
    })
    .catch(error => {
        alert(error.message || 'Login failed. Please try again.');
    });
});
