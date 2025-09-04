import java.util.Scanner;
public class principal {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		AlunoDAO dao = new AlunoDAO();
		dao.conectar();
		boolean sair = false;
		do{
			System.out.println("==========MENU==========\n");
			System.out.println("0 - Sair");
			System.out.println("1 - Listar alunos");
			System.out.println("2 - Inserir aluno");
			System.out.println("3 - Excluir aluno");
			System.out.println("4 - Atualizar aluno");
			
			int opcao = sc.nextInt();
			sc.nextLine();
			switch(opcao) {
				case 0:
					sair = true;
					break;
				case 1:
					System.out.println("Alunos: ");
					Aluno[] alunos = dao.getAlunos();
					for(Aluno aluno : alunos) {
						System.out.println(aluno);
					}
					break;
				case 2:
					if(dao.insertAluno(readAluno())) {
						System.out.println("Aluno inserido com sucesso");
					}else {
						System.out.println("Falha ao inserir aluno");
					}
					break;
				case 3:
					System.out.print("Digite o número de matricula do aluno que deseja excluir: ");
					int matricula = sc.nextInt();
					sc.nextLine();
					if(dao.deleteAluno(matricula)) {
						System.out.println("Aluno(" + matricula + ") deletado com sucesso");
					}else {
						System.out.println("Erro ao deletar aluno(" + matricula + ")");
					}
					break;
				case 4:
					updateMenu(dao);
					break;
					
			}
			
		}while(!sair);
		
		dao.close();
	
	}
	
	
	public static Aluno readAluno() {
		Aluno aluno = new Aluno();
		System.out.print("Digite o número de matricula: ");
		aluno.setMatricula(sc.nextInt());
		sc.nextLine();
		System.out.print("Digite o nome: ");
		aluno.setNome(sc.nextLine());
		System.out.print("Digite a data de nasicmento (dd/MM/yyyy): ");
		aluno.setNascimento(sc.nextLine(), "dd/MM/yyyy");
		System.out.print("Digite ao curso: ");
		aluno.setCurso(sc.nextLine());
		System.out.print("Digite o periodo: ");
		aluno.setPeriodo(sc.nextInt());
		sc.nextLine();
		return aluno;
	}
	
	public static void updateMenu(AlunoDAO dao) {
		System.out.print("Digite o número de matricula do aluno a atualizar: ");
		Aluno aluno = dao.getAluno(sc.nextInt());
		sc.nextLine();
		boolean sair = false;
		do {
			System.out.println(aluno.toString() + "\n");
			System.out.println("Qual campo deseja alterar?\n");
			System.out.println("0 - Salvar alterações");
			System.out.println("1 - nome");
			System.out.println("2 - nascimento (dd/MM/yyyy)");
			System.out.println("3 - curso");
			System.out.println("4 - periodo");
			
			int opcao = sc.nextInt();
			sc.nextLine();
			
			switch(opcao) {
				case 0:
					if(dao.updateAluno(aluno)) {
						System.out.println("Aluno atualizado com sucesso");
					}else {
						System.out.println("Falha ao salvar");
					}
					sair = true;
					break;
				case 1:
					System.out.print("Digite o nome: ");
					aluno.setNome(sc.nextLine());
					break;
				case 2:
					System.out.print("Digite a data de nascimento (dd/MM/yyyy): ");
					aluno.setNascimento(sc.nextLine(), "dd/MM/yyyy");
					break;
				case 3:
					System.out.print("Digite o curso: ");
					aluno.setCurso(sc.nextLine());
					break;
				case 4:
					System.out.print("Digite o período: ");
					aluno.setPeriodo(sc.nextInt());
					sc.nextLine();
					break;
			}
		}while(!sair);
		

	}

}
