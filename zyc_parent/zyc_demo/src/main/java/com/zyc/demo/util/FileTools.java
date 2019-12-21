package com.zyc.demo.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @作用: 文件处理类
 * @作者: syp
 * @时间: 2019-4-16 15:26:27
 */
public class FileTools {
    private String fFname = null;
    List<String> fileList = new ArrayList<String>();

    public String getFileName(String cfgFilename) {
        if (this.fFname == null) {
            String[] str = cfgFilename.split("/");
            String filename = str[str.length - 1];
            this.fFname = filename;
        }

        return this.fFname;
    }

    // 写文件
    public static int writeFile(String fileName, byte[] content) {

        System.out.println("开始写文件:[" + fileName + "]");

        File file = new File(fileName);
        File fileparent = file.getParentFile();
        if (!fileparent.exists()) {
            System.out.println("文件夹不存在，创建该目录");
            fileparent.mkdirs();
        }
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(fileName);
            os.write(content);
            os.flush();

        } catch (Exception e) {
            System.out.println("写文件:[" + fileName + "]异常，异常信息为:["
                    + e.getMessage() + "]");
            return -1;
        } finally {
            try {
                if (null != os)
                    os.close();
            } catch (IOException e) {
            }
        }
        os = null;
        System.out.println("写文件:[" + fileName + "]完成!");
        return 0;
    }

    // 读文件
    public static byte[] readFile(String fileName) {
        FileInputStream fis = null;
        System.out.println("开始读文件:[" + fileName + "]");
        byte[] buffer = null;
        try {
            fis = new FileInputStream(fileName);
            buffer = new byte[fis.available()];
            fis.read(buffer);

        } catch (Exception e) {
            System.out.println("读文件[" + fileName + "]失败 " + e.toString());
        } finally {
            try {
                if (null != fis)
                    fis.close();
            } catch (IOException e) {
            }
        }
        fis = null;
        System.out.println("读文件[" + fileName + "]成功");
        System.out.println("文件[" + fileName + "]转为字节数组");
        return buffer;
    }

    /*
     * 读取文件（可设置编码方式）
     * @return 文件内容
     */
    public String ReadFileContent(String filePath) {
        File file = new File(filePath);
        // BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "gbk"));
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        String str = null;
        StringBuffer Buff = new StringBuffer();
        try {
            while ((str = br.readLine()) != null) {
                Buff.append(str + "\r\n");
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return Buff.toString();
    }

    public List<String> getFiles(String filePath) {
        System.out.println("开始遍历[" + filePath + "]目录下的文件");
        //定义存放文件名的list集合


        //文件主目录
        File root = new File(filePath);

        //读出目录下所有文件
        File[] files = root.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("[" + filePath + "]目录下无文件，不继续后续操作");
            return null;
        }
        //开始遍历文件并判断是否为文件目录
        for (File file : files) {

            // 判断是否文件夹
            if (file.isDirectory()) {

                // 递归调用
                getFiles(file.getAbsolutePath());

            } else {

                // 否则，放入文件集合
                fileList.add(filePath + File.separator + file.getName());
                System.out.println(file.getName());
            }
        }
        System.out.println("[" + filePath + "]目录遍历完成，里面包括[" + fileList.size() + "]个文件");
        return fileList;
    }

    /**
     * 读取一个文本 一行一行读取
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static List<String> readFile02(String path) throws IOException {
        // 使用一个字符串集合来存储文本中的路径 ，也可用String []数组
        List<String> list = new ArrayList<String>();
        FileInputStream fis = new FileInputStream(path);
        // 防止路径乱码   如果utf-8 乱码  改GBK     eclipse里创建的txt  用UTF-8，在电脑上自己创建的txt  用GBK
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while ((line = br.readLine()) != null) {
            // 如果 t x t文件里的路径 不包含---字符串       这里是对里面的内容进行一个筛选
            if (line.lastIndexOf("---") < 0) {
                list.add(line);
            }
        }
        br.close();
        isr.close();
        fis.close();
        return list;
    }
}