const nomePadrinho = document.getElementById('padrinho');
const nomeOng = document.getElementById('ong');
const totalApadrinhados = document.getElementById('total_apadrinhados');
const corpo = document.getElementById('corpo');
const card = document.getElementsByClassName('card');
const valoresCards = document.getElementsByClassName('num');

const url = `http://localhost:8080/apadrinhamento/${localStorage.getItem('apadrinhador_id')}`;
const urlSomatoriaPessoa = `http://localhost:8080/somatoria/idpessoa/${localStorage.getItem('apadrinhador_id')}`;
const urlApadrinhamento = `http://localhost:8080/apadrinhamento/${localStorage.getItem('apadrinhador_id')}`;

window.onload = function(){
    console.log('Onload disparado!');
}

function trazerDados() {

    const options = {
        method: "GET",
        mode: "cors",
        headers: {  
            'content-type': 'application/json',
        }
    }
    fetch(url, options)
        .then(response => {
            return response.json();

        })
        .then(function (jsonData) {
            console.log(jsonData);
            addRows(jsonData);
        })
        .catch(function (e) {
            console.log('Deu erro!');
        })
    function addRows(jsonData) {
        

        const nomePet = jsonData[1].nome_pet
        console.log('Está parando aqui 1');
        const nomeOng = jsonData[2].nome_ong
        const dataMov = jsonData.data_apadrinhamento
        const valor = jsonData[3].valor
        console.log(nomePet);
        console.log(nomeOng);
        console.log(dataMov);
        console.log(valor);
        let col=[];
        let colunas = [dataMov, nomePet, nomeOng, valor];
        for (let i = 0; i < jsonData.length; i++) {
            console.log('ESTÁ PARANDO AQUI!');
            for (let chave in jsonData[i]) {
                if (chave == dataMov || chave == nomePet || chave == nomeOng || chave == valor) {
                    if (col.indexOf(chave) === -1) {
                        col.push(chave);
                    }
                }
            }
        }
        const table = document.createElement("table");
        let tr = table.insertRow(-1);                   // table row.

        for (let i = 0; i < col.length; i++) {
            let th = document.createElement("th");      // table header.
            th.innerHTML = col[i];
            tr.appendChild(th);
        }
        for (let i = 0; i < colunas.length; i++) {

            tr = table.insertRow(-1);
    
            for (let j = 0; j < col.length; j++) {
                let tabCell = tr.insertCell(-1);
                tabCell.innerHTML = dado[i][col[j]];
            }
    
            // Now, add the newly created table with json data, to a container.
            const divShowData = document.getElementById('showData');
            divShowData.innerHTML = "";
            divShowData.appendChild(table);
    
        }
    }
}

trazerDados();

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
