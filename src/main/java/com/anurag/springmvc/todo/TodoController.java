package com.anurag.springmvc.todo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class TodoController {
    
    @Autowired
    TodoService service;

    @InitBinder
    public void InitBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTodoPage(ModelMap model){
        model.addAttribute("todos", service.retrieveTodos(retrieveLoggedInUserName()));
        return "list-todos";
    }

    public String retrieveLoggedInUserName(){
        return "virat";
    }

    @RequestMapping(value = "/addtodo", method = RequestMethod.GET)
    public String addTodoPage(ModelMap model){
        model.addAttribute("todo", new Todo());
        return "todo";
    }

    @RequestMapping(value = "/addtodo", method = RequestMethod.POST)
    public String handleAddTodo(@ModelAttribute("todo") Todo todo, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            return "todo";
        }
        service.addTodo((String) model.get("username"), todo.getDesc(), todo.getTargetDate(), false);
        model.clear();
        return "redirect:list-todos";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id, ModelMap model){
        service.deleteTodo(id);
        model.clear();
        return "redirect:list-todos";
    }

    @GetMapping(value = "/update-todo")
    public String updateTodo(ModelMap model, @RequestParam int id){
        Todo todo = service.retrieveTodo(id);
        model.addAttribute("todo", todo);
        return "todo";
    }

    @PostMapping(value = "/update-todo")
    public String handleUpdatePost(ModelMap model, @ModelAttribute("todo") Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
        todo.setUser((String) model.get("username"));
        service.updateTodo(todo);
        model.clear();
        return "redirect:list-todos";
    }
}
