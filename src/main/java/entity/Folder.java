package entity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author uio
 * Date 2021/3/27 15:30
 * Description: 文件夹实体类
 */
public class Folder implements IFile{

    /**
     * 文件夹名
     */
    private String name;

    /**
     * 文件夹路径，不设置set方法，只能在构造方法中赋值
     */
    private String path;

    /**
     * 该文件夹下属文件夹
     */
    private List<Folder> folderList = new ArrayList<>();

    /**
     * 该文件夹下属文件
     */
    private List<File> fileList = new ArrayList<>();

    public Folder(String name, String path) {
        this.name = name;
        this.path = path;
    }

    @Override
    public String toString() {
        return "Folder{" +
                "name='" + name + '\'' +
                ", folderList=" + folderList +
                ", fileList=" + fileList +
                '}';
    }

    public String getPath() {
        return path;
    }

    public List<Folder> getFolderList() {
        return folderList;
    }

    public void setFolderList(List<Folder> folderList) {
        this.folderList = folderList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

    @Override
    public void delete() {

    }
}
