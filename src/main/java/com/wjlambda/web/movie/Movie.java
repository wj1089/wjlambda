package com.wjlambda.web.movie;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@Getter
@Setter
@ToString
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieNo;
    @Column(length = 4) private  String seq;
    @Column(length = 100) private String movieName;
    @Column(length = 20) private String rankDate;

    public String getRankDate() {
        return rankDate;
    }

    public void setRankDate(String rankDate) {
        this.rankDate = rankDate;
    }

    public Long getMovieNo() {
        return movieNo;
    }

    public void setMovieNo(Long movieNo) {
        this.movieNo = movieNo;
    }

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

    public Movie(){}

    @Builder
    public Movie(String movieName,String seq, String rankDate){
        this.seq=seq;
        this.movieName=movieName;
        this.rankDate=rankDate;
    }
    @Override
    public String toString() {
        return "Movie{" +
                "movieNo=" + movieNo +
                ", seq='" + seq + '\'' +
                ", movieName='" + movieName + '\'' +
                ", rankDate='" + rankDate + '\'' +
                '}';
    }


}
