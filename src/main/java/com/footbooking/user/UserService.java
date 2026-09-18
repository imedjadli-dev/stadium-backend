package com.footbooking.user;

import com.footbooking.common.exception.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository , PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getById(Long id){
        return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(
                "User not found with id" +id));
    }

    public User getByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("User not found with email" + email));
    }

   public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
   }

   public boolean existsByPhone(String phone){
        return userRepository.existsByPhone(phone);
   }


   @Transactional
   public User createUser(String email , String phone , String fullname , String rawPassword){
        if(userRepository.existsByEmail(email)){
            throw new IllegalStateException("Email already registered" + email);
        }

        User user = new User();
        user.setEmail(email);
        user.setFullname(fullname);
        user.setPasswordHash(passwordEncoder.encode(rawPassword));
        user.setRole(Role.USER);
        user.setPhone(phone);
        user.setVerified(false);
        return userRepository.save(user);
   }
}
