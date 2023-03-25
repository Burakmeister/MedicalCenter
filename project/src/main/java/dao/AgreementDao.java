package dao;

import java.util.List;

import org.hibernate.Session;

import mapped.Agreement;
import mapped.Patient;
import mapped.Research;

public class AgreementDao extends Dao<Agreement>{
	public AgreementDao() {
		this.setmodelClass(Agreement.class);
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Agreement> getPatientsAgreement(Patient patient){
        Session session = this.getSession();
        session.beginTransaction();
        List<Agreement> list = session.createQuery(
        		"SELECT agreement "
        		+ "FROM mapped.Agreement agreement "
        		+ "WHERE agreement.patient = :patient")
        		.setParameter("patient", patient)
                .getResultList();
        
        session.getTransaction().commit();
        session.close();
        if (list != null) {
            return list;
        }
        return null;
	}
	
	public List<Agreement> getResearchsAgreements(Research research){
        Session session = this.getSession();
        session.beginTransaction();
        @SuppressWarnings({ "deprecation", "unchecked" })
		List<Agreement> list = session.createQuery(
        		"SELECT agreement "
        		+ "FROM mapped.Agreement agreement "
        		+ "WHERE agreement.research = :research")
        		.setParameter("research", research)
                .getResultList();
        
        session.getTransaction().commit();
        session.close();
        if (list != null) {
            return list;
        }
        return null;
	}
}
