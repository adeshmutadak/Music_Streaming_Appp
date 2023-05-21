package com.example.Music_Streaming_Appp.repo;

import com.example.Music_Streaming_Appp.model.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaylistRepo extends JpaRepository<PlayList,Long> {
}
