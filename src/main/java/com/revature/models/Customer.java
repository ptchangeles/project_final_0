package com.revature.models;

import java.util.Objects;

public class Customer {

		protected int userId;
		protected int accountId;
		protected String fname;
		protected String lname;
		protected String address;
		
		
		public Customer(int userId, String fname, String lname, String address) {
			super();
			this.userId = userId;
			this.fname = fname;
			this.lname = lname;
			this.address = address;
		}


		public int getUserId() {
			return userId;
		}


		public void setUserId(int userId) {
			this.userId = userId;
		}


		public int getAccountId() {
			return accountId;
		}


		public void setAccountId(int accountId) {
			this.accountId = accountId;
		}


		public String getFname() {
			return fname;
		}


		public void setFname(String fname) {
			this.fname = fname;
		}


		public String getLname() {
			return lname;
		}


		public void setLname(String lname) {
			this.lname = lname;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		@Override
		public int hashCode() {
			return Objects.hash(accountId, address, fname, lname, userId);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Customer other = (Customer) obj;
			return accountId == other.accountId && Objects.equals(address, other.address)
					&& Objects.equals(fname, other.fname) && Objects.equals(lname, other.lname)
					&& userId == other.userId;
		}


		@Override
		public String toString() {
			return "Customer [userId=" + userId + ", accountId=" + accountId + ", fname=" + fname + ", lname=" + lname
					+ ", address=" + address + "]";
		}
		
		
		

	
}
