package mylabpakage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAHE
 */
import com.jogamp.opengl.*;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class Line1 implements GLEventListener{
   @Override
   public void display(GLAutoDrawable a) {
      final GL2 gl = a.getGL().getGL2();
      gl.glBegin (GL2.GL_LINE_LOOP);//static field
      gl.glVertex3f(1,0,0);
      gl.glVertex3f(0,0,0);
      gl.glVertex3f(0,1,0);
      gl.glEnd(); 
      float x=(float)Math.random(),y=(float)Math.random();
      gl.glBegin (GL2.GL_POINTS);
      for(int i=0;i<10000000;i++)
      {
      int j=(int)(Math.random()*(6-1)+1);
      if(j==1 || j==2)
      {x=(x+1)/2;y=y/2;gl.glVertex2f(x,y);}
      if(j==4|| j==3)
      {x=(x)/2;y=(y+1)/2;gl.glVertex2f(x,y);}
      if( j==6|| j==5)
      {x=(x)/2;y=y/2;gl.glVertex2f(x,y);}
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
   public static void main(String[] args) {
      //getting the capabilities object of GL2 profile
      final GLProfile p = GLProfile.get(GLProfile.GL2);
      GLCapabilities c= new GLCapabilities(p);
      // The canvas 
      final GLCanvas glcanvas = new GLCanvas(c);
      Line1 l = new Line1();
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