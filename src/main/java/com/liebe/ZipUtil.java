package com.liebe;

import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Expand;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

/**
 * Created by Administrator on 2017/8/14.
 */
public class ZipUtil {

    private static final Project DEFAULT_PROJECT = new Project();


    /**
     * 解压Zip文件
     * @param orgin zip文件
     * @param dest 解压文件夹
     */
    public static void unZip(String orgin, String dest) {
        File zip = new File(orgin);
        File toZip = new File(dest);
        if(!zip.exists()){
            return;
        }
        if(!toZip.exists() || !toZip.isDirectory()){
            toZip.mkdir();
        }
        Expand expand = new Expand();
        expand.setProject(DEFAULT_PROJECT);
        expand.setSrc(zip);
        expand.setDest(toZip);
        expand.execute();

    }

    /**
     * 执行压缩操作
     *
     * @param zipfile 压缩后zip文件
     * @param srcPathName 需要被压缩的文件/文件夹
     */
    public static void zip(String zipfile, String srcPathName) {
        File srcdir = new File(srcPathName);
        if (!srcdir.exists()){
            throw new RuntimeException(srcPathName + "不存在！");
        }

        Zip zip = new Zip();
        zip.setProject(DEFAULT_PROJECT);
        zip.setDestFile(new File(zipfile));
        FileSet fileSet = new FileSet();
        fileSet.setProject(DEFAULT_PROJECT);
        fileSet.setDir(srcdir);
        //fileSet.setIncludes("**/*.java"); //包括哪些文件或文件夹 eg:zip.setIncludes("*.java");
        //fileSet.setExcludes(...); //排除哪些文件或文件夹
        zip.addFileset(fileSet);
        zip.execute();
    }

    //处理批量下载时候，文件压缩问题
    private void doZip(File file, ZipOutputStream zos) throws Exception {
        if(file.exists()) {
            byte[] buffer = new byte[1024];
            FileInputStream fis = new FileInputStream(file);
            ZipEntry zet = new ZipEntry(file.getName());
            zos.putNextEntry(zet);
            int len = 0 ;
            // 读取文件的内容, 打包到zip文件
            while ((len = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
                zos.flush();
            }
            zos.closeEntry();
            fis.close();
        }else {
            throw new MyException("111","您要下载的文件不存在");
        }
    }
}

