// package test;
import java.awt.*;
import java.lang.String;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// import 
public class jisuanqi extends JFrame implements ActionListener{
    private final String[] str = {"1","2","3","/","4","5","6","*","7","8","9","-","0",".","=","+"};
    JButton[] btn = new JButton[str.length];
    JButton res = new JButton("CE");
    JTextField display = new JTextField("0"); //默认显示0

    public jisuanqi(){
        JPanel head = new JPanel(new BorderLayout());   //创建头部面板
        head.add(display,BorderLayout.CENTER);          //将显示区域设为自动
        head.add(res,BorderLayout.EAST);                //将清空键放置头部面板的右边

        JPanel boot = new JPanel(new GridLayout(4,4)); //创建按钮面板
        for(int i = 0; i < str.length; i++){                        //遍历对象数组并生成为按钮
            btn[i] = new JButton(str[i]);
            boot.add(btn[i]);
        }

        getContentPane().setLayout(new BorderLayout());//创建容器并设置容器的布局风格
         getContentPane().add(head,BorderLayout.NORTH);    //将头部面板添加到顶部的位置
         getContentPane().add(boot,BorderLayout.CENTER);   //将按钮面板添加到底部的位置

        for(int i = 0; i < str.length; i++){                //监听按钮
            btn[i].addActionListener(this);
        }
        res.addActionListener(this);
        display.addActionListener(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300,280);
        setVisible(true);
    }

    String S = ".0123456789";
    public void actionPerformed(ActionEvent e){
        Object target = e.getSource();  //事件源
        String cmd = e.getActionCommand();//获取按钮上的符号
        if(target == res){
            handleReset();
        }else if(S.indexOf(cmd) > 0){
            handleNumber(cmd);
        }else{
            handleOperator(cmd);
        }
    }

    boolean isFirst = true;
    double number = 0;
    String fuhao = "=";

    public void handleNumber(String key){   //操作数字
        if(isFirst){
            display.setText(key);
        }else if(!key.equals(".")){     //判断key的值是否为小数点
            display.setText(display.getText() + key);
        }
        isFirst = false;
    }

    public void handleOperator(String key){  //操作计算符号
        double dis = Double.valueOf(display.getText());
        switch (fuhao) {
            case "+":
                number += dis;
                break;
            case "-":
                number -= dis;
                break;
            case "*":
                number *= dis;
                break;
            case "/":
                number /= dis;
                break;
            case "=":
                number = dis;
                break;
            default:
                break;
        }
        display.setText(String.valueOf(number));
        fuhao = key;
        isFirst = true;
    }

    public void handleReset(){  //清空
        display.setText("0");
        isFirst = true;
        fuhao = "=";
    }

    public static void main(String[] args){
       jisuanqi win = new jisuanqi();
       win.setTitle("计算器");
    }
}