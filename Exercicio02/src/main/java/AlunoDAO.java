import java.sql.ResultSet;

public class AlunoDAO extends DAO{
	public AlunoDAO() {
		super();
	}
	
	public boolean insertAluno(Aluno aluno) {
		return this.sendNotReadableQuery(
				"INSERT INTO aluno (matricula, nome, nascimento, curso, periodo) VALUES ("
				+ aluno.getMatricula() + ", '" + aluno.getNome() + "', '" + aluno.getNascimento().toString() + "', '"
				+ aluno.getCurso() + "', " + aluno.getPeriodo() + ");");
	}
	public boolean updateAluno(Aluno aluno) {
		return this.sendNotReadableQuery(
				"UPDATE aluno SET nome= '" + aluno.getNome() + "', nascimento= '" + aluno.getNascimento().toString()
				+ "', curso= '" + aluno.getCurso() + "', periodo= " + aluno.getPeriodo()
				+ " WHERE matricula= " + aluno.getMatricula() + ";");
	}
	
	public boolean deleteAluno(int matricula) {
		return this.sendNotReadableQuery("DELETE FROM aluno WHERE matricula= " + matricula + ";");
	}
	
	public boolean deleteAluno(Aluno aluno) {
		return deleteAluno(aluno.getMatricula());
	}
	
	public Aluno[] getAlunos() {
		return this.<Aluno[]>sendReadableQuery("SELECT * FROM aluno", (ResultSet rs) -> {
			Aluno[] alunos = null;
			if(rs.next()){
				rs.last();
				alunos = new Aluno[rs.getRow()];
				rs.beforeFirst();

				for(int i = 0; rs.next(); i++) {
					alunos[i] = new Aluno(rs.getInt("matricula"), rs.getString("nome"), rs.getDate("nascimento").toLocalDate(), rs.getString("curso"), rs.getInt("periodo"));
				}
			}
			return alunos;
		});
	}
}
