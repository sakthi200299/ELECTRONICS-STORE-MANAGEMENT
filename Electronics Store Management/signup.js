function signUp(event) {
    event.preventDefault();

    const customerName = document.getElementById('customerName').value;
    const customerPhone = document.getElementById('customerPhone').value;
    const customerPassword = document.getElementById('customerPassword').value;
    const role='user';
    if (customerName.trim() === '' || customerPhone.trim() === '' ||customerPassword.trim() === '') {
        alert('Please fill out all fields');
        return;
    }

    const newUser = {
        customerName:customerName,
        customerPhone:customerPhone,
        customerPassword:customerPassword,
        role:role
    };
    console.log(newUser);

    fetch('http://localhost:8356/customer/add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newUser)
    })
    .then(function(response) {
        if (!response.ok) { 
            
            throw new Error('sign up');
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
            alert('Sign up successful');
        } else {
            alert('Sign up successful with data: ' + JSON.stringify(data));
        }
        // Clear the form fields after successful sign up
        document.getElementById('customerName').value = '';
        document.getElementById('customerPhone').value = '';
        document.getElementById('customerPassword').value = '';
    })
    .catch(function(error) {
       
        alert('Sign up'); // Display a generic error message to the user
    });
}
