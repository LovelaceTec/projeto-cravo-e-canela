const urlOng = "http://localhost:8080/ong";

const formLogin = document.getElementById("formLogin");
const formCadastro = document.getElementById("formCadastro");

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
        return(
          ong.cnpj_ong === e.target.cnpj.value,
          ong.email_senha === e.target.senha.value
        ) 
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
            nome_ong: e.target.nome.value,
            email_ong: e.target.email.value,
            cnpj_ong: e.target.cnpj.value,
            senha_ong: e.target.senha.value
          }),
        }).then((data) => {
          alert("usuário cadastrado com sucesso!");
          window.location.href = "loginOng.html";
        });
      }
    });
};

formLogin.onsubmit = function (e) {
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
        return (
          ong.email_ong === e.target.email.value,
          ong.senha_ong ===e.target.senha.value

        ) 
      });
      console.log(ongs);
      if (ongs.length === 0) {
        alert("Email ou senha incorretos");
      } else if (ongs.length > 1) {
        alert("Ocorreu um erro, contate o administrador");
      } else {   
        localStorage.setItem('ong_id',JSON.stringify(ongs[0].id_ong));
        window.location.href = "d1-ong.html";
      }
    });
};
