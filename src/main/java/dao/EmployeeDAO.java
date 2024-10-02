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

    public void deleteEmployee(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                session.delete(employee);
                System.out.println("Employee deleted successfully");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    

    public Employee getEmployee(int id) {
        Employee employee = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            employee = session.get(Employee.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    public void updateEmployee(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
            System.out.println("Employee updated successfully");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    
    public List<Employee> searchEmployee(String keyword) {
        List<Employee> employees = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            employees = session.createQuery("from Employee e where e.name like :keyword or e.email like :keyword or e.post like :keyword or e.phone like :keyword or e.position like :keyword", Employee.class)
                    .setParameter("keyword", "%" + keyword + "%")
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }


    public List<Employee> filterEmployeeByPosition(String position) {
        List<Employee> employees = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            employees = session.createQuery("from Employee e where e.position = :position", Employee.class)
                    .setParameter("position", position)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    public List<Employee> filterEmployeeByPost(String post) {
        List<Employee> employees = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            employees = session.createQuery("from Employee e where e.post = :post", Employee.class)
                    .setParameter("post", post)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }
    
    

}

