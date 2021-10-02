import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class App {
    public static void main(String[] args) throws Exception {
        JFrame mainFrame = new JFrame();

        
        ImageIcon icon = new ImageIcon("funnyFace1.png");
        
        mainFrame.setIconImage(icon.getImage());
        mainFrame.setTitle("Just for Fun");
        mainFrame.setSize(640,420);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().setBackground(Color.PINK);
        mainFrame.setLocationRelativeTo(null);
        // mainFrame.setLayout(null);
        mainFrame.setResizable(false);

        MyProgressBar bar = new MyProgressBar(mainFrame);
        
        mainFrame.add(bar);
        mainFrame.setVisible(true);
        

    }
}

class MyProgressBar extends JPanel implements ActionListener {

    JButton button = new JButton("Click here to entertain:D");
    JProgressBar bar = new JProgressBar(0,100);
    JFrame frame;
    JLabel label = new JLabel();

    MyProgressBar(JFrame frame){


        this.frame = frame;
        this.setLayout(null);
        this.setBackground(Color.PINK);
        this.setOpaque(true);

        label.setBounds(550,350,200,20);
        label.setText("by thenamk20");
        label.setFont(new Font("Game Over",Font.PLAIN,20));
        label.setForeground(Color.BLACK);
        label.setBackground(Color.PINK);
        label.setOpaque(true);

        button.setBounds(200,180,240,30);
        button.addActionListener(this);
        button.setFocusable(false);
        button.setFont(new Font("Game Over",Font.PLAIN,35));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.PINK);

        bar.setBounds(120, 100, 400, 40);
        bar.setValue(0);
        bar.setStringPainted(true);
        bar.setFont(new Font("Game Over",Font.PLAIN,30));
        bar.setForeground(Color.BLACK);

        this.add(label);
        this.add(button);
        this.add(bar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            Thread_Bar tb = new Thread_Bar(bar);
            tb.start();
            button.setEnabled(false);
            
            Frame_Thread frame_thread = new Frame_Thread(frame);
            frame_thread.start();
        }   
    }

}

class Thread_Bar extends Thread {
    JProgressBar bar;
    
    public Thread_Bar(JProgressBar newBar) 
    {
        this.bar = newBar;
    }
    
     @Override
     public void run() 
     {
         int percentage = 0;
         while (percentage < 100) 
         {
             try {
                 sleep(40);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
 
             percentage += 1;
             bar.setValue(percentage);
         }
     }
 }

class Another_FrameForFun extends JFrame implements ActionListener{

    JLabel label1 = new JLabel("You'r computer was hacked :3");
    JLabel label2 = new JLabel("And it luckily has some virus too :((");
    JButton button = new JButton("Exit Only");

    Another_FrameForFun(JFrame frame){

        frame.dispose();
        this.setTitle("HACKING SUCCESSFULLLY");
        this.setLayout(null);
        this.setSize(400,300);
        this.getContentPane().setBackground(Color.BLACK);
        label1.setBounds(52, 80, 300, 50);
        label1.setForeground(Color.GREEN);
        label1.setFont(new Font("Game oveR",Font.BOLD,44));
        
        label2.setBounds(52, 130, 300, 50);
        label2.setForeground(Color.GREEN);
        label2.setFont(new Font("Game oveR",Font.PLAIN,35));
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        button.setBounds(120, 200, 100, 20);
        button.setBackground(Color.PINK);
        button.setForeground(Color.BLACK);
        button.setFocusable(false);
        button.setFont(new Font("Game oveR",Font.PLAIN,25));
        button.addActionListener(this);

        this.add(button);
        this.add(label1);
        this.add(label2);

        ImageIcon icon = new ImageIcon("funnyFace1.png");
        
        this.setIconImage(icon.getImage());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);

        Pane_Thread pane1 = new Pane_Thread();
        pane1.start(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            new Scary_Frame2();
            button.setEnabled(false);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}

class Frame_Thread extends Thread {
    JFrame frame;

    Frame_Thread(JFrame frame){
        this.frame = frame;
    }
    @Override
    public void run(){
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
        new Another_FrameForFun(frame);
    }
}  

class Pane_Thread extends Thread {
    Pane_Thread(){

    }
    @Override
    public void run(){
        try {
            sleep(2500);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
        new Scary_Frame();
    }
    
}

class Scary_Frame extends JFrame {

    JLabel label = new JLabel();

    Scary_Frame(){
        this.setSize(640,420);
        ImageIcon icon = new ImageIcon("scaryface1.jpg");
        Image img = icon.getImage();
        icon = new ImageIcon(img.getScaledInstance(640, 420, Image.SCALE_SMOOTH)); 

        label.setIcon(icon);

        this.setLocationRelativeTo(null);
        this.add(label);
        this.setResizable(false);
        this.setVisible(true);

    }
}

class Scary_Frame2 extends JFrame {

    JLabel label = new JLabel();

    Scary_Frame2(){
        this.setSize(600,380);
        ImageIcon icon = new ImageIcon("carnage.jpg");
        Image img = icon.getImage();
        icon = new ImageIcon(img.getScaledInstance(600, 380, Image.SCALE_SMOOTH)); 

        label.setIcon(icon);

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.add(label);
        this.setVisible(true);

    }
}