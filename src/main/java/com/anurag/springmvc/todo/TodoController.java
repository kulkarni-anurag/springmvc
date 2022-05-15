package com.anurag.springmvc.todo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class TodoController {
    
    @Autowired
    TodoService service;

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTodoPage(ModelMap model){
        model.addAttribute("todos", service.retrieveTodos("virat"));
        return "list-todos";
    }

    @RequestMapping(value = "/addtodo", method = RequestMethod.GET)
    public String addTodoPage(ModelMap model){
        model.addAttribute("todo", new Todo());
        return "todo";
    }

    @RequestMapping(value = "/addtodo", method = RequestMethod.POST)
    public String handleAddTodo(@ModelAttribute("todo") Todo todo, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            System.out.println("error");
        }
        service.addTodo((String) model.get("username"), todo.getDesc(), new Date(), false);
        model.clear();
        return "redirect:list-todos";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id, ModelMap model){
        service.deleteTodo(id);
        model.clear();
        return "redirect:list-todos";
    }
}
