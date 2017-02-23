package com.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by liubo16 on 2017/2/22.
 */
public class ApplicationStartupUtil {
    private static final ApplicationStartupUtil INSTANCE = new ApplicationStartupUtil();
    private static List<BaseHealthChecker> _services;
    private static CountDownLatch _latch;

    public static ApplicationStartupUtil getInstance() {
        return INSTANCE;
    }

    public static boolean checkExternalServices() throws InterruptedException {
        _latch = new CountDownLatch(2);
        _services = new ArrayList<>();
        _services.add(new NetworkHealthChecker(_latch));
        _services.add(new CacheHealthChecker(_latch));

        Executor executor = Executors.newFixedThreadPool(_services.size());

        for (final BaseHealthChecker v :
                _services) {
            executor.execute(v);
        }
        System.out.println(_latch.getCount());
        _latch.await();

        for (final BaseHealthChecker v :
                _services) {
            if (!v.isServiceUp())
                return false;
        }
        return true;
    }
}
