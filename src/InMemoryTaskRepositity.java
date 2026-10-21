import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryTaskRepositity  implements TaskRepository{
    private final List<Task> tasks = new ArrayList<>();
    private static InMemoryTaskRepositity instance;

    private InMemoryTaskRepositity(){

    }
    public static InMemoryTaskRepositity getInstance(){
        if (instance == null){
            instance = new InMemoryTaskRepositity();
        }
        return instance;
    }


    @Override
    public void save(Task task){
        tasks.add(task);
        System.out.println("Репозиторий: Задача успешно сохранена в список.");
    }
    @Override
    public Optional<Task> findById(int id){
        for (Task task: tasks){
            if(task.getId() == id){
                return Optional.of(task);
            }
        }
        return Optional.empty();
    }
    @Override
    public List<Task> findAll(){
        return new ArrayList<>(tasks);
    }
}
