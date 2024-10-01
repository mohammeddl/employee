package dao;

import org.hibernate.Transaction;
import org.hibernate.Session;
import config.HibernateUtil;
import model.Employee;

public class EmployeeDAO {
    

    public void addEmployee(Employee employee){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Start a transaction
            transaction = session.beginTransaction();
            // Save the employee object
            session.save(employee);
            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
