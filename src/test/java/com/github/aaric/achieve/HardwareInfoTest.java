package com.github.aaric.achieve;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.aaric.achieve.hardware.entity.HardwareInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * HardwareInfoTest
 *
 * @author Aaric, created on 2017-10-30T17:13.
 * @since 1.0-SNAPSHOT
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HardwareInfoTest {

    @Test
    public void testPrint() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        String json = mapper.writeValueAsString(new HardwareInfo(Calendar.getInstance().getTime()));
        System.err.println(json);
        HardwareInfo hardwareInfo = mapper.readValue(json, HardwareInfo.class);
        System.err.println(hardwareInfo);
    }
}
