package server.service;

import java.util.concurrent.*;

/**
 * @author uio
 * Date 2021/3/27 12:40
 * Description: 线程池服务
 */
public class PoolService {

    private PoolService() {}

    // todo 优化线程池配置
    private static Executor executor =
            new ThreadPoolExecutor(2, 8, 2000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

    public static Executor getPoolService() {
        return executor;
    }
}
