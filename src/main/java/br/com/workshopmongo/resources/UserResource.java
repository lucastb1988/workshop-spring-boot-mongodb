package br.com.workshopmongo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		User lucas = new User("1", "Lucas Banin", "lucas.t.banin@gmail.com");
		User gustavo = new User("2", "Gustavo Torres", "gustavo.torres@gmail.com");
		List<User> list = new ArrayList<>();
		list.add(lucas);
		list.add(gustavo);
		
		return ResponseEntity.ok().body(list);
	}
}
