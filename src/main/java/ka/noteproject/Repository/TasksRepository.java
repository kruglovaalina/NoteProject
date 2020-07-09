package ka.noteproject.Repository;

import ka.noteproject.Entities.TaskList;
import ka.noteproject.Entities.Tasks;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TasksRepository extends CrudRepository<Tasks, Long> {
    List<Tasks> findByTaskList(TaskList taskList);
}
