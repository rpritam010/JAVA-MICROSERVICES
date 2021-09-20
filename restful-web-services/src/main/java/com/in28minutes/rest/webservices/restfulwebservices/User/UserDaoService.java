/**
 * 
 */
package com.in28minutes.rest.webservices.restfulwebservices.User;

import java.util.*;

import org.springframework.stereotype.Component;

/**
 * @author PRITAM RAJ
 *
 */

@Component
public class UserDaoService {

	private static List<User> users= new ArrayList<>();
	
	private static int usersCount = 3;
	static {
		users.add(new User("Pritam",1 , new Date()));
		users.add(new User("Raj",2,new Date()));
		users.add(new User("Harini",3,new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
