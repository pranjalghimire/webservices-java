package com.example.demo.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.object.Account;
import com.example.demo.object.BankCustomer;
import com.example.demo.object.CheckingAccount;

@RestController
public class UserController {
	
	@GetMapping("/getnumberbalance")
	public String getnumberbalance(@RequestHeader String number,@RequestHeader float balance) {
		return "Your number is" +" "+ number+ " "+ "Your balance is" +" "+ balance;
	}
	
	@PostMapping("/createnumber")
	public Account createnumber(@RequestHeader String number,@RequestHeader float balance) { 
		return new Account(number,balance);
	}
	
	                 
	
	//      Two functionalities used below printmonthlystatement() and getcustomerinfo()

	
	
	
	/*Posting data from header to api    DO this post request first then the bottom post request next(localhost:8080/createcheckingaccount/)
	@PostMapping("/createcheckingaccount")
	public Account createcheckingaccount(@RequestHeader float limit,@RequestHeader float servicefee,@RequestHeader String number,@RequestHeader float balance) { 
		return new CheckingAccount(number,balance,limit,servicefee);
	}
	*/
	
	//Posting api in json format in server   (localhost:8080/createcheckingaccount/)
	@PostMapping("/createcheckingaccount")
	public void createcheckingaccount(@RequestBody CheckingAccount checkingaccount) { 
		checkingaccount.printMonthlyStatement();
	
	}
	
	//getting data from local server    (localhost:8080/getcheckingaccount/)
	@GetMapping("/getcheckingaccount")
	public String getcheckingaccount(@RequestHeader float limit,@RequestHeader float servicefee) {
		return "Your limit is" +" "+ limit+ " "+ "Your servicefee is" +" "+ servicefee;
	}
    
    //updatedcheckingaccount in json format  (localhost:8080/updatecheckingaccount/)
	@PutMapping("/updatecheckingaccount")
	public void updatecheckingaccount(@RequestBody CheckingAccount checkingaccount) {
		 checkingaccount.printMonthlyStatement();
	}
	
	//deleted data in checkingaccount in json   (localhost:8080/deletecheckingaccount/)
	@DeleteMapping("/deletecheckingaccount")
	public void deletecheckingaccount(@RequestBody CheckingAccount checkingaccount) {
		checkingaccount.printMonthlyStatement();
	}
   

	
	
	
	
	
	
	
	/*Posting data from header to api    DO this post request first then the bottom post request next(localhost:8080/createcustomerinfo/)
	@PostMapping("/createcustomerinfo")
	public BankCustomer createcustomerinfo(@RequestHeader String id,@RequestHeader String firstname,@RequestHeader String lastname,@RequestHeader String username,@RequestHeader String password,@RequestHeader String address) { 
		return new BankCustomer(id,firstname,lastname,username,password,address);
	}
    */
	
	//Posting api in json format in server   (localhost:8080/createcustomerinfo/)
	@PostMapping("/createcustomerinfo")
	public void createcreatecustomerinfo(@RequestBody BankCustomer bankcustomer) { 
		bankcustomer.customerInfo();
	
	}
	
	
	//getting data from local server    (localhost:8080/getcustomerinfo/)
	@GetMapping("/getcustomerinfo")
	public String getcustomerinfo(@RequestHeader String id,@RequestHeader String firstname,@RequestHeader String lastname,@RequestHeader String address) {
		return "Your lastname,firstname,id,and address are in order as follows" +id+firstname+lastname+address;
	}
    
    //updatedBankcustomer in json format  (localhost:8080/updatecustomerinfo/)
	@PutMapping("/updatecustomerinfo")
	public void updatecustomerinfo(@RequestBody BankCustomer bankcustomer) {
		bankcustomer.customerInfo();
	}
	
	//deleted data in Bankaccount in json   (localhost:8080/deletecustomerinfo/)
	@DeleteMapping("/deletecustomerinfo")
	public void deletecustomerinfo(@RequestBody BankCustomer bankcustomer) {
		bankcustomer.customerInfo();
	}
}
