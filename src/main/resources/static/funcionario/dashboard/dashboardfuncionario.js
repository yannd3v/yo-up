
    // Data to populate the dashboard with
    const dashboardData = [

    ];

    const dashboardContent = document.getElementById('dashboardContent');

    dashboardData.forEach(data => {
        const card = document.createElement('div');
        card.className = 'card';
        card.innerHTML = `
            <img src="data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 100 100'%3E%3Ctext y='.9em' font-size='90'%3E${encodeURIComponent(data.icon)}</text%3E%3C/svg%3E">
            <h3>${data.title}</h3>
            <p>${data.count}</p>
        `;
        dashboardContent.appendChild(card);
    });
