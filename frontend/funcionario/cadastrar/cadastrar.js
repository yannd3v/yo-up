
document.getElementById('registrationForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const formData = {
        name: document.getElementById('name').value,
        email: document.getElementById('email').value,
        password: document.getElementById('password').value,
    };
    
    console.log("Form Data:", formData);
    alert('Conta criada com sucesso!');
    window.location.href = '/plano_carreira/cadastrar/cadastrar.html';



    
});