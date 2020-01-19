package WindowFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class WinProcess extends JFrame {
    private JTextField textField_1 = new JTextField(30);
    private JTextField textField_2 = new JTextField(30);

    public WinProcess(){
        this.InitJFrame("demo");
    }

    private void InitJFrame(String title){
        JFrame jFrame = new JFrame(title);
        //添加框体的布局方式
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        //分部组件
        //下载标题
        jFrame.add(this.InitTitlePanel("下载工具："));

        //输入框组
        jFrame.add(InitContent("请输入对应的文本文件路径：",textField_1));
        jFrame.add(InitContent("请输入文件的项目保存路径：",textField_2));

        jFrame.add(this.InitTips());
        //窗口大小设定
        jFrame.setBounds(new Rectangle(500,250,800,600));
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private JPanel InitTitlePanel(String title){
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(null);
        titlePanel.setPreferredSize(new Dimension(500, 30));

        JLabel jTitle = new JLabel(title);
        jTitle.setBounds(20, 5, 700, 20);
        jTitle.setFont(new Font("楷体",Font.BOLD,18));

        titlePanel.add(jTitle);
        return titlePanel;
    }


    private JPanel InitContent(String text,JTextField textField){
        JPanel content = new JPanel(){
            private static final long serialVersionUID = 1L;
            @Override
            public void paint(Graphics g) {
                super.paint(g);
            }
        };
        content.setPreferredSize(new Dimension(500, 35));

        JPanel jPanel = new JPanel();
        JLabel title_1 = new JLabel(text);
        textField.setFont(new Font("楷体",Font.PLAIN,16));
        textField.setEditable(false);
        JButton button = new JButton("...");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowChoosePanel(textField);
            }
        });
        jPanel.add(title_1);
        jPanel.add(textField);
        jPanel.add(button);

        content.add(jPanel);
        return content;
    }

    private JPanel InitTips(){
        JPanel tipsPanel = new JPanel();

        JLabel tipContent = new JLabel();
        tipContent.setText("<html><body>Tips:<br>1.注意文本文件的文件名为import.txt或者asset.txt<br>2.注意所填的数据不能为空或者有空格<br>3.我也不知道还要注意啥，反正有什么问题或者bug告诉我即可</html></body>");
        tipContent.setFont(new Font("楷体",Font.BOLD,16));
        tipContent.setForeground(Color.red);
        tipContent.setBounds(new Rectangle(500,300));

        JButton clickButton = new JButton("submit");
        clickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickButton.setEnabled(false);
                if(CheckDataCorrect()){

                }
                clickButton.setEnabled(true);
            }
        });

        tipsPanel.add(tipContent);
        tipsPanel.add(clickButton);
        return tipsPanel;
    }


    private void ShowChoosePanel(JTextField textField){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.showDialog(new JLabel(),"选择");
        File file = fileChooser.getSelectedFile();
        if(file != null){
            textField.setText(file.getAbsolutePath());
        }
    }

    private boolean CheckDataCorrect(){
        if(textField_1.getText() == null || textField_1.getText().isEmpty() || textField_2.getText() == null || textField_2.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "输入的数据不能为空或空格!!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        File txtFile = new File(textField_1.getText());
        if(!txtFile.exists()){
            JOptionPane.showMessageDialog(null, "Txt文本错误：目标文件不存在!!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            if(!txtFile.getName().equals("import.txt")){
                if(!txtFile.getName().equals("assets.txt")){
                    JOptionPane.showMessageDialog(null, "Txt文本错误：请按照要求对文件进行命名!!", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

            }
        }
        File saveFile = new File(textField_2.getText());
        if(!saveFile.exists()){
            JOptionPane.showMessageDialog(null, "SaveFile错误：目标文件不存在!!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(!saveFile.isDirectory()){
            JOptionPane.showMessageDialog(null, "SaveFile错误：请选择文件夹!!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
