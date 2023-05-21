package com.example.Music_Streaming_Appp.repo;


import com.example.Music_Streaming_Appp.model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITokenRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findFirstByToken(String token);

}
