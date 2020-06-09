
package paint;

import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author D
 */


class Frame extends JFrame {

     MyCanvas c;
     private BufferedImage image,image2;
       


    public Frame()  {
       // super.setBounds(0, 0, 800, 600);
       super.setSize(920, 600);
       Font font;
       c=new MyCanvas();
       
    
      
       
       //ADDING COLOR BUTTONS START
       
       
        super.setLayout(null);
        JButton FillColor = new JButton();
        FillColor.setBounds(100,490,150,50);
        FillColor.setBackground(Color.WHITE);
        font = new Font("Serif", Font.BOLD, 18);
        FillColor.setFont(font);
        FillColor.setText("Fill Color");
        FillColor.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
              // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          
               JColorChooser chooser=new JColorChooser();
               class OKListener implements ActionListener{

                   @Override
                   public void actionPerformed(ActionEvent e) {
                    //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                     
                    Color a=chooser.getColor();
                     FillColor.setBackground(a);
                    c.i=10; 
                     c.setDefaultfillColor(a);
                                   
                   }        
               }
               JDialog x=JColorChooser.createDialog(null,"Choose",false,chooser,new OKListener(),null);
               x.setVisible(true);
               
        
              // System.out.println("");
                       
           }
           
        
        });
        add(FillColor);
       
       
        super.setLayout(null);   
        JButton black = new JButton();
        black.setBounds(250, 490, 80, 50);
        black.setBackground(Color.black);
        black.addActionListener((ActionEvent e) -> {
            c.i=0;
            c.setDefaultColor(Color.black);
         
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       });
        add(black);
        
        
        super.setLayout(null);   
        JButton red = new JButton();
        red.setBounds(330, 490, 80, 50);
        red.setBackground(Color.red);
        red.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               c.i=1;
               c.setDefaultColor(Color.RED);
             
          //     c.repaint();
              //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       });
        add(red);
        
        
        super.setLayout(null);   
        JButton blue = new JButton();
        blue.setBounds(410, 490, 80, 50);
        blue.setBackground(Color.blue);
        blue.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               c.i=2;
               c.setDefaultColor(Color.BLUE);
           
            //   c.repaint();
              //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       });
        add(blue);
        
        
        super.setLayout(null);   
        JButton yellow = new JButton();
        yellow.setBounds(490, 490, 80, 50);
        yellow.setBackground(Color.yellow);
         yellow.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               c.i=3;
               c.setDefaultColor(Color.YELLOW);
           
              // c.repaint();
              //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       });
        add(yellow);
        
        
        super.setLayout(null);   
        JButton green = new JButton();
        green.setBounds(570, 490, 80, 50);
        green.setBackground(Color.green);
        green.addActionListener(new ActionListener(){

           @Override
           public void actionPerformed(ActionEvent e) {
                c.i=4;
               c.setDefaultColor(Color.green);
            
               //c.repaint();

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }

        
        });
        add(green);
        
        
        super.setLayout(null);   
        JButton magenta = new JButton();
        magenta.setBounds(650, 490, 80, 50);
        magenta.setBackground(Color.magenta);
        magenta.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               c.i=5;
               c.setDefaultColor(Color.magenta);
           
               //c.repaint();
              //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       });
        add(magenta);
        
        
    
        
        super.setLayout(null);
        JButton CSelector = new JButton();
        CSelector.setBounds(730,490,150,50);
        CSelector.setBackground(Color.WHITE);
        font = new Font("Serif", Font.BOLD, 18);
        CSelector.setFont(font);
        CSelector.setText("Select a Color");
        CSelector.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
              // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          
               JColorChooser chooser=new JColorChooser();
               class OKListener implements ActionListener{

                   @Override
                   public void actionPerformed(ActionEvent e) {
                    //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                     
                    Color a=chooser.getColor();
                     CSelector.setBackground(a);
                     c.i=6;
                     c.setDefaultColor(a);
                     
                
                   }        
               }
               JDialog x=JColorChooser.createDialog(null,"Choose",false,chooser,new OKListener(),null);
               x.setVisible(true);
               
        
              // System.out.println("");
                       
           }
           
        
        });
        add(CSelector);
        
       
        
        
       //ADDING COLOR BUTTONS END
       
       
        
        
        super.setLayout(null); 
        JButton circle = new JButton();
        circle.setBounds(0,50, 100, 50);
        circle.setBackground(Color.LIGHT_GRAY);
        font = new Font("Serif", Font.BOLD, 15);
        circle.setFont(font);
        circle.setText("Circle");
        circle.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               c.f=1;
               
              
            
        //       c.repaint();
               //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }

          
         });
        add(circle);
        
        
        super.setLayout(null); 
        JButton rectangle = new JButton();
        rectangle.setBounds(0, 100, 100, 50);
        rectangle.setBackground(Color.LIGHT_GRAY);
        font = new Font("Serif", Font.BOLD, 15);
        rectangle.setFont(font);
        rectangle.setText("Rectangle");
        rectangle.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               c.f=2;
             
        //      c.repaint();
               
               //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       });
        add(rectangle);
        
        
        super.setLayout(null); 
        JButton line = new JButton();
        line.setBounds(0, 0, 100, 50);
        line.setBackground(Color.LIGHT_GRAY);
        font = new Font("Serif", Font.BOLD, 15);
        line.setFont(font);
        line.setText("Lines");
        line.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               c.f=3;
           //    line.setBackground(Color.GRAY);
          //     c.repaint();
              
               
               //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       });
        add(line);
        
        
        super.setLayout(null); 
        JButton Oval = new JButton();
        Oval.setBounds(0, 150, 100, 50);
        Oval.setBackground(Color.LIGHT_GRAY);
        font = new Font("Serif", Font.BOLD, 15);
        Oval.setFont(font);
        Oval.setText("Oval");
        Oval.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              c.f=4;
        //      Oval.setBackground(Color.GRAY);
          
         //     c.repaint();
               //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       });
        add(Oval);
        
        
        super.setLayout(null); 
        JButton Polygon = new JButton();
        Polygon.setBounds(0, 200, 100, 50);
        Polygon.setBackground(Color.LIGHT_GRAY);
        font = new Font("Serif", Font.BOLD, 15);
        Polygon.setFont(font);
        Polygon.setText("Pentagon");
        Polygon.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              c.f=5;
        //      Polygon.setBackground(Color.GRAY);
       //       c.repaint();
               //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       });
        add(Polygon);
        
        
         super.setLayout(null); 
        JButton Stars = new JButton();
        Stars.setBounds(0, 250, 100, 50);
        Stars.setBackground(Color.LIGHT_GRAY);
        font = new Font("Serif", Font.BOLD, 15);
        Stars.setFont(font);
        Stars.setText("Stars");
        Stars.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              c.f=6;
        //      Stars.setBackground(Color.GRAY);
         //     c.repaint();
               //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       });
        add(Stars);
        
        


      
      super.setLayout(null); 
        JButton Brush = new JButton();
        Brush.setBounds(0, 300, 100, 50);
        Brush.setBackground(Color.LIGHT_GRAY);
        font = new Font("Serif", Font.BOLD, 15);
        Brush.setFont(font);
        Brush.setText("Brush (S)");
        Brush.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              c.f=8;
         //     Brush.setBackground(Color.GRAY);
              
            //  c.repaint();
               //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       });
       add(Brush);
       
       
        super.setLayout(null); 
        JButton Brush2 = new JButton();
        Brush2.setBounds(0, 350, 100, 50);
        Brush2.setBackground(Color.LIGHT_GRAY);
        font = new Font("Serif", Font.BOLD, 15);
        Brush2.setFont(font);
        Brush2.setText("Brush (L)");
        Brush2.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              c.f=11;
         //     Brush.setBackground(Color.GRAY);
              
            //  c.repaint();
               //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       });
       add(Brush2);
       
       
       
       
       
       super.setLayout(null); 
        JButton Eraser = new JButton();
        Eraser.setBounds(0, 400, 100, 50);
        Eraser.setBackground(Color.LIGHT_GRAY);
        font = new Font("Serif", Font.BOLD, 15);
        Eraser.setFont(font);
        Eraser.setText("Eraser");
        Eraser.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              c.f=9;
         //     Eraser.setBackground(Color.GRAY);
          //    c.setForeground(Color.white);
              
              //c.repaint();
               //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       });
       add(Eraser);
       
       
      
      
      
       JMenuBar menubar = new JMenuBar();
       
       
       JMenu file =new JMenu("File    ");      
       JMenuItem Save =new JMenuItem ("Save as   ");
       JMenuItem Open =new JMenuItem ("Open    ");
       
       Open.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
              // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           JFileChooser f = new JFileChooser();
             f.setDialogTitle("Open the Image");
              f.showOpenDialog(null);
               BufferedImage image =null;
            
             try{
                  image = ImageIO.read(new File(f.getSelectedFile()+".jpg"));
                  
                 Graphics a=image.createGraphics();
                  
                  a.drawImage(image, 0, 0, f);
                  
              }
              catch(IOException ex){
                  
              }
             
           }
        
        
    });
         Save.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
           
             JFileChooser f = new JFileChooser();
              f.setDialogTitle("Save the Image");
              f.showSaveDialog(null);
              
             image=new BufferedImage(c.getWidth(), c.getHeight(),BufferedImage.TYPE_INT_RGB);
		
            
		Graphics g2=image.createGraphics();
   
		c.paint(g2);
		try {
			ImageIO.write(image, "jpg", new File(f.getSelectedFile()+".jpg"));
                       
                        JOptionPane.showMessageDialog(c, "Saved as   "+ f.getSelectedFile() +".jpg" );
                        
		} catch (IOException ex) { 
                  // Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
               } 
            
           
            //    Graphics g=image.createGraphics();
                
            
           }
       });
       file.add(Save);
     
       JMenuItem Exit =new JMenuItem ("Exit    ");
       
       Exit.addActionListener((ActionEvent e) -> {
           System.exit(0);
       });
       file.add(Open);
        file.add(Exit);
        menubar.add(file);
        
        
        add(c);
        setVisible(true); 
        setJMenuBar(menubar);
      
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

 
}


