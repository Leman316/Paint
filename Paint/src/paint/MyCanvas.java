/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;




import Shapes.*;
import Tools.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javafx.scene.image.WritableImage;



/**
 *
 * @author D
 */
class MyCanvas extends Canvas{

    public int i,f,index;
    public int oldX,oldY;
    public int mx_start, my_start, mx_end,my_end;
    
    
    MyCircle temp,currCircle;
    MyRectangle temp2,currRect;
    Lines t,curr;
    MyOval oval,currOval;
    MyPentagon poly,penta;
    MyStar star,st;
    
    Brush er;
    Eraser era;
    
    private Color defaultColor;
    private Color defaultfillColor;
    
    ArrayList <MyCircle> circles,filledcircles;
    ArrayList <MyRectangle> rectangles,filledrectangles;
    ArrayList <Lines> lines;
    ArrayList <MyOval> ovals,filledovals; 
    ArrayList <MyPentagon> polys,filledpolys;
    ArrayList <MyStar> stars,filledstars;
    ArrayList <Brush> br;
    ArrayList <Eraser> rub;
    
    int x,y;
    
    
    
   // MyCanvas canvas;
    
 //   boolean ff=false,fy=false;
    

    
    
    
    int tool;
    
     public MyCanvas() {
        
        setSize(800, 600);
        setBounds(100, 0, 805, 490);
        setBackground(Color.white);
        setVisible(true);
        Handler handler = new Handler();
        super.addMouseListener(handler);
        super.addMouseMotionListener(handler);
        
        star = new MyStar();
        
        circles=new ArrayList <>();  
        filledcircles=new ArrayList <>();  
        rectangles =new ArrayList <>();
        filledrectangles =new ArrayList <>();
        lines =new ArrayList <>();
        ovals =new ArrayList <>(); 
        filledovals =new ArrayList <>(); 
        polys=new ArrayList<>();
        filledpolys=new ArrayList<>();
        stars = new ArrayList <>();//1
        filledstars = new ArrayList <>();//2 
        br=new ArrayList<>();
        rub=new ArrayList<>();
        
        

    }

    public void setDefaultfillColor(Color defaultfillColor) {
        this.defaultfillColor = defaultfillColor;
    }

    public void setDefaultColor(Color defaultColor) {
        this.defaultColor = defaultColor;
    }
     
 
    @Override
      public void paint(Graphics g) {
        
          
       //    super.paint(g);
          

          
    //    g.drawLine(mx_start, my_start, mx_end, my_end);

             for(MyCircle x:circles)      //Draw circles
             {
               
                 
                 g.setColor(x.col);
                 g.drawOval(x.cx, x.cy, x.r, x.r);
                 
             }
             
               for(MyCircle x:filledcircles)       ///Draw Filled Circles
             {
               
                 g.setColor(x.col);      
                 g.drawOval(x.cx-1, x.cy-1, x.r+1, x.r+1);
                 g.setColor(x.fcol);
                 g.fillOval(x.cx, x.cy, x.r, x.r);
                 
             }
             
             for(MyRectangle a: rectangles){   //Rectangles
                
     
                 g.setColor(a.c);
                 g.drawRect(a.mx, a.my, a.mx_e, a.my_e);
                 
             
             }
             
             for(MyRectangle a: filledrectangles){
                 
                 g.setColor(a.c);
                 g.drawRect(a.mx-1, a.my-1, a.mx_e+1, a.my_e+1);
                
     
                 g.setColor(a.fc);
                 g.fillRect(a.mx, a.my, a.mx_e, a.my_e);
                 
             
             }
             
             
             
             for(Lines m:lines){               //Lines
                g.setColor(m.c);
               g.drawLine(m.mx_s, m.my_s, m.mx_e,m.my_e);
           }
             
             
             for(MyOval oval:ovals)   //Ovals
             {
                 g.setColor(oval.c);
                 g.drawOval(oval.mx, oval.my, oval.rx, oval.ry);
                 
             }
             
              for(MyOval oval:filledovals)    
             {
                 
                 g.setColor(oval.c);
                 g.drawOval(oval.mx-1, oval.my-1, oval.rx+1, oval.ry+1);
                 g.setColor(oval.fc);
                 g.fillOval(oval.mx, oval.my, oval.rx, oval.ry);
                 
             }
             
             for(MyPentagon p:polys){        /// Pentagons
                
                 g.setColor(p.c);
                 g.drawPolygon(p.xarr, p.yarr, p.n);
                 
                 
             }
             
              for(MyPentagon p:filledpolys){
                
                  g.setColor(p.c);
                 g.drawPolygon(p.xarr, p.yarr, p.n);
                 g.setColor(p.fc);
                 g.fillPolygon(p.xarr, p.yarr, p.n);
                 
                 
             }
             for(MyStar s:stars){               //stars
                // System.out.println(stars.size());      
                 g.setColor(s.c);
                 g.drawPolygon(s.xarr, s.yarr, s.n);
             }
             
             for(MyStar st:filledstars)
             {   
                 
                    g.setColor(st.c);
                     g.drawPolygon(st.xarr, st.yarr, st.n);
                     g.setColor(st.fc);
                    g.fillPolygon(st.xarr, st.yarr, st.n);
             }    
             
             for(Brush a: br){             //Brushes
                 
                 g.setColor(a.col);
                 g.fillRect(a.mx, a.my, a.h, a.w);
                
             }
             for(Eraser a: rub){              //Eraser
                 
                 g.setColor(Color.white);
                 g.clearRect(a.mx, a.my, a.h, a.w);
                 
      
             }
             
          
                 
                 
                   
        }
      
      
      public void setCurrCircle(MyCircle c)
      {
          this.currCircle=c; 
      
      }
      
