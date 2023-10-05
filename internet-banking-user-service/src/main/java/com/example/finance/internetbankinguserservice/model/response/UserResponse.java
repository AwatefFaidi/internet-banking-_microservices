package com.example.finance.internetbankinguserservice.model.response;

import java.util.List;

public class UserResponse {
	 private String firstName;
	    private String lastName;
	    private List<AccountResponse> bankAccounts;
	    private String identificationNumber;
	    private Integer id;
	    private String email;
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public List<AccountResponse> getBankAccounts() {
			return bankAccounts;
		}
		public void setBankAccounts(List<AccountResponse> bankAccounts) {
			this.bankAccounts = bankAccounts;
		}
		public String getIdentificationNumber() {
			return identificationNumber;
		}
		public void setIdentificationNumber(String identificationNumber) {
			this.identificationNumber = identificationNumber;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
	    
	    
}
