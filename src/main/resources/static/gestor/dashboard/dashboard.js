function addRequisito() {
    const reqInput = document.getElementById('reqInput');
    const reqText = reqInput.value.trim();
    if (reqText === '') return;

    const timelineContent = document.getElementById('timelineContentRequisitos');

    const newItem = document.createElement('div');
    newItem.classList.add('timeline-item');
    newItem.textContent = reqText;

    const items = timelineContent.getElementsByClassName('timeline-item');
    if (items.length > 0) {
        items[0].classList.remove('first');
    }
    newItem.classList.add('first');

    timelineContent.insertBefore(newItem, timelineContent.firstChild);
    reqInput.value = '';
}

function addDescricao() {
    const descInput = document.getElementById('descInput');
    const descText = descInput.value.trim();
    if (descText === '') return;

    const timelineContent = document.getElementById('timelineContentDescricao');

    const newItem = document.createElement('div');
    newItem.classList.add('timeline-item');
    newItem.textContent = descText;

    const items = timelineContent.getElementsByClassName('timeline-item');
    if (items.length > 0) {
        items[0].classList.remove('first');
    }
    newItem.classList.add('first');

    timelineContent.insertBefore(newItem, timelineContent.firstChild);
    descInput.value = '';
}
