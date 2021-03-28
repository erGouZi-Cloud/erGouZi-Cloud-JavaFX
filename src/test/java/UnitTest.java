import org.junit.Test;
import server.Controller;


/**
 * @author uio
 * Date 2021/3/27 15:53
 * Description:
 */
public class UnitTest {

    @Test
    public void FileTest() throws InterruptedException {
        String path = "/Users/uio/Downloads/";

        Controller.upFileController(path);
    }
}
