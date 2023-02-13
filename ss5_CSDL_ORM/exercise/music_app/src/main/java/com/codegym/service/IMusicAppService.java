package com.codegym.service;

import com.codegym.model.MusicApp;

import java.util.List;

public interface IMusicAppService {
    List<MusicApp> findAll();

    void save(MusicApp product);

    MusicApp findById(int id);

    void update(int id, MusicApp product);

    void remove(int id);
}
