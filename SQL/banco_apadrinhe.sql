--Proposta de usuário específico para API
--create user 'app_api'@'%' identified by '<SENHA>'
--grant select, update, delete, insert on *.* to 'app_api'@'%';



-- Para apagar o banco anterior e criar com essa versão, retire os dois traços 
--  drop database apadrinhe;

create database apadrinhe;
use apadrinhe;

create table usuarios(
	id_usuario integer auto_increment primary key not null,
    nome_usuario  varchar(50) not null,
    senha_usuario varchar(30)
);


create table administrador(
	id_adm integer auto_increment primary key not null,
    id_usuario integer not null,
    nome_adm varchar(150),
    email_adm varchar(50),
    tipo_acesso varchar(15),
	constraint adm_usuario foreign key
		(id_usuario) references usuarios(id_usuario)
    
);



create table apadrinhadores(
	id_pessoa integer auto_increment primary key not null,
    id_usuario integer not null,
    nome_pessoa varchar(250) not null,
    cpf_pessoa varchar(11) not null,
    email_apadrinhador varchar(50),
 	constraint apad_usuario foreign key
		(id_usuario) references usuarios(id_usuario)
    
);


create table ongs(
	id_ong integer auto_increment primary key not null,
    id_usuario integer not null,
    nome_ong varchar(100) not null,
    cnpj_ong varchar(20) not null,
    email_ong varchar(50),
    telefone_ong varchar(15),
	pix_ong varchar (100),
    cadastro_validado varchar(1),
	constraint ong_usuario foreign key
		(id_usuario) references usuarios(id_usuario)
    
);



create table animais(
	id_animal integer auto_increment primary key not null,
    id_ong integer not null,
    nome_pet varchar(100) not null,
    especie_pet varchar(50),
    idade_pet varchar(10),
	sexo_pet varchar(1),
    resumo_pet text,
    foto_pet varchar(255),
    inicio_campanha date,
    fim_campanha date,
    meta double,
    constraint ong_animais foreign key
		(id_ong) references ongs(id_ong)
);




create table apadrinhamento(
	id_apadrinhamento integer auto_increment primary key not null,
	id_animal integer not null,
	id_ong integer not null,
	id_pessoa integer not null,
	data_apadrinhamento date,
	valor double,
	status_transacao varchar(10),
	constraint ap_animal foreign key
		(id_animal) references animais(id_animal),
	constraint ap_ong foreign key
		(id_ong) references ongs(id_ong),
	constraint ap_pessoa foreign key
		(id_pessoa) references apadrinhadores(id_pessoa)
);



insert into usuarios values
(null, "administracao@cravocanela.com.br", "cravocanela"),
(null, "ada@lovelace.com.br", "algoritmos"),
(null, "curiemary.1867@gmail.com", "isotopos"),
(null, "nise1905silveira@gmail.com", "saude"),
(null, "administracao@clubeanimal.com.br", "petPET123"),
(null, "adm@petamor.com.br", "petamo123"),
(null, "administracao@gatomania.com.br", "Miau6987"),
(null, "adm@colaboracao.com.br", "AuAu8745");

insert into administrador values (null, 1, "Cravo & Canela Consultoria",  "administracao@cravocanela.com.br","administrador");

insert into apadrinhadores values
(null,2,"Ada Lovelace", "36636470054","ada@lovelace.com.br"),
(null,3,"Marie Curie", "41560866071","curiemary.1867@gmail.com"),
(null,4,"Nise da Silveira", "21338218050","nise1905silveira@gmail.com");


insert into ongs values
(null, 5,"Clube Animal", "87233922000127","administracao@clubeanimal.com.br", "51999999999","11999999999","S"),
(null,6, "Pet Amor", "55160118000179","adm@petamor.com.br", "17988888888","55160118000179","N"),
(null, 7,"Gatomania", "85250780000180","administracao@gatomania.com.br", "11977777777","administracao@gatomania.com.br","S"),
(null,8, "ColaboraCÃO", "01082791000109","adm@colaboracao.com.br", "13966666666","adm@colaboracao.com.br","S");



insert into animais values
(null,1,"Baunilha", "cão","5 anos","F","A alegria em forma de doguinho....","https://drive.google.com/file/d/12FSCZOGRjrctAT5t0E3wtWZqInK8gqj6/view?usp=sharing", "2022-03-03", "2022-10-01", 750),
(null,2,"Jabuticaba", "gato", "2 anos", "F", "Um doce de gatinha....", "https://drive.google.com/file/d/19NdNOM4vClrLUZXLzO17Zpjlv6o0_8Qi/view?usp=sharing", "2022-08-24", "2022-12-24", 1050),
(null,3,"Mingau","gato", "6 meses", "M" ,"miau miau miau miau","https://drive.google.com/file/d/1shXTGF_wq1czuXQ4XYXMCz1_P26JGAzR/view?usp=sharing", "2022-07-17", "2022-12-16", 670),
(null,4,"Snoop", "cão", "4 anos", "M", "au au au","https://drive.google.com/file/d/1ktVBFQVuQheACwsvlx1SFFAfRi-kzS5F/view?usp=sharing", "2022-02-18","2023-02-18",1250);



insert into apadrinhamento values
(null,1,1,2,"2022-08-31",175.0,"concluído"),
(null,2,2,3,"2022-09-17",50.0,"concluído"),
(null,3,3,2,"2022-08-24",300.0,"concluído"),
(null,4,4,1,"2022-08-31",60.0,"Andamento");
