document.addEventListener('DOMContentLoaded', () => {
    fetchFuncionarios();
});

function fetchFuncionarios() {
    fetch('http://localhost:8080/funcionarios')
        .then(response => response.json())
        .then(data => {
            const tbody = document.getElementById('funcionarios-tbody');
            tbody.innerHTML = '';
            data.forEach(funcionario => {
                const tr = document.createElement('tr');
                tr.innerHTML = `
                            <td>${funcionario.nome}</td>
                            <td>${funcionario.cargo}</td>
                            <td><a href="${funcionario.planoCarreiraUrl}" class="btn btn-primary btn-sm">Ver Plano</a></td>
                        `;
                tbody.appendChild(tr);
            });
        })
        .catch(error => console.error('Erro ao buscar dados:', error));
}