import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JLabel image,scrText;
    JTextField amount;
    JButton deposit,cancel;
    String pinNum;
    Deposit(String pinNum){
        this.pinNum=pinNum;

        ImageIcon mg=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img=mg.getImage().getScaledInstance(800,900,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(img);
        image=new JLabel(img2);
        image.setBounds(0,0,900,900);
        add(image);

        scrText=new JLabel("Enter The Amount For Deposit");
        scrText.setBounds(175,280,250,20);
        scrText.setForeground(Color.WHITE);
        scrText.setFont(new Font("Roboto",Font.BOLD,16));
        image.add(scrText);

        amount=new JTextField();
        amount.setBounds(160,330,250,25);
        amount.setFont(new Font("Roboto",Font.BOLD,17));
        image.add(amount);

        deposit=new JButton("Deposit");
        deposit.setBounds(175,400,100,25);
        deposit.setFont(new Font("System",Font.BOLD,16));
        deposit.setBackground(new Color(0,153,51));
        deposit.setForeground(Color.WHITE);
        deposit.addActionListener(this);
        image.add(deposit);

        cancel=new JButton("Cancel");
        cancel.setBounds(300,400,100,25);
        cancel.setFont(new Font("System",Font.BOLD,16));
        cancel.setBackground(new Color(255,0,0));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        image.add(cancel);



        setSize(800,900);
        setUndecorated(true);
        setLocation(300,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String amt=amount.getText();
        Date date=new Date();
        if (ae.getSource()==deposit){
        if (amt.isEmpty()){
            JOptionPane.showMessageDialog(null,"please fill your Amount");
        }
        else {
            try {
                conn c = new conn();
                String Query = "INSERT INTO banking values('" + pinNum + "','"+date+"','Deposit','" + amt + "')";
                c.s.executeUpdate(Query);
                JOptionPane.showMessageDialog(null,"₹ "+amt+"/- is deposit in your Account Successfully");
                setVisible(false);
                new Transaction(pinNum).setVisible(true);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        }
        else if (ae.getSource()==cancel){
            setVisible(false);
            new Transaction(pinNum).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
