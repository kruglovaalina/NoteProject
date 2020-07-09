package ka.noteproject.Repository;

import ka.noteproject.Entities.TaskList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskListRepository extends CrudRepository<TaskList, Long> {
   // List<TaskList> findAll();
}