package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Tourist;
import com.example.demo.error.TouristNotFoundException;
import com.example.demo.service.ITouristMgmtService;

@RestController
@RequestMapping("/tourist")
public class TouristOperationController {
	@Autowired
	private ITouristMgmtService service ; 
	
	@PostMapping("/register")
    public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {
        try {
            String resultMsg = service.registerTourist(tourist);
            
            return new ResponseEntity<>(resultMsg, HttpStatus.CREATED); 
            
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Problem in tourist enrollment: " + e.getMessage(), 
                                        HttpStatus.INTERNAL_SERVER_ERROR); 
        }
    }
	
	@GetMapping("/findAll")
	public ResponseEntity<?> displayToursits() {
		//? can return here anything
	    try {
	        List<Tourist> list = service.fetchAllTourist() ; 
	        return new ResponseEntity<>(list, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>("Problem in fetching Tourists", HttpStatus.INTERNAL_SERVER_ERROR); // 500
	    }
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getTouristById(@PathVariable Integer id) throws TouristNotFoundException {
			Tourist tourist = service.fetchTouristById(id) ; 
			return new ResponseEntity<>(tourist , HttpStatus.OK) ; 		
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateTourist(@RequestBody Tourist tourist){
		try {
			String msg = service.modifyTourist(tourist) ; 
			return new ResponseEntity<String>(msg , HttpStatus.OK) ; 
		} catch (Exception e) {
			return new ResponseEntity<String>("Problem in fetching Tourist", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PatchMapping("/pupdate/{id}/{percentage}")
    public ResponseEntity<?> modifyTouristBudgetDetailsById(@PathVariable("id") int id,
                                                          @PathVariable("percentage") double percentage) {
        try {
            String resultMsg = service.updateTouristBudgetById(id, percentage);
            return new ResponseEntity<>(resultMsg, HttpStatus.OK);
        } catch (TouristNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND); // 404
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // 500
        }
    }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTouristById(@PathVariable int id) {
		try {
			String msg = service.removeTouristById(id) ; 
			return new ResponseEntity<String>(msg , HttpStatus.OK) ; 
		} catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/remove/{type}")
	public ResponseEntity<String> deleteTouristById(@PathVariable String type) {
		try {
			String msg = service.removeTouristByPackageType(type) ; 
			return new ResponseEntity<String>(msg , HttpStatus.OK) ; 
		} catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
