package com.wjlambda.web.services;

import com.wjlambda.web.soccer.PlayerDTO;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface PlayerService {
    public List<PlayerDTO> retrieveAll();
    public PlayerDTO findOne(String searchWord);
    public PlayerDTO login(PlayerDTO params);
}
