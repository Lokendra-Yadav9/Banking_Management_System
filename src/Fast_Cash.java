import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Fast_Cash extends JFrame implements ActionListener {
    JLabel image,ScrText;
    JButton R100,R500,R1000,R2000,R5000,R10000,withdraw,cancel;
    String pinNum;
    Fast_Cash( String pinNum){
        this.pinNum=pinNum;
        setLayout(null);

        ImageIcon mg=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img= mg.getImage().getScaledInstance(800,900,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(img);
        image=new JLabel(img2);
        image.setBounds(0,0,800,900);
        add(image);

        ScrText=new JLabel("Click Button  For Fast Money");
        ScrText.setBounds(163,325,280,20);
        ScrText.setFont(new Font("Roboto Medium",Font.BOLD,20));
        ScrText.setForeground(Color.WHITE);
        image.add(ScrText);

        R100=new JButton("₹ 100");
        R100.setBounds(140,418,120,29);
        R100.setFont(new Font("System",Font.BOLD,16));
        R100.addActionListener(this);
        image.add(R100);

        R2000=new JButton("₹ 2000");
        R2000.setBounds(338,418,120,29);
        R2000.setFont(new Font("System",Font.BOLD,16));
        R2000.addActionListener(this);
        image.add(R2000);


        R500=new JButton("₹ 500");
        R500.setBounds(140,450,120,29);
        R500.setFont(new Font("System",Font.BOLD,16));
        R500.addActionListener(this);
        image.add(R500);

        R5000=new JButton("₹ 5000");
        R5000.setBounds(338,450,120,29);
        R5000.setFont(new Font("System",Font.BOLD,16));
        R5000.addActionListener(this);
        image.add(R5000);

        R1000=new JButton("₹ 1000");
        R1000.setBounds(140,481,120,29);
        R1000.setFont(new Font("System",Font.BOLD,16));
        R1000.addActionListener(this);
        image.add(R1000);

        R10000=new JButton("₹ 10000");
        R10000.setBounds(338,481,120,29);
        R10000.setFont(new Font("System",Font.BOLD,16));
        R10000.addActionListener(this);
        image.add(R10000);

        cancel=new JButton("Cancel");
        cancel.setBounds(223,515,140,33);
        cancel.setFont(new Font("Raleway",Font.BOLD,19));
        cancel.setBackground(new Color(255,0,0));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        image.add(cancel);

        setSize(800,900);
        setLocation(800,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==cancel){
            setVisible(false);
            new Transaction(pinNum).setVisible(true);
        }
        else {
            String F_num=((JButton)ae.getSource()).getText().substring(2);
            conn c=new conn();
                try {
                    ResultSet rs = c.s.executeQuery("select * from banking where pin = '" + pinNum + "'");
                    int t_balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            t_balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            t_balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if (ae.getSource() != cancel && t_balance < Integer.parseInt(F_num)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                        Date date = new Date();
                        String Query = "INSERT INTO banking value('" + pinNum + "','" + date + "','Withdraw','" + F_num + "')";
                        c.s.executeUpdate(Query);
                        JOptionPane.showMessageDialog(null,"₹ "+F_num+"/- is Withdraw from your account Successfully");
                        setVisible(false);
                        new Transaction(pinNum).setVisible(true);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
        }
    }


    public static void main(String[] args) {
        new Fast_Cash("");
    }
}
