package bj.Java1200.col01.ch24_数据库高级应用.ch24_3_使用批处理._596_在批处理中使用事务;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class TransitionFrame extends JFrame {
    
    private JPanel contentPane;
    private JLabel shiftLabel;
    private JLabel monthLabel;
    private JTextField moneyTextField;
    private JButton closeButton;
    private JComboBox idComboBox ;
    private JComboBox comeComboBox;
    private BatchAffair batchAffair = new BatchAffair();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TransitionFrame frame = new TransitionFrame();
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
    public TransitionFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 375, 248);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("转账窗体");
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 359, 210);
        contentPane.add(panel);
        panel.setLayout(null);
        List list = batchAffair.selectIds();
        String ids[] = new String[list.size()];
        for(int i = 0;i<list.size();i++){
            ids[i] = list.get(i).toString();
        }
        JLabel idLabel = new JLabel("转帐账户：");
        idLabel.setBounds(61, 24, 65, 15);
        panel.add(idLabel);
        
        shiftLabel = new JLabel("转入账户：");
        shiftLabel.setBounds(61, 64, 65, 15);
        panel.add(shiftLabel);
        
        monthLabel = new JLabel("转账金额：");
        monthLabel.setBounds(61, 107, 65, 15);
        panel.add(monthLabel);
        
        moneyTextField = new JTextField();
        moneyTextField.setBounds(136, 104, 162, 21);
        panel.add(moneyTextField);
        moneyTextField.setColumns(10);
        
        JButton transitionButton = new JButton("转账");
        transitionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_transitionButton_actionPerformed(arg0);
            }
        });
        transitionButton.setBounds(87, 148, 65, 23);
        panel.add(transitionButton);
        
        closeButton = new JButton("关闭");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                do_closeButton_actionPerformed(arg0);
            }
        });
        closeButton.setBounds(202, 148, 65, 23);
        panel.add(closeButton);
        
        idComboBox = new JComboBox(ids);
        idComboBox.setBounds(136, 21, 162, 21);
        panel.add(idComboBox);
        
        comeComboBox = new JComboBox(ids);
        comeComboBox.setBounds(136, 61, 162, 21);
        panel.add(comeComboBox);
    }
    
    // 转账按钮的单击事件
    protected void do_transitionButton_actionPerformed(ActionEvent arg0) {
        String comeNumber = comeComboBox.getSelectedItem().toString();
        String goNumber = idComboBox.getSelectedItem().toString();
        float month = Float.parseFloat(moneyTextField.getText());
        try {
            batchAffair.Batch(comeNumber, goNumber, month);
            JOptionPane.showMessageDialog(getContentPane(), 
                    "转账成功！", "信息提示框", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            JOptionPane.showMessageDialog(getContentPane(), 
                    "转账失败！", "信息提示框", JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    // 关闭按钮的单击事件
    protected void do_closeButton_actionPerformed(ActionEvent arg0) {
        System.exit(0);
    }
}
