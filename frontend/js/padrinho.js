const nomePadrinho = document.getElementById('padrinho');
const nomeOng = document.getElementById('ong');
const totalApadrinhados = document.getElementById('total_apadrinhados');
const valorDoado = document.getElementById('valor');
const porcentagemMetas = document.getElementById('porcentagem_metas');
const dataMovimentacao = document.getElementById('data_movimentacao');
const nomePet = document.getElementById('nome_pet');
const totalArrecadadoCampanha = document.getElementById('total_arrecadado');
const dadosDaTabela = document.getElementById('dadosTabela');
const card = document.getElementsByClassName('card');
const valoresCards = document.getElementsByClassName('num');

const url = `http://localhost:8080/apadrinhamento/${localStorage.getItem('apadrinhador_id')}`;
const urlSomatoriaPessoa = `http://localhost:8080/somatoria/idpessoa/${localStorage.getItem('apadrinhador_id')}`;
const urlApadrinhamento = `http://localhost:8080/apadrinhamento/${localStorage.getItem('apadrinhador_id')}`;

function popularTabela() {

    const options = {
        method: "GET",
        mode: "cors",
        headers: {
            'content-type': 'application/json',
        }
    }
    fetch(url, options).then(response => {
        return response.json();
    
    })  
        .then(data => {
            console.log('oi')
            popularTabela(data);
        })

    function popularTabela(data){
        console.log(data)

        let html = ""
        data.forEach(causa => {
            html += `
                <tr>
                    <td>${causa.data_apadrinhamento.value}</td>
                    <td>${causa.animal.nome_pet.value}</td>
                    <td>${causa.ong.nome_ong.value}</td>
                    <td>${causa.pessoa.valor.value}</td>
                </tr> 
            `
        });
        document.getElementById("dadosTabela").innerHTML = html;
        window.location.href = "d1-padrinho.html";
    }
}

popularTabela();

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
                return previous + data[animal].value;
            }, 0);

            valoresCards[0].innerHTML = animais
        })

}

card_two();
