import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login,Reset,Signup;
    JTextField cardtext;
    JPasswordField pinText;
    Login(){
        setTitle("BIT-COIN Bank ATM Machine");
        setLayout(null);


        ImageIcon imgbank=new ImageIcon(ClassLoader.getSystemResource("icons/bank_icon3.png"));
        Image sizeImg=imgbank.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon reIcon=new ImageIcon(sizeImg);
        JLabel jlabel=new JLabel(reIcon);
        jlabel.setBounds(40,40,100,100);
        add(jlabel);

        JLabel text=new JLabel("WELCOME BIT-C BANK ATM");
        text.setBounds(190,45,500,100);
        text.setFont(new Font("Osward",Font.BOLD,30));
        add(text);

        JLabel cardNo=new JLabel("Card NO : ");
        cardNo.setBounds(140,175,100,100);
        cardNo.setFont(new Font("Raleway",Font.BOLD,20));
        add(cardNo);
        cardtext=new JTextField();
        cardtext.setBounds(240,210,250,30);
        cardtext.setFont(new Font("Arial",Font.BOLD,15));
        add(cardtext);

        JLabel pinNo=new JLabel("PIN No    : ");
        pinNo.setBounds(140,240,100,100);
        pinNo.setFont(new Font("Raleway",Font.BOLD,20));
        add(pinNo);
        pinText=new JPasswordField();
        pinText.setFont(new Font("Arial",Font.BOLD,15));
        pinText.setBounds(240,280,250,30);
        add(pinText);

        login=new JButton("Sign In");
        login.setBounds(240,360,110,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this::actionPerformed);
        add(login);


        Reset=new JButton("Reset");
        Reset.setBounds(380,360,110,30);
        Reset.setBackground(Color.BLACK);
        Reset.setForeground(Color.WHITE);
        Reset.addActionListener(this::actionPerformed);
        add(Reset);

        Signup=new JButton("Sign Up");
        Signup.setBounds(240,410,250,30);
        Signup.setBackground(Color.ORANGE);
        Signup.setForeground(Color.BLACK);
        Signup.addActionListener(this::actionPerformed);
        add(Signup);

        getContentPane().setBackground(Color.white);

        setSize(700,600);
        setVisible(true);
        setLocation(300,10);
    }

    public void actionPerformed(ActionEvent ae){
       if (ae.getSource()==login){
           conn c=new conn();
           String cardnumber=cardtext.getText();
           String PinNum=pinText.getText();
           String Query="select * from login where cardnumber='"+cardnumber+"' and pinNumber='"+PinNum+"'";
           try {
             ResultSet rs=  c.s.executeQuery(Query);
             if (rs.next()){
               setVisible(false);
               new Transaction(PinNum).setVisible(true);
             }
             else {
               JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin ");
             }
           }catch (Exception e){
               System.out.println(e.getMessage());
           }

       } else if (ae.getSource()==Reset) {
           cardtext.setText("");
           pinText.setText("");

       }else if (ae.getSource()==Signup) {
              setVisible(false);
              new SignUpOne().setVisible(true);
       }
    }



    public static void main(String[] args) {
        new Login();
    }
}
