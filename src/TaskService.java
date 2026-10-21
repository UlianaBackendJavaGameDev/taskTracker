import java.util.List;
import java.util.Optional;

public class TaskService {
    private final TaskRepository repository;


    public TaskService(TaskRepository repository){
        this.repository = repository;
    }
    public void createAndSaveTask(int id, String title){
        Task newTask = Task.builder()
                .id(id)
                .title(title)
                .author("Ульяна")
                .dicription("Задача сделана через паттерн Builder")
                .build();
        repository.save(newTask);
    }
    public void completeTask(int id){
        if (id <= 0){
            throw new IllegalArgumentException("ID задачи должен быть больше нуля! Передано: " + id);
        }
        Optional<Task> taskOptional = repository.findById(id);
        taskOptional.ifPresentOrElse(
                task -> {
                    task.setCompleated(true);
                    System.out.println("Сервис: Задача с ID " + id + " отмечена как выполненная.");
                },
                () -> System.out.printf("Сервис ОШИБКА: Задача с ID %d не найдена в системе!%n", id)
        );
    }
    public  void printAllTasks(){
        List<Task> allTasks = repository.findAll();
        System.out.println("=== СПИСОК ВСЕХ ЗАДАЧ ===");
        if(allTasks.isEmpty()){
            System.out.println("Задач пока нет.");
        }else{
            for (Task task : allTasks){
                System.out.println(task);
            }
        }
    }
}
