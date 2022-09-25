const saudacaoPadrinho = document.getElementById('padrinho');
const saudacaoONG = document.getElementById('ong');

console.log(saudacao)
saudacaoPadrinho.innerHTML=`Seja Bem vindo(a) ${localStorage.getItem('nome_apadrinhador')}`
saudacaoONG.innerHTML=`Seja Bem vindo(a) ${localStorage.getItem('nome_ong')}`
