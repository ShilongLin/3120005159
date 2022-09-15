import javax.swing.*;
import java.io.*;

public class compareText {
    /*
    * 依次为：
    * - 原文绝对地址
    * - 对比文地址
    * - 原文
    * - 对比文
    *
    * */
    private static String oriTextURL;
    private static String comTextURL;
    private static String oriText;
    private static String comText;

    private static File comResult;

    /*
    * 构造方法
    * */
    public compareText() {
        comResult=new File("src/data/ans.txt");


    }

    /*
    * 查重率方法
    * */
    public float getRepetitionRate(){
        // 构建两个可改变的数组
        String oriCharArray=oriText;
        String comCharArray=comText;

        // repeatCahrNum为重复字符的个数
        int repeatCharNum=0;
        for(int i=0;i<comCharArray.length();i++){
            int j;
            for(j=0;j<oriCharArray.length();j++){
                if(comCharArray.charAt(i)==oriCharArray.charAt(j)){
                    repeatCharNum++;
                    oriCharArray=removeCharAt(oriCharArray,j);
                    break;
                }
            }
        }

        return (float) repeatCharNum/(float) oriText.length();
    }

    /*
    * 删除字符串中的某个位置字符
    * */
    public static String removeCharAt(String s,int pos){
        return s.substring(0,pos)+s.substring(pos+1);
    }

    /*
    * Set方法和Get方法
    * */
    public static void setOriTextURL(String oriTextURL) {
        try {
            BufferedReader brin=new BufferedReader(new FileReader(oriTextURL));
            compareText.oriTextURL=oriTextURL;
            String temp;
            StringBuilder sumText= new StringBuilder();
            temp=brin.readLine();
            while (temp!=null){
                sumText.append(temp).append('\n');
                temp=brin.readLine();
            }
            setOriText(sumText.toString());
            brin.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"您填入的绝对地址不正确，请重新输入！","错误",JOptionPane.WARNING_MESSAGE);
            setOriText(null);
            compareText.oriTextURL=null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setComTextURL(String comTextURL) {
        try {
            BufferedReader brin=new BufferedReader(new FileReader(comTextURL));
            compareText.comTextURL=comTextURL;
            String temp;
            StringBuilder sumText= new StringBuilder();
            temp=brin.readLine();
            while (temp!=null){
                sumText.append(temp).append('\n');
                temp=brin.readLine();
            }
            setComText(sumText.toString());
            brin.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"您填入的绝对地址不正确，请重新输入！","错误",JOptionPane.WARNING_MESSAGE);
            setComText(null);
            compareText.comTextURL=null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setOriText(String oriText) {
        compareText.oriText = oriText;
    }

    public static void setComText(String comText) {
        compareText.comText = comText;
    }

    public static String getOriText() {
        return oriText;
    }

    public static String getComText() {
        return comText;
    }

    public static void setComResult(String ansURL) {
        compareText.comResult = new File(ansURL);
    }
}
