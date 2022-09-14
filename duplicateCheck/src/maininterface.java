import javax.swing.*;

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

    public void startInterface(){
        JFrame jFrame=new JFrame("maininterface");
        maininterface test=new maininterface();
        jFrame.setContentPane(test.mainbox);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(680,680);
    }

}
