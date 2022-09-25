const formUser = document.getElementById("FormRegister");
const formLogin = document.getElementById("FormLogin");


formUser.onsubmit = function (e) {
  e.preventDefault();
  const cpf_cadastro = 

  fetch("http://localhost:8080/usuarios", {
    method: "POST",
    mode: "cors", // no-cors, *cors, same-origin
    headers: {
      "Content-Type": "application/json",
    },

    body: JSON.stringify({
      nome_usuario: e.target.email.value,
      senha_usuario: e.target.senha.value,
    }),
  })
    .then((response) => response.json())
    .then((data) => {
      fetch("http://localhost:8080/apadrinhadores", {
        method: "POST",       
        headers: {
          "Content-Type": "application/json",
        },
       
        body: JSON.stringify({
          nome_pessoa: e.target.nome.value,
          email_apadrinhador: e.target.email.value,
          cpf_pessoa: e.target.cpf.value.match(/\d/g).join(""),
          usuario: data,
         
        }),
      }).then((data) => {
        alert("Usuário cadastrado com sucesso");
        window.location.href = 'loginUsuario.html';
      });
    });
};

formLogin.onsubmit = function (e) {
  e.preventDefault();
  fetch("http://localhost:8080/usuarios", {
    method: "GET",
    headers: {
      Accept: "application/json",
    },
  })
    .then((response) => response.json())
    .then((dataUsuarios) => {
      const usuarios = dataUsuarios.filter((usuario) => {
        return (
          usuario.nome_usuario === e.target.email.value &&
          usuario.senha_usuario === e.target.senha.value
        );
      });

      if (usuarios.length === 0) {
        alert("Usuário ou senha inválido");
      } else if (usuarios.length > 1) {
        alert("Ocorreu um erro, contate um administrador");
      } else {
        fetch("http://localhost:8080/apadrinhadores", {
          method: "GET",
          headers: {
            Accept: "application/json",
          },
        })
          .then((response) => response.json())
          .then((dataApadrinhadores) => {
            const apadrinhadores = dataApadrinhadores.filter((apadrinhador) => {
              return apadrinhador.usuario.id_usuario === usuarios[0].id_usuario;
            });
            if (apadrinhadores.length === 0) {
              alert("Este usuário não pode logar como apadrinhador");
            } else if (apadrinhadores.length > 1) {
              alert("Ocorreu um erro, contate um administrador");
            }else{
              localStorage.setItem("nome_apadrinhador",apadrinhadores[0].nome_pessoa);
              window.location.href = 'padrinho.html';
              
            }
          });
      }
    });
};