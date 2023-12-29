package com.example.demo_kr.service;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.example.demo_kr.repository.RepositoryProfile;

@Primary
@Service
public class ServiceSettings implements ServiceProfile {

    private final RepositoryProfile Repositoryprofile;

    public ServiceSettings(RepositoryProfile Repositoryprofile) {
        this.Repositoryprofile = Repositoryprofile;
    }
    @Override
    public void createProfile(String email, String password) {
        Repositoryprofile.insertProfile(email, password);
    }
}
