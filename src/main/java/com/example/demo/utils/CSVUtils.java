package com.example.demo.utils;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/**
 * Created by adminstrator on 2018/2/7.
 */
public class CSVUtils {

    public static File createCSVFile(List<Map<Integer, String>> exportData, LinkedHashMap<Integer, String> rowMapper, String outPutPath, String filename) {

        File csvFile = null;
        BufferedWriter csvFileOutputStream = null;
        try {
            csvFile = new File(outPutPath + "/" + filename + ".csv");
            //csvFile = new File(outPutPath + "//"+filename + ".csv");
            File parent = csvFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            csvFile.createNewFile();

            // GB2312使正确读取分隔符","
            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "UTF-8"), 1024);
            // 写入文件头部
            for (Iterator<Entry<Integer, String>> propertyIterator = rowMapper.entrySet().iterator(); propertyIterator.hasNext(); ) {
                Entry<Integer, String> propertyEntry = (Entry<Integer, String>) propertyIterator.next();
                csvFileOutputStream.write("\"" + propertyEntry.getValue().toString() + "\"");
                if (propertyIterator.hasNext()) {
                    csvFileOutputStream.write(",");
                }
            }
            csvFileOutputStream.newLine();
            // 写入文件内容
            for (Iterator<Map<Integer, String>> iterator = exportData.iterator(); iterator.hasNext(); ) {
                Map<Integer, String> row = (Map<Integer, String>) iterator.next();
                for (Iterator<Entry<Integer, String>> propertyIterator = rowMapper.entrySet().iterator(); propertyIterator.hasNext(); ) {
                    Entry<Integer, String> propertyEntry = (Entry<Integer, String>) propertyIterator.next();
                    csvFileOutputStream.write("\"" + row.get(propertyEntry.getKey().toString()) + "\"");
                    if (propertyIterator.hasNext()) {
                        csvFileOutputStream.write(",");
                    }
                }
                if (iterator.hasNext()) {
                    csvFileOutputStream.newLine();
                }
            }
            csvFileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvFileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvFile;
    }

}
