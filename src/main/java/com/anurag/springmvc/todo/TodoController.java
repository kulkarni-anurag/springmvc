package com.anurag.springmvc.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TodoController {
    
    TodoService service = new TodoService();

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTodoPage(ModelMap model){
        model.addAttribute("todos", service.retrieveTodos("virat"));
        return "list-todos";
    }
}
