import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "aluno")

public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String matricula;
    
    private String cpf;
    
    private String nome;
    
    private LocalDate dataDeNascimento;

    

    public Aluno(String matricula, String cpf, String nome, LocalDate dataNascimento) {
        this.matricula = matricula;
        this.cpf = cpf;
        this.nome = nome;
        this.dataDeNascimento = dataNascimento;
         
    }



    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }



    public String getMatricula() {
        return matricula;
    }



    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }



    public String getCpf() {
        return cpf;
    }



    public void setCpf(String cpf) {
        this.cpf = cpf;
    }



    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }



    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    


    
    
}
