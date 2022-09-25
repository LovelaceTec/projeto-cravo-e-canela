const urlLogin = "localhost:8080/login";
const urlOng = "http://localhost:8080/ong";
const urlUsuario = "http://localhost:8080/usuarios";

const formLogin = document.getElementById("formLogin");
const formCadastro = document.getElementById("formCadastro");

formCadastro.onsubmit = function (e) {
  e.preventDefault();
  fetch("http://localhost:8080/ong", {
    method: "GET",
    headers: {
      Accepted: "application/json",
    },
  })
    .then((response) => response.json())
    .then((dataOngs) => {
      const ongs = dataOngs.filter((ong) => {
        return ong.cnpj_ong === e.target.cnpj.value;
      });
      if (ongs.length > 0) {
        alert("Já existe um cadastro para esta ONG");
      } else {
        fetch("http://localhost:8080/usuarios", {
          method: "POST",
          headers: {
            "Content-type": " application/json",
          },

          body: JSON.stringify({
            nome_usuario: e.target.email.value,
            senha_usuario: e.target.senha.value,
          }),
        })
          .then((response) => response.json())
          .then((data) => {
            fetch("http://localhost:8080/ong", {
              method: "POST",
              headers: {
                "Content-type": "application/json",
              },
              body: JSON.stringify({
                nome_ong: e.target.nome.value,
                email_ong: e.target.email.value,
                cnpj_ong: e.target.cnpj.value,
                usuario: data,
              }),
            }).then((data) => {
              alert("usuário cadastrado com sucesso!");
              window.location.href = "ong.html";
            });
          });
      }
    });
};

formLogin.onsubmit = function (e) {
  e.preventDefault();
  fetch("http://localhost:8080/usuarios", {
    method: "GET",
    headers: {
      Accepted: "application/json",
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
      console.log(usuarios);
      if (usuarios.length === 0) {
        alert("usuario ou senha inválidos");
      } else if (usuarios.length > 1) {
        alert("ocorreu um erro, contate o administrador");
      } else {
        fetch("http://localhost:8080/ong", {
          method: "GET",
          headers: {
            Accepted: "application/json",
          },
        })
          .then((response) => response.json())
          .then((dataOngs) => {
            const ongs = dataOngs.filter((ong) => {
              return ong.usuario.id_usuario === usuarios[0].id_usuario;
            });
            console.log(ongs);
            if (ongs.length === 0) {
              alert("Este usuário não tem permissão para logar como ong");
            } else if (ongs.length > 1) {
              alert("Ocorreu um erro, contate o administrador");
            } else {
                 window.location.href = "ong.html";
            }
          });
      }
    });
};
