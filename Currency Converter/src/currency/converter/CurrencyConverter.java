package currency.converter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Converter extends JFrame implements ActionListener{
    
    double Rupee=1.0;
    double Dollar=82.74;
    double Euro=89.60;
    double Yen=0.56;
    double Rupiah=0.0054;
    double Pound=104.20;
    double SingaporeDollar=104.20;
    
    JLabel heading, base, target;
    JTextField basecurrency, targetcurrency;
    JComboBox basebox1, basebox2; 
    JButton convert, reset, exit;
    
    Converter(){
        setTitle("currency_conveter");
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setSize(600,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        heading=new JLabel("CURRENCY CONVERTER");
        heading.setFont(new Font("RALEWAY", Font.BOLD, 28));
        heading.setBounds(130,20,350,40);
        add(heading);
        
        base=new JLabel("Base Currency:");
        base.setFont(new Font("RALEWAY", Font.BOLD,20));
        base.setBounds(50,110,180,30);
        add(base);
        
        basecurrency=new JTextField();
        basecurrency.setHorizontalAlignment(0);
        basecurrency.setBounds(270, 110, 200, 30);
        basecurrency.setForeground(Color.BLACK);
        add(basecurrency);
        
        String basecurrency[]={"₹", "$", "€", "S$", "¥", "£", "Rp"};
        basebox1=new JComboBox(basecurrency);
        basebox1.setBounds(480,110,50,30);
        basebox1.setBackground(Color.white);
        add(basebox1);
        
        target=new JLabel("Target Currency:");
        target.setFont(new Font("RALEWAY", Font.BOLD,20));
        target.setBounds(50,180,180,30);
        add(target);
        
        targetcurrency=new JTextField();
        targetcurrency.setHorizontalAlignment(0);
        targetcurrency.setBounds(270, 180, 200, 30);
        targetcurrency.setForeground(Color.BLACK);
        add(targetcurrency);
        
        String targetcurrency[]={"₹", "$", "€", "S$", "¥", "£", "Rp"};
        basebox2=new JComboBox(targetcurrency);
        basebox2.setBounds(480,180,50,30);
        basebox2.setBackground(Color.white);
        add(basebox2);
        
        convert=new JButton("Convert Currency");
        convert.setBounds(225,270,150,30);
        convert.setForeground(Color.BLACK);
        convert.addActionListener(this);
        add(convert);
        
        reset=new JButton("Reset");
        reset.setBounds(225,320,150,30);
        reset.setForeground(Color.BLACK);
        reset.addActionListener(this);
        add(reset);
        
        exit=new JButton("Exit");
        exit.setBounds(225,370,150,30);
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        add(exit);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==convert){
            try{
            double converamount=Double.parseDouble(basecurrency.getText());
            
            double amtinRupee=0.0;
             
            if(basebox1.getSelectedItem().equals("₹")){
                amtinRupee=converamount*Rupee;
            }
            else if(basebox1.getSelectedItem().equals("$")){
                amtinRupee=converamount*Dollar;
            }
            else if(basebox1.getSelectedItem().equals("€")){
                amtinRupee=converamount*Euro;
            }
            else if(basebox1.getSelectedItem().equals("S$")){
                amtinRupee=converamount*SingaporeDollar;
            }
            else if(basebox1.getSelectedItem().equals("¥")){
                amtinRupee=converamount*Yen;
            }
            else if(basebox1.getSelectedItem().equals("£")){
                amtinRupee=converamount*Pound;
            }
            else if(basebox1.getSelectedItem().equals("Rp")){
                amtinRupee=converamount*Rupiah;
            }
            
            double amttochange=0.0;
            
            if(basebox2.getSelectedItem().equals("₹")){
                amttochange=amtinRupee/Rupee;
            }
             else if(basebox2.getSelectedItem().equals("$")){
                amttochange=amtinRupee/Dollar;
            }
            else if(basebox2.getSelectedItem().equals("€")){
                amttochange=amtinRupee/Euro;
            }
            else if(basebox2.getSelectedItem().equals("S$")){
                amttochange=amtinRupee/SingaporeDollar;
            }
            else if(basebox2.getSelectedItem().equals("¥")){
                amttochange=amtinRupee/Yen;
            }
            else if(basebox2.getSelectedItem().equals("£")){
                amttochange=amtinRupee/Pound;
            }
            else if(basebox2.getSelectedItem().equals("Rp")){
                amttochange=amtinRupee/Rupiah;
            }
            String amount=String.format("%.2f",amttochange );
            targetcurrency.setText(amount);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Incorrect Details");
                    }
        }
        else if(ae.getSource()==reset){
            basecurrency.setText("");
            targetcurrency.setText("");
        }
        else if(ae.getSource()==exit){
            System.exit(0);
        }
    }
}

public class CurrencyConverter {

    public static void main(String[] args) {
        // TODO code application logic here
        Converter convert=new Converter();
        convert.setVisible(true);
    }
    
}
