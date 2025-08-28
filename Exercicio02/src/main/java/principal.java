import java.time.LocalDate;
public class principal {
	public static void main(String[] args) {
		Aluno aluno = new Aluno(87830, "Jacinto", LocalDate.of(2001, 9, 11), "Engenharia de pesca", 5);
		System.out.println(aluno);
	}

}
