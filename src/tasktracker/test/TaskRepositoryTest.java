package tasktracker.test;

import tasktracker.model.Task;
import tasktracker.repository.InMemoryTaskRepositity;
import tasktracker.repository.TaskRepository;

import java.util.Optional;

public class TaskRepositoryTest {
    public static void main(String[] args){
        System.out.println("=== ЗАПУСК UNIT-ТЕСТОВ РЕПОЗИТОРИЯ ===");

        testSaveAndFindByIdSuccess();
        testFindByNotFound();
    }

    // Тест-кейс 1: Успешное сохранение и поиск задачи
    public static void testSaveAndFindByIdSuccess(){
        TaskRepository repository = InMemoryTaskRepositity.getInstance();
        Task task = Task.builder().id(100).title("Тестовая задача").build();


        repository.save(task);
        Optional<Task> foundOptional = repository.findById(100);


        if(foundOptional.isPresent() && foundOptional.get().getTitle().equals("Тестовая задача")){
            System.out.println("✅ ТЕСТ 1 ПРОЙДЕН: Задача успешно сохранена и найдена.");
        }else{
            System.out.println("❌ ТЕСТ 1 ПРОВАЛЕН: Не удалось найти сохраненную задачу!");
        }
    }
    // ест-кейс 2: Поиск несуществующей задачи (Должен вернуть пустой Optional)
    public static void testFindByNotFound(){
        TaskRepository repository = InMemoryTaskRepositity.getInstance();
        Optional<Task> foundOptinal = repository.findById(999_999);

        if(foundOptinal.isEmpty()){
            System.out.println("✅ ТЕСТ 2 ПРОЙДЕН: Для несуществующего ID возвращается пустой Optional.");
        }else{
            System.out.println("❌ ТЕСТ 2 ПРОВАЛЕН: Метод вернул объект там, где должен быть пустой Optional!");
        }
    }

}
