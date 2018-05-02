package com.maowei.learning.file;

import java.io.File;
import java.util.LinkedList;

public class FolderTraverse {
    public static void traverseFolder(String path){
        int fileNum = 0;
        int folderNum = 0;
        File file = new File(path);
        if(file.exists()){
            LinkedList<File> list = new LinkedList<File>();
            for(File f : file.listFiles()){
                if(f.isDirectory()){
                    System.out.println("文件夹："+f.getAbsolutePath());
                    list.add(f);
                    folderNum++;
                }else {
                    System.out.println("文件："+f.getAbsolutePath());
                    fileNum++;
                }
            }

            while(!list.isEmpty()){
                File tempFile = list.removeFirst();
                for(File f : tempFile.listFiles()){
                    if(f.isDirectory()){
                        System.out.println("文件夹："+f.getAbsolutePath());
                        list.add(f);
                        folderNum++;
                    }else {
                        System.out.println("文件："+f.getAbsolutePath());
                        fileNum++;
                    }
                }
            }

        }else {
            System.out.println("文件不存在!");
        }
        System.out.println("文件夹共有:" + folderNum + ",文件共有:" + fileNum);
    }

    public static void main(String[] args) {
        traverseFolder("/Users/apple/EnvConfig/apache-maven-3.2.5/repository");
    }
}
