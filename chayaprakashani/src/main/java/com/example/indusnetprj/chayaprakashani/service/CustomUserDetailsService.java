package com.example.indusnetprj.chayaprakashani.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.indusnetprj.chayaprakashani.dao.StudentDAO;
import com.example.indusnetprj.chayaprakashani.entity.StudentDetails;
import com.example.indusnetprj.chayaprakashani.model.CustomUserDetails;



@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
    private StudentDAO usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Optional<StudentDetails> optionalUsers = usersRepository.findByuserId(userId);

        optionalUsers
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUsers
                .map(CustomUserDetails::new).get(); 
	}

}
