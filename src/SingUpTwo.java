import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingUpTwo extends JFrame implements ActionListener {

    JLabel FormNo,Pg_02,Religion,category,income,education,Occupation,panNo,addharNum, seniorCiti,ExistAcc;
    JTextField pantext,AdharText;
    JRadioButton Syes,Sno,Eyes,Eno;
    JComboBox religion,Category,incomes,Eduction,Occapation;
    JButton Next;
    String FormNum;

    SingUpTwo(String FormNum){
        setLayout(null);
        this.FormNum=FormNum;

        FormNo=new JLabel("APPLICATION NO. "+FormNum);
        FormNo.setFont(new Font("Raleway", Font.BOLD,12));
        FormNo.setBounds(400,0,400,50);
        add(FormNo);

        Pg_02=new JLabel("PAGE-02 ADDITIONAL DETAILS");
        Pg_02.setFont(new Font("Raleway", Font.BOLD,20));
        Pg_02.setBounds(170,70,400,40);
        add(Pg_02);

        Religion=new JLabel("Religion :");
        Religion.setFont(new Font("Roboto medium", Font.BOLD,16));
        Religion.setBounds(90,150,100,20);
        add(Religion);

        String[] valReligon={"Hindu","Muslim","Sikh","Cristian","Other"};
        religion=new JComboBox<>(valReligon);
        religion.setBounds(250,150,250,23);
        religion.setBackground(Color.WHITE);
        religion.setSelectedIndex(-1);
        add(religion);

        category=new JLabel("Category :");
        category.setFont(new Font("Roboto medium", Font.BOLD,16));
        category.setBounds(90,200,100,20);
        add(category);

        String [] valcategory={"General","OBC","SC","ST"};
        Category=new JComboBox<>(valcategory);
        Category.setBounds(250,200,250,23);
        Category.setBackground(Color.WHITE);
        Category.setSelectedIndex(-1);
        add(Category);

        income=new JLabel("Income :");
        income.setFont(new Font("Roboto medium", Font.BOLD,16));
        income.setBounds(90,250,100,20);
        add(income);

        String[] valIncome={"Null","less than > 2 lac","2 lac to 8 lac","greater than < 8 lac"};
        incomes=new JComboBox<>(valIncome);
        incomes.setBounds(250,250,250,23);        religion.setBackground(Color.WHITE);
        incomes.setBackground(Color.WHITE);
        incomes.setSelectedIndex(-1);
        add(incomes);

        education=new JLabel("<html>Eduction<br> Qualification : </html>");
        education.setFont(new Font("Roboto medium", Font.BOLD,16));
        education.setBounds(90,300,200,40);
        add(education);

        String[] valEdu={"illiterate","High School (10th)","Higher Secondary (12th)","Diploma (ITI)","Bachelor's degree","Master's degree","PHD "};
        Eduction=new JComboBox<>(valEdu);
        Eduction.setBounds(250,300,250,23);
        Eduction.setBackground(Color.WHITE);
        Eduction.setSelectedIndex(-1);
        add(Eduction);

        Occupation=new JLabel("Occupation :");
        Occupation.setFont(new Font("Roboto medium",Font.BOLD,16));
        Occupation.setBounds(90,360,100,20);
        add(Occupation);

        String[] valOcc={"Government servant","Private servant","Business","Farmer","Labour","UnEmployed","Student"};
        Occapation=new JComboBox<>(valOcc);
        Occapation.setBounds(250,360,250,23);
        Occapation.setBackground(Color.WHITE);
        Occapation.setSelectedIndex(-1);
        add(Occapation);

        panNo =new JLabel("Pan Number : ");
        panNo.setFont(new Font("Roboto medium",Font.BOLD,16));
        panNo.setBounds(90,410,150,20);
        add(panNo);

        pantext=new JTextField();
        pantext.setBounds(250,410,250,23);
        add(pantext);


        addharNum=new JLabel("Aadhar number : ");
        addharNum.setFont(new Font("Roboto medium",Font.BOLD,16));
        addharNum.setBounds(90,450,150,20);
        add(addharNum);

        AdharText=new JTextField();
        AdharText.setBounds(250,450,250,20);
        add(AdharText);

        seniorCiti=new JLabel("Senior Citizen : ");
        seniorCiti.setFont(new Font("Roboto medium",Font.BOLD,16));
        seniorCiti.setBounds(90,500,200,20);
        add(seniorCiti);

        Syes=new JRadioButton("Yes");
        Syes.setBounds(250,500,70,20);
        Syes.setBackground(Color.WHITE);
        add(Syes);

        Sno=new JRadioButton("No");
        Sno.setBounds(400,500,70,20);
        Sno.setBackground(Color.WHITE);
        add(Sno);

        ExistAcc=new JLabel("Existing Account : ");
        ExistAcc.setFont(new Font("Roboto medium",Font.BOLD,16));
        ExistAcc.setBounds(90,550,200,20);
        add(ExistAcc);

        Eyes=new JRadioButton("Yes");
        Eyes.setBounds(250,550,70,20);
        Eyes.setBackground(Color.WHITE);
        add(Eyes);

        Eno=new JRadioButton("No");
        Eno.setBackground(Color.WHITE);
        Eno.setBounds(400,550,70,20);
        add(Eno);


        Next=new JButton("Next");
        Next.setFont(new Font("Roboto medium",Font.BOLD,16));
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.setBounds(380,600,100,25);
        Next.addActionListener(this);
        add(Next);


        getContentPane().setBackground(Color.WHITE);
        setBounds(200,30,650,750);
        setVisible(true);
    }

    public void  actionPerformed(ActionEvent ae){
        String  Sreligion=(String) religion.getSelectedItem();
        String Scategory=(String) Category.getSelectedItem();
        String Sincome=(String) incomes.getSelectedItem();
        String SEducation=(String) Eduction.getSelectedItem();
        String SOccapation=(String) Occapation.getSelectedItem();
        String SpanNum=pantext.getText();
        String SAdhar=AdharText.getText();
        String SCitizen = null;
        if (Syes.isSelected()){
            SCitizen="Yes";
        }
        else if(Sno.isSelected()) {
            SCitizen="No";
        }
        String SExistAcc = null;
        if (Eyes.isSelected()){
            SExistAcc="Yes";
        }
        else if (Eno.isSelected()){
            SExistAcc="No";
        }

        try {
            if (Sreligion==null||Sreligion.isEmpty()){
                JOptionPane.showMessageDialog(null,"this i required field");
            }
           else if (Scategory==null||Scategory.isEmpty()){
                JOptionPane.showMessageDialog(null,"this i required field");
            }else if (Sincome==null||Sincome.isEmpty()){
                JOptionPane.showMessageDialog(null,"this i required field");
            }else if (SEducation==null ||SEducation.isEmpty()){
                JOptionPane.showMessageDialog(null,"this i required field");
            }else if (SOccapation == null || SOccapation.isEmpty()) {
                JOptionPane.showMessageDialog(null, "This is a required field");
            }else if (SpanNum.isEmpty()){
                JOptionPane.showMessageDialog(null,"this i required field");
            }else if (SAdhar.isEmpty()){
                JOptionPane.showMessageDialog(null,"this i required field");
            }else if (!Syes.isSelected() && !Sno.isSelected()){
                JOptionPane.showMessageDialog(null,"this i required field");
            }else if (!Eyes.isSelected() && !Eno.isSelected()){
                JOptionPane.showMessageDialog(null,"this i required field");
            }
           else {
               conn c=new conn();
               String Quiry2="INSERT INTO SignUp2 values('"+FormNum+"','"+Sreligion+"','"+Scategory+"','"+Sincome+"','"+SEducation+"','"+SOccapation+"','"+SpanNum+"','"+SAdhar+"','"+SCitizen+"','"+SExistAcc+"')";
               c.s.executeUpdate(Quiry2);
               setVisible(false);
               new SignUpThree(FormNum).setVisible(true);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }



    public static void main(String[] args) {
        new SingUpTwo("");
    }
}
