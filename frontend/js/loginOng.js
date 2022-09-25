const urlLogin = "localhost:8080/login";
const urlOng = "http://localhost:8080/ong";
const urlUsuario = "http://localhost:8080/usuarios";

const formLogin = document.getElementById("formLogin");
const formCadastro = document.getElementById("formCadastro");

formLogin.onsubmit = function (e) {
  e.preventDefault();

  fetch(urlUsuario, {
    method: "POST",
    headers: {
      "Content-type": " application/json",
    },

    body: JSON.stringify({
        nome_usuario: e.target.email.value,
        senha_usuario: e.target.senha.value
    }),
  }).then(response =>{
       alert("Usuario cadastrado com sucesso") 
  }).catch((error) => {
     alert("ocorreu um erro, tente novamente");
  });
};
