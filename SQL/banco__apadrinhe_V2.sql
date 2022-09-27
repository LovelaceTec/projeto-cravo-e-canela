create database apadrinhe;
use apadrinhe;


create table administrador(
	id_adm integer auto_increment primary key not null,
    nome_adm varchar(150),
    email_adm varchar(50),
    tipo_acesso varchar(15),
	senha_adm varchar(30)
);



create table apadrinhadores(
	id_pessoa integer auto_increment primary key not null,
    nome_pessoa varchar(250) not null,
    cpf_pessoa varchar(11) not null,
    email_pessoa varchar(50),
	senha_pessoa varchar(30),
	unique key cpf_pessoa_unique (cpf_pessoa)
);


create table ongs(
	id_ong integer auto_increment primary key not null,
    nome_ong varchar(100) not null,
    cnpj_ong varchar(20) not null,
    email_ong varchar(50),
    telefone_ong varchar(15),
	pix_ong varchar (100),
    cadastro_validado varchar(1),
	senha_ong varchar(30),
	unique key cnpj_ong_unique (cnpj_ong)
);



create table animais(
	id_pet integer auto_increment primary key not null,
    id_ong_pet integer not null,
    nome_pet varchar(100) not null,
    especie_pet varchar(50),
    idade_pet varchar(10),
	sexo_pet varchar(1),
    resumo_pet text,
    foto_pet varchar(255),
    inicio_campanha date,
    fim_campanha date,
    meta double,
    constraint ong_pet foreign key
		(id_ong_pet) references ongs(id_ong)
);




create table apadrinhamento(
	id_apadrinhamento integer auto_increment primary key not null,
	id_pet_ap integer not null,
	id_ong_ap integer not null,
	id_pessoa_ap integer not null,
	data_apadrinhamento date,
	valor double,
	status_transacao varchar(10),
	constraint ap_animal foreign key
		(id_pet_ap) references animais(id_pet),
	constraint ap_ong foreign key
		(id_ong_ap) references ongs(id_ong),
	constraint ap_pessoa foreign key
		(id_pessoa_ap) references apadrinhadores(id_pessoa)
);



insert into administrador values (null, "Cravo & Canela Consultoria",  "administracao@cravocanela.com.br","administrador","cravocanela");

insert into apadrinhadores values
(null,"Ada Lovelace", "36636470054","ada@lovelace.com.br","algoritmos"),
(null,"Marie Curie", "41560866071","curiemary.1867@gmail.com","isotopos"),
(null,"Nise da Silveira", "21338218050","nise1905silveira@gmail.com","saude");


insert into ongs values
(null,"Clube Animal", "87233922000127","administracao@clubeanimal.com.br", "51999999999","11999999999","S","petPET123"),
(null,"Pet Amor", "55160118000179","adm@petamor.com.br", "17988888888","55160118000179","N","petamo123"),
(null,"Gatomania", "85250780000180","administracao@gatomania.com.br", "11977777777","administracao@gatomania.com.br","S","Miau6987"),
(null,"ColaboraCÃO", "01082791000109","adm@colaboracao.com.br", "13966666666","adm@colaboracao.com.br","S","AuAu8745");



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


