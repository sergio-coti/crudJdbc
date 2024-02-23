package controllers;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import entities.Pessoa;
import repositories.PessoaRepository;

public class PessoaController {

	public void cadastrarPessoa() {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			System.out.println("\nCADASTRO DE PESSOA:\n");
			
			Pessoa pessoa = new Pessoa();
			pessoa.setId(UUID.randomUUID());
			
			System.out.print("ENTRE COM O NOME DA PESSOA..: ");
			pessoa.setNome(scanner.nextLine());
			
			System.out.print("ENTRE COM O CPF.............: ");
			pessoa.setCpf(scanner.nextLine());
			
			System.out.print("ENTRE COM O TELEFONE........: ");
			pessoa.setTelefone(scanner.nextLine());
			
			PessoaRepository pessoaRepository = new PessoaRepository();
			pessoaRepository.inserir(pessoa);
			
			System.out.println("\nPESSOA CADASTRADO COM SUCESSO.");
		}
		catch(Exception e) {
			System.out.println("\nFALHA AO CADASTRAR PESSOA:");
			System.out.println(e.getMessage());
		}
		
		scanner.close();
	}	
	
	public void atualizarPessoa() {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			System.out.println("\nATUALIZAÇÃO DE PESSOA:\n");
			
			System.out.print("ENTRE COM O ID DA PESSOA....: ");
			UUID id = UUID.fromString(scanner.nextLine());
			
			//consultando pessoa no banco de dados através do id
			PessoaRepository pessoaRepository = new PessoaRepository();
			Pessoa pessoa = pessoaRepository.obterPorId(id);
			
			//verificando se pessoa foi encontrado
			if(pessoa != null) {
				
				System.out.print("ENTRE COM O NOME DA PESSOA..: ");
				pessoa.setNome(scanner.nextLine());
				
				System.out.print("ENTRE COM O CPF.............: ");
				pessoa.setCpf(scanner.nextLine());
				
				System.out.print("ENTRE COM O TELEFONE........: ");
				pessoa.setTelefone(scanner.nextLine());
				
				pessoaRepository.editar(pessoa);
				
				System.out.println("\nPESSOA ATUALIZADA COM SUCESSO.");
			}
			else {
				System.out.println("\nPESSOA NÃO ENCONTRADO.");
			}
		}
		catch(Exception e) {
			System.out.println("\nFALHA AO ATUALIZAR PESSOA:");
			System.out.println(e.getMessage());
		}
		
		scanner.close();
	}
	
	public void excluirPessoa() {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			System.out.println("\nEXCLUSÃO DE PESSOA:\n");
			
			System.out.print("ENTRE COM O ID DA PESSOA....: ");
			UUID id = UUID.fromString(scanner.nextLine());
			
			//consultando pessoa no banco de dados através do id
			PessoaRepository pessoaRepository = new PessoaRepository();
			Pessoa pessoa = pessoaRepository.obterPorId(id);
			
			//verificando se pessoa foi encontrado
			if(pessoa != null) {
								
				pessoaRepository.excluir(pessoa);
				
				System.out.println("\nPESSOA EXCLUIDA COM SUCESSO.");
			}
			else {
				System.out.println("\nPESSOA NÃO ENCONTRADO.");
			}
		}
		catch(Exception e) {
			System.out.println("\nFALHA AO EXCLUIR PESSOA:");
			System.out.println(e.getMessage());
		}
		
		scanner.close();
	}
	
	public void consultarPessoas() {
		
		try {
			
			System.out.println("\nCONSULTA DE PESSOAS:\n");
			
			//consultando todas as pessoas cadastradas
			PessoaRepository pessoaRepository = new PessoaRepository();
			List<Pessoa> lista = pessoaRepository.obterTodos();
			
			//percorrendo todos os objetos da lista
			for(Pessoa pessoa : lista) {
				
				System.out.println("\nID......: " + pessoa.getId());
				System.out.println("\nNOME....: " + pessoa.getNome());
				System.out.println("\nCPF.....: " + pessoa.getCpf());
				System.out.println("\nTELEFONE: " + pessoa.getTelefone());
				System.out.println("\n");
			}
		}
		catch(Exception e) {
			System.out.println("\nFALHA AO CONSULTAR PESSOAS:");
			System.out.println(e.getMessage());
		}
	}
}












