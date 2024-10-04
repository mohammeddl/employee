package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.EmployeeDAO;
import model.Employee;

public class EmployeeServiceImplt implements EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeServiceImplt() {
        employeeDAO = new EmployeeDAO();
    }

    @Override
    public void createEmployee(HttpServletRequest req) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String post = req.getParameter("post");
        String phone = req.getParameter("phone");
        String position = req.getParameter("position");

        Employee newEmployee = new Employee(name, email, post, phone, position);
        employeeDAO.addEmployee(newEmployee);
    }

    @Override
    public List<Employee> listEmployees() {
        return employeeDAO.getEmployees();
    }

    @Override
    public void updateEmployee(HttpServletRequest req) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String post = req.getParameter("post");
        String phone = req.getParameter("phone");
        String position = req.getParameter("position");

        Employee employee = new Employee(id, name, email, post, phone, position);
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(HttpServletRequest req) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        employeeDAO.deleteEmployee(id);
    }

    @Override
    public Employee getEmployeeById(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("id"));
        return employeeDAO.getEmployee(id);
    }

    @Override
    public List<Employee> searchEmployee(HttpServletRequest req) {
        String keyword = req.getParameter("keyword");
        return employeeDAO.searchEmployee(keyword);
    }

    @Override
    public List<Employee> filterEmployee(HttpServletRequest req) {
        String position = req.getParameter("position");
        String post = req.getParameter("post");
        if (position != null) {
            return employeeDAO.filterEmployeeByPosition(position);
        } else if (post != null) {
            return employeeDAO.filterEmployeeByPost(post);
        }
        return null;
    }
}
