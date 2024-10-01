package dao;

import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import config.HibernateUtil;
import model.Employee;

public class EmployeeDAO {
    

    public void addEmployee(Employee employee){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>(); 
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            employees = session.createQuery("from Employee", Employee.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees; 
    }
    
}

