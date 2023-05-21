package com.example.Music_Streaming_Appp.controller;

import com.example.Music_Streaming_Appp.dto.SignInInput;
import com.example.Music_Streaming_Appp.dto.SignInOutput;
import com.example.Music_Streaming_Appp.dto.SignUpOutput;
import com.example.Music_Streaming_Appp.model.Song;
import com.example.Music_Streaming_Appp.model.User;
import com.example.Music_Streaming_Appp.service.SongService;
import com.example.Music_Streaming_Appp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    SongService songService;
    @PostMapping("/signup")
    public SignUpOutput signUp(@Valid @RequestBody User signUpDto){
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signin")
    public SignInOutput signIn(@Valid @RequestBody SignInInput signInDto){
        return userService.signIn(signInDto);
    }
    @GetMapping("song")
    public ResponseEntity<List<Song>> getAllSong(){
        List<Song> songs = songService.getAllSongs();
        return ResponseEntity.ok(songs);
    }

}

