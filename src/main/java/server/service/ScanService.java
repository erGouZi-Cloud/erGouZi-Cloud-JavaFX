package server.service;

import entity.FileEntity;
import entity.Folder;
import entity.IFile;

import java.io.File;
import java.util.concurrent.*;

/**
 * @author uio
 * Date 2021/3/27 11:41
 * Description: 上传文件服务
 */
public class ScanService implements Runnable {

    private String path;

    public ScanService(String path) {
        this.path = path;
    }

    /**
     * 扫描文件夹
     * @return
     */
    public Folder scanFolder(String path) {
        // todo 多线程遍历
        File file = new File(path);
        File[] fs = file.listFiles();
        if(fs == null) {
            // todo 待修改
            return null;
        }
        // 该File为文件夹
        Folder root = new Folder(file.getName(), path);
        for (File f : fs) {
            if(f.isDirectory()) {
                root.getFolderList().add(scanFolder(f.getPath()));
                System.out.println(f.getName());
            } else {
                root.getFileList().add(new File(f.getName(), f.getPath()));
                System.out.println(f.getName());
            }
        }
        return root;
    }


    @Override
    public void run() {
        File file = new File(this.path);

        IFile iFile = null;

        if(file.isDirectory()) {
            iFile = scanFolder(this.path);
        } else {
            iFile = new FileEntity(file.getName(), file.getPath());

        }
    }
}
