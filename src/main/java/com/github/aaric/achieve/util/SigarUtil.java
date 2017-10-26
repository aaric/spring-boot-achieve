package com.github.aaric.achieve.util;

import com.google.common.io.Resources;
import org.hyperic.sigar.Sigar;

import java.io.File;

/**
 * SigarUtil
 *
 * @author Aaric, created on 2017-10-26T14:39.
 * @since 1.0-SNAPSHOT
 */
public class SigarUtil {

    private static class SigarUtilHolder {
        private static final SigarUtil INSTANCE = new SigarUtil();
        private static final Sigar Sigar = new Sigar();
    }

    private SigarUtil() {
        try {
            String file = Resources.getResource("sigar/.sigar_shellrc").getFile();
            File classPath = new File(file).getParentFile();
            String path = System.getProperty("java.library.path");
            if (OsCheck.getOperatingSystemType() == OsCheck.OSType.Windows) {
                path += ";" + classPath.getCanonicalPath();
            } else {
                path += ":" + classPath.getCanonicalPath();
            }
            System.setProperty("java.library.path", path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final Sigar getInstance() {
        return SigarUtilHolder.Sigar;
    }

    public static final SigarUtil getSigarUtilInstance() {
        return SigarUtilHolder.INSTANCE;
    }
}
