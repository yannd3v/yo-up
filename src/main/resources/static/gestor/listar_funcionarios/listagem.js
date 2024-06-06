document.addEventListener('DOMContentLoaded', () => {
    fetchFuncionarios();
});

function fetchFuncionarios() {
    fetch('http://localhost:8080/funcionarios/all')
        .then(response => response.json())
        .then(data => {
            const tbody = document.getElementById('funcionarios-tbody');
            tbody.innerHTML = '';
            data.forEach(funcionario => {
                const tr = document.createElement('tr');
                tr.innerHTML = `
                            <td>${funcionario.id}</td>  
                            <td>${funcionario.nome}</td>
                            <td><a href="../plano_carreira/planocarreira.html?id=${funcionario.id}" class="btn btn-primary btn-sm">Ver Plano</a></td>
                        `;
                tbody.appendChild(tr);
            });
        })
        .catch(error => console.error('Erro ao buscar dados:', error));
}