
async function login() {
    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;

    const loginRequest = {
        email: email,
        senha: senha
    };

    try {
        const response = await fetch('http://localhost:8080/funcionarios/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(loginRequest)
        });

        if (response.ok) {
            const funcionario = await response.json();
            console.log('Login bem-sucedido:', funcionario);
            sessionStorage.setItem('id_funcionario', funcionario['id']);
            alert('Login bem-sucedido!');
            window.location.href = '../../funcionario/dashboard/dashboardfuncionario.html';
        } else {
            alert('Email ou senha incorretos');
        }
    } catch (error) {
        console.error('Erro na requisição:', error);
        alert('Erro na requisição: ' + error.message);
    }
}



  function redirectToRegistration(){
    window.location.href = '../../funcionario/cadastrar/cadastrarfuncionario.html'
}
    

    