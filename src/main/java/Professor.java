import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;
    private String matricula;
    private String formacao;
    private LocalDate dataNascimento;

    
    public Professor(String nome, String matricula, String formacao, LocalDate dataNascimento) {
		this.nome = nome;
		this.matricula = matricula;
		this.formacao = formacao;
		this.dataNascimento = dataNascimento;
	}

	public Integer getId() {
        return id;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Professor [dataNascimento=" + dataNascimento + ", formacao=" + formacao + ", id=" + id + ", matricula="
				+ matricula + ", nome=" + nome + "]";
	}

    

   
    
        
}
