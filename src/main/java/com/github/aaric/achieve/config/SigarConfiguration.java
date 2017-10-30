package com.github.aaric.achieve.config;

import com.google.common.io.Resources;
import org.hyperic.sigar.Sigar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

/**
 * Sigar配置
 *
 * @author Aaric, created on 2017-10-27T13:39.
 * @since 1.0-SNAPSHOT
 */
@Configuration
public class SigarConfiguration {

    /**
     * Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SigarConfiguration.class);

    /**
     * types of Operating Systems
     */
    public enum OSType {
        Windows, MacOS, Linux, Other
    }

    /**
     * default os type
     */
    protected static OSType detectedOS;

    /**
     * detected the operating system from the os.name System property and cache
     * <p>
     * the result
     *
     * @returns - the operating system detected
     */
    public static OSType getOperatingSystemType() {
        if (detectedOS == null) {
            String OS = System.getProperty("os.name", "generic").toLowerCase();
            if (OS.indexOf("win") >= 0) {
                detectedOS = OSType.Windows;
            } else if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
                detectedOS = OSType.MacOS;
            } else if (OS.indexOf("nux") >= 0) {
                detectedOS = OSType.Linux;
            } else {
                detectedOS = OSType.Other;
            }
        }
        return detectedOS;
    }

    @Bean
    public Sigar sigar() {
        String file = Resources.getResource("sigar/.sigar_shellrc").getFile();
        File classPath = new File(file).getParentFile();
        String path = System.getProperty("java.library.path");
        logger.info("JavaLibraryPath: {}", path);
        try {
            if (getOperatingSystemType() == OSType.Windows) {
                path += ";" + classPath.getCanonicalPath();
            } else {
                path += ":" + classPath.getCanonicalPath();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty("java.library.path", path);
        return new Sigar();
    }
}
