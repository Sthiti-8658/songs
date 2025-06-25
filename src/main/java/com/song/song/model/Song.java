package com.song.song.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String artist;

    @Column(columnDefinition = "TEXT")
    private String lyrics;

    // Constructors
    public Song() {}

    public Song(String title, String artist, String lyrics) {
        this.title = title;
        this.artist = artist;
        this.lyrics = lyrics;
    }

    // Getters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getLyrics() { return lyrics; }

    // Setters (optional for JPA)
    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setArtist(String artist) { this.artist = artist; }
    public void setLyrics(String lyrics) { this.lyrics = lyrics; }
}
