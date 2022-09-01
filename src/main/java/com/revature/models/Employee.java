package com.revature.models;

import java.util.Objects;

public class Employee {

		protected int employeeId;
		protected int userId;
		protected int role;
		
		public Employee(int employeeId, int userId, int role) {
			super();
			this.employeeId = employeeId;
			this.userId = userId;
			this.role = role;
		}

		public int getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public int getRole() {
			return role;
		}

		public void setRole(int role) {
			this.role = role;
		}

		@Override
		public int hashCode() {
			return Objects.hash(employeeId, role, userId);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			return employeeId == other.employeeId && role == other.role && userId == other.userId;
		}

		@Override
		public String toString() {
			return "Employee [employeeId=" + employeeId + ", userId=" + userId + ", role=" + role + "]";
		}
		
		
		
}
