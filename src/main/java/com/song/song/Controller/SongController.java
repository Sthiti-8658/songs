package com.song.song.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.song.song.Service.SongService;
import com.song.song.model.Song;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping("/lyrics")
    public String getLyricsByTitle(@RequestParam String title) {
        return songService.getSongByTitle(title)
                .map(Song::getLyrics)
                .orElse("Lyrics not found for the song: " + title);
    }

    @GetMapping("/id")
    public String getLyricsById(@RequestParam Long id) {
        return songService.getSongById(id)
                .map(Song::getLyrics)
                .orElse("Lyrics not found for the song with ID: " + id);
    }

    @GetMapping("/all")
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }
    //crud create, read, update, delete

    @PostMapping()
    public Song createSong(@RequestBody Song song) {
        return songService.createSong(song);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Song> updateSong(@PathVariable Long id, @RequestBody Song song) {
        Song updated = songService.updateSong(id, song);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable Long id) {
        if (songService.deleteSong(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
