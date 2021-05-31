import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DaoProfessor implements Dao<Professor> {

    private List<Professor> professores = new ArrayList<>();

    
    @Override
    public Optional<Professor> get(long id) {
        for(var a : professores){
            if(a.getId() == id){
            return Optional.of(a);  }    
    }

        return Optional.empty();

    }
    

    @Override
    public List<Professor> getAll() {
        
        return professores;
    }

    @Override
    public void save(Professor p) {
        this.professores.add(p);

    }

    @Override
    public void update(Professor professor) {

        var existe = get(professor.getId());

        if(existe.isPresent()){
            var p = existe.get();
            p.setNome(professor.getNome());
            p.setFormacao(professor.getFormacao());
        }else {

            this.professores.add(professor);
        }       

    }

    @Override
    public void delete(Professor professor) {

        var existe = get(professor.getId());
        if(existe.isPresent()){
            this.professores.remove(professor);
        }else {
            System.out.println("ERRO: NÃO ENCONTRADO");
        }
       

    }

    public List<Professor> getProfessores() {
        return professores;
    }

        

}
