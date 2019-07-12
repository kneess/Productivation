package com.ac.Productivation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ac.Productivation.model.User;
import com.ac.Productivation.repository.UserRepository;
import com.ac.Productivation.service.ProductivationServiceInt;
import com.ac.Productivation.service.UserService;

@RunWith(SpringRunner.class)
public class ProductivationServiceImplTest {
	@TestConfiguration
	static class ProductivationServiceImplContext{
		@Bean
		public ProductivationServiceInt service()
		{
			return new UserService();
		}
	}
	private static User me;
	
	@Autowired
	UserService service;
	
	@MockBean
	UserRepository repository;
	
	@Before
	public void setUp() {
		 me = new User("Anibal","Campos","Anibalicz");
	}
	

	@Test
	public void whenFoundById_thenReturnUsertest() {
		Mockito.when(repository.findUserById(1l)).thenReturn(me);
		User found = service.getUserById(1l);
		assertThat(found.getId()).isEqualTo(me.getId());
	}

}
