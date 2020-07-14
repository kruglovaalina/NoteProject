package ka.noteproject.repository;

import ka.noteproject.domain.TaskList;
import org.springframework.data.repository.CrudRepository;

public interface TaskListRepository extends CrudRepository<TaskList, Long> {
    // List<TaskList> findAll();
}