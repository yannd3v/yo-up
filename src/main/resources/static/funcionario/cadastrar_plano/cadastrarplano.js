
let funcionario_id;
async function getFuncionarioId() {
    try {
        const response = await fetch('http://localhost:8080/funcionarios/{id}', {
            method: 'GET'
        });
        if (response.ok) {
            const data = await response.json();
            funcionario_id = data.funcionario_id;
        } else {
            console.error('Erro ao obter funcionario_id:', response.statusText);
        }
    } catch (error) {
        console.error('Erro na requisição:', error);
    }
}

window.onload = getFuncionarioId();
document.getElementById('registrationForm').addEventListener('submit', async function (event) {
    event.preventDefault();


    const cargoAtual = document.getElementById('cargoAtual').value;
    const cargoFuturo = document.getElementById('cargoFuturo').value;
    const objetivoCarreira = document.getElementById('objetivoCarreira').value;


    const planoCarreiraDTO = {
        cargoAtual: cargoAtual,
        cargoFuturo: cargoFuturo,
        objetivoCarreira: objetivoCarreira,
        funcionario_id: funcionario_id
    };


    try {
        const response = await fetch('http://localhost:8080/planocarreira', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(planoCarreiraDTO)
        });


        if (response.ok) {
            const result = await response.json();
            console.log('Plano de carreira realizado com sucesso:', result);
            alert('Plano de carreira realizado com sucesso!');
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


