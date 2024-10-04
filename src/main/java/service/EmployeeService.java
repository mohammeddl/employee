package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Employee;

public interface EmployeeService {

    void createEmployee(HttpServletRequest req) throws IOException;

    List<Employee> listEmployees();

    void updateEmployee(HttpServletRequest req) throws IOException;

    void deleteEmployee(HttpServletRequest req) throws IOException;

    Employee getEmployeeById(HttpServletRequest req);

    List<Employee> searchEmployee(HttpServletRequest req);

    List<Employee> filterEmployee(HttpServletRequest req);
    
} 
