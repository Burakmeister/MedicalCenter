package dao;

import java.util.List;

import org.hibernate.Session;

import mapped.Referral;
import mapped.Research;
import mapped.Result;
import mapped.Test;

public class TestDao extends Dao<Test>{
	public TestDao() {
		this.setmodelClass(Test.class);
	}
}