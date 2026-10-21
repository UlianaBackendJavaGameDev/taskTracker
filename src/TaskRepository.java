import java.util.List;
import java.util.Optional;



public interface TaskRepository {
    void save(Task task);
    Optional<Task> findById(int id);
    List<Task> findAll();

}
