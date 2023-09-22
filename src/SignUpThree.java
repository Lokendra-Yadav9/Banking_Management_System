import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {
    JLabel FormNo,pg_03,AcType,Card_number,C_num,P_num,Pin_Number,Cinfo,Pinfo,Service_req;
    JRadioButton SavingAc,current,Fix_Account,Recurring_AC;
    JCheckBox Atm,PassBook,CheckBook,Credit_card,InternetB,MobileB,Alert ,confirm,E_state;
    JButton Submit,Cancel;
    ButtonGroup AccountType;
    String FormNum;

    SignUpThree(String FormNUm){
        this.FormNum=FormNUm;

        setLayout(null);

        FormNo=new JLabel("APPLICATION NO. "+FormNUm);
        FormNo.setFont(new Font("Raleway", Font.BOLD,12));
        FormNo.setBounds(400,0,400,50);
        add(FormNo);

        pg_03=new JLabel("PAGE-03 ACCOUNT DETAILS");
        pg_03.setFont(new Font("Raleway", Font.BOLD,20));
        pg_03.setBounds(170,70,400,40);
        add(pg_03);

        AcType=new JLabel("Account Type");
        AcType.setFont(new Font("Roboto medium", Font.BOLD,16));
        AcType.setBounds(90,150,300,20);
        add(AcType);

        SavingAc=new JRadioButton("Saving Account");
        SavingAc.setFont(new Font("Roboto",Font.BOLD,15));
        SavingAc.setBounds(110,180,150,20);
        SavingAc.setBackground(Color.WHITE);
        add(SavingAc);

        current=new JRadioButton("Current Account");
        current.setFont(new Font("Roboto",Font.BOLD,15));
        current.setBounds(310,180,150,20);
        current.setBackground(Color.WHITE);
        add(current);

        Fix_Account=new JRadioButton("Fix-Deposit Account");
        Fix_Account.setFont(new Font("Roboto",Font.BOLD,15));
        Fix_Account.setBounds(110,210,190,20);
        Fix_Account.setBackground(Color.WHITE);
        add(Fix_Account);

        Recurring_AC=new JRadioButton("Recurring Account");
        Recurring_AC.setFont(new Font("Roboto",Font.BOLD,15));
        Recurring_AC.setBounds(310,210,170,20);
        Recurring_AC.setBackground(Color.WHITE);
        add(Recurring_AC);

        AccountType=new ButtonGroup();
        AccountType.add(SavingAc);
        AccountType.add(current);
        AccountType.add(Fix_Account);
        AccountType.add(Recurring_AC);

        Card_number=new JLabel("Card Number :");
        Card_number.setBounds(90,270,150,20);
        Card_number.setFont(new Font("Roboto medium", Font.BOLD,16));
        Card_number.setBackground(Color.WHITE);
        add(Card_number);

        C_num=new JLabel("XXXX-XXXX-XXXX-4425");
        C_num.setBounds(230,270,200,20);
        C_num.setFont(new Font("Roboto medium", Font.BOLD,16));
        C_num.setBackground(Color.WHITE);
        add(C_num);

        Cinfo=new JLabel("(Your 16-digit Account number)");
        Cinfo.setBounds(100,290,500,20);
        Cinfo.setFont(new Font("Roboto medium", Font.ITALIC,13));
        Cinfo.setBackground(Color.RED);
        add(Cinfo);

        Pin_Number=new JLabel("PIN Number   :");
        Pin_Number.setBounds(90,340,150,20);
        Pin_Number.setFont(new Font("Roboto medium",Font.BOLD,16));
        Pin_Number.setBackground(Color.WHITE);
        add(Pin_Number);

        P_num=new JLabel("XX78");
        P_num.setBounds(230,340,150,20);
        P_num.setFont(new Font("Roboto medium", Font.BOLD,16));
        P_num.setBackground(Color.WHITE);
        add(P_num);

        Pinfo=new JLabel("(Your 4-digit PIN number )");
        Pinfo.setBounds(100,360,500,20);
        Pinfo.setFont(new Font("Roboto medium", Font.ITALIC,13));
        Pinfo.setBackground(Color.RED);
        add(Pinfo);

        Service_req=new JLabel("Service Required");
        Service_req.setBounds(90,410,200,20);
        Service_req.setFont(new Font("Roboto medium",Font.BOLD,16));
        add(Service_req);

        Atm=new JCheckBox("ATM Card");
        Atm.setBounds(110,450,110,20);
        Atm.setFont(new Font("Roboto",Font.BOLD,15));
        Atm.setBackground(Color.WHITE);
        add(Atm);

        PassBook=new JCheckBox("Pass-Book");
        PassBook.setBounds(250,450,110,20);
        PassBook.setFont(new Font("Roboto",Font.BOLD,15));
        PassBook.setBackground(Color.WHITE);
        add(PassBook);

        CheckBook=new JCheckBox("CheckBook");
        CheckBook.setBounds(400,450,120,20);
        CheckBook.setFont(new Font("Roboto",Font.BOLD,15));
        CheckBook.setBackground(Color.WHITE);
        add(CheckBook);

        Credit_card=new JCheckBox("Credit-Card ");
        Credit_card.setBounds(110,490,115,20);
        Credit_card.setFont(new Font("Roboto",Font.BOLD,15));
        Credit_card.setBackground(Color.WHITE);
        add(Credit_card);

        InternetB=new JCheckBox("Internet Banking ");
        InternetB.setBounds(250,490,151,20);
        InternetB.setFont(new Font("Roboto",Font.BOLD,15));
        InternetB.setBackground(Color.WHITE);
        add(InternetB);

        MobileB=new JCheckBox("Mobile Banking ");
        MobileB.setBounds(400,490,145,20);
        MobileB.setFont(new Font("Roboto",Font.BOLD,15));
        MobileB.setBackground(Color.WHITE);
        add(MobileB);

        Alert=new JCheckBox("Email & SMS Alerts ");
        Alert.setBounds(110,530,180,20);
        Alert.setFont(new Font("Roboto",Font.BOLD,15));
        Alert.setBackground(Color.WHITE);
        add(Alert);

        E_state=new JCheckBox("E-Statement");
        E_state.setBounds(290,530,180,20);
        E_state.setFont(new Font("Roboto",Font.BOLD,15));
        E_state.setBackground(Color.WHITE);
        add(E_state);

        confirm=new JCheckBox("I hereby declares that the above entered information are correct to the best of my knowledge.");
        confirm.setBounds(90,590,600,15);
        confirm.setFont(new Font("Roboto",Font.ITALIC,12));
        confirm.setBackground(Color.WHITE);
        add(confirm);

        Cancel=new JButton("Cancel");
        Cancel.setFont(new Font("Raleway",Font.BOLD,16));
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.setBounds(200,620,150,25);
        Cancel.addActionListener(this);
        add(Cancel);

        Submit=new JButton("Submit");
        Submit.setFont(new Font("Raleway",Font.BOLD,16));
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        Submit.setBounds(400,620,150,25);
        Submit.addActionListener(this);
        add(Submit);

        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setBounds(700,30,650,750);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==Submit){
        String AccountType=null;
        if (SavingAc.isSelected()){
            AccountType= "Saving Account";
        } else if (current.isSelected()) {
            AccountType="Current Account";
        } else if (Fix_Account.isSelected()) {
            AccountType="Fix Deposit Account";
        }else if (Recurring_AC.isSelected()){
            AccountType="Recurring Account";
        }
        Random random=new Random();
        String cardNumber=""+Math.abs((random.nextLong() %90000000L)+5040936000000000L);
        System.out.println(cardNumber);

        String pinNumber= ""+Math.abs((random.nextLong()%9000L)+1000L);
            System.out.println(pinNumber);
        String facility="";
        if (Atm.isSelected()){
            facility+=" Atm Card,";
        }
        if (PassBook.isSelected()){
            facility+=" PassBook,";
        }
        if (CheckBook.isSelected()){
            facility+=" CheckBook,";
        }
        if (Credit_card.isSelected()){
            facility+=" Credit Card,";
        }
        if (InternetB.isSelected()){
            facility=facility+" Internet Banking,";
        }
        if (InternetB.isSelected()){
            facility=facility+" Mobile Banking,";
        }
        if (Alert.isSelected()){
            facility=facility+" Email & SMS Alerts,";
        }
        if (E_state.isSelected()){
            facility=facility+" E-Statement";
        }

       try {
           if (AccountType.isEmpty()){
               JOptionPane.showMessageDialog(null,"this is required field");
           }
           else {
               conn c = new conn();
               String Quiry3 = "INSERT INTO SignUp3 values('" + FormNum + "','" + AccountType + "','" + cardNumber + "','" + pinNumber + "','" + facility + "')";
               String Quiry4="INSERT INTO login values('"+FormNum+"','"+cardNumber+"','"+pinNumber+"')";
               c.s.executeUpdate(Quiry3);
               c.s.executeUpdate(Quiry4);
               JOptionPane.showMessageDialog(null,"Card Number: "+cardNumber+"\nPin Number: "+pinNumber);
               setVisible(false);
               new Deposit(pinNumber).setVisible(true);
           }
       }
       catch (Exception e){
           System.out.println(e.getMessage());
       }

        }
        else if (ae.getSource()==Cancel){
            setVisible(false);
            new Login().setVisible(true);
        }





    }

    public static void main(String[] args) {
        new SignUpThree("");
    }
}
