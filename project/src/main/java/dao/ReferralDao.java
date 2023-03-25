package dao;

import java.util.List;

import org.hibernate.Session;

import mapped.Referral;

public class ReferralDao extends Dao<Referral>{
	public ReferralDao() {
		this.setmodelClass(Referral.class);
	}
}