      public void setCurrRect(MyRectangle r)
      {
          this.currRect=r;  
      }
      
       public void setCurrLine(Lines l)
      {
          this.curr=l;  
      }
      
         private void setCurrOval(MyOval ov) {
             
             this.currOval=ov;
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
         
         
         private void setCurPenta(MyPentagon pe) {
             this.penta=pe;
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
         
            private void setCurStar(MyStar s) {
                
             this.st=s;
           //  s.fc=defaultfillColor;
           
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
            
            
  

   


   
      
      
      
      
      
      
      class Handler implements MouseMotionListener,MouseListener{

        @Override
        public void mouseDragged(MouseEvent e) {
            
          //For Reshaping
            
            if(f==1)
            {                           //Circles
                
              //  temp.cx=e.getX();
              //  temp.cy=e.getY();
               
                temp.r=e.getX()-temp.cx;
             
                repaint();
   
            }
            if(f==2){           //Rects
                
               // temp2.mx_s=e.getX();
               // temp2.my_s=e.getY();
                
                temp2.mx_e=e.getX()-temp2.mx;
                temp2.my_e=e.getY()-temp2.my;
                
               
                
                repaint();
                
            }
            
             
            if(f==3){                //Lines
               
                t.mx_e=e.getX();
                t.my_e=e.getY();
                repaint();
                
                
            }
            
           
                
            
            
            if(f==4){                 //Ovals
                
                oval.rx=e.getX()-oval.mx;
                oval.ry=e.getY()-oval.my;
              
                repaint();
                
                
            }
                
             if(f==5){
                    
             // poly.r=(int) ((int)Math.sqrt(Math.pow((e.getX()-poly.x),2)+Math.pow((e.getY()-poly.y),2)))/15;
             poly.r=(e.getX()-poly.x)/5;
              poly.xarr[0]=poly.x;
              poly.yarr[0]=poly.y-5* poly.r;
              poly.xarr[1]=poly.x-4* poly.r;
              poly.yarr[1]=poly.y-3* poly.r;
              poly.xarr[2]=poly.x-3* poly.r;
              poly.yarr[2]=poly.y+4* poly.r;
              poly.xarr[3]=poly.x+3* poly.r;
              poly.yarr[3]=poly.y+4* poly.r;             
              poly.xarr[4]=poly.x+4* poly.r;
              poly.yarr[4]=poly.y-3* poly.r; 
                   repaint();
                }
             
             if(f==6 ){
        //   star.r=(int) ((int)Math.sqrt(Math.pow((e.getX()-star.x),2)+Math.pow((e.getY()-star.y),2)))/15;    
             star.r=(e.getX()-star.x)/5;
      
              star.xarr[0]=star.x;
            
              star.yarr[0]=star.y-5*star.r;
              star.xarr[2]=star.x-4*star.r;
              star.yarr[2]=star.y-3*star.r;
              star.xarr[4]=star.x-3*star.r;
              star.yarr[4]=star.y+4*star.r;
              star.xarr[1]=star.x+3*star.r;
              star.yarr[1]=star.y+4*star.r;             
              star.xarr[3]=star.x+4*star.r;
              star.yarr[3]=star.y-3*star.r;
              
              
                 repaint();
             
             }
             
             if(f==8){
               Brush es =new Brush();
               es.col=defaultColor;
               er=es;
               es.mx=e.getX();
               es.my=e.getY();
               
                 er.h=3;
                 er.w=3;
                  br.add(es);
                 repaint();
                 
                 
           }
             
              if(f==11){
               Brush es =new Brush();
               es.col=defaultColor;
          //     er=es;
               es.mx=e.getX();
               es.my=e.getY();
               
                 es.h=6;
                 es.w=6;
                  br.add(es);
                 repaint();
                
                 
                 
           }
              if(f==9){
               Eraser r =new Eraser();
             //  r.col=Color.WHITE;
               era=r;
               r.mx=e.getX();
               r.my=e.getY();
               
                 r.h=10;
                 r.w=10;
                rub.add(r);
                repaint();
                 
           }
          
            
            
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseMoved(MouseEvent e) {
               
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseClicked(MouseEvent e) {
           
           //System.out.println(e.getX()+ "  "+ e.getY());
         
      
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
              

          //  Shapes Are Created
          //  In this function
          
          
            if(f==1){
            
            MyCircle circle = new MyCircle();
           
            circle.col=defaultColor;
            circle.fcol=defaultfillColor;
            
            circle.cx=e.getX();
            circle.cy=e.getY();
            temp=circle;
             setCurrCircle(circle);
             if(i==10 )filledcircles.add(circle);
             else circles.add(circle);
            
            repaint();
            }
            
            
           if (f==3) {

                Lines l = new Lines();
                
                setCurrLine(l);
                l.c=defaultColor;
                t = l;
                l.mx_s = e.getX();
                l.my_s = e.getY();
                l.mx_e = e.getX();
                l.my_e = e.getY();
                lines.add(l);
                repaint();
            }
            
           if(f==2){
            MyRectangle rect = new MyRectangle();
            setCurrRect(rect);
            rect.c=defaultColor;
            rect.fc=defaultfillColor;
            temp2=rect;
            rect.mx=e.getX();
            rect.my=e.getY();
            if(i==10) filledrectangles.add(rect);
            else rectangles.add(rect);        
            repaint();
            }
           
         
           
           
             
            if(f==4){
            MyOval ov = new MyOval();
            
            setCurrOval(ov);
            ov.c=defaultColor;
            ov.fc=defaultfillColor;
            oval=ov;
            ov.mx=e.getX();
            ov.my=e.getY();
            if(i==10 ) filledovals.add(ov);
            else  ovals.add(ov);
            
            repaint();
                
                
            }
            
                  
          if(f==5){ 
        //      while ()
              MyPentagon p= new MyPentagon();
              setCurPenta(p);
              p.c=defaultColor;
              p.fc=defaultfillColor;
              //poly=p;
              p.n=5;
             
              p.x=e.getX();
              p.y=e.getY();
              p.r=e.getX()-p.x;
              p.xarr[0]=p.x;
              p.yarr[0]=p.y-5*p.r;
              p.xarr[1]=p.x-4*p.r;
              p.yarr[1]=p.y-3*p.r;
              p.xarr[2]=p.x-3*p.r;
              p.yarr[2]=p.y+4*p.r;
              p.xarr[3]=p.x+3*p.r;
              p.yarr[3]=p.y+4*p.r;             
              p.xarr[4]=p.x+4*p.r;
              p.yarr[4]=p.y-3*p.r; 
             if(i==10 ) filledpolys.add(p);
              else polys.add(p);
             poly=p;
              repaint();
          
        } 
          
          
           if(f==6){ 
        
              
           
             
              st = new MyStar();
              setCurStar(st);
               st.c=defaultColor;
              
             st.fc=defaultfillColor;
            
            //  st.a=false;
               st.n=5;
           //   s.r=5;
              st.x=e.getX();
              st.y=e.getY();
              st.r=1;
              st.xarr[0]=e.getX();
              st.yarr[0]=e.getY()-5*st.r;
              st.xarr[2]=e.getX()-4*st.r;
              st.yarr[2]=e.getY()-3*st.r;
              st.xarr[4]=e.getX()-3*st.r;
              st.yarr[4]=e.getY()+4*st.r;
              st.xarr[1]=e.getX()+3*st.r;
              st.yarr[1]=e.getY()+4*st.r;             
              st.xarr[3]=e.getX()+4*st.r;
              st.yarr[3]=e.getY()-3*st.r; 
              if(i==10)filledstars.add(st);
              else stars.add(st);
               star = st;
              repaint();
          
        } 
           
           
           
           
           
      
            
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
         
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
          
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
          //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    
     
      }
      
}
   