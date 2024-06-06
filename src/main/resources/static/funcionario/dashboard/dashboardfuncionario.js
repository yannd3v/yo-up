document.addEventListener('DOMContentLoaded', function() {
    const requisitos = [
        { title: 'Requisito 1'},
        { title: 'Requisito 2'},
        { title: 'Requisito 3'},
        { title: 'Requisito 4'}
    ];

    const descricaoRequisitos = [
        {description: 'Descrição do requisito 1'},
        {description: 'Descrição do requisito 2'},
        {description: 'Descrição do requisito 3'},
        {description: 'Descrição do requisito 4'}
    ];

    const timelineContent = document.getElementById('timelineContent');
    const descricaoTimelineContent = document.getElementById('descricaoTimelineContent');

    requisitos.forEach((requisito, index) => {
        const newItem = document.createElement('div');
        newItem.classList.add('timeline-item');
        newItem.textContent = requisito.title;

        if (index === 0) {
            newItem.classList.add('first');
        }

        const descricaoItem = document.createElement('div');
        descricaoItem.classList.add('timeline-item');
        descricaoItem.textContent = descricaoRequisitos[index].description;

        const content = document.createElement('div');
        content.classList.add('timeline-item-content');
        content.appendChild(newItem);
        content.appendChild(descricaoItem);

        if (index % 2 === 0) {
            content.classList.add('left');
        } else {
            content.classList.add('right');
        }

        timelineContent.appendChild(content);
    });
});
