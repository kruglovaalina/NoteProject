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
public class ListView {
    @Autowired
    private TaskListRepository taskListRepository;

    @Autowired
    private TasksRepository tasksRepository;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String getIndex(Model model) {
        Map<Long, TaskList> lists = getLists();
        Iterable<Tasks> tasks = tasksRepository.findAll();

        model.addAttribute("lists", lists.values());
        model.addAttribute("currentList", lists.get(0L));
        model.addAttribute("tasks", tasks);

        return "list";
    }

    @RequestMapping(value = {"/list/{uid}"}, method = RequestMethod.GET)
    public String getIndex(Model model, @PathVariable long uid){
        Map<Long, TaskList> lists = getLists();
        List<Tasks> tasks = tasksRepository.findByTaskList((TaskList) lists);


        model.addAttribute("lists", lists.values());
        model.addAttribute("currentList", lists.get(uid));
        model.addAttribute("tasks", tasks);

        return "list";
    }

    private Map<Long, TaskList> getLists(){
        Map<Long, TaskList> result = new HashMap<>();
        result.put(0L, new TaskList(("Все")));

        Iterable<TaskList> lists = taskListRepository.findAll();

        for (TaskList entity: lists){
            result.put(entity.getUid(), entity);
        }
        return result;
    }


    @RequestMapping(value={"/addList"}, method=RequestMethod.GET)
    public String listForm(Model model) {
        model.addAttribute("addList", new TaskList());
        return "addList";
    }

    @RequestMapping(value="/addList", method=RequestMethod.POST)
    public String listSubmit(@ModelAttribute TaskList addlist, Model model) {
        if (StringUtils.hasText(addlist.getName())) {
            TaskList result = taskListRepository.save(new TaskList(addlist.getName()));
            Long uid = result.getUid();

            return "redirect:/list/" + uid;
        }
        return "redirect:/list";
    }
}