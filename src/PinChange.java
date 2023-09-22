import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JLabel image,srctext,current_txt,NewText,Re_newtext;
    JPasswordField C_pin,N_pin,R_pin;

    JButton change,Back;
    String pinNum;
    PinChange(String pinNum){
        this.pinNum=pinNum;
        setLayout(null);

        ImageIcon mg=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img=mg.getImage().getScaledInstance(800,900,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(img);
        image=new JLabel(img2);
        image.setBounds(0,0,800,900);
        add(image);

        srctext=new JLabel("Change PIN");
        srctext.setBounds(230,285,220,20);
        srctext.setFont(new Font("System",Font.BOLD,17));
        srctext.setForeground(Color.WHITE);
        image.add(srctext);

        current_txt=new JLabel("Enter Current PIN");
        current_txt.setBounds(139,325,240,20);
        current_txt.setFont(new Font("System",Font.BOLD,15));
        current_txt.setForeground(Color.WHITE);
        image.add(current_txt);

        C_pin=new JPasswordField();
        C_pin.setBounds(305,325,150,25);
        C_pin.setFont(new Font("Raleway",Font.BOLD,18));
        image.add(C_pin);


        NewText=new JLabel("Enter New PIN");
        NewText.setBounds(139,380,250,20);
        NewText.setFont(new Font("System",Font.BOLD,15));
        NewText.setForeground(Color.WHITE);
        image.add(NewText);

        N_pin=new JPasswordField();
        N_pin.setBounds(305,380,150,25);
        N_pin.setFont(new Font("Raleway",Font.BOLD,18));
        image.add(N_pin);

        Re_newtext=new JLabel("Re-Enter New PIN");
        Re_newtext.setBounds(139,430,250,20);
        Re_newtext.setFont(new Font("System",Font.BOLD,15));
        Re_newtext.setForeground(Color.WHITE);
        image.add(Re_newtext);

        R_pin=new JPasswordField();
        R_pin.setBounds(305,430,150,25);
        R_pin.setFont(new Font("Raleway",Font.BOLD,18));
        image.add(R_pin);

        change=new JButton("Change");
        change.setBounds(139,490,140,30);
        change.setFont(new Font("Roboto medium",Font.BOLD,18));
        change.setBackground(new Color(0,255,57));
        change.addActionListener(this);
        image.add(change);

        Back=new JButton("Back");
        Back.setBounds(318,490,140,30);
        Back.setFont(new Font("Roboto medium",Font.BOLD,18));
        Back.setBackground(new Color(255,0,0));
        Back.addActionListener(this);
        image.add(Back);



        setSize(800,900);
        setLocation(700,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==Back){
            setVisible(false);
            new Transaction(pinNum).setVisible(true);
        }
        else {
            String current_pin=C_pin.getText();
            String New_pin=N_pin.getText();
            String Re_new=R_pin.getText();
            if (current_pin.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please Enter the current Pin");
            } else if (New_pin.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Please Enter the New Pin");
            }else if (Re_new.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Please Re-Enter the New Pin");
            }
            else {
                if (!current_pin.equals(pinNum)){
                    JOptionPane.showMessageDialog(null,"Your Current Pin is Incorrect");
                    C_pin.setText("");
                    return;
                }
                if (!New_pin.equals(Re_new)) {
                    JOptionPane.showMessageDialog(null, "Your New Pin is Not Matched ");
                    N_pin.setText("");
                    R_pin.setText("");
                    return;
                }
                    try {
                        conn c = new conn();
                        String Query="update banking set pin = '"+New_pin+"' where pin ='"+pinNum+"'";
                        String Query1="update login set pinNumber = '"+New_pin+"'   where pinNumber ='"+pinNum+"'";
                        String Query2="update SignUp3 set pin_number = '"+New_pin+"' where pin_number ='"+pinNum+"'";
                        c.s.executeUpdate(Query);
                        c.s.executeUpdate(Query1);
                        c.s.executeUpdate(Query2);

                        JOptionPane.showMessageDialog(null,"Your PIN GENERATED successfully ");
                        setVisible(false);
                        new Transaction(pinNum).setVisible(true);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
        }
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}
