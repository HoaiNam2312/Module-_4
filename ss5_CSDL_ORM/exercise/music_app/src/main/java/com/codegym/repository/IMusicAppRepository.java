package com.codegym.repository;

import com.codegym.model.MusicApp;

import java.util.List;

public interface IMusicAppRepository {
    List<MusicApp> findAll();

    void save(MusicApp product);

    MusicApp findById(int id);

    void update(int id, MusicApp product);

    void remove(int id);
}
