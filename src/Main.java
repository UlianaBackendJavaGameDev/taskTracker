import java.util.List;

public class Main{
    public static void main(String[] args){
//        TaskRepository repository = InMemoryTaskRepositity.getInstance();

//        TaskService taskService = new TaskService(repository);

        TaskRepository repository = new FileTaskRepository();

        TaskService taskService = new TaskService(repository);
        System.out.println("--- Шаг 1: Проверяем пустой список ---");
        taskService.printAllTasks();

        System.out.println("\\n--- Шаг 2: Добавляем задачи ---");
        taskService.createAndSaveTask(1, "Выучить коллекции в Java");
        taskService.createAndSaveTask(2, "Разобраться с паттерном Dependency Injection");
        taskService.createAndSaveTask(3, "Понять, зачем нужен класс Optional");

        System.out.println("\n--- Шаг 3: Выводим список созданных задач ---");
        taskService.printAllTasks();

        System.out.println("\\n--- Шаг 4: Выполняем задачу №2 ---");
        taskService.completeTask(2);

        System.out.println("\n--- Шаг 5: Проверяем работу Optional на несуществующей задаче ---");
        taskService.completeTask(9999);

        System.out.println("\n--- Шаг 6: Финальный просмотр списка задач ---");
        taskService.printAllTasks();

        System.out.println("\\n--- Шаг 7: Тестируем наше исключение ---");

        System.out.println("\\n--- Шаг 8: Тестируем Stream API (Фильтр по автору) ---");
        List<Task> ulyanaTask = taskService.getTaskByAuthor("Ульяна");
        System.out.println("Задачи автора Ульяна:");
        ulyanaTask.forEach(task -> System.out.println(task));
        System.out.println("\\n--- Шаг 9: Тестируем Stream API (Только названия выполненных) ---");
        List<String> completeadTitles = taskService.getCompletedTaskTitles();
        System.out.println("Выполненные задачи (только заголовки): " + completeadTitles);

        System.out.println("\\n--- Шаг 10: Тестируем собственные Дженерики (Generics) ---");
        Box<String> stringBox = new Box<>();
        stringBox.put("Ульяна, дженерики работают!");
        String text = stringBox.get();
        System.out.println("Из строковой коробки достали:"+ text);

        Box<Task> taskBox = new Box<>();
        taskBox.put(Task.builder().id(777).title("Покорить Java Core").build());
        Task genericTask = taskBox.get();
        System.out.println("Из таск-коробки достали задачу: " + genericTask.getTitle());

        try{
            taskService.completeTask(-10);
        } catch (IllegalArgumentException e){
            System.out.println("Перехвачено исключение в классе Main: " + e.getMessage());

        }
        System.out.println("\n[КОНЕЦ] Программа не упала и успешно завершила работу!");
    }
}
class Box<T>{
    private T item;

    public void put(T item){
        this.item = item;
    }
    public T get(){
        return item;
    }
}