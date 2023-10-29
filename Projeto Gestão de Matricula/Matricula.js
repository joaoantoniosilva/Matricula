// matricula.js

document.addEventListener("DOMContentLoaded", function() {
 
    document.getElementById("buscarMatriculas").addEventListener("click", function() {
        // Obtenha os parâmetros que deseja enviar com a solicitação AJAX
        var alunoId = document.getElementById("alunoId").value;
        var dataInicio = document.getElementById("dataInicio").value;
        var dataFim = document.getElementById("dataFim").value;

        // Construa a URL do endpoint do controlador com base nos parâmetros
        var url = "/matricula/buscar?alunoId=" + alunoId + "&dataInicio=" + dataInicio + "&dataFim=" + dataFim;

        // Faça a solicitação AJAX
        var xhr = new XMLHttpRequest();
        xhr.open("GET", url, true);

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

// matricula.js

document.addEventListener("DOMContentLoaded", function() {
    var formularioMatricula = document.getElementById("formularioMatricula");

    formularioMatricula.addEventListener("submit", function(event) {
        event.preventDefault();

        var formData = new FormData(formularioMatricula);

        // Enviar a matrícula para o controlador
        fetch("/matricula/cadastrar", {
            method: "POST",
            body: formData
        })
        .then(function(response) {
            if (response.ok) {
                alert("Matrícula enviada com sucesso!");
                // Redirecionar ou fazer outras ações após o envio bem-sucedido
            } else {
                alert("Erro ao enviar matrícula.");
            }
        })
        .catch(function(error) {
            console.error("Erro na solicitação: " + error);
        });
    });
});

