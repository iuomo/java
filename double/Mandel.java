  import java.applet.APPLET;  
    import java.awt.*;  
     
  public class Mandel extends JApplet implements Runnable{  
      Image image;  
      Thread t;  
    Point[] p;  
    int height,width;  
     boolean flag;  
      public void init(){  
         image = getImage(getCodeBase(),"mandel.jpg");  
         setSize(800,600);  
        height = getHeight();  
         width = getWidth();  
        p = new Point[1000];  
       for(int i=0 ;i<p.length ; i++)  
            p[i] = new Point();  
         
          int x = 10,y = 10,i=0;  
            
        while( x + 10 < width){  
             p[i].x = x;  
           p[i].y = y;  
              x+=10;  
             i++;  
          }  
         while(y+80<height){  
              p[i].x = x;  
             p[i].y = y;  
             y+=10;  
              i++;  
         }  
          while( x - 10 > 0){  
             p[i].x = x;  
             p[i].y = y;  
             x-=10;  
             i++;  
         }  
          while( x - 10 > 0){  
              p[i].x = x;  
              p[i].y = y;  
              x-=10;  
              i++;  
          }  
          while( y-10 > 0 ){  
             p[i].x = x;  
             p[i].y = y;  
            y-=10;  
             i++;  
         }  
           
          flag = false;     
        t = new Thread(this);  
         t.start();  
      }  
     public void run(){  
         while(true){  
            try{  
                flag = !flag;  
                repaint();  
                 Thread.sleep(1000);  
              }  
               catch(InterruptedException ex){}  
         }  
      }  
     public void paint(Graphics g){  
        
        g.drawImage(image,0,0,800,600,this);  
        if(flag){  
              g.setColor(new Color(145,243,190));  
             for(int i = 0;i<p.length;i++){  
                  g.fillOval(p[i].x,p[i].y,5,5);  
             }  
         }  
           
     }  
 }  
