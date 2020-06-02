package com.wjlambda.web.serviceImpls;

import com.wjlambda.web.soccer.PlayerDTO;
import com.wjlambda.web.mapper.PlayerMapper;
import com.wjlambda.web.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired PlayerMapper playerMapper;
    @Override
    public List<PlayerDTO> retrieveAll(){
        return  playerMapper.selectAll();
    }

    @Override
    public PlayerDTO findOne(String searchWord) {
        return playerMapper.selectOne(searchWord);
    }

    @Override
    public PlayerDTO login(PlayerDTO params) {
        return playerMapper.login(params);
    }

}
