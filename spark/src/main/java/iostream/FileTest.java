package iostream;


import java.io.*;
import java.util.ArrayList;

/**
 * @ClassName FileTest
 * @Author zhangqx02
 * @Date 2019/11/4 14:39
 * @Description
 * File类常见需求
 */

public class FileTest {
    public static void main(String[] args) throws IOException{
        File file=new File("D:\\MyFile\\workLearning\\spark\\src");
//        showDir(file);
        showDir(file,0);
        getFileName(file, new ArrayList<File>());
        list(file, 0);

    }

    /**
     * 文件名过滤：列出给定目录的所有.java文件
     * @param file
     */
    private static void showFileName(File file){
        String[] fileName = file.list(new FilenameFilter(){//匿名内部类

            /**
             * Tests if a specified file should be included in a file list.
             *
             * @param dir  the directory in which the file was found.
             * @param name the name of the file.
             * @return <code>true</code> if and only if the name should be
             * included in the file list; <code>false</code> otherwise.
             */
            @Override
            public boolean accept(File dir, String name) {//复写唯一方法
                return name.endsWith(".java");//列出所有.java文件
            }
        });

    }

    /**
     * 指出指定目录下的所有文件和文件夹(递归)
     * 示例1:不带层次递归
     * @param dir
     */
    private static void showDir(File dir){
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length;i++){
            if (files[i].isDirectory()&&!files[i].isHidden()){
                showDir(files[i]);
            }else {
                System.out.println(files[i]);
            }
        }
    }
    /**
     * 指出指定目录下的所有文件和文件夹(递归)
     * 示例2:带层次递归
     * @param dir
     * @param level
     */
    private static void showDir(File dir,int level){
        System.out.println(getLevel(level));
        level++;
        File[] files =dir.listFiles();
        for (int i =0; i < files.length; i++){
            if (files[i].isDirectory() && !files[i].isHidden()){
                showDir(files[i],level);
            }else {
                System.out.println(getLevel(level)+files[i]);//是文件就打印层次和目录
            }
        }
    }

    private static String getLevel(int level){
//        System.out.println("|--");
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        for (int i = 0; i < level; i++){
            sb.append( "-|");
        }

        return sb.toString();
    }

    /**
     * 需求：
     * 删除带内容的目录
     * @param dir
     */
    private static void removeDir(File dir){
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory() && !files[i].isHidden()){
                removeDir(files[i]);//如果是文件夹则继续递归遍历
            }else {//如果是文件则删除，注意删除的时候打印删除的结果，防止误删除或者重删除的情况
                System.out.println(files[i].toString()+"::"+files[i].delete());
            }
            System.out.println(dir+"::"+dir.delete());
        }
    }

    /**
     * 需求:
     * 将指定目录下的java文件的绝对路径存储到文件文件中
     * 思路：
     * 对指定的目录进行递归
     * 获取递归过程中所有java文件的路径
     * 将这些路径存储到集合中
     * 将集合汇总的数据写入文件中
     * @param file
     * @param arrayList
     */

    //对指定目录进行递归并将所有Java文件存储到集合中
    private static void getFileName(File file, ArrayList<File> arrayList) throws IOException{
        File[] files = file.listFiles();
        for (int i = 0; i < files.length;i++){
            if (files[i].isDirectory() && !files[i].isHidden()){
                getFileName(files[i],arrayList);
            }else {
                if (files[i].getName().endsWith(".java")){
                    arrayList.add(files[i]);
                }
            }
        }
        File fil = new File("D:\\MyFile\\workLearning\\spark\\src\\files\\saveFile.text");
        saveFileToNewDir(arrayList, fil);
    }
    //将集合中所有数据存储到新文件中
    private static void saveFileToNewDir(ArrayList<File> arrayList,File newDir) throws IOException {
        BufferedWriter bufw = null;
        try{
            bufw = new BufferedWriter(new FileWriter(newDir));
            for (File file:arrayList){
                String fileAbsolutePath = file.getAbsolutePath();
                bufw.write(fileAbsolutePath);
                bufw.newLine();
                bufw.flush();
            }
        }catch (Exception e){
            System.out.println("文件写入失败");
        }finally {
            try{
                if (bufw != null){
                    bufw.close();
                }
            }catch (Exception e2){
                System.out.println("文件写入流关闭失败");
            }
        }

    }


    /**
     * 遍历目录
     */

    public static void list(File file,int i) {
        File[] list=file.listFiles();
        String flag=dealIndex(i);
        for (File file1 : list) {
            if (file1.isDirectory()) {
                i++;
                System.out.println(flag+file1.getName());
                list(file1,i);
                i--;
            }else{
                System.out.println(flag+file1.getName());
            }

        }

    }
    private static String dealIndex(int index) {
        StringBuffer flag=new StringBuffer();
        for (int i = 0; i < index; i++) {
            flag.append("|_ ");
        }
        return flag.toString();
    }

}

