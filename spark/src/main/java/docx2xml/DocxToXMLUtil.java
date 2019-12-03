package docx2xml;


import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName DocxToXMLUtil
 * @Author zhangqx02
 * @Date 2019/12/3 9:12
 * @Description
 * 将docx文档章的表格转化为xml文档
 */

public class DocxToXMLUtil {
    public static void  main(String[] args){
        DocxToXMLUtil test = new DocxToXMLUtil();
        String docxPath = "D:\\MyFile\\workLearning\\spark\\src\\files\\docx2xml.docx";
        String author = "zhangqx02";
        getTableData(docxPath,author);
    }
    private static void getTableData(String filePath,String author){
        try {
            FileInputStream in = new FileInputStream(filePath);
            if (filePath.toLowerCase().endsWith("docx")){
                docx2xml(in,author);
            }else if (filePath.toLowerCase().endsWith(".doc")){
                doc2xml(in);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void docx2xml( FileInputStream in,String author){
        XWPFDocument document = null;
        try {
            document = new XWPFDocument(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Iterator<XWPFTable> tabItr = document.getTablesIterator();
        while (tabItr.hasNext()){
            String tableTagStart = "<table ";
            String tableId = "id=";
            String javaId = "javaId=";
            String tableName = "name=";
            String tableTagEnd = " >";
            String endTable ="<\\table>";
            StringBuffer headBuffer = new StringBuffer(tableTagStart);
            headBuffer.append(tableId+"\"\" ");
            headBuffer.append(javaId+"\"\" ");
            headBuffer.append(tableName+"\"\" ");
            headBuffer.append(tableTagEnd+"\n");
            StringBuffer tablexml = new StringBuffer(headBuffer.toString());
            String remInfo = "\t<rem>====================================================================</rem>\n" +
                    "\t<rem> 输入人:"+ author +" 输入时间： "+ getDate()+"</rem>\n" +
                    "\t<rem>table description</rem>\n" + "\t<rem>====================================================================</rem>\n";
            tablexml.append(remInfo);
            String tag = "\t<column ";
            String id = "id=";
            String type = "type=";
            String size = "size=";
            String primaryKey = "primaryKey=";
            String required = "required=";
            String name ="name=";
            String end = " />";
            XWPFTable table = tabItr.next();
            List<XWPFTableRow> rowList =table.getRows();
            for (int i = 1; i < rowList.size(); i++){
                StringBuffer rowBUffer = new StringBuffer(tag);
                XWPFTableRow row = rowList.get(i);
                List<XWPFTableCell> cellList = row.getTableCells();
                for (int j =0; j < cellList.size(); j++){

                    String cell = cellList.get(j).getText().toUpperCase();
                    switch (j){
                        case 0:
                            String newId = id+ "\""+cell +"\" ";
                            rowBUffer.append(newId);
                            break;
                        case 1:
                            if (cell.contains("(")){
                                int startIndex = cell.indexOf("(");
                                int endIndex = cell.indexOf(")");
                                String cellType = cell.substring(0,startIndex);
                                String cellSize = cell.substring(startIndex+1,endIndex);
                                String newType = type+ "\""+cellType+"\" ";
                                rowBUffer.append(newType);
                                String newSize = size+"\""+cellSize+"\" ";
                                rowBUffer.append(newSize);
                            }else {
                                String newType = type+"\""+cell+"\" ";
                                rowBUffer.append(newType);
                            }
                            break;
                        case 2:
                            break;
                        case 3:
                            if (cell.contains(",")){
                                String newPrimaryKey = "";
                                String newRequired = "";
                                if (cell.contains("主键")){
                                    newPrimaryKey = primaryKey +"\"true\" ";
                                }else{
                                    newPrimaryKey = primaryKey +"\"false\" ";
                                }
                                if (cell.contains("非空")){
                                    newRequired = required +"\"true\" ";
                                }else {
                                    newRequired = required +"\"false\" ";
                                }
                                rowBUffer.append(newPrimaryKey);
                                rowBUffer.append(newRequired);
                            }
                            break;
                        case 4:
                            String newName = name +"\""+cell +"\"";
                            rowBUffer.append(newName);
                            rowBUffer.append(end);
                            break;
                            default:
                    }
                }


                tablexml.append(rowBUffer.toString()+"\n");
            }
            String xmlString = tablexml.toString()+endTable+"\n\n\n\n";
            testPrint("xmlString", xmlString);
            saveXml(xmlString);
        }

//        testPrint("tableList",tableList.toString());
    }
    private static void doc2xml(FileInputStream in){

    }

    private static void testPrint(String message,String out){
        System.out.println(message+" : "+out);
    }
    private static String getDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        return df.format(new Date());
    }
    private static void saveXml(String data){
        String saveXmlPath = "D:\\MyFile\\workLearning\\spark\\src\\files\\docx2xml.xml";
        try {
            FileWriter fw = new FileWriter(saveXmlPath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
            fw.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
