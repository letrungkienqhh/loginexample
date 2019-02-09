package com.kienletrung.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kienletrung.DAO.RoleDao;
import com.kienletrung.DAO.UserDao;
import com.kienletrung.entity.AppUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser = this.userDao.findUserAccount(username);
		if (appUser == null) {
			System.out.println("System not found: " + username);
			throw new UsernameNotFoundException(username + " not found in database");
		}
		System.out.println("FoundUser: " + username);
		List<String> listRole = this.roleDao.getRoleName(appUser.getId());
		List<GrantedAuthority> grantedAuthority = new ArrayList<GrantedAuthority>();
		if (!(listRole == null)) {
			for (String role : listRole) {
				SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role);
				grantedAuthority.add(simpleGrantedAuthority);
			}
		}
		UserDetails userDetails = new User(appUser.getUserName(), appUser.getEncryptedPassWord(), grantedAuthority);
		return userDetails;

	}

}
