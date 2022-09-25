const saudacao = document.getElementById('padrinho');

console.log(saudacao)
saudacao.innerHTML=`Seja Bem vindo(a) ${localStorage.getItem('nome_apadrinhador')}`
