package com.watcher.strategy1;

import java.util.Comparator;

/**
 * Created by liubo on 2016/10/18.
 */
public class SortById implements Comparator{
    private int sortType = 0; //升序
    @Override
    public int compare(Object o1, Object o2) {
        int id1 = ((Person)o1).id;
        int id2 = ((Person)o2).id;
        if (sortType==0)
            return id1-id2;
        return id2-id1;
    }

    public int getSortType() {
        return sortType;
    }

    public void setSortType(int sortType) {
        this.sortType = sortType;
    }
}
