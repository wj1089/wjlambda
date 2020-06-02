package com.wjlambda.web.proxy;

import com.wjlambda.web.movie.Movie;
import com.wjlambda.web.movie.MovieRepository;
import com.wjlambda.web.music.Music;
import com.wjlambda.web.music.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
public class ProxyController{
    @Autowired Box<Object> box;
    @Autowired Crawler crawler;
    @Autowired Proxy pxy;
    @Autowired FileUploader uploader;
    @Autowired MusicRepository musicRepository;
    @Autowired MovieRepository movieRepository;
    @PostMapping("/bugsmusic")
    public HashMap<String,Object> bugsmusic(@RequestBody String searchWord){
        pxy.print("넘어온 키워드: "+searchWord);
        box.clear();
        if(musicRepository.count() == 0) crawler.movie();
        List<Music> list = musicRepository.findAll();
        box.put("count", list.size());
        box.put("list", list);
        pxy.print("조회한 수: "+list.size());
        return box.get();
    }

    @GetMapping("/soccer/{searchWord}")
    public String soccer(@PathVariable String searchWord){
        pxy.print("넘어온 키워드 : " + searchWord);
        uploader.upload();
        return null;
    }
    @GetMapping("/movie/{searchWord}")
    public HashMap<String, Object> movie(@PathVariable String searchWord){
        pxy.print("넘어온 키워드: "+searchWord);
        box.clear();
        if(movieRepository.count() == 0) crawler.movie();
        List<Movie> list = movieRepository.findAll();
        box.put("count", list.size());
        box.put("list", list);
        pxy.print("조회한 수: "+list.size());
        return box.get();
    }
}