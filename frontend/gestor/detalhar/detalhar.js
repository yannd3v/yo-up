// script.js
document.getElementById('editBtn').addEventListener('click', function() {
    document.getElementById('editBtn').style.display = 'none';
    document.getElementById('saveBtn').style.display = 'block';

    const fields = ['specialty', 'email', 'phone', 'address'];
    fields.forEach(field => {
        const spanTag = document.getElementById(`${field}Text`);
        const input = document.createElement('input');
        input.type = 'text';
        input.id = `${field}Input`;
        input.value = spanTag.textContent;
        spanTag.parentNode.appendChild(input);
        spanTag.style.display = 'none';
    });
});

document.getElementById('saveBtn').addEventListener('click', function() {
    const fields = ['specialty', 'email', 'phone', 'address'];
    fields.forEach(field => {
        const inputTag = document.getElementById(`${field}Input`);
        const spanTag = document.getElementById(`${field}Text`);
        spanTag.textContent = inputTag.value;
        spanTag.style.display = 'inline';
        inputTag.parentNode.removeChild(inputTag);
    });

    document.getElementById('editBtn').style.display = 'block';
    document.getElementById('saveBtn').style.display = 'none';
});