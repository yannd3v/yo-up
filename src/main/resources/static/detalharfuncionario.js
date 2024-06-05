document.addEventListener("DOMContentLoaded", function () {

    function carregarDadosFuncionario(id) {
        if (!id) {
            console.error('ID do funcionário não encontrado');
            return;
        }

        fetch(`/funcionarios/${id}`)
            .then(response => response.json())
            .then(data => {
                document.getElementById('id').value = data.id;
                document.getElementById('nome').value = data.nome;
                document.getElementById('email').value = data.email;
                document.getElementById('experiencia').value = data.experiencia;
                document.getElementById('habilidades').value = data.habilidades;
            })
            .catch(error => {
                console.error('Erro ao obter dados do funcionário:', error);
            });
    }

    const urlParams = new URLSearchParams(window.location.search);
    const idFuncionario = urlParams.get('id');

    console.log('ID do funcionário extraído da URL:', idFuncionario); // Log para verificar o valor do ID


    carregarDadosFuncionario(idFuncionario);


    document.getElementById('saveBtn').addEventListener('click', function () {
        const idFuncionario = document.getElementById('id').value;
        const nome = document.getElementById('nome').value;
        const email = document.getElementById('email').value;
        const experiencia = document.getElementById('experiencia').value;
        const habilidades = document.getElementById('habilidades').value;

        if (!idFuncionario) {
            console.error('ID do funcionário não encontrado');
            return;
        }

        fetch(`/funcionarios`, {
            method: 'PUT',
            body: JSON.stringify({ id: idFuncionario, nome, email, experiencia, habilidades }),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (response.ok) {
                alert('Perfil do funcionário atualizado com sucesso!');
            }
        }).catch(error => {
            console.error('Erro ao atualizar perfil do funcionário:', error);
        });
    });
});
