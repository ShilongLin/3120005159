package text;

import com.comparator.compareText;

import java.text.DecimalFormat;

public class Main {
    /*
    * =========================================
    * command line
    * */
    public static void main(String[] args) {
        // get parameter
        compareText comTool=new compareText();
        compareText.setOriTextURL(args[0]);
        compareText.setComTextURL(args[1]);
        compareText.setComResult(args[2]);

        // Keep two decimal places
        DecimalFormat df=new DecimalFormat("#0.00");

        // print result
        System.out.println("成功对比文章，结果已打印在答案文件中");
        System.out.println("=====原文=====");
        System.out.println(compareText.getOriText());
        System.out.println("=====对比文章=====");
        System.out.println(compareText.getComText());
        System.out.println("=====对比结果=====");
        System.out.println("重复率："+df.format(comTool.getRepetitionRate()));
        System.out.println("相似度（向量余弦）："+compareText.getSimilarity()*100+"%");
        System.out.println("重复内容："+ compareText.getRepeatStrings());
        comTool.getResultToTxt();
    }
}
