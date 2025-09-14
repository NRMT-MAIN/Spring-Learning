package com.example.demo.runners;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.DrivingLicense;
import com.example.demo.entity.Person;
import com.example.demo.service.IOnetoOneAssociationMgmtService;

@Component
public class OnetoOneAssociationTestRunner implements CommandLineRunner {
	
	@Autowired
	private IOnetoOneAssociationMgmtService service ; 

	@Override
	public void run(String... args) throws Exception {
		try {
//			Person person = new Person("Raja" , "Hyd" , 40) ; 
//			DrivingLicense license = new DrivingLicense("LWM", LocalDate.now(), LocalDate.of(2024, 12, 14)) ; 
//			
//			license.setPersonDetails(person);
//			
//			String msg = service.saveDataUsingDrivingLicense(license) ; 
//			System.out.println(msg);
			
			service.showDataUsingPerson().forEach(per -> {
				System.out.println(per);
			});
			
			System.out.println("----------------------------------------");
			
			service.showDataUsingDrivingLicenses().forEach(l -> {
				System.out.println(l);
			});
			
		} catch (Exception e) {
			e.printStackTrace() ;
		}

	}

}
