package com.codegym.service;

import com.codegym.model.MusicApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicAppService implements IMusicAppService {
    @Autowired
    IMusicAppService iMusicAppService;
    @Override
    public List<MusicApp> findAll() {
        return iMusicAppService.findAll();
    }

    @Override
    public void save(MusicApp musicApp) {
    iMusicAppService.save(musicApp);
    }

    @Override
    public MusicApp findById(int id) {
        return iMusicAppService.findById(id);
    }

    @Override
    public void update(int id, MusicApp musicApp) {
        iMusicAppService.update(id,musicApp);
    }

    @Override
    public void remove(int id) {
        iMusicAppService.remove(id);
    }
}
