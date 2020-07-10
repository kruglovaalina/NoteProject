package ka.noteproject.view;

import ka.noteproject.domain.TaskList;
import ka.noteproject.domain.Tasks;
import ka.noteproject.repository.TaskListRepository;
import ka.noteproject.repository.TasksRepository;
import ka.noteproject.vo.TaskListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TaskView {
    @Autowired
    private TaskListRepository taskListRepository;

    @Autowired
    private TasksRepository tasksRepository;

    @RequestMapping(value="/list/addTask", method=RequestMethod.GET)
    public String taskForm(Model model) {
        model.addAttribute("addTask", new TaskList());
        return "addTask";
    }

    @RequestMapping(value="/list/addTask", method=RequestMethod.POST)
    public String taskSubmit(@ModelAttribute TaskListVO task, Model model) {
        if (StringUtils.hasText(task.getTitle())){
            TaskList list = taskListRepository.findById(task.getParentUid()).get();

            Tasks task1 = new Tasks();
            task1.setTittle(task.getTitle());
            task1.setTaskList(list);

            tasksRepository.save(task1);
        }
        return "redirect:/list/" + task.getParentUid();
    }
}

