public class Main{
    public static void main(String[] args){
        TaskRepository repository = InMemoryTaskRepositity.getInstance();

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

        try{
            taskService.completeTask(-10);
        } catch (IllegalArgumentException e){
            System.out.println("Перехвачено исключение в классе Main: " + e.getMessage());

        }
        System.out.println("\n[КОНЕЦ] Программа не упала и успешно завершила работу!");
    }
}