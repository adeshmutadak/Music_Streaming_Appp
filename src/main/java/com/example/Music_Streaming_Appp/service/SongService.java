package com.example.Music_Streaming_Appp.service;

import com.example.Music_Streaming_Appp.model.Song;
import com.example.Music_Streaming_Appp.repo.ISongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    ISongRepo iSongRepo;
    public Song createSong(Song song) {
        return iSongRepo.save(song);
    }

    public boolean updateSong(Long songId, Song updatedSong) {
        Song song=iSongRepo.findById(songId).get();
        if(song!=null){
            song.setTitle(updatedSong.getTitle());
            song.setArtist(updatedSong.getArtist());
            iSongRepo.save(updatedSong);
            return true;
        }
        return  false;
    }

    public boolean deleteSong(Long songId) {
        Song song=iSongRepo.findById(songId).get();
        if(song!=null){
            iSongRepo.deleteById(songId);
            return true;
        }
        return false;
    }

    public List<Song> getAllSongs() {
        return iSongRepo.findAll();
    }
}