package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Tourist;
import com.example.demo.error.TouristNotFoundException;
import com.example.demo.repositories.ITouristRepo;

@Service("touristMgmtService")
public class TouristServiceMgmtImpl implements ITouristMgmtService {
	
	@Autowired
	private ITouristRepo touristRepo ; 
	
	@Override
	public String registerTourist(Tourist tourist) {
		
		int idVal = touristRepo.save(tourist).getTid() ; 
		
		 return "Tourist is registered having the ID value :: " + idVal;
	}
	
	@Override
	public List<Tourist> fetchAllTourist() {
		List<Tourist> list = touristRepo.findAll() ; 
		
		list.sort((t1 , t2) -> {
			return t1.getTid().compareTo(t2.getTid()) ; 
		});
		
		return list ; 
	}
	
	@Override
	public Tourist fetchTouristById(Integer tid) throws TouristNotFoundException {
		Optional<Tourist> opt = touristRepo.findById(tid) ; 
		
		if(!opt.isPresent()) throw new TouristNotFoundException("Tourist not present with id :: " + tid) ; 
		return opt.get();
	}
	
	@Override
	public String modifyTourist(Tourist tourist) {
		Optional<Tourist> opt = touristRepo.findById(tourist.getTid()) ;
		
		if(opt.isPresent()) {
			touristRepo.save(tourist) ; 
			return tourist.getTid() + " Tourist is updated" ; 
		}
		return tourist.getTid() + " Tourist is not found for updation." ; 
	}
	
	@Override
    public String updateTouristBudgetById(int tid, double hikePercentage) throws TouristNotFoundException {
        Optional<Tourist> opt = touristRepo.findById(tid);
        if (opt.isPresent()) {
            Tourist tourist = opt.get();
            double budget = tourist.getBudget();
            double newBudget = budget + (budget * hikePercentage / 100.0);
            
            tourist.setBudget(newBudget); 
            touristRepo.save(tourist); 
            
            return "Tourist budget is hiked. New budget: " + newBudget;
        } else {
            throw new TouristNotFoundException(tid + " tourist not found for updation");
        }
    }
	
	@Override
	public String removeTouristById(int id) throws TouristNotFoundException {
		Optional<Tourist> opt = touristRepo.findById(id) ; 
		
		if(opt.isPresent()) {
			touristRepo.deleteById(id);
			
			return id + "Tourist is find and deleted." ; 
		} else {
			throw new TouristNotFoundException(id + " tourist not found for deletion");
		}
	}
	
	@Override
	public String removeTouristByPackageType(String type) {
		int count = touristRepo.deleteTouristByPackageType(type) ; 
		return count + "no. of tourist are deleted.";
	}
}
