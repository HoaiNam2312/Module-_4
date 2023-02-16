package com.codegym.test_spring_boots.repository;



import com.codegym.test_spring_boots.model.MusicApp;

import java.util.List;

public interface IMusicAppRepository {
    List<MusicApp> findAll();

    void save(MusicApp product);

    MusicApp findById(int id);

    void update(int id, MusicApp product);

    void remove(int id);
}
