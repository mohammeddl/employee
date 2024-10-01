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

    public void doPost(HttpServletRequest req , HttpServletResponse res ) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String post = req.getParameter("post");
        String phone = req.getParameter("phone");
        String position = req.getParameter("position");

        Employee employee = new Employee(name, email, post, phone, position);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.addEmployee(employee);


        req.setAttribute("message", "Employee added successfully");
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> employees = employeeDAO.getEmployees();
    
        // employees.stream().forEach(t-> System.out.println(t.getName()));
    
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }
    
    
    
}
