import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Balance_ry extends JFrame implements ActionListener {
    JLabel image,Balance,scrtext;
    String pinNum;
    JButton back;
    Balance_ry(String pinNum){
        this.pinNum=pinNum;
        setLayout(null);

        ImageIcon mg=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img=mg.getImage().getScaledInstance(800,900,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(img);
        image=new JLabel(img2);
        image.setBounds(0,0,800,900);
        add(image);

        Balance=new JLabel("Your ");

        back=new JButton("Back");
        back.setBounds(220,470,150,20);
        back.setFont(new Font("Raleway",Font.BOLD,17));
        back.setBackground(new Color(255,0,0));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);


        int Balance=0;
        conn c=new conn();
        try {
            ResultSet rs=c.s.executeQuery("select * from banking where pin='"+pinNum+"'");
            while (rs.next()){
                if (rs.getString("type").equals("Deposit")){
                    Balance+=Integer.parseInt(rs.getString("amount"));
                }
                else {
                    Balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        scrtext=new JLabel("<html>Your Total Balance Is\n\n ₹  "+Balance+"/- </html>");
        scrtext.setBounds(210,350,250,50);
        scrtext.setFont(new Font("System",Font.BOLD,16));
        scrtext.setForeground(Color.WHITE);
        image.add(scrtext);



        setSize(800,900);
        setBounds(700,0,800,900);
        setLocation(700,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==back){
            setVisible(false);
            new Transaction(pinNum).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Balance_ry("");
    }
}
