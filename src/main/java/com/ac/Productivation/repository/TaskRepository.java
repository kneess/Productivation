package com.ac.Productivation.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ac.Productivation.model.Task;
import com.ac.Productivation.model.User;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long>{
	public List<Task> findAllByUser(User user);
	public Task findTaskById(Long id);
}
