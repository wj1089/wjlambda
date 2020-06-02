package com.wjlambda.web.proxy;

import com.wjlambda.web.music.Music;
import com.wjlambda.web.music.MusicDTO;
import com.wjlambda.web.music.MusicRepository;
import com.wjlambda.web.soccer.Player;
import com.wjlambda.web.soccer.PlayerDTO;
import com.wjlambda.web.soccer.PlayerRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

@Service("loder") @Lazy
public class FileUploader  extends Proxy{
    @Autowired PlayerDTO player;
    @Autowired Inventory<String> inventory;
    @Autowired PlayerRepository playerRepository;
    @Autowired MusicDTO music;
    @Autowired MusicRepository musicRepository;

    public void upload (){
        inventory.clear();
        try{
            BufferedReader reader = new BufferedReader(
                    new FileReader(
                            new File("C:\\Users\\bit23\\IdeaProjects\\wjlambda\\src\\main\\resources\\com\\wjlambda\\web\\mapper\\player.csv")));
            String player = "";
            while((player = reader.readLine())!=null){
                inventory.add(player);
            }
        }catch(Exception e){
                print("파일 리딩 에러");
            e.printStackTrace();

        }
       /* for (String s : inventory.get()){
            String[] arr = s.split(",");*/
            //player.set
        print("-------------------------------");
        print(inventory.get().get(0).toString());
        String[] arr = inventory.get().get(0).split(",");
        //"2000003","유동우","K10","YOU,  DONGWOO","","","DF","40","","07-MAR-1978","1","177","70"
        Player p = new Player();
        p.setPlayerId(arr[0]);
        p.setPlayerName(arr[1]);

        p.setEPlayerName(arr[3]);
        p.setNickname(arr[4]);
        p.setJoinYyyy(arr[5]);
        p.setPosition(arr[6]);
        p.setBackNo(arr[7]);
        p.setNation(arr[8]);
        p.setBirthDate(arr[9]);
        p.setSolar(arr[10]);
        p.setHeight(arr[11]);
        p.setWeight(arr[12]);
        print("************************************");
        print(player.toString());
        playerRepository.save(p);
        }


    }
