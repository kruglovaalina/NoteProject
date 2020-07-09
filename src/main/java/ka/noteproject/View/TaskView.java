package ka.noteproject.View;

import ka.noteproject.Entities.TaskList;
import ka.noteproject.Entities.Tasks;
import ka.noteproject.Repository.TaskListRepository;
import ka.noteproject.Repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TaskView {
    @Autowired
    private TaskListRepository taskListRepository;

    @Autowired
    private TasksRepository tasksRepository;

    @RequestMapping(value = {"/list/{parent_uid}"}, method = RequestMethod.GET)
    public String getIndex(Model model, @PathVariable Long parent_uid) {
        Map<Long, Tasks> tasks = getTasks();

        model.addAttribute("tasks", tasks.values());

        return "list";
    }

    @RequestMapping(value = {"/list/{parent_uid}/{uid}"}, method = RequestMethod.GET)
    public String getIndex(Model model, @PathVariable long uid, @PathVariable Long parent_uid){
        Map<Long, Tasks> tasks = getTasks();

        model.addAttribute("tasks", tasks.values());

        return "list";
    }

    private Map<Long, Tasks> getTasks(){
        Map<Long, Tasks> result = new HashMap<>();

        Iterable<Tasks> tasks = tasksRepository.findAll();

        for (Tasks entity: tasks){
            result.put(entity.getUid(), entity);
        }
        return result;
    }

    @RequestMapping(value="/list/addTask", method=RequestMethod.GET)
    public String taskForm(Model model) {
        model.addAttribute("addTask", new TaskList());
        return "addTask";
    }

    @RequestMapping(value="/list/addTask", method=RequestMethod.POST)
    public String taskSubmit(@ModelAttribute Tasks addtask, Model model) {
        if (StringUtils.hasText(addtask.getTittle())){
            tasksRepository.save(new Tasks());
        }
        return "redirect:/list/" + addtask.getTaskListUid();
    }
}

