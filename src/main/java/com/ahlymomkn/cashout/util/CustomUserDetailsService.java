package com.ahlymomkn.cashout.util;

import com.ahlymomkn.cashout.model.entity.User;
import com.ahlymomkn.cashout.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.Collections;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String NationalIdOrMobileNumber) throws UsernameNotFoundException {
        User user = userRepository.findByNationalIdOrMobileNumber(NationalIdOrMobileNumber, NationalIdOrMobileNumber)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with national id or mobile number: " + NationalIdOrMobileNumber));

        return new org.springframework.security.core.userdetails.User(
                user.getNationalId(), user.getPassword(), Collections.emptyList());

    }
}
