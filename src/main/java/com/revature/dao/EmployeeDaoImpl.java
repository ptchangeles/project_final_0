package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;

import com.revature.models.Employee;
import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void createEmployeeRecord(Employee employee) {
		try {
			
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement("INSERT into employees values (?, ?, ?)");
			st.setInt(1, employee.getEmployeeId());
			st.setInt(2, employee.getEmployeeId());
			st.setInt(3, employee.getRole());
			
			st.execute();
			LoggingUtil.getLogger().info("Successful Attempt.");
	} catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unsuccessful Attempt.");
	} 
		
	}

	@Override
	public Employee viewEmployeeRecordById(int employeeId) {
		Employee getById = null;
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement("SELECT * from employees WHERE employee_id = ?");
			st.setInt(1, employeeId);
			ResultSet rs = st.executeQuery();
			
			int n_employeeId;
			int n_userId;
			int n_role;
			
			
			if ((rs.next())){
				n_employeeId = rs.getInt("employee_id");
				n_userId = rs.getInt("user_id");	
				n_role = rs.getInt("role");	
					
					getById = new Employee(n_employeeId, n_userId, n_role);
			LoggingUtil.getLogger().trace("Successful attempt");
			} else {
			LoggingUtil.getLogger().warn("Unsuccessful attempt to retrieve data");	
			}
			}catch (SQLException e){
			LoggingUtil.getLogger().warn("Unable to retrieve data.",e);
		} return getById;
	}

	@Override
	public Employee viewEmployeeRecordByRole(int role) {
		Employee getByRole = null;
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement("SELECT * from employees WHERE role = ?");
			st.setInt(3, role);
			ResultSet rs = st.executeQuery();
			
			int n_employeeId;
			int n_userId;
			int n_role;
			
			
			if ((rs.next())){
				n_employeeId = rs.getInt("employee_id");
				n_userId = rs.getInt("user_id");	
				n_role = rs.getInt("role");	
					
				getByRole = new Employee(n_employeeId, n_userId, n_role);
			LoggingUtil.getLogger().trace("Successful attempt");
			} else {
			LoggingUtil.getLogger().warn("Unsuccessful attempt to retrieve data");	
			}
			}catch (SQLException e){
			LoggingUtil.getLogger().warn("Unable to retrieve data.",e);
		} return getByRole;
	}

	@Override
	public Set<Employee> viewAllEmployees() {
		Set<Employee> getAll = new TreeSet<Employee>();
		
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement("SELECT * from employees");
			ResultSet rs = st.executeQuery();
			
			Employee tempEmp;
			int n_employeeId;
			int n_userId;
			int n_role;
			
			while (rs.next()) {
				n_employeeId = rs.getInt("employee_id");
				n_userId = rs.getInt("user_id");	
				n_role = rs.getInt("role");
				
				
				tempEmp = new Employee(n_employeeId, n_userId, n_role);
				getAll.add(tempEmp);
			}
		} catch (SQLException e) {
			LoggingUtil.getLogger().warn("Unable to display database data", e);
		} LoggingUtil.getLogger().trace(getAll.size() + " currently listed data");
		
	return getAll;
	}

	@Override
	public void updateEmployeeRecord(Employee employee) {
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement("UPDATE employee SET role = ?, WHERE employee_id = ? OR user_id = ?");
			st.setInt(1, employee.getEmployeeId());
			st.setInt(2, employee.getUserId());
			st.setInt(3, employee.getRole());
			st.execute();
		LoggingUtil.getLogger().trace("Successful update of employee data (role).");
		} catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unable to update employee data (role).", e);
		}
		
	}

	@Override
	public void deleteEmployeeRecordbyId(int employeeId) {
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement("DELETE FROM employees WHERE employee_id = ?");
			st.setInt(1, employeeId);
			st.execute();
		LoggingUtil.getLogger().trace("Successful deletion of employee record.");
		} catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unable to delete employee record.", e);
		}
	}

	@Override
	public void assignRole(int role) {
		try {
			Connection c = ConnectionFactory.getConnection();
			PreparedStatement st = c.prepareStatement("UPDATE employees SET role = ? WHERE employee_id = ?");
			st.setInt(1, role);
			st.execute();
			
		LoggingUtil.getLogger().trace("Successful assignment of role for employee.");
		}
	     catch (SQLException e) {
		LoggingUtil.getLogger().warn("Unable to assign employee role.", e);
		}
	}

}
