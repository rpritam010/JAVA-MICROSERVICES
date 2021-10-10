/**
 * 
 */
package com.in28minutes.rest.webservices.restfulwebservices.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author PRITAM RAJ
 *
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
