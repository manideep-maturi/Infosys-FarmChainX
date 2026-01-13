function clearLoginErrors() {
    document.getElementById("emailError").innerText = "";
    document.getElementById("passwordError").innerText = "";
}

function loginUser() {

    clearLoginErrors();

    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value.trim();

    let isValid = true;

    // Email validation
    if (!email) {
        document.getElementById("emailError").innerText = "* Email is required";
        isValid = false;
    }

    // Password validation
    if (!password) {
        document.getElementById("passwordError").innerText = "* Password is required";
        isValid = false;
    }

    if (!isValid) return;

    fetch("http://localhost:8081/api/auth/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, password })
    })
    .then(res => {
        if (res.status === 401 || res.status === 400) {
            throw new Error("Invalid credentials");
        }
        return res.json();
    })
    .then(user => {
        if (user.role === "FARMER") {
            window.location.href = "farmer.html";
        } else if (user.role === "DISTRIBUTOR") {
            window.location.href = "distributor.html";
        } else {
            window.location.href = "consumer.html";
        }
    })
    .catch(() => {
        document.getElementById("passwordError").innerText =
            "* Wrong email or password";
    });
}
