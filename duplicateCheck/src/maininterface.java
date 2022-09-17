import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class maininterface {
    private JPanel mainbox;
    private JPanel originalBox;
    private JTextField oriTextURL;
    private JButton oriConfig;
    private JLabel tip1;
    private JPanel compareBox;
    private JLabel tip2;
    private JTextField comTextURL;
    private JButton comConfig;
    private JPanel showArea;
    private JPanel showOriginalTextArea;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JPanel showCompareTextArea;
    private JPanel showResult;
    private JButton compareBtn;
    private JTextArea textArea3;
    private JPanel resultBox;
    private JTextField resTextURL;
    private JButton resConfig;


    public void startInterface() throws IOException {
        // 配置组件的属性
        textArea1.setEditable(false);
        textArea2.setEditable(false);
        textArea3.setEditable(false);

        JFrame jFrame=new JFrame("maininterface");
        jFrame.setContentPane(this.mainbox);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(680,680);

        // 引入compareText类
        compareText comTool=new compareText();


        /*
        * 按钮的属性设置
        * */
        this.oriConfig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oriURLFlag=oriTextURL.getText();
                if(JOptionPane.showConfirmDialog(jFrame,"原文绝对地址是否为："+oriURLFlag,"请确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                    comTool.setOriTextURL(oriURLFlag);
                }
                textArea1.setText(comTool.getOriText());
            }
        });
        this.comConfig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String comURLFlag=comTextURL.getText();
                if(JOptionPane.showConfirmDialog(jFrame,"对比文章绝对地址是否为："+comURLFlag,"请确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                    comTool.setComTextURL(comURLFlag);
                }
                textArea2.setText(comTool.getComText());
            }
        });

        this.resConfig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(JOptionPane.showConfirmDialog(jFrame,"答案文章绝对地址是否为："+resTextURL.getText(),"请确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                    comTool.setComResult(resTextURL.getText());
                }
            }
        });

        this.compareBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comTool.getResultToTxt();
                System.out.println("查重率为"+comTool.getRepetitionRate());
                textArea3.setText(comTool.getComResultTxt());
            }
        });
    }

}
