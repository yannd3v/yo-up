document.getElementById('registrationForm').addEventListener('submit', async function(event) {
    event.preventDefault();


    const nome = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const senha = document.getElementById('password').value;


    const funcionarioDTO = {
        nome: nome,
        email: email,
        senha: senha
    };

    try {
        const response = await fetch('http://localhost:8080/funcionarios', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(funcionarioDTO)
        });


        if (response.ok) {
            const result = await response.json();
            console.log('Cadastro realizado com sucesso:', result);
            alert('Cadastro realizado com sucesso!');
            document.getElementById('registrationForm').reset();
        } else {
            const errorData = await response.json();
            console.error('Erro ao cadastrar:', errorData);
            alert('Erro ao cadastrar: ' + errorData.message);
        }
    } catch (error) {
        console.error('Erro na requisição:', error);
        alert('Erro na requisição: ' + error.message);
    }
});
