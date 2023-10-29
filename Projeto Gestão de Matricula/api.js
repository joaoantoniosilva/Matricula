// Exemplo de código JavaScript no frontend
fetch('http://localhost:8080/api/dados') // Certifique-se de usar o endereço correto do seu backend
  .then(response => response.text())
  .then(data => {
    console.log(data); // Aqui você pode lidar com os dados recebidos do backend
  })
  .catch(error => {
    console.error('Erro ao buscar dados:', error);
  });

