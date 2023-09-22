import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniState extends JFrame {
    JLabel banktext,mini,card,Balance;
    String pinNum;
    MiniState(String pinNum){
        this.pinNum=pinNum;
        setLayout(null);

        setTitle("Mini Statement");



        banktext=new JLabel("Bit-C Bank");
        banktext.setBounds(150,10,120,20);
        banktext.setFont(new Font("System",Font.BOLD,19));
        add(banktext);

        card=new JLabel();
        card.setBounds(20,60,400,20);
        card.setFont(new Font("RaleWay",Font.PLAIN,15));
        add(card);

        mini=new JLabel();
        add(mini);

        Balance=new JLabel();
        add(Balance);

        try {
           conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from login where pinNumber='5463'");
           while (rs.next()){
               card.setText("  Card Number     :           "+rs.getString("cardnumber").substring(0,4)+"-XXXX-"+rs.getString("cardnumber").substring(8,12)+"-XXXX");
           }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from banking where pin='"+pinNum+"'");
            int balance=0;
            while (rs.next()){
                mini.setText(mini.getText() + "<html>" +rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"  + rs.getString("type") +  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + " ₹ " +rs.getString("amount")+"<br>");
                if (rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else if (rs.getString("type").equals("Withdraw")){
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            Balance.setText("total current Balance : ₹ "+balance);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        mini.setBounds(20,120,550,400);
        mini.setFont(new Font("Raleway",Font.BOLD,15));

        Balance.setBounds(130,450,300,20);
        Balance.setFont(new Font("Raleway",Font.BOLD,18));

        setLocation(700,50);
        setSize(500,600);
        setBounds(800,50,500,600);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniState("");
    }
}
