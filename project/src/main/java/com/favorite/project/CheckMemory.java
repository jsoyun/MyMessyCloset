package com.favorite.project;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.NumberFormat;

public class CheckMemory {

    private static Log logger = (Log) LogFactory.getLog(ProjectApplication.class);

    public CheckMemory() {
        Runtime runtime = Runtime.getRuntime();
        final NumberFormat format = NumberFormat.getInstance();

        final long maxMemory = runtime.maxMemory();
        final long allocatedMemory = runtime.totalMemory();
        final long freeMemory = runtime.freeMemory();
        final long mb = 1024 * 1024;
        final String mega = " MB";

        logger.info("=============Memory Info==================");
        logger.info("Free memory:" + format.format(freeMemory / mb) + mega);
        logger.info("Allocated memory:" + format.format(allocatedMemory / mb) + mega);
        logger.info("Max memory:" + format.format(maxMemory / mb) + mega);
        logger.info("Total memory:" + format.format(freeMemory + (maxMemory - allocatedMemory) / mb) + mega);

        logger.info("========================================");
    }


}
