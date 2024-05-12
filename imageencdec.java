import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.*;
public class imageencdec {
    public static void operate(int key){
    JFileChooser filechooser=new JFileChooser();
    filechooser.showOpenDialog(null);
    File file=filechooser.getSelectedFile();
    // file FileInputStream
    try{
        FileInputStream fis=new FileInputStream(file);
        byte []data=new byte[fis.available()];
        fis.read(data);
        int i=0;
        for(byte b:data){
            System.out.println(b);
            data[i]=(byte)(b^key);
            i++;
        }
        FileOutputStream fos=new FileOutputStream(file);
        fos.write(data);
        fos.close();
        fis.close();
        JOptionPane.showMessageDialog(null, "done");
        }
    catch(Exception e){
        e.printStackTrace();
    }
}
    public static void main(String[] args) {
        System.out.println("this is testing");
        
        JFrame j=new JFrame();
        j.setTitle("imagee operation");
        j.setSize(500, 500);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
        Font font=new Font("Roboto",Font.BOLD,25);
        //CREATING A BUTTON
        JButton button=new JButton();
        button.setText("open Image");
        button.setFont(font);
        //creating a text field
        JTextField textfield=new JTextField(10);
        textfield.setFont(font);
        
         button.addActionListener(e->{
            System.out.println("Button clicked");
            String text= textfield.getText();
            int temp=Integer.parseInt(text);
            operate(temp);
        });
        j.setLayout(new FlowLayout());
        j.add(button);
        j.add(textfield);
        j.setVisible(true);
    }
}
