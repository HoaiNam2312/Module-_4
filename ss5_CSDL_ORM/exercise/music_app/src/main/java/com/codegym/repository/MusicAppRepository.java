package com.codegym.repository;

import com.codegym.model.MusicApp;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        TypedQuery<MusicApp> query = entityManager.createQuery("select m from MusicApp as m", MusicApp.class);
        musicAppList = query.getResultList();
        return musicAppList;
    }

    @Transactional
    @Override
    public void save(MusicApp musicApp) {
        entityManager.persist(musicApp);
    }

    @Transactional
    @Override
    public MusicApp findById(int id) {

        return entityManager.find(MusicApp.class, id);
    }

    @Transactional
    @Override
    public void update(int id, MusicApp music) {
        MusicApp musicEdit = findById(id);
        musicEdit.setArtist(music.getArtist());
        musicEdit.setKindOfMusic(music.getKindOfMusic());
        musicEdit.setName(music.getName());
        musicEdit.setSongFilePath(music.getSongFilePath());
        entityManager.merge(musicEdit);
    }

    @Transactional
    @Override
    public void remove(int id) {
        MusicApp musicDelete = findById(id);
        entityManager.remove(musicDelete);
    }
}
