package dao;

import java.util.List;

import org.hibernate.Session;

import mapped.Referral;
import mapped.Research;
import mapped.User;

public class ResearchDao extends Dao<Research>{
	public ResearchDao() {
		this.setmodelClass(Research.class);
	}
	
	public Research getResearchByTitle(String title) {
        Session session = this.getSession();
        session.beginTransaction();
        Research research = null;
        research = (Research) session.createQuery(
                " select res "
                + "from mapped.Research res "
                + "where res.title = :title")
                .setParameter("title", title)
                .uniqueResult();
        session.getTransaction().commit();
        session.close();
        if (research != null) {
            return research;
        }
        return null;
    }
}