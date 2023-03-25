package dao;

import java.util.List;

import org.hibernate.Session;

import mapped.Patient;
import mapped.Result;
import mapped.User;

public class UserDao extends Dao<User>{
	public UserDao() {
		this.setmodelClass(User.class);
	}
	
    public User getUser(String login, String password) {
        Session session = this.getSession();
        session.beginTransaction();
        User user = null;
        user = (User) session.createQuery(
                " select user "
                + "from mapped.User user "
                + "where user.login = :login and user.password =:password")
                .setParameter("login", login)
                .setParameter("password", password)
                .uniqueResult();

        session.getTransaction().commit();
        session.close();
        if (user != null) {
            return user;
        }
        return null;
    }
    
    public User getUserPatient(Patient patient) {
        Session session = this.getSession();
        session.beginTransaction();
        User user = null;
        user = (User) session.createQuery(
                " select user "
                + "from mapped.User user "
                + "where user.patient = :patient")
                .setParameter("patient", patient)
                .uniqueResult();

        session.getTransaction().commit();
        session.close();
        if (user != null) {
            return user;
        }
        return null;
    }
}