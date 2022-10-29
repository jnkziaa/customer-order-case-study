package com.jnkziaa.customerordercasestudy.service;


import com.jnkziaa.customerordercasestudy.entity.UsersInfo;
import com.jnkziaa.customerordercasestudy.repository.UsersInfoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UsersInfoRepository usersInfoRepository;

    public UserDetailsServiceImpl(UsersInfoRepository usersInfoRepository) {
        this.usersInfoRepository = usersInfoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersInfo user = usersInfoRepository.findUsersInfoByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found with username" + username));
        return UserDetailsImpl.build(user);
    }
}
