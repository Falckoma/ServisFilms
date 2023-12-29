package com.example.demo_kr.service;

import com.example.demo_kr.model.Profile;
import com.example.demo_kr.repository.RepositoryAuthent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements ServisAuth {

    private final RepositoryAuthent repositoryAuthent;

    @Autowired
    public AuthenticationService(RepositoryAuthent repositoryAuthent) {
        this.repositoryAuthent = repositoryAuthent;
    }

    public boolean authenticate(String email, String password) {

        Profile profile = repositoryAuthent.findByEmail(email);
        return profile.email() != null && profile.getPassword().equals(password);
    }
/*    public static boolean authenticate(String email, String password) {
        return "falckoma@gmail.com".equals(email) && "111".equals(password);
    }*/
}
