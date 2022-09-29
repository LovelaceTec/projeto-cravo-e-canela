const formUser = document.getElementById("FormRegister");
const formLogin = document.getElementById("FormLogin");

const urlApadrinhadores = "http://localhost:8080/apadrinhadores";

formUser.onsubmit = function (e) {
  e.preventDefault();
  fetch(urlApadrinhadores, {
    method: "GET",
    headers: {
      Accept: "application/json",
    },
  })
    .then((response) => response.json())
    .then((dataApadrinhadores) => {
      const apadrinhadores = dataApadrinhadores.filter((apadrinhador) => {
        return (
          apadrinhador.cpf_pessoa === e.target.cpf.value.match(/\d/g).join("")
        );
      });
      if (apadrinhadores.length > 0) {
        alert("Cadastro já existe");
      } else {
        fetch(urlApadrinhadores, {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },

          body: JSON.stringify({
            nome_pessoa: e.target.nome.value,
            email_apadrinhador: e.target.email.value,
            cpf_pessoa: e.target.cpf.value.match(/\d/g).join(""),
            senha_pessoa: e.target.senha.value,
          }),
        }).then((response) => {
          alert("Usuário cadastrado com sucesso");
          window.location.href = "loginUsuario.html";
        });
      }
    });
};

formLogin.onsubmit = function (e) {
  e.preventDefault();
  fetch(urlApadrinhadores, {
    method: "GET",
    headers: {
      Accept: "application/json",
    },
  })
    .then((response) => response.json())
    .then((dataApadrinhadores) => {
      console.log(dataApadrinhadores)
      const apadrinhadores = dataApadrinhadores.filter((apadrinhador) => {
        return (
          apadrinhador.email_pessoa === e.target.email.value &&
          apadrinhador.senha_pessoa === e.target.senha.value
        );
      });
      console.log(apadrinhadores)
      if (apadrinhadores.length === 0) {
        alert("Usuário ou senha inválidos");
      } else if (apadrinhadores.length > 1) {
        alert("Ocorreu um erro, contate um administrador");
      } else {
        localStorage.setItem(
          "apadrinhador_id",
          JSON.stringify(apadrinhadores[0].id_pessoa)
        );
        window.location.href = "d1-padrinho.html";
      }
    });
};
