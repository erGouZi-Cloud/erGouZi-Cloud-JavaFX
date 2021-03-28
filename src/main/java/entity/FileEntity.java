package entity;

/**
 * @author uio
 * Date 2021/3/27 15:34
 * Description: 文件类
 */
public class FileEntity implements IFile {

    /**
     * 文件名
     */
    private String name;

    /**
     * 文件路径
     */
    private String path;

    public FileEntity(String name, String path) {
        this.name = name;
        this.path = path;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void delete() {

    }
}
