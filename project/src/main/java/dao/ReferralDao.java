package dao;

import java.util.List;

import org.hibernate.Session;

import mapped.Referral;

public class ReferralDao extends Dao<Referral>{
	public ReferralDao() {
		this.setmodelClass(Referral.class);
	}
	
	public List<Referral> getAllReferrals(){
        Session session = this.getSession();
        session.beginTransaction();
        List<Referral> list = session.createQuery(
        		"SELECT referral"
        		+ "FROM mapped.Referral referral")
                .getResultList();
        session.getTransaction().commit();
        session.close();
        if (list != null) {
            return list;
        }
        return null;
	}
}