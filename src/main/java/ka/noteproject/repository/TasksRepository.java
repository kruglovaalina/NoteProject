package ka.noteproject.repository;

import ka.noteproject.domain.TaskList;
import ka.noteproject.domain.Tasks;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TasksRepository extends CrudRepository<Tasks, Long> {
    List<Tasks> findByTaskList(TaskList taskList);
}
