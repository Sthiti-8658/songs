package com.song.song.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.song.song.model.Song;

public interface SongRepository extends JpaRepository<Song, Long> {
    Optional<Song> findByTitleIgnoreCase(String title);
}
