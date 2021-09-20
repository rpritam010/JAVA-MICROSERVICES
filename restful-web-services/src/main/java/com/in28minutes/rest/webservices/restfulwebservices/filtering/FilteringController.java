/**
 * 
 */
package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.*;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
 * @author PRITAM RAJ
 *
 */

@RestController
public class FilteringController {

	//fields1,fields2
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBean sb = new SomeBean("value1","value2","value3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("Fields1","Fields2");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(sb);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retriveListOfSomeBean() {
		
		return Arrays.asList(new SomeBean("value1","value2","value3"),new SomeBean("value11","value22","value33"));
	}
}
