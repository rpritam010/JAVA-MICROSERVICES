/**
 * 
 */
package com.in28minutes.rest.webservices.restfulwebservices.versoning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PRITAM RAJ
 *
 */
@RestController
public class PersoningVersoningController {

	@GetMapping(value="/person/param",params="version=1")
	public PersonV1 personV1() {
		return new PersonV1("Pritam Raj");
	}
	@GetMapping(value="/person/param",params="version=2")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Pritam","Raj"));
	}
	
	@GetMapping(value="/person/header",headers="X-API-version=1")
	public PersonV1 headerV1() {
		return new PersonV1("Pritam Raj");
	}
	@GetMapping(value="/person/header",headers ="X-API-version=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Pritam","Raj"));
	}
	
	@GetMapping(value="/person/produces",produces ="application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Pritam Raj");
	}
	@GetMapping(value="/person/produces",produces ="application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Pritam","Raj"));
	}

}
