package com.wjlambda.web.controllers;

import com.wjlambda.web.soccer.PlayerDTO;
import com.wjlambda.web.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired PlayerService playerService;
    @Autowired PlayerDTO player;
    @GetMapping("")
    public List<PlayerDTO> list(){
        return playerService.retrieveAll();
    }
    @PostMapping("/{playerId}/access")
    public Map<String, Object> login(
            @PathVariable String  playerId,
            @RequestBody PlayerDTO params){
        Map<String,Object> map = new HashMap<>();
        player = playerService.login(params);
        if(player != null){
            System.out.println("로그인정보 "+ player.toString());
            map.put("result", true);
        }else{
            map.put("result",false);
        }
        map.put("player",player);
        return map;
    }
}
