package week8;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UI3Test extends JFrame
{
	
	public UI3Test()
	{
		setSize(100, 100);
	}

	public static void main(String s[])
	{
		UI3Test sui = new UI3Test();
		sui.setVisible(true);
		sui.addMouseMotionListener(new MouseHandler2(sui.getGraphics()));
	}
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		System.out.println("In paint component");
	}
}

class MouseHandler2 implements  MouseMotionListener
{
	private Graphics gc;
	private int x, y;

	MouseHandler2(Graphics g){
		this.gc=g;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		gc.drawLine(x, y, e.getX(), e.getY());
		x=e.getX();
		y=e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}