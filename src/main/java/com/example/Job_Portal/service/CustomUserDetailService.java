//package com.example.Job_Portal.service;
//
//import com.example.Job_Portal.entity.CustomUserDetail;
//import com.example.Job_Portal.entity.User;
//import com.example.Job_Portal.repository.UserRepo;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class CustomUserDetailService implements UserDetailsService {
//
//    private final UserRepo userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findUserByEmail(email);
//        user.orElseThrow(() -> new UsernameNotFoundException("User not found"));
//        return user.map(CustomUserDetail::new).get();
//    }
//}
