package com.example.blog.service.impl;

import com.example.blog.model.AppUser;
import com.example.blog.model.UserRole;
import com.example.blog.repository.IAppUserRepository;
import com.example.blog.repository.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IAppUserRepository appUserRepository;
    @Autowired
    private IUserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       //Tìm đối tượng đang đăng nhập trong DB
        AppUser appUser = this.appUserRepository.findByUserName(userName);

        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }



        List<GrantedAuthority> grantList = new ArrayList<>();
        List<UserRole> userRoles = this.userRoleRepository.findByAppUser(appUser);
        if(userRoles!=null){
            for (UserRole userRole:
                 userRoles) {
                GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getAppRole().getRoleName());
                grantList.add(authority);
            }

        }
        UserDetails userDetails = new User(appUser.getUserName(),
                appUser.getEncrytedPassword(), grantList);

        return userDetails;
    }

}