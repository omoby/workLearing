package docx2xml;


/**
 * @ClassName Docx2XMLUtilTest
 * @Author zhangqx02
 * @Date 2019/12/4 16:12
 * @Description
 * docx文档转换为xml文档的测试类
 */

public class Docx2XMLUtilTest {
    //docx文件所在文件路径
    private static final String docxFilePath = "D:\\MyFile\\workLearning\\spark\\src\\files\\docx2xml3.docx";
    //生成的xml文件保存路径
    private static final String xmlFileSavePath = "D:\\MyFile\\workLearning\\spark\\src\\files\\docx2xml3.xml";
    //表格录入人
    private static final String author = "zhangqx02";
    public static void main(String[] args){
        Docx2XMLUtil util = new Docx2XMLUtil();
        util.setDocxFilePath(docxFilePath);
        util.setAuthor(author);
        util.setXmlFileSavePath(xmlFileSavePath);
        util.getTableData();
    }
}
