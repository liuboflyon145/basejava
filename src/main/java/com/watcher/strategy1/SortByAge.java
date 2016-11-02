package com.watcher.strategy1;

import java.util.Comparator;

/**
 * Created by liubo on 2016/10/18.
 */
public class SortByAge implements Comparator{
    private int sortType = 0;

    @Override
    public int compare(Object o1, Object o2) {
        if (sortType==0)
            return ((Person) o1).getAge()-((Person)o2).getAge();
        return ((Person) o2).getAge()-((Person)o1).getAge();
    }

    public void setSortType(int sortType) {
        this.sortType = sortType;
    }
}
