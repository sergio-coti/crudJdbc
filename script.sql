--script para criação da tabela
create table pessoa(
	id			uuid			primary key,
	nome		varchar(150)	not null,
	cpf			varchar(14)		not null,
	telefone    varchar(20)     not null
);

--consultar todos os registros da tabela
select * from pessoa;

--gravando
insert into pessoa(id, nome, cpf, telefone) 
values(gen_random_uuid(), 'Ana Paula', '123.456.789-00', '(21)99999-0000');
