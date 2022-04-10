import javax.swing.*;
import java.awt.*;
import java.awt.event.*;	
class FDemo extends JFrame
{
 JPDemo jp;
 FDemo()
 { 
  super.setTitle("Snake & Leader"); 
  jp=new JPDemo();
  add(jp);
 }
}
class JPDemo extends JPanel implements ActionListener,KeyListener
{
 ImageIcon img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11;
 Image swt,board,s1,start,player1,player2,player11,player12,dice,dice0;
 
 JButton b1,b2,b3,b4;
 JTextField tx1,tx2,tx3;
 
 int px1=40;
 int py1=620;
 int px2=120;
 int py2=620;
 int score=0;
 int score2=0;
 int x=0;
 boolean b=false;
 boolean b0=false;
 JPDemo()
 {
  setBackground(Color.black);
  
  img1=new ImageIcon("swt.jpg");
  img2=new ImageIcon("board.jpg");
  img3=new ImageIcon("s1.png");
  img4=new ImageIcon("start.jpg");
  img5=new ImageIcon("about.gif");
  img6=new ImageIcon("reset.png");
  img7=new ImageIcon("start.gif");
  img8=new ImageIcon("player1.png");
  img9=new ImageIcon("player2.png");
  img10=new ImageIcon("dice.gif");
  img11=new ImageIcon("dice0.jpg");
 
  swt=img1.getImage();
  board=img2.getImage();
  s1=img3.getImage();
  start=img4.getImage();
  
  player1=img8.getImage();
  player2=img9.getImage();

  player11=img8.getImage();
  player12=img9.getImage();

  dice=img10.getImage();
 dice0=img11.getImage();
 
  setLayout(null);

  b1=new JButton(img5);
  b1.setBounds(50,120,100,30);
  add(b1);
  b1.setBackground(new Color(4,129,255));

  b2=new JButton(img6);
  b2.setBounds(50,180,100,30);
  add(b2);
  b2.setBackground(new Color(4,129,255));
  b2.addActionListener(this);

  Font f=new Font("bauhaus 93",Font.ITALIC,20);
  
  tx1=new JTextField("Start Game");
  tx1.setBounds(50,230,150,35);
  add(tx1);
  tx1.setBackground(Color.black);
  tx1.setForeground(Color.green);
  tx1.setFont(f);

  tx2=new JTextField("Player 1 Name");
  tx2.setBounds(50,290,150,35);
  add(tx2);
  tx2.setBackground(Color.black);
  tx2.setForeground(Color.green);
  tx2.setFont(f);
  tx2.addKeyListener(this);
   
  tx3=new JTextField("Player 2 Name");
  tx3.setBounds(50,375,150,35);
  add(tx3);
  tx3.setBackground(Color.black);
  tx3.setFont(f);
  tx3.addKeyListener(this);

  b3=new JButton("Roll");
  b3.setBounds(50,500,100,30);
  add(b3);
  b3.setBackground(Color.red);
  b3.setFont(f);
  b3.addActionListener(this);
  
  b4=new JButton(img7);
  b4.setBounds(20,560,150,60);
  add(b4);
  b4.setBackground(Color.red);
  b4.setFont(f);
 }
 public void paintComponent(Graphics g)
 {
  super.paintComponent(g);

  
  if(px1==140)
  {
   px1=70*25;
  }
  g.setColor(new Color(4,129,255));
  g.fillRect(0,0,200,735);

  g.drawImage(swt,0,0,this);
  g.drawImage(board,200,0,this);
  g.drawImage(s1,920,0,this);
  g.drawImage(start,20,550,this);

  g.drawImage(player1,px1,py1,this);
  g.drawImage(player2,px2,py2,this);
  
  g.drawImage(player11,10,280,this);
  g.drawImage(player12,10,360,this);
  
  g.drawImage(dice,10,420,this);
  g.drawImage(dice0,110,430,this);
  if(b)
   { 
       System.out.println("player1win");
	   g.setColor(Color.black);
	   Font f=new Font("Algerian",Font.BOLD,50);
	   g.setFont(f);
	   g.drawString("Player 1 is Winner",350,200);
   }
   if(b0)
   { 
System.out.println("player 2 win");
	   g.setColor(Color.black);
	   Font f=new Font("Algerian",Font.BOLD,50);
	   g.setFont(f);
	   g.drawString("Player 2 is Winner",350,200);
   }
 
  }
 public void actionPerformed(ActionEvent e)
 {
   if(e.getSource()==b2)
   {
    px1=40;
    py1=620;
	px2=120;
	py2=620;
	score=0;
	score2=0;
	b=false;
	b0=false;
   }
 
  if(e.getSource()==b3)
  {
   int random=(int)Math.round(Math.random()*5+1);
   score+=random;
   if(px1==280)
   {
    px1=70*25;
   }
   switch(random)
   {
    case 1:
    img11=new ImageIcon("dice1.png");
    break;
    case 2:
    img11=new ImageIcon("dice2.png");
    break;
    case 3:
    img11=new ImageIcon("dice3.png");  			
    break;
    case 4:
    img11=new ImageIcon("dice4.png");
    break;
    case 5:
    img11=new ImageIcon("dice5.png");
    break;
    case 6:
    img11=new ImageIcon("dice6.png");
    break;
   }
  int x=140;
  int y=645;
  int k=1;
  int count=score;
  int count1=0;
  px1=210;
  py1=645;
  
  if(score>=100)
  {
	  b=true;
	  px1=40;
	  py1=620;
  }
	 
  M: for(int i=1;i<=10;i++)
     {
      if(k==11)
      {
       x-=70;
       px1-=70;
       k--;
      }
      if(k==0)
      {
       x+=70;
       px1+=70;
       k++;
      } 
	  if(score==4)
		 {
			
			 px1=70*12;
			 score=25;
			 y-=70;
			 for(int j=1;j<=2;j++)
			 {
			 for( i=1;i<=4;i++)
			 {
			 px1-=70;
			 }
	         py1-=70;
			 }
		 }
		 if(score==13)
		 {
			
			 px1=70*25;
			 score=46;
			 y-=70;
			 for(int j=1;j<=3;j++)
			 {
			 for( i=1;i<=3;i++)
			 {
			 px1-=70;
			 }
	         py1-=70;
			 }
		 }
		 if(score==33)
		 {
			
			 px1=70*24;
			 score=49;
			 y-=70;
			 for(int j=1;j<=1;j++)
			 {
			 for( i=1;i<=5;i++)
			 {
			 px1-=70;
			 }
	         py1-=70;
			 }
		 }
		
		 if(score==42)
		 {
			
			 px1=70*16;
			 score=63;
			 y-=70;
			 for(int j=1;j<=2;j++)
			 {
			 for( i=1;i<=5;i++)
			 {
			 px1-=70;
			 }
	         py1-=70;
			 }
		 }
		 if(score==50)
		 {
			
			 px1=70*10;
			 score=69;
			 y-=70;
			 for(int j=1;j<=2;j++)
			 {
			 for( i=1;i<=4;i++)
			 {
			 px1-=70;
			 }
	         py1-=70;
			 }
		 }
		 if(score==62)
		 {
			
			 px1=70*12;
			 score=81;
			 y-=70;
			 for(int j=1;j<=2;j++)
			 {
			 for( i=1;i<=4;i++)
			 {
			 px1-=70;
			 }
	         py1-=70;
			 }
		 }
		 if(score==74)
		 {
			
			 px1=70*9;
			 score=92;
			 y-=70;
			 for(int j=1;j<=2;j++)
			 {
			 for( i=1;i<=2;i++)
			 {
			 px1-=70;
			 }
	         py1-=70;
			 }
		 }
		 if(score==27)
		 {
			
			 px1=70*11;
			 score=5;
			 y-=70;
			 for(int j=1;j<=2;j++)
			 {
			 for( i=1;i<=1;i++)
			 {
			 px1+=70;
			 }
	         py1+=70;
			 }
		 }
		 if(score==40)
		 {
			
			 px1=70*3;
			 score=3;
			 y-=70;
			 for(int j=1;j<=3;j++)
			 {
			 for( i=1;i<=1;i++)
			 {
			 px1+=70;
			 }
	         py1+=70;
			 }
		 }
		 if(score==43)
		 {
			
			 px1=70*4;
			 score=18;
			 y-=70;
			 for(int j=1;j<=3;j++)
			 {
			 for( i=1;i<=1;i++)
			 {
			 px1+=70;
			 }
	         py1+=70;
			 }
		 }
		 if(score==54)
		 {
			
			 px1=70*17;
			 score=31;
			 y-=70;
			 for(int j=1;j<=2;j++)
			 {
			 for( i=1;i<=1;i++)
			 {
			 px1+=70;
			 }
	         py1+=70;
			 }
		 }
		 if(score==66)
		 {
			
			 px1=70*10;
			 score=45;
			 y-=70;
			 for(int j=1;j<=2;j++)
			 {
			 for( i=1;i<=1;i++)
			 {
			 px1+=70;
			 }
	         py1+=70;
			 }
		 }
		 if(score==76)
		 {
			
			 px1=70*8;
			 score=58;
			 y-=70;
			 for(int j=1;j<=2;j++)
			 {
			 for( i=1;i<=1;i++)
			 {
			 px1+=70;
			 }
	         py1+=70;
			 }
		 }
		 if(score==89)
		 {
			
			 px1=70*15;
			 score=53;
			 y-=70;
			 for(int j=1;j<=3;j++)
			 {
			 for( i=1;i<=1;i++)
			 {
			 px1+=70;
			 }
	         py1+=70;
			 }
		 }
		 if(score==99)
		 {
			
			 px1=70*8;
			 score=41;
			 y-=70;
			 for(int j=1;j<=5;j++)
			 {
			 for( i=1;i<=1;i++)
			 {
			 px1+=70;
			 }
	         py1+=70;
			 }
		 }
      for(int j=1;j<=10;j++)
      {  
       count1++;     
       if(count1==count)break M;
       if(i%2==1)
       {
        x+=70;
        px1+=70; 
        k++;
       }
       else
       {
        x-=70;
        px1-=70;
        k--;
       }  
      }
       y-=70;
       py1-=70;
     }
   }
    
      
	  
	  
	  
	  
  if(e.getSource()==b3)
  {
   int random=(int)Math.round(Math.random()*5+1);
   score2+=random;
   
   switch(random)
   {
    case 1:
    img11=new ImageIcon("dice1.png");
    break;
    case 2:
    img11=new ImageIcon("dice2.png");
    break;
    case 3:
    img11=new ImageIcon("dice3.png");  			
    break;
    case 4:
    img11=new ImageIcon("dice4.png");
    break;
    case 5:
    img11=new ImageIcon("dice5.png");
    break;
    case 6:
    img11=new ImageIcon("dice6.png");
    break;
   }
  int x=140;
  int y=645;
  int k=1;
  int count=score2;
  int count1=0;
  px2=210;
  py2=645;
    
  if(score2>=100)
  {
	  b0=true;
	  px2=120;
	  py2=620;
  }	
  
  M: for(int i=1;i<=10;i++)
     {
      if(k==11)
      {
       x-=70;
       px2-=70;
       k--;
      }
      if(k==0)
      {
       x+=70;
       px2+=70;
       k++;
      } 
	  if(score2==4)
		 {
			
			 px2=70*12;
			 score2=25;
			 y-=70;
			 for(int j=1;j<=2;j++)
			 {
			 for( i=1;i<=4;i++)
			 {
			 px2-=70;
			 }
	         py2-=70;
			 }
		 }
		 if(score2==13)
		 {
			
			 px2=70*25;
			 score2=46;
			 y-=70;
			 for(int j=1;j<=3;j++)
			 {
			 for( i=1;i<=3;i++)
			 {
			 px2-=70;
			 }
	         py2-=70;
			 }
		 }
		 if(score2==33)
		 {
			
			 px2=70*24;
			 score2=49;
			 y-=70;
			 for(int j=1;j<=1;j++)
			 {
			 for( i=1;i<=5;i++)
			 {
			 px2-=70;
			 }
	         py2-=70;
			 }
		 }
		
		 if(score2==42)
		 {
			
			 px2=70*16;
			 score2=63;
			 y-=70;
			 for(int j=1;j<=2;j++)
			 {
			 for( i=1;i<=5;i++)
			 {
			 px2-=70;
			 }
	         py2-=70;
			 }
		 }
		 if(score2==50)
		 {
			
			 px2=70*10;
			 score2=69;
			 y-=70;
			 for(int j=1;j<=2;j++)
			 {
			 for( i=1;i<=4;i++)
			 {
			 px2-=70;
			 }
	         py2-=70;
			 }
		 }
		 if(score2==62)
		 {
			
			 px2=70*12;
			 score2=81;
			 y-=70;
			 for(int j=1;j<=2;j++)
			 {
			 for( i=1;i<=4;i++)
			 {
			 px2-=70;
			 }
	         py2-=70;
			 }
		 }
		 if(score2==74)
		 {
			
			 px2=70*9;
			 score2=92;
			 y-=70;
			 for(int j=1;j<=2;j++)
			 {
			 for( i=1;i<=2;i++)
			 {
			 px2-=70;
			 }
	         py2-=70;
			 }
		 }
		 if(score2==27)
		 {
			
			 px2=70*11;
			 score2=5;
			 y-=70;
			 for(int j=1;j<=2;j++)
			 {
			 for( i=1;i<=1;i++)
			 {
			 px2+=70;
			 }
	         py2+=70;
			 }
		 }
		 if(score2==40)
		 {
			
			 px2=70*3;
			 score2=3;
			 y-=70;
			 for(int j=1;j<=3;j++)
			 {
			 for( i=1;i<=1;i++)
			 {
			 px2+=70;
			 }
	         py2+=70;
			 }
		 }
		 if(score2==43)
		 {
			
			 px2=70*4;
			 score2=18;
			 y-=70;
			 for(int j=1;j<=3;j++)
			 {
			 for( i=1;i<=1;i++)
			 {
			 px2+=70;
			 }
	         py2+=70;
			 }
		 }
		 if(score2==54)
		 {
			
			 px2=70*17;
			 score2=31;
			 y-=70;
			 for(int j=1;j<=2;j++)
			 {
			 for( i=1;i<=1;i++)
			 {
			 px2+=70;
			 }
	         py2+=70;
			 }
		 }
		 if(score2==66)
		 {
			
			 px2=70*10;
			 score2=45;
			 y-=70;
			 for(int j=1;j<=2;j++)
			 {
			 for( i=1;i<=1;i++)
			 {
			 px2+=70;
			 }
	         py2+=70;
			 }
		 }
		 if(score2==76)
		 {
			
			 px2=70*8;
			 score2=58;
			 y-=70;
			 for(int j=1;j<=2;j++)
			 {
			 for( i=1;i<=1;i++)
			 {
			 px2+=70;
			 }
	         py2+=70;
			 }
		 }
		 if(score2==89)
		 {
			
			 px2=70*15;
			 score2=53;
			 y-=70;
			 for(int j=1;j<=3;j++)
			 {
			 for( i=1;i<=1;i++)
			 {
			 px2+=70;
			 }
	         py2+=70;
			 }
		 }
		 if(score2==99)
		 {
			
			 px2=70*8;
			 score2=41;
			 y-=70;
			 for(int j=1;j<=5;j++)
			 {
			 for( i=1;i<=1;i++)
			 {
			 px2+=70;
			 }
	         py2+=70;
			 }
		 }
      for(int j=1;j<=10;j++)
      {  
       count1++;     
       if(count1==count)break M;
       if(i%2==1)
       {
        x+=70;
        px2+=70; 
        k++;
       }
       else
       {
        x-=70;
        px2-=70;
        k--;
       }  
      }
       y-=70;
       py2-=70;
     }
  }
	 
     x++;
     dice0=img11.getImage();
    
   } 
   public void keyReleased(KeyEvent e)
   {
	  if(tx2.isFocusOwner())
	  {
	   String s1=tx2.getText().trim();
	   if(s1.equals(" "))
	   {
		   tx2.setText("Player 1 Name");
		   tx2.setForeground(Color.gray);
	   }
	  }
	  if(tx3.isFocusOwner())
	  {
	   String s2=tx3.getText().trim();
	   if(s2.equals(" "))
	   {
		   tx3.setText("Player 2 Name");
		   tx3.setForeground(Color.gray);
	   }
	  }
   }
   public void keyPressed(KeyEvent e)
   {
	if(tx2.isFocusOwner())
	{
	 String s1=tx2.getText();
     if(s1.equals("Player 1 Name"))
	 {
		tx2.setForeground(Color.white);
		tx2.setText(" ");
	 }
    }
    if(tx3.isFocusOwner())
	{	
    String s2=tx3.getText();
    if(s2.equals("Player 2 Name"))
	{
		tx3.setForeground(Color.white);
		tx3.setText(" ");
	}
    }	
   }
   public void keyTyped(KeyEvent e){}
  }
class SnakeLeader3
{
 public static void main(String args[])
 {
  FDemo f=new FDemo();
  f.setVisible(true);
  f.setBounds(200,0,990,735);
  String inputName=JOptionPane.showInputDialog("Enter Your Name");
   JOptionPane.showMessageDialog(null,"Your name is="+inputName);
  f.setDefaultCloseOperation(f.EXIT_ON_CLOSE); 
 }
}