const nomePadrinho = document.getElementById('padrinho');
const nomeOng = document.getElementById('ong');
const totalApadrinhados = document.getElementById('total_apadrinhados');
const corpo = document.getElementById('corpo');
const card = document.getElementsByClassName('card');
const valoresCards = document.getElementsByClassName('num');

const urlSomatoriaOng = `http://localhost:8080/somatoria/idong/${localStorage.getItem('id_ong')}`;
const urlOng = `http://localhost:8080/apadrinhamento/idong/${localStorage.getItem('id_ong')}`;


function card_two() {

    const options = {
        method: "GET",
        mode: "cors",
        headers: {
            'content-type': 'application/json',
        }
    }
    fetch(urlSomatoriaOng, options).then(response => {
        return response.json();
    })
        .then(data => {
            console.log(data)
            const sum = data[0].somatoria
            valoresCards[1].innerHTML = 'R$' + sum + ',00'
        })

}

card_two();


function card_one() {

    const options = {
        method: "GET",
        mode: "cors",
        headers: {
            'content-type': 'application/json',
        }
    }
    fetch(urlOng, options).then(response => {
        return response.json();

    }).then((data) => {
        const animais = Object.keys(data).reduce(function (previous, animal) {
            return previous + data[animal].value;
        }, 0);

        valoresCards[0].innerHTML = animais
    })

}

card_one();
