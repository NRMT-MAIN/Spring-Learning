package com.example.demo.runner;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entitty.Customer;
import com.example.demo.repository.ICustomerRepository;
import com.example.demo.service.ICustomerManagementService;
import com.example.demo.view.IDynamicResultView1;
import com.example.demo.view.IDynamicResultView2;
import com.example.demo.view.IDynamicResultView3;

//@Component
public class JpaRepoRunner implements CommandLineRunner {
	@Autowired
	private ICustomerManagementService custService ; 
	
	@Autowired
	private ICustomerRepository custRepo ; 
	
	@Override
	public void run(String... args) throws Exception {
//		try {
//			String message = custService.deleteCustomerByIds(List.of(1,2,3,4 , 786)) ; 
//			System.out.println(message);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			Customer cust = custService.getCustomerById(34) ; 
//			System.out.println(cust == null ? "Customer not found" : cust);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
		
//		try {
//			Customer cust = new Customer() ; 
//			cust.setCadd("Delhi") ; 
//			
//			List<Customer> list = custService.showCustomerByExampleData(cust, true, "billAmt" , "cname") ; 
//			list.forEach(System.out::println);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			Customer cust1 = new Customer("Ramesh" , "Hyderabad" , 6700.00f) ; 
//			Customer cust2 = new Customer("Ram" , "Hyderabad" , 6450.00f) ; 
//			Customer cust3 = new Customer("Sanjay" , "Mumbai" , 6700.00f) ; 
//			
//			
//			List<Customer> list = List.of(cust1 , cust2 , cust3) ; 
//			
//			System.out.println(custService.groupCustomerRegistration(list));
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
//		try {
//			//custRepo.findByCnameEquals("Ram").forEach(System.out::println); ; 
//			
//			//custRepo.findByCaddStartingWith("Hyd").forEach(System.out::println); ; 
//			
//			custRepo.findByBillAmtBetween(1000.00f, 1200.00f).forEach(System.out::println); 
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			custRepo.findByBillAmtGreaterThanEqualAndBillAmtLessThanEqual(1000.00f, 1200.00f).forEach(System.out::println); ; 
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
////			custRepo.findByCaddInIgnoreCaseOrCnameContainingIgnoreCase(List.of("hyderabad" , "delhi"), "Cust")
////			.forEach(System.out::println);
//			
//			custRepo.findByCaddInIgnoreCaseAndCnameContainingIgnoreCase(List.of("hyderabad" , "delhi"), "Cust")
//			.forEach(System.out::println);
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
//		try {
//			custRepo.findByBillAmtBetween(1000.00f, 1200.00f).forEach(view -> {
//				System.out.println(view.getCid() + " ---> " + view.getCname());
//			});
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			custRepo.findByCaddIn(List.of("Hyderabad" , "Delhi"), IDynamicResultView1.class).forEach(view1 -> {
//				System.out.println(view1.getCid() + " ---> " + view1.getCname());
//			});
//			
//			System.out.println("------------------------------------------------------");
//			
//			custRepo.findByCaddIn(List.of("Hyderabad" , "Delhi"), IDynamicResultView2.class).forEach(view2 -> {
//				System.out.println(view2.getCid() + " ---> " + view2.getCname() + " ----> " + view2.getBillAmt());
//			});
//			
//			System.out.println("--------------------------------------------------------");
//			
//			custRepo.findByCaddIn(List.of("Hyderabad" , "Delhi"), IDynamicResultView3.class).forEach(view3 -> {
//				System.out.println(view3.getCname() + " ---> " + view3.getCadd() + " ----> " + view3.getBillAmt());
//			});
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			System.out.println(custRepo.findByCid(45));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			//custRepo.getAllCustomer().forEach(System.out::println); ; 
//			
//			//custRepo.getCustomerByBillAmountRange(1000.00f , 1200.00f).forEach(System.out::println);
//			
////			List<Object[]> list = custRepo.getCustomerData("Customer_34", "Customer_35") ; 
////			list.forEach(row -> {
////				for(Object val : row) {
////					System.out.print(val + "  ") ; 
////				}
////				System.out.println();
////			});
//			
////			List<String> list = custRepo.findCustomerAddrsByNameChars("R%") ; 
////			
////			list.forEach(addrs -> {
////				System.out.println(addrs);
////			});
////			
////			System.out.println("--------------------------------");
////			custRepo.findCustomerAddrsByNameChars("R%").forEach(System.out::println);
//			
////			Customer cust = custRepo.findCustomerDataByAddrs("Hyderabad"); 
////			System.out.println(cust);
//		} catch (Exception e) {
//			e.printStackTrace();
//	
		
	}
}
