package bj.Java1200.col01.ch18_文件的读取_写入_整理和控制.ch18_3_文件控制._449;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatFrame extends JFrame {
    
    private JPanel contentPane;
    private JTextField pathTextField;
    private JTextArea resultTextArea = new JTextArea();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StatFrame frame = new StatFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public StatFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 371, 220);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("统计txt文件字符数");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 355, 262);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel messageLabel = new JLabel("选择文件：");
        messageLabel.setBounds(0, 22, 70, 22);
        panel.add(messageLabel);
        
        pathTextField = new JTextField();
        pathTextField.setBounds(63, 23, 202, 21);
        panel.add(pathTextField);
        pathTextField.setColumns(10);
        
        JButton chooseButton = new JButton("选择");
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_chooseButton_actionPerformed(arg0);
            }
        });
        chooseButton.setBounds(275, 22, 77, 23);
        panel.add(chooseButton);
        
       
        resultTextArea.setBounds(0, 54, 352, 134);
        panel.add(resultTextArea);
    }
    
    // 选择按钮的单击事件方法
    protected void do_chooseButton_actionPerformed(ActionEvent arg0) {
        FileDialog fd = new FileDialog(this);
        fd.setVisible(true);
        String filePath = fd.getDirectory() + fd.getFile();
        if (filePath.endsWith(".txt")) {
            pathTextField.setText(filePath);
            StatUtil util = new StatUtil();
            int[] sum = util.statis(filePath);
            int number = sum[0];
            int word = sum[1];
            int total = sum[2];
            int sumNumber = sum[3];
            resultTextArea.setText("统计结果为：\n"+"数字总数为："+number+"\n字母数为："+word+"\n英文标点为："+total+"\n总字符数为："+sumNumber);
        }
    }
}
