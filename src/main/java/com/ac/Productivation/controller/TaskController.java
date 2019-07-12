package com.ac.Productivation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.ac.Productivation.model.Task;
import com.ac.Productivation.model.User;
import com.ac.Productivation.service.TaskService;
import com.ac.Productivation.service.UserService;

@Controller
public class TaskController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping(value= {"/tasks", "/"})
	public String userTasks(Model model) {
		User user = userService.getLoggedInUser();
		List<Task> tasks = taskService.findAllByUser(user);
		model.addAttribute("tasks", tasks);
		return "alltasks";
	}
	
	@GetMapping("task/new")
		public String form(Model model) {
			model.addAttribute("task", new Task());
			return "new";
	}
	
	@PostMapping("/tasks")
	public String newTask(@Valid Task task, BindingResult bindingResult, Model model) {
		User user = userService.getLoggedInUser();
		if(!bindingResult.hasErrors()) {
			task.setUser(user);
			taskService.save(task);
			model.addAttribute("success","Task Successfully Submited");
			model.addAttribute("task", new Task());
		}
		return "new";
	}
	
	@GetMapping("/task/{task.id}")
	public String getTask(@PathVariable("task.id") Long id, Task task, Model model) {
		Task singleTask = taskService.findById(id);
		model.addAttribute("task", singleTask);
		return "task";
	}
	
	@DeleteMapping("/task/{task.id}")
	public RedirectView deleteTask(@PathVariable("task.id") Long id) {
		Task task = taskService.findById(id);
		taskService.delete(task);
		return new RedirectView("/tasks");
	}
	
	@PutMapping("/task/{task.id}")
	public RedirectView completeTask(@PathVariable("task.id") Long id) {
		Task task = taskService.findById(id);
		boolean isTrue = true;
		boolean isFalse = false;
		if(task.isComplete() != true) {
			task.setComplete(isTrue);
		} else {
			task.setComplete(isFalse);
		}
		taskService.save(task);
		return new RedirectView("/tasks");
	}
}
