import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class compareText {
    private static String oriTextURL;
    private static String comTextURL;
    private static String oriText;
    private static String comText;
    public compareText() throws IOException {
//        this.oriTextURL=oriTextURL;
//        this.comTextURL=comTextURL;
//        Scanner scanner=new Scanner(System.in);
//        BufferedReader brin=new BufferedReader(new FileReader(oriTextURL));
//        oriText=brin.readLine();
//        System.out.println(oriText);
    }

    class UrlException extends RuntimeException{

        public UrlException(String message){
            super(message);
        }

    }

    public static void setOriTextURL(String oriTextURL) {
        try {
            BufferedReader brin=new BufferedReader(new FileReader(oriTextURL));
            compareText.oriTextURL=oriTextURL;
            String temp;
            String sumText="";
            temp=brin.readLine();
            while (temp!=null){
                sumText+=temp+'\n';
                temp=brin.readLine();
            }
            setOriText(sumText);
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
            BufferedReader brin=new BufferedReader(new FileReader(oriTextURL));
            compareText.comTextURL=comTextURL;
            String temp;
            String sumText="";
            temp=brin.readLine();
            while (temp!=null){
                sumText+=temp+'\n';
                temp=brin.readLine();
            }
            setComText(sumText);
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

    public static String getOriTextURL() {
        return oriTextURL;
    }

    public static String getComTextURL() {
        return comTextURL;
    }

    public static String getOriText() {
        return oriText;
    }

    public static String getComText() {
        return comText;
    }
}
