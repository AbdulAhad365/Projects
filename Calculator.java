import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
public class calculator implements ActionListener {
    JFrame frame;
    JTextField field;
    JButton number[]=new JButton[10];
    JButton operators[]=new JButton[6];
    JButton addition,subtraction,multiply,divide,decimal,tan,cos,sin;
    JButton clear,del,equal,reminder;
    JPanel panel;
    double a=0,b=0,ans=0;
    char c;
    String store;
    calculator(){
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,600);
        frame.setResizable(false);
        frame.setLayout(null);
        //------------------    FRAME   --------------
        field=new JTextField("");
        field.setEditable(false);
        field.setBounds(100,50,200,25);
        frame.add(field);
        field.setHorizontalAlignment(JTextField.TRAILING);



        //------------Background color


        addition=new JButton("+");
        subtraction=new JButton("-");
        multiply=new JButton("*");
        divide=new JButton("/");
        clear=new JButton("CLR");
        del=new JButton("Delete");

        operators[0]=addition;
        operators[1]=subtraction;
        operators[2]=multiply;
        operators[3]=divide;
        operators[4]=clear;
        operators[5]=del;

        for(int i=0;i<6;i++){
            operators[i].addActionListener(this);
            operators[i].setFocusable(false);
        }
        for(int i=0;i<10;i++){
            number[i]=new JButton(String.valueOf(i));
            number[i].addActionListener(this);
            number[i].setFocusable(false);
        }

        decimal=new JButton(".");
        decimal.setText(".");
        decimal.setFocusable(false);
        decimal.addActionListener(this);

        tan=new JButton("tan");

        tan.setFocusable(false);
        tan.setText("tan");
        tan.addActionListener(this);

        sin=new JButton("sin");
        sin.setFocusable(false);
        sin.setText("sin");
        sin.addActionListener(this);

        cos=new JButton("cos");
        cos.setFocusable(false);
        cos.setText("cos");
        cos.addActionListener(this);

        reminder=new JButton("%");
        reminder.setFocusable(false);
        reminder.setText("%");
        reminder.addActionListener(this);


        equal=new JButton("=");
        equal.setFocusable(false);
        equal.addActionListener(this);
        //Make a panel
        panel=new JPanel();
        panel.setLayout(new GridLayout(4,4,0,0));


        panel.add(number[1]);
        panel.add(number[2]);
        panel.add(number[3]);
        panel.add(operators[0]);

        panel.add(number[4]);
        panel.add(number[5]);
        panel.add(number[6]);
        panel.add(equal);



        panel.add(number[7]);
        panel.add(number[8]);
        panel.add(number[9]);
        panel.add(number[0]);
        panel.add(operators[1]);

        panel.add(operators[2]);

        panel.add(operators[3]);
        panel.add(operators[4]);
        panel.add(operators[5]);
        panel.add(decimal);

        panel.add(tan);
        panel.add(cos);
        panel.add(sin);
        panel.add(reminder);


        panel.setBounds(50,80,300,400);
        //panel.setBackground(Color.cyan);


        //add the deletion & the clear methord
        clear.setBounds(50,500,100,25);
        frame.add(clear);
        del.setBounds(200,500,100,25);
        frame.add(del);

        frame.getContentPane().setBackground(Color.GRAY);

        frame.add(panel);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++){
            if(e.getSource()==number[i]){
//                field.setEditable(true);
                field.setText(field.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decimal){
            field.setText(field.getText().concat("."));
        }
        //--------------------
        if(e.getSource()==subtraction){
            a=Double.parseDouble(field.getText());
            field.setText("");
            c='-';
        }
        if(e.getSource()==reminder){
            a=Double.parseDouble(field.getText());
            field.setText("");
            c='%';
        }
        if(e.getSource()==tan || field.getText().equals("tan")){
                a=Double.parseDouble(field.getText());
                field.setText("");
                field.setText(String.valueOf(Math.tan(a)));
        }
        if(e.getSource()==cos || field.getText().equals("cos")){
            a=Double.parseDouble(field.getText());
            field.setText("");
            field.setText(String.valueOf(Math.cos(a)));
        }
        if(e.getSource()==sin || field.getText().equals("sin")){
            a=Double.parseDouble(field.getText());
            field.setText("");
            field.setText(String.valueOf(Math.sin(a)));
        }

        if(e.getSource()==multiply){
            a=Double.parseDouble(field.getText());
            field.setText("");
            c='*';
        }

        if(e.getSource()==divide){
            a=Double.parseDouble(field.getText());
            field.setText("");
            c='/';
        }

        if(e.getSource()==addition){
            a=Double.parseDouble(field.getText());
            field.setText("");
            c='+';
        }
        if(e.getSource()==clear){

            field.setText("");
            a=0;
            b=0;
            c=' ';
        }
        if(e.getSource()==del){
            String s=field.getText();
            field.setText("");
            System.out.println(s);
            if(s.length()>0){
                for(int i=0;i<s.length()-1;i++){
                    field.setText(field.getText()+s.charAt(i));
                }
            }
        }
        if(e.getSource()==equal){
            b=Double.parseDouble(field.getText());
            field.setText("");

            switch (c){
                case '+':
                    ans=a+b;
                    field.setText(String.valueOf(ans));
                    break;

                case '-':
                    ans=a-b;
                    field.setText(String.valueOf(ans));
                    break;
                case '*':
                    ans=a*b;
                    field.setText(String.valueOf(ans));
                    break;
                case '/':
                    ans=a/b;
                    field.setText(String.valueOf(ans));
                    break;
                case '%':
                    ans=a%b;
                    field.setText(String.valueOf(ans));
                    break;

            }
            a=ans;

        }


    }
}
