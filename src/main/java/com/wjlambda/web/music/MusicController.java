package com.wjlambda.web.music;

import com.wjlambda.web.proxy.Box;
import com.wjlambda.web.proxy.Crawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
public class MusicController {
    @Autowired Box<Object> box;
    @Autowired Crawler crawler;
    @Autowired Music music;

}
