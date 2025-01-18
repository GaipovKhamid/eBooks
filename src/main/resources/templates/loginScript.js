function submitForm() {
    clearErrors();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    fetch('/api/registration', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ email, password })
    })
        .then(response => response.json())
        .then(data => {
            if (response.status !== 200) {
                // Обработка ошибок от сервера
                for (const [field, message] of Object.entries(data)) {
                    setError(field, message);
                }
            } else {
                alert(data); // Успешная регистрация
            }
        })
        .catch(error => console.error('Error:', error));
}
