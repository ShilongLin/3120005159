package text;

import com.comparator.Comparator;

import java.io.*;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;

public class ForHomework {
    public static void main(String[] args) throws IOException {
        String oriText=getTextFromURL(args[0]);
        String comText=getTextFromURL(args[1]);
        System.out.println("相似度（向量余弦）："+Comparator.getConsineSimilarity(oriText,comText)*100+"%");
        writeResultforURL(args[2],"相似度（向量余弦）："+Comparator.getConsineSimilarity(oriText,comText)*100+"%");
    }

    public static String getTextFromURL(String URL) throws IOException {
        StringBuilder text= new StringBuilder();
        BufferedReader brin=new BufferedReader(new FileReader(URL));
        String temp;
        int flag=1;
        while ((temp=brin.readLine())!=null){
            if(flag==1){
                text.append(temp);
                flag=0;
            }else {
                text.append("\n").append(temp);
            }
        }
        brin.close();
        return text.toString();
    }

    public static void writeResultforURL(String URL,String message) throws IOException {
        BufferedWriter bout=new BufferedWriter(new FileWriter(URL));
        bout.write(message);
        bout.flush();
        bout.close();
    }

}
