import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.sumanit.springcloud.feign.Application;
import org.sumanit.springcloud.feign.feignclient.HelloClient;
import org.sumanit.springcloud.feign.feignclient.HelloWithRibbonClient;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleTest {
    @Autowired
    private HelloClient helloClient;
    @Autowired
    private HelloWithRibbonClient helloWithRibbonClient;
    @Test
    public void test(){
        Object o = helloClient.getHello();
        System.out.println(o.toString());
    }

    @Test
    public void test2(){
        Object o = helloWithRibbonClient.getHello();
        System.out.println(o.toString());
    }
}