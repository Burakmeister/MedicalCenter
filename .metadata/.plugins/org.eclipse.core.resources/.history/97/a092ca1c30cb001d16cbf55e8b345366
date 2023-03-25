package dao;

import java.util.List;

import org.hibernate.Session;

import mapped.Patient;

public class PatientDao extends Dao<Patient>{
	public PatientDao() {
		this.setmodelClass(Patient.class);
	}
	
	public List<Patient> getAllPatients(){
        Session session = this.getSession();
        session.beginTransaction();
        List<Patient> list = session.createQuery(
        		"SELECT patient"
        		+ "FROM mapped.Patient patient")
                .getResultList();
        session.getTransaction().commit();
        session.close();
        if (list != null) {
            return list;
        }
        return null;
	}
		
}
