const nomePadrinho = document.getElementById('padrinho');
const nomeOng = document.getElementById('ong');
const totalApadrinhados = document.getElementById('total_apadrinhados');
const totalApadrinhamento = document.getElementById('total_apadrinhamento');
const porcentagemMetas = document.getElementById('porcentagem_metas');
const dataMovimentacao = document.getElementById('data_movimentacao');
const nomePet = document.getElementById('nome_pet');
const totalArrecadadoCampanha = document.getElementById('total_arrecadado');
const card = document.getElementsByClassName('card');
const valoresCards = document.getElementsByClassName('num');

const url = 'http://localhost:8080/apadrinhamento';
const urlSomatoriaPessoa = `http://localhost:8080/somatoria/idpessoa/${localStorage.getItem('apadrinhador_id')}`;
const urlApadrinhamento = `http://localhost:8080/apadrinhamento/${localStorage.getItem('apadrinhador_id')}`;

// function consultarMetas() {

//     const options = {
//         method: "GET",
//         mode: "cors",
//         headers: {
//             'content-type': 'application/json',
//         }
//     }
//     fetch(url, options).then(response => {
//         return response.json();
//     })  
//         .then(data => {
//             popularTabela(data);
//             console.log(data)
//         })

//     function atribuirCampos(data) {
//         document.getElementById('padrinho').value = apadrinhamento.padrinho;
//         document.getElementById('ong').value = apadrinhamento.nome_ong;
//         document.getElementById("total_apadrinhados").value =  apadrinhamento.totalApadrinhados;
//         document.getElementById("total_apadrinhamento").value =  apadrinhamento.totalApadrinhamento;
//         document.getElementById("porcentagem_metas").value =  apadrinhamento.porcentagemMetas;
//         document.getElementById("data_movimentacao").value =  apadrinhamento.data_apadrinhamento;
//         document.getElementById("nome_campanha").value =  apadrinhamento.nomeCampanha;
//         document.getElementById("total_arrecadado").value =  apadrinhamento.totalArrecadadoCampanha;
//     }

//     function popularTabela(data){
//         console.log(data)

//         let html = ""
//         data.forEach(causa => {
//             html += `
//                 <tr>
//                     <td>${causa.data_apadrinhamento}</td>
//                     <td>${causa.nome_pet}</td>
//                     <td>${causa.nome_ong}</td>
//                     <td>${causa.totalArrecadadoCampanha}</td>
//                 </tr> 
//             `
//         });
//         document.getElementById("dadosTabela").innerHTML = html;
//         window.location.href = "d1-padrinho.html";
//     }
// }

function card_one() {

    const options = {
        method: "GET",
        mode: "cors",
        headers: {
            'content-type': 'application/json',
        }
    }
    fetch(urlSomatoriaPessoa, options).then(response => {
        return response.json();
    })
        .then(data => {
            const sum = data[0].somatoria
            valoresCards[1].innerHTML = 'R$' + sum + ',00'
        })

}

card_one();


function card_two() {

    const options = {
        method: "GET",
        mode: "cors",
        headers: {
            'content-type': 'application/json',
        }
    }
    fetch(urlApadrinhamento, options).then(response => {
        return response.json();

    }).then((data) => {
            const animais = Object.keys(data).reduce(function (previous, animal) {
                console.log(data[animal].value)
                return previous + data[animal].value;
            }, 0);

            valoresCards[0].innerHTML = animais
        })

}

card_two();
