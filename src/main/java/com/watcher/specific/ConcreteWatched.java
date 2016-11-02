package com.watcher.specific;

import com.watcher.Watched;
import com.watcher.Watcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liubo on 2016/10/11.
 */
public class ConcreteWatched implements Watched {

    private List<Watcher> list = new ArrayList<>();
    @Override
    public void addWatcher(Watcher watcher) {
        list.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        list.remove(watcher);
    }

    @Override
    public void notifyWatchers(String strs) {
        // 自动调用实际上是主题进行调用的
        for (Watcher w :list ) {
            w.update(strs);
        }
    }
}
