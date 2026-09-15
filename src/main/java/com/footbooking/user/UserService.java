package com.footbooking.user;

import com.footbooking.common.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
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
}
