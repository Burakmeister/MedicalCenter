package dao;

import java.util.List;

import org.hibernate.Session;

import mapped.Patient;
import mapped.Research;

public class PatientDao extends Dao<Patient>{
	public PatientDao() {
		this.setmodelClass(Patient.class);
	}
		
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Patient> getPatientsByResearchTitle(String title){
        Session session = this.getSession();
        session.beginTransaction();
        List<Patient> patients = null;
        patients = session.createQuery(
                " select patients "
                + "from mapped.Patient patients, mapped.Agreement agree, mapped.Research res "
                + "where res = agree.research "
                + "AND patients = agree.patient "
                + "AND res.title = :title")
                .setParameter("title", title)
                .getResultList();
        session.getTransaction().commit();
        session.close();
        if (patients != null) {
            return patients;
        }
        return null;
	}
}
