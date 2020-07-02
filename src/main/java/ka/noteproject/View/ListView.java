package ka.noteproject.View;

import ka.noteproject.Entities.TaskList;
import ka.noteproject.Repository.TaskListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ListView {
    @Autowired
    private TaskListRepository taskListRepository;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String getIndex(Model model) {
        Map<Long, TaskList> lists = getLists();

        model.addAttribute("lists", lists.values());

        return "list";
    }

    @RequestMapping(value = {"/list/{id}"}, method = RequestMethod.GET)
    public String getIndex(Model model, @PathVariable long uid){
        Map<Long, TaskList> lists = getLists();

        model.addAttribute("lists", lists.values());
        model.addAttribute("currentList", lists.get(null));

        return "list";
    }

    private Map<Long, TaskList> getLists(){
        Map<Long, TaskList> result = new HashMap<>();
        Iterable<TaskList> lists = taskListRepository.findAll();

        for (TaskList entity: lists){
            result.put(entity.getUid(), entity);
        }
        return result;
    }
}