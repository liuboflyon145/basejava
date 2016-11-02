package com.watcher.test;

import com.watcher.Watched;
import com.watcher.Watcher;
import com.watcher.specific.ConcreteWatched;
import com.watcher.specific.ConcreteWatcher;
import com.watcher.specific.IntegralWatcher;
import com.watcher.specific.MessageWatcher;

/**
 * Created by liubo on 2016/10/11.
 */
public class Test {

    public static void main(String[] args) {
        Watched girl = new ConcreteWatched();

        Watcher watcher1 = new ConcreteWatcher();
        Watcher watcher2 = new MessageWatcher();
        Watcher watcher3 = new IntegralWatcher();

        girl.addWatcher(watcher1);
        girl.addWatcher(watcher2);
        girl.addWatcher(watcher3);

        girl.notifyWatchers("观察者模式");
    }
}
