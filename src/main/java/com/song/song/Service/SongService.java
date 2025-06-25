package com.song.song.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.song.model.Song;
import com.song.song.repository.SongRepository;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public Optional<Song> getSongByTitle(String title) {
        return songRepository.findByTitleIgnoreCase(title);
    }

    public Optional<Song> getSongById(Long id) {
        return songRepository.findById(id);
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    public Song updateSong(Long id, Song updatedSong) {
        return songRepository.findById(id)
            .map(song -> {
                song.setTitle(updatedSong.getTitle());
                song.setArtist(updatedSong.getArtist());
                song.setLyrics(updatedSong.getLyrics());
                return songRepository.save(song);
            })
            .orElse(null);
    }

    public boolean deleteSong(Long id) {
        if (songRepository.existsById(id)) {
            songRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
