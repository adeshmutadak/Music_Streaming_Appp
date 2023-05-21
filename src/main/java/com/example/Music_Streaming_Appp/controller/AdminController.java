package com.example.Music_Streaming_Appp.controller;

import com.example.Music_Streaming_Appp.model.Song;
import com.example.Music_Streaming_Appp.service.AdminService;
import com.example.Music_Streaming_Appp.service.SongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    SongService songService;
    @PostMapping
    public ResponseEntity<Song> createSong(@RequestBody @Valid Song song) {
        Song createdSong = songService.createSong(song);
        return ResponseEntity.ok(createdSong);
    }
    @PutMapping("/songs/{songId}")
    public ResponseEntity<String> updateSong(@PathVariable Long songId, @RequestBody @Valid Song updatedSong) {
        boolean update = songService.updateSong(songId, updatedSong);
        if (update) {
            return new ResponseEntity<>(updatedSong.toString(), HttpStatus.OK);
        }
        return new ResponseEntity<>("The entered Id is not song's Id", HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/songs/{songId}")
    public ResponseEntity<String> deleteSong(@PathVariable Long songId) {
        boolean deleted = songService.deleteSong(songId);
        if (deleted) {
            return new ResponseEntity<>(songId.toString(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("The entered Id is not song's Id", HttpStatus.NOT_FOUND);

    }
}