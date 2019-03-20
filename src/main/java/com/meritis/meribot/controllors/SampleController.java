package com.meritis.meribot.controllors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mock")
public class SampleController {
	
	@RequestMapping("/hello")
	public String helloWorld() {
		return "Hello World";		
	}
	
    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public ResponseEntity sendMessage(@RequestBody String message){
    	String feedback= "bonjour";
    	if(!StringUtils.isEmpty(message)) {
    		if(message.toLowerCase().contains("bonjour")) {
    			feedback ="salut, que puis-je faire pour toi?";
    		}
    		if(message.toLowerCase().contains("congé") || message.toLowerCase().contains("absence")) {
    			feedback ="ok, je m'occupe de ça.";
    		}
    		if(message.toLowerCase().contains("merci") || message.toLowerCase().contains("ciao")) {
    			feedback ="à ton service, au revoir.";
    		}
    	}
        return new ResponseEntity(feedback, HttpStatus.OK);
    }
}
