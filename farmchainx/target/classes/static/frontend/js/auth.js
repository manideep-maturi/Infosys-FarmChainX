function clearErrors() {
    document.getElementById("nameError").innerText = "";
    document.getElementById("emailError").innerText = "";
    document.getElementById("passwordError").innerText = "";
    document.getElementById("roleError").innerText = "";
}

function registerUser() {

    clearErrors();

    const name = document.getElementById("name").value.trim();
    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value.trim();
    const role = document.getElementById("role").value;

    let isValid = true;

	// Name validation (RELIABLE VERSION)
	if (name === "") {
	    document.getElementById("nameError").innerText = "* Name is required";
	    isValid = false;
	} else if (name.length < 4) {
	    document.getElementById("nameError").innerText =
	        "* Name must be at least 4 characters";
	    isValid = false;
	}


    // Email validation
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!email) {
        document.getElementById("emailError").innerText = "* Email is required";
        isValid = false;
    } else if (!emailPattern.test(email)) {
        document.getElementById("emailError").innerText = "* Invalid email format";
        isValid = false;
    }

    // Password validation
    const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{6,}$/;
    if (!password) {
        document.getElementById("passwordError").innerText = "* Password is required";
        isValid = false;
    } else if (!passwordPattern.test(password)) {
        document.getElementById("passwordError").innerText =
            "* Min 6 chars, include upper, lower & number";
        isValid = false;
    }

    // Role validation
    if (!role) {
        document.getElementById("roleError").innerText = "* Role is required";
        isValid = false;
    }

    if (!isValid) return;

    // Backend call
    fetch("http://localhost:8081/api/auth/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, email, password, role })
    })
    .then(res => {
        if (res.status === 400 || res.status === 409) {
            throw new Error("exists");
        }
        return res.json();
    })
    .then(() => {
        alert("Registration successful");
        window.location.href = "login.html";
    })
    .catch(() => {
        document.getElementById("emailError").innerText =
            "* User already exists. Please login";
    });
}
