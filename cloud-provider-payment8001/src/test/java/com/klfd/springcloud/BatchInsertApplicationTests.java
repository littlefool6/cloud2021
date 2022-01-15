package java.com.klfd.springcloud;

import com.klfd.springcloud.entities.Payment;
import com.klfd.springcloud.service.PaymentService;
import com.klfd.springcloud.tools.BatchInsertProcessor;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class BatchInsertApplicationTests {

    @Resource
    private PaymentService paymentService;

    @Test
    public void batchInsert() {
        final BatchInsertProcessor<Payment> work = new BatchInsertProcessor<>();
        work.start((t, ts) -> {
            //单条数据t就有数据，多条数据ts就会有数据
            //这里我是插了2w条数据，所以用ts
            paymentService.saveList(ts);
        }, 10, 2000);
        // 模拟生产数据
        try {
            for (int i = 0; i < 20000; i++) {
                work.put(new Payment((long) i, i + " name"));
            }
            // 等待入库完成
            work.await();
        } catch (Exception e) {
            // 如果生产过程中有异常,立即停止掉处理器，不再入库
            work.stop();
        }
    }
}
