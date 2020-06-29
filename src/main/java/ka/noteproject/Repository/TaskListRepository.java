package ka.noteproject.Repository;

import ka.noteproject.Entities.TaskList;
import org.springframework.data.repository.CrudRepository;

public interface TaskListRepository extends CrudRepository<TaskList, Long> {


}