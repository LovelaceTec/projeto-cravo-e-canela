const nomePadrinho = document.getElementById('padrinho');
const nomeOng = document.getElementById('ong');
const totalApadrinhados = document.getElementById('total_apadrinhados');
const corpo = document.getElementById('corpo');
const card = document.getElementsByClassName('text-column');
const valoresCards = document.getElementsByClassName('num');

const urlSomatoriaPessoa = `http://localhost:8080/somatoria/idpessoa/${localStorage.getItem('id_ong')}`;
const urlOng = `http://localhost:8080//apadrinhamento/idong/${localStorage.getItem('id_ong')}`;

window.onload = function(){

    trazerDados();
    console.log('Onload disparado!');
}

function trazerDados() {
    debugger;

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
        });


    function addRows(jsonData) {
        debugger;


        const nomeOng = jsonData.ong.nome_ong
        const nomePet = jsonData.animal.status_transacao
        const dataMov = jsonData.data_apadrinhamento
        const valor = jsonData.valor

        let col=[];
        let cabecalho = ["Nome" , "Ong" , "Data" , "Valor"]
        let valores = [nomePet, nomeOng, dataMov, valor];

        const table = document.createElement("table");
        let tr = table.insertRow(-1);                   // table row.

        for (let i = 0; i < cabecalho.length; i++) {
            let th = document.createElement("th");      // table header.
            th.innerHTML = cabecalho[i];
            tr.appendChild(th);
        }

        tr = table.insertRow(-1);                   // table row.

        for (let i = 0; i < valores.length; i++) {
            let th = document.createElement("th");      // table header.
            th.innerHTML = valores[i];
            tr.appendChild(th);
        }

        const divShowData = document.getElementById('showData');
        divShowData.innerHTML = "";
        divShowData.appendChild(table);


    }
}

//trazerDados();

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