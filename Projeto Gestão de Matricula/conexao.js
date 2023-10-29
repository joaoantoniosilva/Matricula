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

// Chama a função para conectar ao backend
   

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

    // Faz a solicitação POST

        document.addEventListener("DOMContentLoaded", function () {
            const matriculaForm = document.getElementById("matriculaForm");
            const resultadoDiv = document.getElementById("resultado");
        
            matriculaForm.addEventListener("submit", function (e) {
                e.preventDefault();
        
                const nome = document.getElementById("nome").value;
                const curso = document.getElementById("curso").value;
        
                const dadosMatricula = {
                    nome: nome,
                    curso: curso,
                };
        
                fetch('http://localhost:8080/matricula', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(dadosMatricula)
                })
                .then(response => response.json())
                .then(data => {
                    resultadoDiv.innerHTML = "Resposta do servidor: " + data;
                })
                .catch(error => {
                    console.error('Erro ao enviar os dados:', error);
                });
            });
        });
        
        
}



