package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import model.Employee;

@WebServlet("/employee")
public class EmployeeController extends HttpServlet {

    private EmployeeDAO employeeDAO;

    public void init() throws ServletException {
        employeeDAO = new EmployeeDAO(); 
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list"; 

        switch (action) {
            case "list":
                listEmployees(req, res); 
                break;
            case "edit":
                showEditForm(req, res); 
                break;
            case "delete":
                deleteEmployee(req, res); 
                break;
            case "search":
                searchEmployee(req, res); 
                break;
            default:
                listEmployees(req, res); 
                break;
        }
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "create":
                createEmployee(req, res); 
                break;
            case "update":
                updateEmployee(req, res); 
                break;
            default:
                listEmployees(req, res); 
                break;
        }
    }


    private void createEmployee(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String post = req.getParameter("post");
        String phone = req.getParameter("phone");
        String position = req.getParameter("position");

        Employee newEmployee = new Employee(name, email, post, phone, position);
        employeeDAO.addEmployee(newEmployee);
        res.sendRedirect("employee?action=list");
    }

    private void updateEmployee(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String post = req.getParameter("post");
        String phone = req.getParameter("phone");
        String position = req.getParameter("position");

        Employee employee = new Employee(id,name, email, post, phone, position);
        employeeDAO.updateEmployee(employee);
        res.sendRedirect("employee?action=list");
    }


    private void listEmployees(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Employee> employees = employeeDAO.getEmployees();
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }
    
    private void deleteEmployee(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        employeeDAO.deleteEmployee(id);
        req.setAttribute("message", "Employee deleted successfully");
        res.sendRedirect("employee?action=list");
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Employee existingEmployee = employeeDAO.getEmployee(id);
        req.setAttribute("employee", existingEmployee);
        req.getRequestDispatcher("modifyEmployee.jsp").forward(req, res);
    }
    
    
    private void searchEmployee(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<Employee> employees = employeeDAO.searchEmployee(keyword);
        if(employees.isEmpty()) {
            req.setAttribute("message", "No result found");
        }else {
            req.setAttribute("message", "Search result");
        }
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }

}
