package ka.noteproject.Repository;

import ka.noteproject.Entities.Tasks;
import org.springframework.data.repository.CrudRepository;

public interface TasksRepository extends CrudRepository<Tasks, Long> {
}
