/**
 * 
 */
package com.in28minutes.rest.webservices.restfulwebservices.User;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.*;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author PRITAM RAJ
 *
 */

@RestController
public class UserJPAResource {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/jpa/users")
	public List<User> retriveAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retriveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		EntityModel<User> model = EntityModel.of(user.get());
		
		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retriveAllUsers());
		
		model.add(linkToUsers.withRel("all-users"));
		return model;
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
		
	}
	
}
