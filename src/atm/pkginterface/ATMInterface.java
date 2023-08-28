package atm.pkginterface;
import javax.swing.*;
import java.awt.*;

 class ATM{
    private double balance;
    
    public ATM( double balance){
        this.balance=balance;
    }
     
    public double checkbalance(){
        return balance;
    }
    
    public void deposit(double amount){
        if(amount>0)
            balance+=amount;
    }
    
    public boolean withdraw(double amount){
        if(amount>0 && balance>amount){
            balance-=amount;
            return true;
        }
         return false;
    }
}
 class ATMInterface extends JFrame  {
 private final ATM userAcc;
    JButton withdraw, deposit, checkamt, exit;
   ATMInterface(ATM account){
        this.userAcc=account;
       
       setTitle("ATM INTERFACE");
       
        setLayout(null);
        getContentPane().setBackground(Color.white);
       
       setSize(600,600);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
       initComponents();
}
   private void updateBalanceLabel() {
     userAcc.checkbalance();
     
}
       private void initComponents(){
    
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
       Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel label=new JLabel(i3);
       label.setBounds(100,10,100,100);
       add(label);
       
       JLabel text=new JLabel("ATM MACHINE");
       text.setFont(new Font("Osward", Font.BOLD,38));
       text.setBounds(200, 50, 400, 40);
       add(text);
       
       
       withdraw=new JButton("WITHDRAW");
       withdraw.addActionListener((e)->{
            String input = JOptionPane.showInputDialog("Enter withdrawal amt:");
            double amt = Double.parseDouble(input);
            if (userAcc.withdraw(amt)) {
                 updateBalanceLabel();
                 double balance = userAcc.checkbalance();
                 JOptionPane.showMessageDialog(this, input+ " Rs is debited from your account. Current balance is: "+balance+ "Rs");
            } else {
            JOptionPane.showMessageDialog(this, "Insufficient funds or invalid amt.");
        }
       });
       withdraw.setBounds(100,150,400,70);
       withdraw.setForeground(Color.BLACK);
       add(withdraw);
       
       deposit=new JButton("DEPOSIT");
       deposit.addActionListener((e)->{
             String input = JOptionPane.showInputDialog("Enter deposit amt:");
        double amt = Double.parseDouble(input);
        userAcc.deposit(amt);
        updateBalanceLabel();
        double balance = userAcc.checkbalance();
                 JOptionPane.showMessageDialog(this, input+ " Rs is debited from your account. Current balance is: "+balance+ "Rs");
       });
       deposit.setBounds(100,250,400,70);
       deposit.setForeground(Color.BLACK);
       add(deposit);
       
       checkamt=new JButton("CHECK BALANCE");
       checkamt.addActionListener((e)->{
       double balance = userAcc.checkbalance();
    JOptionPane.showMessageDialog(this, "Your current balance is: " + balance);
        });
       checkamt.setBounds(100,350,400,70);
       checkamt.setForeground(Color.BLACK);
       add(checkamt);
       
       exit=new JButton("EXIT");
       exit.addActionListener((e)->{
           System.exit(0);
       });
       exit.setBounds(430,470,90,40);
       exit.setBackground(Color.BLACK);
       exit.setForeground(Color.WHITE);
       add(exit);
       

   }
   
    public static void main(String[] args) {
        ATM amount=new ATM(500);
      ATMInterface atm= new ATMInterface(amount);
      atm.setVisible(true);
    }    
}
