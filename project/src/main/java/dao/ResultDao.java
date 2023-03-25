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
}