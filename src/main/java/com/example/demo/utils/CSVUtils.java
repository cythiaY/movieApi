package com.example.demo.utils;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/**
 * Created by adminstrator on 2018/2/7.
 */
public class CSVUtils {

    public static File createCSVFile(List<Map<String, String>> exportData, LinkedHashMap<String, String> rowMapper, String outPutPath, String filename) {

        File csvFile = null;
        BufferedWriter csvFileOutputStream = null;
        try {
            csvFile = new File(outPutPath + "/"+filename + ".csv");
            //csvFile = new File(outPutPath + "//"+filename + ".csv");
            File parent = csvFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            csvFile.createNewFile();

            // GB2312使正确读取分隔符","
            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "UTF-8"), 1024);
            // 写入文件头部
            for (Iterator<Entry<String, String>> propertyIterator = rowMapper.entrySet().iterator(); propertyIterator.hasNext(); ) {
                Entry<String, String> propertyEntry = (Entry<String, String>) propertyIterator.next();
                csvFileOutputStream.write("\"" + propertyEntry.getValue().toString() + "\"");
                if (propertyIterator.hasNext()) {
                    csvFileOutputStream.write(",");
                }
            }
            csvFileOutputStream.newLine();
            // 写入文件内容
            for (Iterator<Map<String, String>> iterator = exportData.iterator(); iterator.hasNext(); ) {
                Map<String, String> row = (Map<String, String>) iterator.next();
                for (Iterator<Entry<String, String>> propertyIterator = rowMapper.entrySet().iterator(); propertyIterator.hasNext(); ) {
                    Entry<String, String> propertyEntry = (Entry<String, String>) propertyIterator.next();
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

    public static void main(String[] args) {
        List<Map<String, String>> exportData = new ArrayList<Map<String, String>>();
        Map<String, String> row1 = new LinkedHashMap<String, String>();
        row1.put("1", "11");
        row1.put("2", "12");
        row1.put("3", "13");
        row1.put("4", "14");
        row1.put("5", "15");
        row1.put("6", "16");
        row1.put("7", "17");
        exportData.add(row1);
        row1 = new LinkedHashMap<String, String>();
        row1.put("1", "21");
        row1.put("2", "22");
        row1.put("3", "23");
        row1.put("4", "24");
        row1.put("5", "25");
        row1.put("6", "26");
        row1.put("7", "27");
        exportData.add(row1);
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("1", "编码号");
        map.put("2", "代金券兑换码");
        map.put("3", "代金券状态");
        map.put("4", "认领人");
        map.put("5", "认领日期");
        map.put("6", "使用日期");
        map.put("7", "过期日期");
        createCSVFile(exportData, map, "D:/develop/cvs/", "活动目录");
    }

}
