package com.pooldead.controllers;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pooldead.domain.Poll;
import com.pooldead.repository.PollRepository;

//The @RestController is a convenient yet meaningful annotation and has the same effect as adding both @Controller and @ResponseBody annotations. 
@RestController
public class PollController {
	
	//we use the @Inject annotation to inject an instance of PollRepository into our controller.
	@Inject
	private PollRepository pollRepository;
	
	// The @RequestMapping annotation declares the URI and the allowed HTTP method
	@RequestMapping(value="/polls", method=RequestMethod.GET)
	//The getAllPolls method used ResponseEntity as its return type, indicating that the return value is the complete HTTP response.
	public ResponseEntity<Iterable<Poll>> getAllPolls() {
			//ResponseEntity gives you full control over the HTTP response, including the response body and response headers. The method implementation begins with reading all of the polls using the PollRepository. We then create an instance of ResponseEntity and pass in Poll data and the HttpStatus.OK status value. The Poll data becomes part of the response body and OK (code 200) becomes the response status code.
	        Iterable<Poll> allPolls = pollRepository.findAll();
	        return new ResponseEntity<>(allPolls, HttpStatus.OK);
	}

	
	//The createPoll method takes a parameter of the type Poll. The @RequestBody annotation tells Spring that the entire request body needs to be converted to an instance of Poll.
	@RequestMapping(value="/polls", method=RequestMethod.POST)
	public ResponseEntity<?> createPoll(@RequestBody Poll poll) {
		//Inside the method, we simply delegate the Poll persistence to PollRepository’s save method. We then create a new ResponseEntity with status CREATED (201) and return it.
		poll = pollRepository.save(poll);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
	}
}
