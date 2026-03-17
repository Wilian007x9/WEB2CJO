import java.util.Scanner;

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);
	private static PeopleManeger manager = new PeopleManeger();

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
	
	private static void search() {
		System.out.println("Digite o CPF: ");
		String cpf = scanner.nextLine();
		Person person = manager.search(cpf);
		if(person != null) {
			System.out.println("Pessoa encontrada. Dados: ");
			System.out.println(person);
		} else {
			System.out.println("Pessoa não encontrada. Tente novamente. ");
		}
	}
	
	private static void update() {
		System.out.println("Digite o CPF: ");
		String cpf = scanner.nextLine();
		System.out.println("Digite o nome: ");
		String name = scanner.nextLine();
		if(manager.update(cpf, name)) {
			System.out.println("Dados atualizados.");
		} else {
			System.out.println("Erro ao atualizar os dados.");
		}
	}
	
	private static void remove() {
		System.out.println("Digite o CPF: ");
		String cpf = scanner.nextLine();
		if(manager.remove(cpf)) {
			System.out.println("Dados excluidos.");
		} else {
			System.out.println("Erro ao excluir os dados os dados.");
		}
	}

	public static void main(String[] args) {
		int opcao;
		do {
			opcao = menu();
			switch (opcao) {
			case 1: {
				Person person = readData();
				if(manager.save(person)) {
					System.out.println("Pessoa cadastrada com sucesso!");
					System.out.println(manager.getPeopleList());
				} else {
					System.out.println("Erro ao cadastra pessoa");
				}
				break;
			}
			
			case 2: {
				search();
				break;
			}
			
			case 3: {
				update();
				break;
			}
			
			case 4: {
				remove();
				break;
			}
			default:
				System.out.println("Invalido!");
			}
			System.out.println("Pressioner ENTER para continuar...");
			scanner.nextLine();
		} while(opcao != 5);
	}
}
