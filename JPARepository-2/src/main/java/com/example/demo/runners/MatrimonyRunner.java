package com.example.demo.runners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.demo.JpaRepository2Application;
import com.example.demo.entity.MarriageSeeker;
import com.example.demo.service.IMatrimonyManagementService;

@Component
public class MatrimonyRunner implements CommandLineRunner {

    private final JpaRepository2Application jpaRepository2Application;
	
	@Autowired
	private IMatrimonyManagementService service ;

    MatrimonyRunner(JpaRepository2Application jpaRepository2Application) {
        this.jpaRepository2Application = jpaRepository2Application;
    } 
	
	@Override
	public void run(String... args) throws Exception {
		
//		Scanner sc = new Scanner(System.in) ; 
//		System.out.print("Enter a name :: "); 
//		String name = sc.nextLine()  ;
//		
//		System.out.print("Enter Address :: ");
//		String addrss = sc.nextLine() ; 
//		
//		System.out.print("Enter DOB(yyyy-MM-ddThh:mm:ss) :: ");
//		String dob = sc.nextLine() ; 
//		
//		LocalDateTime ldob = LocalDateTime.parse(dob) ; 
//		
//		System.out.print("Is the Customer Indian? :: ");
//		boolean isIndian = sc.nextBoolean() ; 
//		sc.nextLine() ; 
//		
//		System.out.print("Enter photo file path :: ");
//		String photoPath = sc.nextLine() ; 
//		
//		System.out.print("Enter Resume file path :: ");
//		String resumePath = sc.nextLine() ; 
//		
//		
//		// Create Strean representing photofile , resumefile
//		FileInputStream fis = new FileInputStream(photoPath) ; 
//		byte[] photoContent = fis.readAllBytes() ; 
//		
//		File file = new File(resumePath) ; 
//		FileReader fr = new FileReader(resumePath) ; 
//		char[] resumeContent = new char[(int) file.length()] ; 
//		fr.read(resumeContent) ; 
//		
//		//create model class object
//		MarriageSeeker seeker = new MarriageSeeker(name , addrss , ldob , photoContent , resumeContent , isIndian) ; 
//		
//		try {
//			System.out.println(service.registerMarriageSeeker(seeker));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		MarriageSeeker seeker = service.getMarriageSeekerById(1L) ;
		System.out.println(seeker.getMid() + " " + seeker.getName() + "  " + seeker.getAddrss() + "  " + seeker.getDob());
		
		byte[] photoContent = seeker.getPhoto() ; 
		char[] resumeContent = seeker.getResume() ; 
		
		//Write the array to the destination file
		FileOutputStream fos = new FileOutputStream("saaample.jpg") ; 
		fos.write(photoContent); 
		fos.flush();
		fos.close();
		
		FileWriter writer = new FileWriter("sampleResume.txt") ; 
		writer.write(resumeContent);
		writer.flush() ; 
		writer.close() ;
	}
}
