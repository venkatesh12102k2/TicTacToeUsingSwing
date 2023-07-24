package tic_tac_toe;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class GameFrame extends JFrame implements MouseListener{
	int p=-1;
	int count=0;
	int time = 10;
	int[][] a = new int[3][3];
	JLabel commentary,xTimer,oTimer,xTimerLabel,oTimerLabel;
	JButton start;
	JLabel[][] labels = new JLabel[3][3];
	Timer xTimerObj,oTimerObj;
	GameFrame()
	{
		commentary = new JLabel("GAME STARTS WITH O");
		start = new JButton("START");
		xTimerLabel = new JLabel("X");
		oTimerLabel = new JLabel("O");
		xTimer = new JLabel(time+"");
		oTimer = new JLabel(time+"");
		addMouseListener(this);
		setTitle("Tic Tac Toe");
		setLayout(null);
		setSize(800,800);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		oTimerObj = new Timer(1000,oGameTimer);	
		xTimerObj = new Timer(1000,xGameTimer);
		start.addActionListener(ae->
		{
			oTimerObj.start();
			start.setEnabled(false);
		});
		
		
	}
	
	ActionListener xGameTimer = new ActionListener()
	{
		int timeRem=time;
		public void actionPerformed(ActionEvent e)
		{
			if(timeRem == 0)
			{
				commentary.setText("PLAYER X TIME OUT!!! PLAYER O WON");
				count = 9;
				oTimerObj.stop();
				xTimerObj.stop();
			}
			else
			{
				timeRem--;
				xTimer.setText(timeRem+"");
			}
		}
	};
	
	ActionListener oGameTimer = new ActionListener()
	{
		int timeRem=time;
		public void actionPerformed(ActionEvent e)
		{
			if(timeRem == 0)
			{
				commentary.setText("PLAYER O TIME OUT!!! PLAYER X WON");
				count = 9;
				oTimerObj.stop();
				xTimerObj.stop();
			}
			else
			{
				timeRem--;
				oTimer.setText(timeRem+"");
			}
		}
	};
	
	public void paint(Graphics g)
	{
		g.drawRect(100, 100, 600, 600);
		g.drawLine(100,300,700,300);
		g.drawLine(100, 500, 700, 500);
		g.drawLine(300, 100, 300, 700);
		g.drawLine(500, 100, 500, 700);
		
		add(xTimer);
		xTimer.setBounds(10,350,70,70);
		xTimer.setFont(new Font("Arial",Font.PLAIN,25));
		add(oTimer);
		oTimer.setBounds(725,350,70,70);
		oTimer.setFont(new Font("Arial",Font.PLAIN,25));
		
		add(commentary);
		commentary.setBounds(250,710,500,25);
		commentary.setFont(new Font("Arial",Font.PLAIN,25));
		
		this.add(start);
		start.setBounds(325,40,150,25);
		add(xTimerLabel);
		xTimerLabel.setBounds(20,300,50,25);
		xTimerLabel.setFont(new Font("Arial",Font.BOLD,25));
		add(oTimerLabel);
		oTimerLabel.setBounds(725,300,50,25);
		oTimerLabel.setFont(new Font("Arial",Font.BOLD,25));
	}
	
	public void mousePressed(MouseEvent e) {
			if(start.isEnabled()) return;
			if(count == 0);
			{
				xTimerObj.start();
			}
	
	
			if(p==-1)
			{
				oTimerObj.stop();
				xTimerObj.restart();
			}
			else
			{
				xTimerObj.stop();
				oTimerObj.restart();
			}
			
			int x=e.getX();
			int y =e.getY();
			if(x>100 && x<700 && y>100 && y<700 && count<9)
			{
				JLabel label = getLabel();
				count++;
				
				if(a[0][0]==0 && x>100 && x<300 && y>100 && y<300)//square 1
				{
					a[0][0]=p;
					add(label);
					label.setBounds(150,150,100,100);
					labels[0][0]=label;
				}
				else if(a[0][1]==0 && x>300 && x<500 && y>100 && y<300)//square 2
				{
					a[0][1]=p;
					add(label);
					label.setBounds(350,150,100,100);
					labels[0][1]=label;
				}
				else if(a[0][2]==0 && x>500 && x<700 && y>100 && y<300)//square 3
				{
					a[0][2]=p;
					add(label);
					label.setBounds(550,150,100,100);
					labels[0][2]=label;
				}
				else if(a[1][0]==0 && x>100 && x<300 && y>300 && y<500)//square 4
				{
					a[1][0]=p;
					add(label);
					label.setBounds(150,350,100,100);
					labels[1][0]=label;
				}
				else if(a[2][0]==0 && x>100 && x<300 && y>500 && y<700)//square 7
				{
					a[2][0]=p;
					add(label);
					label.setBounds(150,550,100,100);
					labels[2][0]=label;
				}
				else if(a[1][1]==0 && x>300 && x<500 && y>300 && y<500)//square 5
				{
					a[1][1]=p;
					add(label);
					label.setBounds(350,350,100,100);
					labels[1][1]=label;
				}
				else if(a[2][1]==0 && x>300 && x<500 && y>500 && y<700)//square 8
				{
					a[2][1]=p;
					add(label);
					label.setBounds(350,550,100,100);
					labels[2][1]=label;
				}
				else if(a[1][2]==0 && x>500 && x<700 && y>300 && y<500)//square 6
				{
					a[1][2] = p;
					add(label);
					label.setBounds(550,350,100,100);
					labels[1][2]=label;
				}
				else if(a[2][2]==0 && x>500 && x<700 && y>500 && y<700)//square 9
				{
					a[2][2] = p;
					add(label);
					label.setBounds(550,550,100,100);
					labels[2][2]=label;
				}
				p=-p;
				if(checkWin()!=0)
				{
					switch(checkWin())
					{
					case 1:
						for(int i=0;i<3;i++)
						{
							labels[0][i].setBackground(Color.green);
						}
						break;
					case 2:
						for(int i=0;i<3;i++)
						{
							labels[1][i].setBackground(Color.green);
						}
						break;
					case 3:
						for(int i=0;i<3;i++)
						{
							labels[2][i].setBackground(Color.green);
						}
						break;
					case 4:
						for(int i=0;i<3;i++)
						{
							labels[i][0].setBackground(Color.green);
						}
						break;
					case 5:
						for(int i=0;i<3;i++)
						{
							labels[i][1].setBackground(Color.green);
						}
						break;
					case 6:
						for(int i=0;i<3;i++)
						{
							labels[i][2].setBackground(Color.green);
						}
						break;
					case 7:
						for(int i=0;i<3;i++)
						{
							labels[i][i].setBackground(Color.green);
						}
						break;
					case 8:
						for(int i=0;i<3;i++)
						{
							labels[i][3-i-1].setBackground(Color.green);
						}
						break;
					}
					count = 9;
					p=-p;
					commentary.setText("PLAYER "+getPlayer()+" WON");
					oTimerObj.stop();
					xTimerObj.stop();
				}
				else if(count==9) 
				{
					commentary.setText("MATCH IS DRAW");
					xTimerObj.stop();
					oTimerObj.stop();
				}
				else commentary.setText("PLAYER "+getPlayer()+" TURN");
				
			}
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {	
	}
	public void mouseExited(MouseEvent e) {	
	}
	public void mouseClicked(MouseEvent e) {		
	}


	public String getPlayer()
	{
		return (p==-1)?"O":"X";
	}
	
	public JLabel getLabel() 
	{
		String str;
		JLabel l;
		if(p == 1) str="X";
		else str="O";
		l = new JLabel(str);
		l.setOpaque(true);
		l.setFont(new Font("MV Boli",Font.PLAIN,100));
		return l;
	}
	
	
	public int checkWin()
	{
		int i,j,c,tmp;
		//checking horizontally
		for(i=0;i<3;i++)
		{
			c=0;
			tmp=a[i][0];
			for(j=0;j<3;j++)
			{
				
				if(a[i][j]!=0 && a[i][j] == tmp) c++;
			}
			if(c == 3) return i+1;
		}
		
		//checking vertically
		for(j=0;j<3;j++)
		{
			c=0;
			tmp=a[0][j];
			for(i=0;i<3;i++)
			{
				if(a[i][j] == tmp && a[i][j]!=0) c++;
			}
			if(c == 3) return j+4;
		}
		
		//checking top left to bottom right diagonal
		c=0;
		tmp=a[0][0];
		for(i=0;i<3;i++)
		{
			if(a[i][i]==0) break;
			if(a[i][i] == tmp) c++;
		}
		if(c==3) return 7;
		
		
		//checking top right to bottom left
		c=0;
		tmp=a[0][2];
		for(i=0;i<3;i++)
		{
			if(a[i][3-i-1]==0) break;
			if(a[i][3-i-1] == tmp) c++;
		}
		if(c==3) return 8;
		return 0;
	}
}

public class TicTacToe
{
	public static void main(String[] args) {
		new GameFrame();
	}
}
