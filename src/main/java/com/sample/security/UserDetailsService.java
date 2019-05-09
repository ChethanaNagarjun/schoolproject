package com.sample.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.sample.dao.UserDao;
import com.sample.model.Authority;
import com.sample.model.User;


@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) {

        log.debug("Authenticating {}", login);
        String lowercaseLogin = login.toLowerCase();

        User userFromDatabase = null;
        if(lowercaseLogin.contains("@")) {
            try {
				userFromDatabase = userDao.getByEmail(lowercaseLogin);
			} catch (Throwable e) {
				e.printStackTrace();
			}
        } else {
            try {
				userFromDatabase = userDao.getByUserName(lowercaseLogin);
			} catch (Throwable e) {
				e.printStackTrace();
			}
        }

        if (userFromDatabase == null) {
            throw new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database");
        } else if (!userFromDatabase.getActivated()) {
            throw new UserNotActivatedException("User " + lowercaseLogin + " is not activated");
        }

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<Authority> authorityList = userFromDatabase.getAuthorities();
        for (Authority authority : authorityList) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
            grantedAuthorities.add(grantedAuthority);
        }
        System.out.println(grantedAuthorities);
        return new org.springframework.security.core.userdetails.User(userFromDatabase.getUserName(), userFromDatabase.getPassword(), grantedAuthorities);

    }

}
