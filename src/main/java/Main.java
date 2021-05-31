import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("poo");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();


    public static void salvar(Object a){

        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit(); 
        System.out.println("Aluno cadastrado.");
    }

    public static <T> T buscar(Class<T> entityClass, Integer id) {
        var obj = entityManager.find(entityClass, id);



        return obj;

    }

    public static void atualizar(Object a){

        entityManager.getTransaction().begin();
        entityManager.merge(a);
        entityManager.getTransaction().commit(); 
        System.out.println("atualizado com sucesso...");

    }

    public <T> List<T> listar(Class<T> entityClass) {
        return entityManager.createQuery("select a from " + entityClass.getSimpleName() + " a", entityClass)
                .getResultList();
    }

    public static void remover(Object a){

        entityManager.getTransaction().begin();
        entityManager.remove(a);
        entityManager.getTransaction().commit();
        System.out.println("Removido...");
    }

    public static void encerrar(){

        entityManager.close();
        entityManagerFactory.close();

    }

    public static void main (String [] args) {
        
        String matricula = "12107864";
        String cpf = "123456789-10";
        String nome = "Samuel vertelo";        
        LocalDate dataDeNascimento = LocalDate.parse("1989-11-10");
                

        var aluno = new Aluno(matricula, cpf, nome, dataDeNascimento);

        var daoAluno = new DaoAluno();

        daoAluno.save(aluno);
        salvar(aluno);        
             

       var aluno2 = new Aluno("12107865", "123456789-11","guilherme", dataDeNascimento);
       
       salvar(aluno2);     
        
        
        atualizar(aluno);

        remover(aluno2);

        dataDeNascimento = LocalDate.parse("1978-06-23");

        Professor prof = new Professor("Waldir", "3001-01", "Mestrado", dataDeNascimento);
        salvar(prof);
        
        
        

       
        encerrar();
        
    }   

    
}
