// Suponha que você tenha um botão ou algum evento que acione a solicitação
document.getElementById("seuBotao").addEventListener("click", function() {
    // Obtenha a data selecionada, substitua isso pela sua lógica
    var dataSelecionada = document.getElementById("dataSelecionada").value; 

    // Faça a solicitação AJAX
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "/dashboardEscola?dataSelecionada=" + dataSelecionada, true);
    
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Analise a resposta JSON
            var response = JSON.parse(xhr.responseText);

          
            for (var escola in response) {
                if (response.hasOwnProperty(escola)) {
                    var dadosEscola = response[escola];
                    console.log("Escola: " + escola);
                    console.log("Matrículas Ativas: " + dadosEscola.matriculasAtivas);
                    console.log("Matrículas Transferidas: " + dadosEscola.matriculasTransferidas);
                    console.log("Matrículas Excluídas: " + dadosEscola.matriculasExcluidas);

                    
                }
            }
        }
    };
    
    xhr.send();
});

// dashboard.js

document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("buscarDados").addEventListener("click", function() {
        // Obtenha a data selecionada do elemento de entrada
        var dataSelecionada = document.getElementById("dataSelecionada").value;

        //  solicitação AJAX
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "/dashboardEscola?dataSelecionada=" + dataSelecionada, true);

        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    // Processar a resposta JSON
                    var response = JSON.parse(xhr.responseText);
                    // Atualize a interface do usuário com os dados da resposta
                    atualizarTabela(response);
                } else {
                    console.error("Erro na solicitação: " + xhr.status);
                }
            }
        };

        xhr.send();
    });
});

function atualizarTabela(data) {
  
}

