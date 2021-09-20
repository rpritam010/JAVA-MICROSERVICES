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
import org.springframework.validation.annotation.Validated;
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
public class UserResource {

	@Autowired
	private UserDaoService service;
	//get / users
	//retriveAllUsers
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<User> retriveUser(@PathVariable int id) {
		User user = service.findOne(id);
		
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
		EntityModel<User> model = EntityModel.of(user);
		
		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retriveAllUsers());
		
		model.add(linkToUsers.withRel("all-users"));
		return model;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
	}
	
}
