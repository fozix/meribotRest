package com.meritis.meribot.controllors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meritis.meribot.models.Entity;
import com.meritis.meribot.services.EntityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/entity")
@Api(value="entityController", description="operations to manages entities of meribot.")
public class EntityController {

	  private EntityService entityService;
	  
	    @Autowired
	    public void setEntityService(EntityService entityService) {
	        this.entityService = entityService;
	    }
	 
	   
	    @ApiOperation(value = "View a list of available products", response = Iterable.class)
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully retrieved list"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
	    @RequestMapping(value = "/list", method= RequestMethod.GET,produces = "application/json")
	    public Iterable list(Entity model){
	        Iterable entityList = entityService.listAllEntities();
	        return entityList;
	    }
	   
	    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET)
	    public Entity showEntity(@PathVariable String id, Entity model){
	    	Entity entity = entityService.getEntityById(id);
	        return entity;
	    }
	 
	 
	    @RequestMapping(value = "/add", method = RequestMethod.POST)
	    public ResponseEntity saveEntity(@RequestBody Entity entity){
	        entityService.saveEntity(entity);
	        return new ResponseEntity("Entity saved successfully", HttpStatus.OK);
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
	 
	 
	    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	    public ResponseEntity updateEntity(@PathVariable String id, @RequestBody Entity entity){
	        Entity storedEntity = entityService.getEntityById(id);
	        storedEntity.setName(entity.getName());
	        entityService.saveEntity(storedEntity);
	        return new ResponseEntity("Entity updated successfully", HttpStatus.OK);
	    }
	 
	  
	    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity delete(@PathVariable String id){
	        entityService.deleteEntity(id);
	        return new ResponseEntity("Entity deleted successfully", HttpStatus.OK);
	 
	    }
}
