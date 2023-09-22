import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener{
    long random;
    JTextField OName,OFname,Emailtext,AddressTextField,CityTextField,StateTextField,PinTextField;
    JRadioButton maleRadio,femaleRadio,otherRadio,marriedRadio,unmarriedRadio,otherStatusRadio;
    JButton next;
    ButtonGroup MaritalGroup,genderGroup;
    JLabel FormNo,Pg_01,Name,fname,dob,gender,marital,Email,State,address,city,Pincode;
    JDateChooser dob_applicant;
    SignUpOne(){
        setLayout(null);

        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000L)+1000);

        FormNo=new JLabel("APPLICATION NO. "+random);
        FormNo.setFont(new Font("Raleway", Font.BOLD,12));
        FormNo.setBounds(400,0,400,50);
        add(FormNo);

        Pg_01=new JLabel("PAGE-01 PERSONAL DETAILS ");
        Pg_01.setFont(new Font("Raleway", Font.BOLD,20));
        Pg_01.setBounds(170,70,400,40);
        add(Pg_01);


        Name =new JLabel("Applicant Name : ");
        Name.setFont(new Font("Roboto medium", Font.BOLD,16));
        Name.setBounds(90,150,250,20);
        add(Name);

        OName=new JTextField();
        OName.setBounds(260,150,250,23);
        add(OName);


        fname=new JLabel("Father's Name  : ");
        fname.setFont(new Font("Roboto medium", Font.BOLD,16));
        fname.setBounds(90,200,250,20);
        add(fname);

        OFname=new JTextField();
        OFname.setBounds(260,200,250,23);
        add(OFname);

        dob=new JLabel("Date of birth     : ");
        dob.setFont(new Font("Roboto medium", Font.BOLD,16));
        dob.setBounds(90,250,250,20);
        add(dob);

        dob_applicant=new JDateChooser();
        dob_applicant.setBounds(260,250,250,23);
        add(dob_applicant);


        gender=new JLabel("Gender              : ");
        gender.setFont(new Font("Roboto medium", Font.BOLD,16));
        gender.setBounds(90,300,250,20);
        add(gender);

        maleRadio=new JRadioButton("Male");
        maleRadio.setBounds(260,300,70,25);
        maleRadio.setFont(new Font("Roboto",Font.BOLD,15));
        maleRadio.setBackground(Color.WHITE);
        add(maleRadio);

        femaleRadio=new JRadioButton("Female");
        femaleRadio.setBounds(340,300,90,25);
        femaleRadio.setFont(new Font("Roboto",Font.BOLD,15));
        femaleRadio.setBackground(Color.WHITE);
        add(femaleRadio);

        otherRadio=new JRadioButton("Other");
        otherRadio.setBounds(450,300,90,25);
        otherRadio.setFont(new Font("Roboto",Font.BOLD,15));
        otherRadio.setBackground(Color.WHITE);
        add(otherRadio);

        genderGroup=new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderGroup.add(otherRadio);

        marital=new JLabel("Marital Status   : ");
        marital.setFont(new Font("Roboto medium", Font.BOLD,16));
        marital.setBounds(90,350,250,20);
        add(marital);

        marriedRadio=new JRadioButton("Married");
        marriedRadio.setBounds(260,350,80,23);
        marriedRadio.setFont(new Font("Roboto",Font.BOLD,14));
        marriedRadio.setBackground(Color.WHITE);
        add(marriedRadio);

        unmarriedRadio=new JRadioButton("Un-Married");
        unmarriedRadio.setBounds(340,350,105,23);
        unmarriedRadio.setFont(new Font("Roboto",Font.BOLD,14));
        unmarriedRadio.setBackground(Color.WHITE);
        add(unmarriedRadio);

        otherStatusRadio=new JRadioButton("Other");
        otherStatusRadio.setBounds(450,350,100,23);
        otherStatusRadio.setFont(new Font("Roboto",Font.BOLD,14));
        otherStatusRadio.setBackground(Color.WHITE);
        add(otherStatusRadio);

        MaritalGroup=new ButtonGroup();
        MaritalGroup.add(marriedRadio);
        MaritalGroup.add(unmarriedRadio);
        MaritalGroup.add(otherStatusRadio);

        Email=new JLabel("Email                 : ");
        Email.setFont(new Font("Roboto medium", Font.BOLD,16));
        Email.setBounds(90,400,250,20);
        add(Email);

        Emailtext=new JTextField();
        Emailtext.setBounds(260,400,250,23);
