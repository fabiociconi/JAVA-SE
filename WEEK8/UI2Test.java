import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UI2Test extends JFrame
{
	public UI2Test()
	{
		setSize(100, 100);
		addMouseListener(new MouseHandler());
	}

	public static void main(String s[])
	{
		UI2Test sui = new UI2Test();
		sui.setVisible(true);
	}
}

class MouseHandler implements MouseListener
{
	public void mouseClicked(MouseEvent ev)
	{
		System.out.println("mouse clicked at="+ev.getX()+","+ev.getY());
	}
	public void mouseEntered(MouseEvent ev)
	{
		System.out.println("mouse entered at="+ev.getX()+","+ev.getY());
	}
	public void mouseExited(MouseEvent ev)
	{
		System.out.println("mouse exited at="+ev.getX()+","+ev.getY());
	}
	public void mousePressed(MouseEvent ev)
	{
		System.out.println("mouse pressed at="+ev.getX()+","+ev.getY());
	}
	public void mouseReleased(MouseEvent ev)
	{
		System.out.println("mouse released at="+ev.getX()+","+ev.getY());
	}
}