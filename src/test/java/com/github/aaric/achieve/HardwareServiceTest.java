package com.github.aaric.achieve;

import com.github.aaric.achieve.hardware.service.HardwareService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * HardwareServiceTest
 *
 * @author Aaric, created on 2017-10-27T15:23.
 * @since 1.0-SNAPSHOT
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HardwareServiceTest {

    @Autowired
    protected HardwareService hardwareService;

    @Test
    public void testGetCupInfo() {
        System.out.println(hardwareService.getCupInfo());
        System.out.println(hardwareService.getCupInfo());
    }

    @Test
    public void testGetMemInfo() {
        System.out.println(hardwareService.getMemInfo());
        System.out.println(hardwareService.getMemInfo());
    }

    @Test
    public void testGetDiskInfo() {
        System.out.println(hardwareService.getDiskInfo());
        System.out.println(hardwareService.getDiskInfo());
    }

    @Test
    public void testGetNetworkInfo() {
        System.out.println(hardwareService.getNetworkInfo());
        System.out.println(hardwareService.getNetworkInfo());
    }
}
