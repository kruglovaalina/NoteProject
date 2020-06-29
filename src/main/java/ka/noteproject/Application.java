package ka.noteproject;

import ka.noteproject.Entities.TaskList;
import ka.noteproject.Repository.TaskListRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        TaskListRepository repository = context.getBean(TaskListRepository.class);

        // save a couple of lists
        repository.save(new TaskList("Test list1"));
        repository.save(new TaskList("Test list2"));


        // fetch all lists
        Iterable<TaskList> lists = repository.findAll();
        System.out.println("Lists found with findAll():");
        System.out.println("-------------------------------");
        for (TaskList entity : lists) {
            System.out.println(entity.getName());
        }

        context.close();
    }
}