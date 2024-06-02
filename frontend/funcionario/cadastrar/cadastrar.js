
document.getElementById('registrationForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const formData = {
        name: document.getElementById('name').value,
        email: document.getElementById('email').value,
        password: document.getElementById('password').value,
    };

    const funcionarioDTO = {
        nome: nome,
        email: email,
        senha: senha
    }

    fetch('http://localhost:8080/funcionarios', {
        method: 'POST',
        headers:{
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(funcionarioDTO)
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Erro ao cadastrar funcionário');
            }
        })
        .then(formData => {
            console.log('Sucesso:', data);
            alert('Funcionário cadastrado com sucesso!');
        })
        .catch(error => {
            console.error('Erro:', error);
            alert('Erro ao cadastrar funcionário');
        });
});

    window.location.href = '/plano_carreira/cadastrar/cadastrar.html';