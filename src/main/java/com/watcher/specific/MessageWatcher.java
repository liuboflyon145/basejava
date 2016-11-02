package com.watcher.specific;

import com.watcher.Watcher;

/**
 * Created by liubo on 2016/10/11.
 */
public class MessageWatcher implements Watcher {
    @Override
    public void update(String str) {
        System.out.println(this.getClass().getName()+" "+str);
    }
}
