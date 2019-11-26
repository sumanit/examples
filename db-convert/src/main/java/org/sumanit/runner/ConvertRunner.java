package org.sumanit.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.sumanit.service.ConvertService;

import javax.annotation.Resource;

/**
 * Created by 苏曼 on 2019/11/26.
 */
@Component
public class ConvertRunner implements CommandLineRunner {
    @Resource
    private ConvertService convertService;
    @Override
    public void run(String... args) throws Exception {
        convertService.convert();
        System.out.println("ConvertRunner");
    }
}
