package com.wjlambda.web.movie;

import lombok.Data;
import org.springframework.stereotype.Component;



@Component
public class MovieDTO {
    private String movieName,seq,rankDate;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getRankDate() {
        return rankDate;
    }

    public void setRankDate(String rankDate) {
        this.rankDate = rankDate;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "movieName='" + movieName + '\'' +
                ", seq='" + seq + '\'' +
                ", rankDate='" + rankDate + '\'' +
                '}';
    }
}