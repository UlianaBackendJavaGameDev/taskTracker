import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class FileTaskRepository  implements TaskRepository{
    private final String FILE_NAME = "task.txt";

    @Override
    public void save(Task task){
        List<Task> currentTask = findAll();
        currentTask.removeIf(t -> t.getId() == task.getId());
        currentTask.add(task);

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))){
            for (Task t :  currentTask){
                writer.println(t.getId() + "|" + t.getTitle() + "|" + t.isCompleated());
            }
            System.out.println("Файловый репозиторий: Задача успешно сохранена на диск.");
        } catch (IOException e){
            System.out.println("Ошибка ввода-вывода при записи в файл: " + e.getMessage());
        }
    }
    @Override
    public Optional<Task> findById(int id){
        for (Task task : findAll()){
            if(task.getId() == id){
                return  Optional.of(task);
            }
        }
        return Optional.empty();
    }
    @Override
    public List<Task> findAll(){
        List<Task> taskList = new ArrayList<>();
        File file = new File(FILE_NAME);


        if(!file.exists() ){
            return taskList;
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;

            while((line = reader.readLine()) != null){
                String [] parts = line.split("\\|");
                int id  = Integer.parseInt(parts[0]);
                String title = parts[1];
                boolean isCompleated = Boolean.parseBoolean(parts[2]);

                Task task =  Task.builder()
                        .id(id)
                        .title(title)
                        .isCompleated(isCompleated)
                        .author("Ульяна")
                        .dicription("Загружено из файла")
                        .build();
                taskList.add(task);
            }
        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода при чтении файла: " + e.getMessage());
        }
        return taskList;
    }
}
