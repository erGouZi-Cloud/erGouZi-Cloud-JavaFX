package server;

import server.service.PoolService;
import server.service.ScanService;

/**
 * @author uio
 * Date 2021/3/27 14:01
 * Description: 监听请求
 */
public class Controller {


    /**
     * 启动上传文件夹服务，静态方法，更快速的访问
     * 获得文件夹路径，进行文件上传
     * 异步
     * @param path 文件夹路径
     */
    public static void upFileController(String path) {
        PoolService.getPoolService().execute(new ScanService(path)); // 调用线程池，异步进行处理
    }

}
