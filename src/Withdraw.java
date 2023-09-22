import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    JLabel image,ScrText;
    JTextField W_amount;
    JButton cancel, Submit;
    String pinNUm;
    Withdraw(String pinNum){
        this.pinNUm=pinNum;
        setLayout(null);

        ImageIcon mg=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img=mg.getImage().getScaledInstance(800,900,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(img);
        image=new JLabel(img2);
        image.setBounds(0,0,800,900);
        add(image);

        ScrText=new JLabel("Enter the amount for Withdraw");
        ScrText.setBounds(180,325,250,20);
        ScrText.setFont(new Font("System",Font.BOLD,16));
        ScrText.setForeground(Color.WHITE);
        image.add(ScrText);

        W_amount=new JTextField();
        W_amount.setBounds(190,370,220,25);
        W_amount.setFont(new Font("Roboto",Font.BOLD,18));
        image.add(W_amount);

        Submit=new JButton("Submit");
        Submit.setBounds(180,450,110,25);
        Submit.setFont(new Font("Roboto medium",Font.BOLD,16));
        Submit.setBackground(new Color(0,153,51));
        Submit.addActionListener(this);
        Submit.setForeground(Color.WHITE);
        image.add(Submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(310,450,110,25);
        cancel.setFont(new Font("Roboto medium",Font.BOLD,16));
        cancel.setBackground(new Color(255,0,0));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        image.add(cancel);


        setSize(800,900);
        setLocation(700,10);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==Submit){
            String W_num=W_amount.getText();
            Date date=new Date();
            if (W_num==null){
                JOptionPane.showMessageDialog(null,"Please Enter An Amount");
            } else {
                try {
                conn c=new conn();
                String Query="INSERT INTO banking values('"+pinNUm+"','"+date+"','Withdraw','"+W_num+"')";
                c.s.executeUpdate(Query);
                JOptionPane.showMessageDialog(null,"₹ "+W_num+"/- is Withdraw from Your Account Successfully");
                setVisible(false);
                new Transaction(pinNUm).setVisible(true);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }

        } else if (ae.getSource()==cancel) {
            setVisible(false);
            new Transaction(pinNUm).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdraw("");
    }
}
