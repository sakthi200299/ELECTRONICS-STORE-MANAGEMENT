document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    const loginData = {
        customerName: username,
        customerPassword: password
    };

    fetch('http://localhost:8356/customer/authenticate', {
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
    })
    .then(data => {
        if (data.message === "Authentication successful") {
            const role = data.role; // Assuming the role is returned from the server
            if (role === "admin") {
                throw new Error("Only admins are allowed to log in.");
            }
            alert('Login successful');
            const customerId = data.customerId;
            window.location.href = `Admincrud.html?customerId=${customerId}`;
        } else {
            alert('Login failed. Please check your username and password.');
        }
    })
    .catch(error => {
        alert(error.message || 'Login failed. Please try again.');
    });
});
