package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import service.EmployeeServiceImplt;

@WebServlet("/employee")
public class EmployeeController extends HttpServlet {

    private EmployeeServiceImplt employeeService;

    public void init() throws ServletException {
        employeeService = new EmployeeServiceImplt(); 
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
            case "filter":
                filterEmployee(req, res);
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
        employeeService.createEmployee(req);
        res.sendRedirect("employee?action=list&alertType=addSuccess");
    }

    private void updateEmployee(HttpServletRequest req, HttpServletResponse res) throws IOException {
        employeeService.updateEmployee(req);
        res.sendRedirect("employee?action=list&alertType=success&alertMessage=Employee updated successfully");
    }

    private void deleteEmployee(HttpServletRequest req, HttpServletResponse res) throws IOException {
        employeeService.deleteEmployee(req);
        res.sendRedirect("employee?action=list&alertType=success&alertMessage=Employee deleted successfully");
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Employee existingEmployee = employeeService.getEmployeeById(req);
        req.setAttribute("employee", existingEmployee);
        req.getRequestDispatcher("modifyEmployee.jsp").forward(req, res);
    }

    private void listEmployees(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Employee> employees = employeeService.listEmployees();
        String alertType = req.getParameter("alertType");
        String alertMessage = req.getParameter("alertMessage");
        if (alertType != null && alertMessage != null) {
            req.setAttribute("alertType", alertType);
            req.setAttribute("alertMessage", alertMessage);
        }
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }

    private void searchEmployee(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Employee> employees = employeeService.searchEmployee(req);
        if (employees.isEmpty()) {
            req.setAttribute("alertType", "error");
            req.setAttribute("alertMessage", "No employee found");
        }
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }

    private void filterEmployee(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Employee> employees = employeeService.filterEmployee(req);
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }
}
