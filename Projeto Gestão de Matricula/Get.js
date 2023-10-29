function conectarBackend() {
    // Endpoint do backend Java
    const endpointURL = 'http://localhost:8080/matriculas';

    // Faz uma solicitação GET
    fetch(endpointURL)
        .then(response => {
            if (!response.ok) {
                throw new Error('Não foi possível obter os dados do servidor.');
            }
            return response.json();
        })
        .then(data => {
            // Manipular os dados recebidos do backend aqui
            console.log('Dados recebidos do backend:', data);
        })
        .catch(error => {
            console.error('Erro ao se comunicar com o backend:', error);
        });
}
