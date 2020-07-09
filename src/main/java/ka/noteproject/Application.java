package ka.noteproject;

import ka.noteproject.Entities.TaskList;
import ka.noteproject.Entities.Tasks;
import ka.noteproject.Repository.TaskListRepository;
import ka.noteproject.Repository.TasksRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;
import java.util.List;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
       /* TaskListRepository taskListRepository = context.getBean(TaskListRepository.class);
        TasksRepository tasksRepository = context.getBean(TasksRepository.class);

        //список задач
        TaskList newTaskList = taskListRepository.save(new TaskList("Test List 1"));

        //задача 1
        Tasks newTask1 = new Tasks();
        newTask1.setTittle("Task 1");
        newTask1.setTaskList(newTaskList);

        //задача 2
        Tasks newTask2 = new Tasks();
        newTask2.setTittle("Task 2");
        newTask2.setTaskList(newTaskList);

        tasksRepository.save(newTask1);
        tasksRepository.save(newTask2);

        System.out.println("Тест 1 - вывод списка и задач в нем");
        showALLTaskList(taskListRepository, tasksRepository);

        //список всех задач в БД
        Iterable<Tasks> tasks = tasksRepository.findAll();

        //первая задача из итератора
        Tasks oneTasks = tasks.iterator().next();

        //удаляем ее
        //taskListRepository.delete(oneTasks);

        //System.out.println("Тест 2 - вывод списка и задач в нем после удаления одной");
        //showALLTaskList(taskListRepository, tasksRepository);

        context.close();
        */
    }

    private static void showALLTaskList(TaskListRepository taskListRepository, TasksRepository tasksRepository) {
        Iterable<TaskList> taskLists = taskListRepository.findAll();

        for(TaskList taskList: taskLists) {
            System.out.println(taskList.getUid() + ": " + taskList.getName());
            List<Tasks> tasks = tasksRepository.findByTaskList(taskList);

            for (Tasks task: tasks) {
                System.out.println(" - " + task.getUid() + ": " + task.getTittle());
            }
        }
    }
}