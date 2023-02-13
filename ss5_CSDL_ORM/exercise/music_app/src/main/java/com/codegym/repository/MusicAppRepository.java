package com.codegym.repository;

import com.codegym.model.MusicApp;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MusicAppRepository implements IMusicAppRepository{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<MusicApp> findAll() {
        List<MusicApp> musicAppList = new ArrayList<>();
        TypedQuery<MusicApp> query = entityManager.createQuery("from MusicApp", MusicApp.class);
        musicAppList = query.getResultList();
        return musicAppList;
    }

    @Override
    public void save(MusicApp product) {

    }

    @Override
    public MusicApp findById(int id) {
        return null;
    }

    @Override
    public void update(int id, MusicApp product) {

    }

    @Override
    public void remove(int id) {

    }
}
