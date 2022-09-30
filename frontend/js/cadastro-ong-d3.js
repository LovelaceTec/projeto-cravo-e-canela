const urlOng = "http://localhost:8080/ong";

const formCadastro = document.getElementsByClassName('form-detail')[0]
console.log(formCadastro)


formCadastro.onsubmit = function (e) {
    e.preventDefault();
    fetch(urlOng, {
      method: "GET",
      headers: {
        Accepted: "application/json",
      },
    })
      .then((response) => response.json())
      .then((dataOngs) => {
        const ongs = dataOngs.filter((ong) => {
          return  ong.cnpj_ong === e.target.cnpj.value         
          
        });
        if (ongs.length > 0) {
          alert("Já existe um cadastro para esta ONG");
        } else {
          fetch(urlOng, {
            method: "POST",
            headers: {
              "Content-type": "application/json",
            },
            body: JSON.stringify({
              nome_ong: e.target.nome_empresa.value,
              //email_ong: e.target.email.value,
              cnpj_ong: e.target.cnpj.value,
              pix_ong: e.target.pix.value
            }),
          }).then((data) => {
            alert("usuário cadastrado com sucesso!");
            window.location.href = "loginOng.html";
          });
        }
      });
  };