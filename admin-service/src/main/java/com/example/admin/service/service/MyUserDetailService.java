package com.example.admin.service.service;

import com.example.admin.service.entity.RegisterUser;
import com.example.admin.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        Optional<User> user = userLoginRepository.findByUserName(userName);
//        user.orElseThrow(()->new UsernameNotFoundException("Not Found "+userName));
//        return user.map(MyUserDetails::new).get();
//        return new User("foo", "foo",
//                new ArrayList<>());

        /*RegisterUser foundUser=userRepository.findByUserEmail(userName);
        if(foundUser==null){
            return null;
        }
        List<GrantedAuthority> auth = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");
        if (userName.equals("admin")) {
            auth = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN");
        }
        String user=foundUser.getUserEmail();
        String pass=foundUser.getUserPassword();*/
        List<GrantedAuthority> auth = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_ADMIN");
        return new User("admin", "admin",auth);

    }
}
