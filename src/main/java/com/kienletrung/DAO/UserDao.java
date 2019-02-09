package com.kienletrung.DAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kienletrung.entity.AppUser;

@Repository
@Transactional
public class UserDao {
	@Autowired
	private EntityManager entityManager;

	public AppUser findUserAccount(String username) {
		try {
			String sql = "select au from " + AppUser.class.getName() + " au where au.user_name=:username";
			TypedQuery<AppUser> query = this.entityManager.createQuery(sql, AppUser.class);
			query.setParameter("username", username);
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}
}
