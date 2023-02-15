package com.codegym.service;

import com.codegym.model.MusicApp;
import com.codegym.repository.IMusicAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicAppService implements IMusicAppService {
    @Autowired
    IMusicAppRepository iMusicAppRepository;
    @Override
    public List<MusicApp> findAll() {
        return iMusicAppRepository.findAll();
    }

    @Override
    public void save(MusicApp musicApp) {
    iMusicAppRepository.save(musicApp);
    }

    @Override
    public MusicApp findById(int id) {
        return iMusicAppRepository.findById(id);
    }

    @Override
    public void update(int id, MusicApp musicApp) {
        iMusicAppRepository.update(id,musicApp);
    }

    @Override
    public void remove(int id) {
        iMusicAppRepository.remove(id);
    }
}
