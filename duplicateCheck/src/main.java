import java.text.DecimalFormat;

public class main {
    /*
    * 命令行版
    * */
    public static void main(String[] args) {
        compareText comTool=new compareText();
        compareText.setOriTextURL(args[0]);
        compareText.setComTextURL(args[1]);
        compareText.setComResult(args[2]);
        // 保留两位小数
        DecimalFormat df=new DecimalFormat("#0.00");
        System.out.println("成功对比文章，结果已打印在答案文件中");
        System.out.println("=====原文=====");
        System.out.println(comTool.getOriText());
        System.out.println("=====对比文章=====");
        System.out.println(comTool.getComText());
        System.out.println("=====对比结果=====");
        System.out.println("重复率："+df.format(comTool.getRepetitionRate()));
        System.out.println("重复内容："+comTool.getRepeatStrings());
        comTool.getResultToTxt();
    }
}
