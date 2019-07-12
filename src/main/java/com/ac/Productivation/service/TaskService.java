package com.ac.Productivation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ac.Productivation.model.Task;
import com.ac.Productivation.model.User;
import com.ac.Productivation.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> findAllByUser(User user) {
		List<Task> tasks = taskRepository.findAllByUser(user);
		return tasks;
	}
	
	public void save(Task task) {
		taskRepository.save(task);
	}
	
	public void delete(Task task) {
		taskRepository.delete(task);
	}
	
	public Task findById(Long id) {
		return taskRepository.findTaskById(id);
	}
}
