package pl.edu.pb.todoapp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskStorage {
    private static final TaskStorage taskStorage = new TaskStorage();
    private final List<Task> tasks;

    private TaskStorage() {
        tasks = new ArrayList<Task>();
        for(int i = 1; i <= 150; i++){
            Task task = new Task();
            task.setName("Pilne zadanie numer" + i);
            task.setDone(i % 3 == 0);
            tasks.add(task);
            if(i % 3 == 0) {
                task.setCategory(Category.STUDIES);
            } else {
                task.setCategory(Category.HOME);
            }
        }
    }

    public void addTask(Task task){ tasks.add(task); }

    public static TaskStorage getInstance() {
        return taskStorage;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Task getTaskById(UUID uuid) {
        for (Task task : tasks){
            if(uuid.equals(task.getId())){
                return task;
            }
        }
        return null;
    }
}
