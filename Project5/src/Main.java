import java.util.Scanner;

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);

	public static int menu() {
		System.out.println("------------------------------");
		System.out.println("Sistema de controle de pessoas");
		System.out.println("------------------------------");
		System.out.println("--------menu de opções--------");
		System.out.println("------------------------------");
		System.out.println("------------------------------");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Buscar pelo cpf");
		System.out.println("3 - Atualizar");
		System.out.println("4 - Remover");
		System.out.println("5 - Sair");
		System.out.println("------------------------------");
		System.out.println("Escolha uma opção: ");
		return scanner.nextInt();
	}
	
	public static Person readData() {
		System.out.println("Digite o nome: ");
		String name = scanner.nextLine();
		System.out.println("Digite o CPF: ");
		String cpf = scanner.nextLine();
		return new Person(name, cpf);
	}

	public static void main(String[] args, Person person) {
		PeopleManeger manager = new PeopleManeger();
		int opcao;
		do {
			opcao = menu();
			switch (opcao) {
			case 1: {
				person = readData();
				if(manager.save(person)) {
					System.out.println("Pessoa cadastrada com sucesso!");
					System.out.println(manager.getPeopleList());
				} else {
					System.out.println("Erro ao cadastra pessoa");
				}
				break;
			}
			default:
				System.out.println("Invalido!");
			}
		} while(opcao != 5);
	}
}
