package com.ac.Productivation;


import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ac.Productivation.model.User;
import com.ac.Productivation.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductivationRepositoryIntTest {
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	UserRepository repository;

	@Test
	public void whenUserFoundBYFirstName_thenReturnUsertest() {
		User me = new User("Anibal","Campos","Anibalicz");
		entityManager.persist(me);
		entityManager.flush();
		
		User found = repository.findUserById(me.getId());
		assertThat(found.getId()).isEqualTo(me.getId());
	}

}
