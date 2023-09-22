import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JLabel image,SrcText;
    JButton Deposit,Withdraw,Fast_cash,MiniState,PinChange,BalanceEnQury,Exit;

   String pinNum;
    Transaction(String pinNumber){
       this.pinNum=pinNumber;

        ImageIcon mg=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image m1=mg.getImage().getScaledInstance(800,850,Image.SCALE_DEFAULT);
        ImageIcon img=new ImageIcon(m1);
        image=new JLabel(img);
        image.setBounds(0,0,800,850);
        add(image);

        SrcText=new JLabel("Please Select Your Transaction ");
        SrcText.setBounds(180,310,700,20);
        SrcText.setFont(new Font("System",Font.BOLD,15));
        SrcText.setForeground(Color.WHITE);
        image.add(SrcText);

        Deposit=new JButton("Deposit");
        Deposit.setBounds(140,420,150,29);
        Deposit.setFont(new Font("Reboto",Font.BOLD,15));
        Deposit.addActionListener(this);
        image.add(Deposit);

        Withdraw=new JButton("Withdraw");
        Withdraw.setBounds(310,420,150,29);
        Withdraw.setFont(new Font("Reboto",Font.BOLD,15));
        Withdraw.addActionListener(this);
        image.add(Withdraw);

        Fast_cash=new JButton("Fast Cash");
        Fast_cash.setBounds(140,451,150,29);
        Fast_cash.setFont(new Font("Reboto",Font.BOLD,15));
        Fast_cash.addActionListener(this);
        image.add(Fast_cash);

        MiniState=new JButton("Mini Statement");
        MiniState.setBounds(310,451,150,29);
        MiniState.setFont(new Font("Reboto",Font.BOLD,15));
        MiniState.addActionListener(this);
        image.add(MiniState);

        PinChange=new JButton("Pin Change");
        PinChange.setBounds(140,482,150,29);
        PinChange.setFont(new Font("Reboto",Font.BOLD,15));
        PinChange.addActionListener(this);
        image.add(PinChange);

        BalanceEnQury=new JButton("Balance Enquiry");
        BalanceEnQury.setBounds(310,482,150,29);
        BalanceEnQury.setFont(new Font("Reboto",Font.BOLD,14));
        BalanceEnQury.addActionListener(this);
        image.add(BalanceEnQury);

        Exit=new JButton("Exit");
        Exit.setBounds(310,513,150,29);
        Exit.setFont(new Font("Reboto",Font.BOLD,14));
        Exit.addActionListener(this);
        image.add(Exit);


        setSize(800,900);
        setBackground(Color.WHITE);
        setLocation(700,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==Exit){
          System.exit(0);
        }
        else if (ae.getSource()==Deposit){
           setVisible(false);
           new Deposit(pinNum).setVisible(true);
        }
        else if (ae.getSource()==Withdraw){
         setVisible(false);
         new Withdraw(pinNum).setVisible(true);
        } else if (ae.getSource()==Fast_cash) {
           setVisible(false);
           new Fast_Cash(pinNum).setVisible(true);
        } else if (ae.getSource()==PinChange) {
            setVisible(false);
            new PinChange(pinNum).setVisible(true);
        } else if (ae.getSource()==MiniState) {
            setVisible(false);
            new MiniState(pinNum).setVisible(true);
        } else if (ae.getSource()==BalanceEnQury) {
            setVisible(true);
            new Balance_ry(pinNum).setVisible(true);
        }
    }


    public static void main(String[] args) {
    new Transaction("");
    }
}
