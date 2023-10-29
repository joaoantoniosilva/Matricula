// aluno.js

document.addEventListener("DOMContentLoaded", function() {
    var formularioBuscaAluno = document.getElementById("formularioBuscaAluno");
    var formularioMatricula = document.getElementById("formularioMatricula");

    // Evento para buscar aluno
    formularioBuscaAluno.addEventListener("submit", function(event) {
        event.preventDefault();

        var alunoId = document.getElementById("alunoId").value;

        // Realizar a solicitação para buscar o aluno pelo ID
        fetch("/aluno/buscar?id=" + alunoId)
            .then(function(response) {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error("Erro na busca do aluno");
                }
            })
            .then(function(data) {
                // Preencher o formulário de matrícula com os dados do aluno encontrado
                document.getElementById("alunoIdMatricula").value = data.id;
            })
            .catch(function(error) {
                console.error(error);
            });
    });

    // Evento para matricular aluno
    formularioMatricula.addEventListener("submit", function(event) {
        event.preventDefault();

        var formData = new FormData(formularioMatricula);

        // Enviar a matrícula para o controlador
        fetch("/aluno/matricular", {
            method: "POST",
            body: formData
        })
        .then(function(response) {
            if (response.ok) {
                alert("Aluno matriculado com sucesso!");
                // Redirecionar ou fazer outras ações após a matrícula bem-sucedida
            } else {
                alert("Erro ao matricular aluno.");
            }
        })
        .catch(function(error) {
            console.error("Erro na solicitação: " + error);
        });
    });
});
