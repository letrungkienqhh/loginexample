package com.kienletrung.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.kienletrung.entity.UserRole;

public class RoleDao {
	@Autowired
	private EntityManager entityManager;

	public List<String> getRoleName(long userId) {
		String sql="select ur.appRole.roleName from "+UserRole.class.getName()+"ur "+"where ur.appUser.UserID="
				+ ":userId";
		TypedQuery<String> query= this.entityManager.createQuery(sql,String.class);
		query.setParameter("userId", userId);
		return query.getResultList();
				
	}

}
