package com.wjlambda.web.proxy;


import com.wjlambda.web.mapper.MovieMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Data
@Component
public class Pager {
    @Autowired MovieMapper movieMapper;
    private int rowCount;
    private int pageCount;
    private int blockCount;
    private int rowStart;

    public MovieMapper getMovieMapper() {
        return movieMapper;
    }

    public void setMovieMapper(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getBlockCount() {
        return blockCount;
    }

    public void setBlockCount(int blockCount) {
        this.blockCount = blockCount;
    }

    public int getRowStart() {
        return rowStart;
    }

    public void setRowStart(int rowStart) {
        this.rowStart = rowStart;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public int getPrevBlock() {
        return prevBlock;
    }

    public void setPrevBlock(int prevBlock) {
        this.prevBlock = prevBlock;
    }

    public int getRowEnd() {
        return rowEnd;
    }

    public void setRowEnd(int rowEnd) {
        this.rowEnd = rowEnd;
    }

    public int getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(int pageEnd) {
        this.pageEnd = pageEnd;
    }

    public int getNextBlock() {
        return nextBlock;
    }

    public void setNextBlock(int nextBlock) {
        this.nextBlock = nextBlock;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getBlockNow() {
        return blockNow;
    }

    public void setBlockNow(int blockNow) {
        this.blockNow = blockNow;
    }

    private int pageStart;
    private int prevBlock;
    private int rowEnd;
    private int pageEnd;
    private int nextBlock;
    private int pageSize;
    private int blockSize;
    private int pageNow;
    private int blockNow;
    private boolean exisPrev, existNext;
    private String searchWord;
    public void paging(){
        rowCount = movieMapper.count();
        rowStart = pageNow * pageSize;
        rowEnd = (pageNow != (pageCount -1)) ? rowStart + (pageSize-1): rowCount - 1;
        pageCount = (rowCount % pageSize != 0) ? rowCount / pageSize +1 :rowCount / pageSize ;
        pageStart = blockNow *  blockSize;
        pageEnd = (blockNow != (blockCount -1)) ? pageStart + (blockSize - 1): pageCount - 1;
        // pageSize = 5;
        // pageNow = 0;
        blockCount = (pageCount % blockSize != 0) ? pageCount / blockSize +1:pageCount / blockSize ;
        prevBlock = pageStart - blockSize;
        nextBlock = pageStart + blockSize;
        // blockSize = 5;
        blockNow = pageNow / blockSize;
        System.out.println("blockNow :: "+blockNow);
        exisPrev = blockNow != 0;
        System.out.println("existPrev :: "+exisPrev);
        existNext = (blockNow + 1) != blockCount;
        System.out.println("existNext :: "+existNext);
    }

}