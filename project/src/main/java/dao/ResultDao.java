package dao;

import java.util.List;

import org.hibernate.Session;

import mapped.Referral;
import mapped.Research;
import mapped.Result;

public class ResultDao extends Dao<Result>{
	public ResultDao() {
		this.setmodelClass(Result.class);
	}
	
	public List<Result> getAllResults(){
        Session session = this.getSession();
        session.beginTransaction();
        List<Result> list = session.createQuery(
        		"SELECT result"
        		+ "FROM mapped.Result result")
                .getResultList();
        session.getTransaction().commit();
        session.close();
        if (list != null) {
            return list;
        }
        return null;
	}
}