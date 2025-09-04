import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aluno{
	
	//properties
	private int matricula;
	private String nome;
	private LocalDate nascimento;
	private String curso;
	private int periodo;
	
	//constructors
	public Aluno() {
		this.matricula = -1;
		this.nome = "";
		this.nascimento = null;
		this.curso = "";
		this.periodo = -1;
	}
	public Aluno(int matricula, String nome, LocalDate nascimento, String curso, int periodo) {
		this.matricula = matricula;
		this.nome = nome;
		this.nascimento = nascimento;
		this.curso = curso;
		this.periodo = periodo;
	}
	
	//getters
	public int getMatricula() {
		return this.matricula;
	}
	public String getNome() {
		return this.nome;
	}
	public LocalDate getNascimento() {
		return this.nascimento;
	}
	public String getCurso() {
		return this.curso;
	}
	public int getPeriodo() {
		return this.periodo;
	}
	
	//setters
	public void setMatricula(int matricula) {
		this.matricula =  matricula;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	public void setNascimento(String nascimentoStr, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		this.nascimento = LocalDate.parse(nascimentoStr, formatter);
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
	//methods
	@Override
	public String toString() {
		return "Aluno [" + 
				"matricula=" + this.getMatricula() + 
				", nome=" + this.getNome() + 
				", nascimento=" + this.getNascimento().toString() + 
				", curso=" + this.getCurso() + 
				", periodo=" + this.getPeriodo() +
				"]";
	}
	
	
}
