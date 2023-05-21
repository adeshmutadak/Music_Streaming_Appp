package com.example.Music_Streaming_Appp.repo;

import com.example.Music_Streaming_Appp.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepo extends JpaRepository<Song, Long> {
}
