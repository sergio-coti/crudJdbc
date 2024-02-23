package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import entities.Pessoa;
import factories.ConnectionFactory;

public class PessoaRepository {

	public void inserir(Pessoa pessoa) throws Exception {

		//abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		//escrevendo o script sql para inserir um registro na tabela de pessoa
		PreparedStatement statement = connection.prepareStatement
				("insert into pessoa(id, nome, cpf, telefone) values(?,?,?,?)");
		
		//preenchendo os parametros do comando insert
		statement.setObject(1, pessoa.getId());
		statement.setString(2, pessoa.getNome());
		statement.setString(3, pessoa.getCpf());
		statement.setString(4, pessoa.getTelefone());
		statement.execute();
		
		//fechando a conexão
		connection.close();
	}	
	
	public void editar(Pessoa pessoa) throws Exception {
		
		//abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		//escrevendo o script sql para editar um registro na tabela de pessoa
		PreparedStatement statement = connection.prepareStatement
				("update pessoa set nome=?, cpf=?, telefone=? where id=?");
		
		//preenchendo os parametros do comando update
		statement.setString(1, pessoa.getNome());
		statement.setString(2, pessoa.getCpf());
		statement.setString(3, pessoa.getTelefone());
		statement.setObject(4, pessoa.getId());
		statement.execute();
		
		//fechando a conexão
		connection.close();
	}
	
	public void excluir(Pessoa pessoa) throws Exception {
		
		//abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		//escrevendo o script sql para excluir um registro na tabela de pessoa
		PreparedStatement statement = connection.prepareStatement
				("delete from pessoa where id=?");
		
		//preenchendo os parametros do comando delete
		statement.setObject(1, pessoa.getId());
		statement.execute();
		
		//fechando a conexão
		connection.close();
	}
	
	public List<Pessoa> obterTodos() throws Exception {
		
		//abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		//escrevendo o script sql para consultar os registros na tabela de pessoa
		PreparedStatement statement = connection.prepareStatement
				("select * from pessoa order by nome");
		
		//ler todos os registros obtidos da consulta
		ResultSet resultSet = statement.executeQuery();
		
		//criando uma lista de objetos da classe pessoa
		List<Pessoa> lista = new ArrayList<Pessoa>(); //vazia
		
		//percorrer cada registro obtido pelo resultSet
		while(resultSet.next()) {
			
			Pessoa pessoa = new Pessoa();
			pessoa.setId(UUID.fromString(resultSet.getString("id")));
			pessoa.setNome(resultSet.getString("nome"));
			pessoa.setCpf(resultSet.getString("cpf"));
			pessoa.setTelefone(resultSet.getString("telefone"));
			
			lista.add(pessoa); //adicionando o objeto 'pessoa' na lista
		}
		
		//fechando a conexão
		connection.close();
		//retornando a lista
		return lista;
	}	
	
	public Pessoa obterPorId(UUID id) throws Exception {
		
		//abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();
		
		//escrevendo o script sql para consultar o registros na tabela de pessoa
		PreparedStatement statement = connection.prepareStatement
				("select * from pessoa where id=?");
		
		statement.setObject(1, id);
		ResultSet resultSet = statement.executeQuery();
		
		Pessoa pessoa = null; //vazio (sem espaço de memória)
		
		if(resultSet.next()) {
			
			pessoa = new Pessoa();
			pessoa.setId(UUID.fromString(resultSet.getString("id")));
			pessoa.setNome(resultSet.getString("nome"));
			pessoa.setCpf(resultSet.getString("cpf"));
			pessoa.setTelefone(resultSet.getString("telefone"));
		}
		
		//fechar a conexão
		connection.close();
		//retornar o objeto 'pessoa'
		return pessoa;
	}
	
}





