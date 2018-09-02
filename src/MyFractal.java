
import com.jogamp.opengl.*;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import javax.swing.JFrame;

public class MyFractal implements GLEventListener{
    int arr[];
    MyFractal(){}
    MyFractal(int a[])
    {arr=a;}
   @Override
   public void display(GLAutoDrawable a) {
      final GL2 gl = a.getGL().getGL2();
      float ax=(float)0.25,ay=0;
      float bx=(float)Math.cos(Math.PI/3)/4,by=(float)Math.sin(Math.PI/3)/4;
      float cx=(float)Math.cos(2*Math.PI/3)/4,cy=(float)Math.sin(2*Math.PI/3)/4;
      float dx=(float)Math.cos(3*Math.PI/3)/4,dy=(float)Math.sin(3*Math.PI/3)/4;
      float ex=(float)Math.cos(4*Math.PI/3)/4,ey=(float)Math.sin(4*Math.PI/3)/4;
      float fx=(float)Math.cos(5*Math.PI/3)/4,fy=(float)Math.sin(5*Math.PI/3)/4;
      gl.glBegin (GL2.GL_LINE_LOOP);//static field
      gl.glVertex3f(ax,ay,0);
      gl.glVertex3f(bx,by,0);
      gl.glVertex3f(cx,cy,0);
      gl.glVertex3f(dx,dy,0);
      gl.glVertex3f(ex,ey,0);
      gl.glVertex3f(fx,fy,0);
      gl.glEnd(); 
      float x=(float)Math.random(),y=(float)Math.random();
      gl.glBegin (GL2.GL_POINTS);
      int k=0;
      while(k<1)
      {
      for(double i=0;i<10000;i++)
      {
      int j=(int)i%arr.length;
      if(arr[j]==1||arr[j]==2)
      {x=(x+ax)/2;y=(y+ay)/2;gl.glVertex2f(x,y);}
      if(arr[j]==2||arr[j]==3)
      {x=(x+bx)/2;y=(y+by)/2;gl.glVertex2f(x,y);}
      if(arr[j]==3||arr[j]==4)
      {x=(x+cx)/2;y=(y+cy)/2;gl.glVertex2f(x,y);}      
      if(arr[j]==4||arr[j]==5)
      {x=(x+dx)/2;y=(y+dy)/2;gl.glVertex2f(x,y);}
      if(arr[j]==5||arr[j]==6)
      {x=(x+ex)/2;y=(y+ey)/2;gl.glVertex2f(x,y);}
      if(arr[j]==6||arr[j]==1)
      {x=(x+fx)/2;y=(y+fy)/2;gl.glVertex2f(x,y);}
      }
      k++;
      }
      gl.glEnd(); 
     
      
   }
   @Override
   public void dispose(GLAutoDrawable a) {
      //method body
   }

   @Override
   public void init(GLAutoDrawable a) {
      // method body
   }
   @Override
   public void reshape(GLAutoDrawable a, int b, int c, int d, int e) {
      // method body
   }
   public static void main(String[] args) throws Exception {
	    FileReader reader = new FileReader("C:\\Users\\MAHE\\Desktop\\lab\\src\\hi.txt");
	    BufferedReader bufferedReader = new BufferedReader(reader);			 
	    String line="";
            String nums="";

            line=bufferedReader.readLine();
            System.out.println(line);
            while ((line) != null) {
            nums+=(line+",");  
            line=bufferedReader.readLine();
                    }
            reader.close();
            StringTokenizer st=new StringTokenizer(nums,",");
      int arr[]=new int[st.countTokens()];
      for(int i=0;i<arr.length;i++)
      { arr[i]=Integer.parseInt(st.nextToken());
      System.out.println(arr[i]);
      }
      //getting the capabilities object of GL2 profile
      final GLProfile p = GLProfile.get(GLProfile.GL2);
      GLCapabilities c= new GLCapabilities(p);
      // The canvas 
      final GLCanvas glcanvas = new GLCanvas(c);
      MyFractal l=new MyFractal(arr);
      glcanvas.addGLEventListener(l);
      glcanvas.setSize(400, 400);
      //creating frame
      final JFrame f= new JFrame ("triangle");
      //adding canvas to frame
      f.getContentPane().add(glcanvas);
      f.setSize(f.getContentPane().getPreferredSize());
      f.setVisible(true);
   }//end of main
}//end of classimport javax.media.opengl.GL2;