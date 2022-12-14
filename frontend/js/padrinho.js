
const nomePadrinho = document.getElementById('padrinho');
const nomeOng = document.getElementById('ong');
const totalApadrinhados = document.getElementById('total_apadrinhados');
const corpo = document.getElementById('corpo');
const card = document.getElementsByClassName('card');
const valoresCards1 = document.getElementById('num1');
const valoresCards2 = document.getElementsByClassName('num2');


const url = `http://localhost:8080/apadrinhamento/${localStorage.getItem('apadrinhador_id')}`;
const urlSomatoriaPessoa = `http://localhost:8080/somatoria/idpessoa/${localStorage.getItem('apadrinhador_id')}`;
const urlApadrinhamento = `http://localhost:8080/apadrinhamento/${localStorage.getItem('apadrinhador_id')}`;

window.onload = function () {

    trazerDados();
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
        });


    function addRows(jsonData) {
        debugger;


        const nomePet = jsonData.animal.nome_pet
        const nomeOng = jsonData.ong.nome_ong
        const dataMov = jsonData.data_apadrinhamento
        const valor = jsonData.valor

        let col = [];
        let cabecalho = ["Nome", "Ong", "Data", "Valor"]
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

trazerDados();


function card_one() {

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
        const dados = collect(data[0].id_apadrinhamento);
        let totalDados = dados.count();
        valoresCards1.innerHTML = totalDados;
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
    fetch(urlSomatoriaPessoa, options).then(response => {
        return response.json();
    })
        .then(data => {
            const sum = data[0].somatoria
            valoresCards2.innerHTML = 'R$' + sum + ',00'
        })
}

card_two();
