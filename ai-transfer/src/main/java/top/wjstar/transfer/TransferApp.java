package top.wjstar.transfer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 * @author wxvirus
 */
@MapperScan({"top.wjstar.transfer.mapper", "top.wjstar.transfer.dao"})
@SpringBootApplication
public class TransferApp {
    public static void main(String[] args) {
        SpringApplication.run(TransferApp.class, args);
    }
}
