urlApadrinhamento = "http://localhost:8080/apadrinhamento";

const formApadrinhe= document.getElementsByClassName('form-detail')[0]
const apadrinhamento = document.getElementsByClassName("form-control");
const apadrinhamentoCartaoData =  document.getElementsByClassName("form-control2");
const apadrinhamentoCartaoExpira =  document.getElementsByClassName("form-control3");

formApadrinhe.onsubmit = function (e) {
  e.preventDefault();

  fetch("http://localhost:8080/apadrinhamento", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    
    body: JSON.stringify({
      nome_pet : e.target.nome_pet.value,
      especie_pet : e.target.especie_pet.value,
      idade_pet : e.target.idade_pet.value,
      sexo_pet : "",
      resumo_pet : e.target.descritivo_card.value,
      foto_pet : e.target.foto_pet.value,
      inicio_campanha : e.target.inicio_campanha,
      fim_campanha : e.target.final_campanha,
      id_ong : 1
    }),
  }).then((response) => {
    alert("Campanha Cadastrada com sucesso!!");
   // window.location.href = "d1-ong.html";
  });
};
