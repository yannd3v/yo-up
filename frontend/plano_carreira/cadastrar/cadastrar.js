// script.js
document.getElementById('registrationForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const formData = {
        cargoAtual: document.getElementById('cargoAtual').value,
        cargoFuturo: document.getElementById('cargoFuturo').value,
        experiencia: document.getElementById('experiencia').value,
        habilidades: document.getElementById('habilidades').value
    };
    
    console.log("Form Data:", formData);
    alert('Preparando seu Plano de Carreira personalizado...');
    window.location.href = '/funcionario/home_page/dashboard.html';
});
