import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class DaoAluno implements Dao<Aluno>{   

    private List<Aluno> alunos = new ArrayList<>();


    @Override
    public Optional<Aluno> get(long id){

        for(var a : alunos){
            if(a.getId() == id){
            return Optional.of(a);
        }
    }

        return Optional.empty();
}

    @Override
    public List<Aluno> getAll(){

        return alunos;

}     

    @Override
    public void save(Aluno aluno){    

        this.alunos.add(aluno);  
    

}

    @Override
    public void update(Aluno aluno){

        var existe = get(aluno.getId());

        if(existe.isPresent()){
            var a = existe.get();
            a.setNome(aluno.getNome());
            a.setCpf(aluno.getCpf());
        }else {

            this.alunos.add(aluno);
    }    
    
}

    @Override
    public void delete(Aluno aluno){

        var existe = get(aluno.getId());
        if(existe.isPresent()){
            this.alunos.remove(aluno);
        }  else {
            System.out.println("ERROR: NOT FOUND -> "+aluno.getClass());
    }
    

}


    
    public String toString() {
        return "DaoAluno [alunos=" + alunos + "]";
}






    
}