//        Emailtext.setFont(new Font("Raleway", Font.BOLD,16));
        add(Emailtext);


        address=new JLabel("Address            : ");
        address.setFont(new Font("Roboto medium", Font.BOLD,16));
        address.setBounds(90,450,250,20);
        add(address);

        AddressTextField=new JTextField();
        AddressTextField.setBounds(260,450,250,23);
//        AddressTextField.setFont(new Font("Raleway", Font.BOLD,16));
        add(AddressTextField);

        city=new JLabel("City                   : ");
        city.setFont(new Font("Roboto medium", Font.BOLD,16));
        city.setBounds(90,500,250,20);
        add(city);

        CityTextField=new JTextField();
        CityTextField.setBounds(260,500,250,23);
//        CityTextField.setFont(new Font("Raleway", Font.BOLD,16));
        add(CityTextField);

        State=new JLabel("State                 : ");
        State.setFont(new Font("Roboto medium", Font.BOLD,16));
        State.setBounds(90,550,250,20);
        add(State);

        StateTextField=new JTextField();
        StateTextField.setBounds(260,550,250,23);
//        StateTextField.setFont(new Font("Raleway", Font.BOLD,16));
        add(StateTextField);

        Pincode=new JLabel("Pin code No.     : ");
        Pincode.setFont(new Font("Roboto medium", Font.BOLD,16));
        Pincode.setBounds(90,600,250,20);
        add(Pincode);

        PinTextField=new JTextField();
        PinTextField.setBounds(260,600,250,23);
//        PinTextField.setFont(new Font("Raleway", Font.BOLD,16));
        add(PinTextField);

        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,16));
        next.setBounds(410,650,100,25);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

//        setSize(600,750);
//        setLocation(270,65);
        setBounds(200,30,650,750);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent Ae){
     String Formno=""+random;
     String names=OName.getText();
     String fname=OFname.getText();
     String dob=((JTextField)dob_applicant.getDateEditor().getUiComponent()).getText();
     String Gender;
     if (maleRadio.isSelected()){
          Gender="Male";

     } else if (femaleRadio.isSelected()) {
          Gender="Female";
     }
     else {
          Gender="Other";
     }

     String email=Emailtext.getText();
     String marital;
     if (marriedRadio.isSelected()){
      marital="Married";
     }
     else if(unmarriedRadio.isSelected()){
      marital="UnMarried";
     }
     else {
      marital="other";
     }

     String address= AddressTextField.getText();
     String city=CityTextField.getText();
     String State=StateTextField.getText();
     String pincode=PinTextField.getText();

     try {
      if (names.isEmpty()){
       JOptionPane.showMessageDialog(null,"name is required");
      }
      else if (fname.isEmpty()) {
       JOptionPane.showMessageDialog(null,"Father Name is required");
      }
      else if (address.isEmpty()) {
       JOptionPane.showMessageDialog(null,"Address Name is required");
      }else if (email.isEmpty()) {
       JOptionPane.showMessageDialog(null,"Email Name is required");
      }else if (dob.isEmpty()) {
       JOptionPane.showMessageDialog(null,"Date of birth Name is required");
      }else if (city.isEmpty()) {
       JOptionPane.showMessageDialog(null,"City Name is required");
      }else if (State.isEmpty()) {
       JOptionPane.showMessageDialog(null,"State Name is required");
      }else if (pincode.isEmpty()) {
       JOptionPane.showMessageDialog(null,"Pin code Name is required");
      }
      else {
       conn c=new conn();
       String Query="INSERT INTO SignUp values('"+Formno+"','"+names+"','"+fname+"','"+address+"','"+email+"','"+marital+"','"+Gender+"','"+dob+"','"+city+"','"+State+"','"+pincode+"')";
       c.s.executeUpdate(Query);

       setVisible(false);
      new SingUpTwo(Formno).setVisible(true);
      }
     }catch (Exception e){
      System.out.println(e.getMessage());
     }

    }



    public static void main(String[] args) {
     new SignUpOne();
    }
}
