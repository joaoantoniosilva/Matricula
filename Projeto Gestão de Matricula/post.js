function conectarBackend() {
    // Endpoint do backend Java
    const endpointURL = 'http://localhost:8080/matriculas';

    // Dados a serem enviados no corpo da solicitação POST (em formato JSON)
    const dadosParaEnviar = {
        campo1: 'valor1',
        campo2: 'valor2',
        // Adicione os campos e valores que deseja enviar
    };

    // Configuração da solicitação
    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json', // Indica que estamos enviando dados JSON
        },
        body: JSON.stringify(dadosParaEnviar), // Converte os dados para JSON e os envia no corpo da solicitação
    };
}
