package com.watcher;

/**
 * Created by liubo on 2016/10/11.
 */
public interface Watched {
    public void addWatcher(Watcher watcher);

    public void removeWatcher(Watcher watcher);

    public void notifyWatchers(String strs);

}
