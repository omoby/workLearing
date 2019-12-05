package docx2xml;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName Docx2XMLUtil
 * @Author zhangqx02
 * @Date 2019/12/4 15:22
 * @Description
 * 将docx文档章的表格转化为xml文档
 */

public class Docx2XMLUtil {
    private  String docxFilePath ;
    private  String xmlFileSavePath ;
    private  String author;

    public String getDocxFilePath() {
        return docxFilePath;
    }

    public void setDocxFilePath(String docxFilePath) {
        this.docxFilePath = docxFilePath;
    }

    public String getXmlFileSavePath() {
        return xmlFileSavePath;
    }

    public void setXmlFileSavePath(String xmlFileSavePath) {
        this.xmlFileSavePath = xmlFileSavePath;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void getTableData(){
        try {
            String filePath = getDocxFilePath();
            if (filePath.toLowerCase().endsWith("docx")){
                docx2xml();
            }else if (filePath.toLowerCase().endsWith(".doc")){
                doc2xml();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void docx2xml(){
        XWPFDocument document = getXWPFDocument();

        Iterator<XWPFTable> tabItr = document.getTablesIterator();
        String tableHeaderInfo = getTableHeader();
        String remInfo = getRemInfo();
        int tableIndex = 1;
        while (tabItr.hasNext()){
            StringBuffer tablexml = new StringBuffer(tableHeaderInfo);
            tablexml.append(remInfo);

            XWPFTable table = tabItr.next();
            String tableColumnInfo = getTableColumn(table);
            tablexml.append(tableColumnInfo);

            String xmlString = tablexml.toString()+getEndTableTag()+"\n\n\n\n";
            testPrint(String.valueOf(tableIndex), xmlString);
            saveXml(xmlString);
            tableIndex++;
        }
    }
    private  void doc2xml(){

    }

    /**
     * 打印测试
     * @param message
     * @param out
     */
    private  void testPrint(String message,String out){
        System.out.println(message+":\n"+out);
    }

    /**
     * 获取当前的日期，格式为yyyy.MM.dd
     * @return
     */
    private  String getDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        return df.format(new Date());
    }

    private  void saveXml(String data){
        String saveXmlPath = getXmlFileSavePath();
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

    /**
     * 判断数据类型是否有长度
     * @param cell
     * @return
     */
    private  boolean hasSize(String cell){
        if ("DATETIME".equalsIgnoreCase(cell)||"TEXT".equalsIgnoreCase(cell) || "TIMESTAMP".equalsIgnoreCase(cell) || "LONGTEXT".equalsIgnoreCase(cell)){
            return false;
        }
        return true;
    }

    /**
     * 判断表格格式，tableStyle标记表的格式，字段和长度在一起为true，分开为false
     * @param header
     * @return
     */
    private boolean getTableStyle(List<XWPFTableCell> header) {
        boolean isContains = false ;
        Iterator<XWPFTableCell> cellIterator = header.iterator();
        while (cellIterator.hasNext()){
            String cel = cellIterator.next().getText();
            if (cel.contains("长度")){
                isContains = true;
                break;
            }
        }
        return isContains;
    }

    /**
     * 获取文件输入流
     * @return
     */
    private FileInputStream getFileInputStream(){
        FileInputStream in = null;
        try {
            in = new FileInputStream(getDocxFilePath());
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return in;
    }

    /**
     * 获取docx文件流
     * @return
     */
    private XWPFDocument getXWPFDocument(){
       FileInputStream in = getFileInputStream();
       XWPFDocument document = null;
        try {
            document = new XWPFDocument(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    /**
     * 获取表同的格式
     * @return
     */
    private String getTableHeader(){
        String tableTagStart = "<table ";
        String tableId = "id=";
        String javaId = "javaId=";
        String tableName = "name=";
        String tableTagEnd = ">";
        StringBuffer headBuffer = new StringBuffer(tableTagStart);
        headBuffer.append(tableId+"\"\" ");
        headBuffer.append(javaId+"\"\" ");
        headBuffer.append(tableName+"\"\" ");
        headBuffer.append(tableTagEnd+"\n");
        return headBuffer.toString();
    }

    /**
     * 返回table的闭合标签
     * @return
     */
    private String getEndTableTag(){
        return "<\\table>";
    }

    /**
     * 获取创建人的信息
     * @return
     */
    private  String getRemInfo(){
        String remInfo = "\t<rem>====================================================================</rem>\n" +
                        "\t<rem> 输入人:"+ author +"\t输入时间："+ getDate()+"</rem>\n" +
                         "\t<rem>table description</rem>\n"+
                        "\t<rem>====================================================================</rem>\n";
        return remInfo;
    }

    /**
     * 遍历获取每一列的数据
     * @param table
     * @return
     */
    private String getTableColumn(XWPFTable table) {
        String tag = "\t<column ";
        String id = "id=";
        String type = "type=";
        String size = "size=";
        String primaryKey = "primaryKey=";
        String required = "required=";
        String name = "name=";
        String end = " />\n";
        StringBuffer tableColumsBuffer = new StringBuffer();
        List<XWPFTableRow> rowList = table.getRows();
        //tableStyle标记表的格式，字段和长度在一起为true，分开为false
        boolean tableStyle = false;
        tableStyle = getTableStyle(rowList.get(0).getTableCells());

        for (int i = 1; i < rowList.size(); i++) {
            StringBuffer rowBUffer = new StringBuffer(tag);
            XWPFTableRow row = rowList.get(i);
            List<XWPFTableCell> cellList = row.getTableCells();
            boolean isHasSize = false;
            for (int j = 0; j < cellList.size(); j++) {
                String cell = cellList.get(j).getText().trim().toUpperCase();
                switch (j) {
                    case 0:
                        String newId = id + "\"" + cell + "\" ";
                        rowBUffer.append(newId);
                        break;
                    case 1:
                        if (!tableStyle){
                            if (cell.contains("(")) {
                                int startIndex = cell.indexOf("(");
                                int endIndex = cell.indexOf(")");
                                String cellType = cell.substring(0, startIndex);
                                String cellSize = cell.substring(startIndex + 1, endIndex);
                                String newType = type + "\"" + cellType + "\" ";
                                rowBUffer.append(newType);
                                String newSize = size + "\"" + cellSize + "\" ";
                                rowBUffer.append(newSize);
                            } else {
                                String newType = type + "\"" + cell + "\" ";
                                rowBUffer.append(newType);
                            }
                        }else {
                            isHasSize = hasSize(cell);
                            String newType = type + "\"" + cell + "\" ";
                            rowBUffer.append(newType);
                        }
                        break;
                    case 2:
                        if (isHasSize) {
                            String newSize = size + "\"" +cell + "\" ";
                            rowBUffer.append(newSize);
                            isHasSize = false;
                        }
                        break;
                    case 3:
                        String newPrimaryKey = "";
                        String newRequired = "";
                        if (cell.contains("主键")) {
                            newPrimaryKey = primaryKey + "\"true\" ";
                        } else {
                            newPrimaryKey = primaryKey + "\"false\" ";
                        }
                        if (cell.contains("非空")) {
                            newRequired = required + "\"true\" ";
                        } else {
                            newRequired = required + "\"false\" ";
                        }
                        rowBUffer.append(newPrimaryKey);
                        rowBUffer.append(newRequired);
                        break;
                    case 4:
                        String newName = name + "\"" + cell + "\"";
                        rowBUffer.append(newName);
                        rowBUffer.append(end);
                        break;
                    default:
                }
            }
            tableColumsBuffer.append(rowBUffer.toString());
        }
        return tableColumsBuffer.toString();
    }
}
