
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Hashtable;
import java.util.Map;


public class GUI {
    game game_0;
   int  frameHeight =394;
   int frameWidth=328;
   int gameBoardSize= 296;
   int marginSize =16;
   Color backgroundColor = new Color(255,225,120);

   Map numberTiles;

   GameBoard gb;
   MyFrame frame;

   public GUI(){

       game_0=new game();
       frame =  new MyFrame();
       frame.setFocusable(true);
       frame.addKeyListener(new MyFrame());
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       loadNumberTiles();

       gb=new GameBoard();
      // gb.setFocusable(true);

       // north panel

       JPanel northPanel =new JPanel();
       northPanel.setLayout(new GridLayout());
       northPanel.setPreferredSize(new Dimension(frameWidth,82));
       JLabel gameLabel = new JLabel("1024",SwingConstants.CENTER);
       gameLabel.setFont(new Font("Serif",Font.BOLD,20));
       northPanel.add(gameLabel);
       northPanel.add(new JLabel("<html>Score:<br>524</html>",SwingConstants.CENTER));
       northPanel.add(new JLabel("<html>High Score:<br>22600</html>",SwingConstants.CENTER));
       northPanel.setBackground(backgroundColor);

       JPanel westBuffer =new JPanel();
       westBuffer.setPreferredSize(new Dimension(marginSize,gameBoardSize));
       westBuffer.setBackground(backgroundColor);

      JPanel eastBuffer =new JPanel();
       eastBuffer.setPreferredSize(new Dimension(marginSize,gameBoardSize));
       eastBuffer.setBackground(backgroundColor);

       JPanel southBuffer =new JPanel();
       southBuffer.setPreferredSize(new Dimension(frameWidth,marginSize));
       southBuffer.setBackground(backgroundColor);


       //add panels to frame
       frame.getContentPane().add(northPanel,BorderLayout.NORTH);
       frame.getContentPane().add(westBuffer,BorderLayout.WEST);
       frame.getContentPane().add(eastBuffer,BorderLayout.EAST);
       frame.getContentPane().add(southBuffer,BorderLayout.SOUTH);
       frame.getContentPane().add(gb,BorderLayout.CENTER);


       frame.getContentPane().setPreferredSize(new Dimension(frameWidth,frameHeight));
       frame.pack();
       frame.setVisible(true);

   }

   void loadNumberTiles(){
       numberTiles =new Hashtable();
//       ClassLoader cldr=this.getClass().getClassLoader();
//       URL url0000;
//       url0000 = cldr.getResource("bin/images/tile00.png");
//       URL url0001=cldr.getResource("bin/images/tile01.png");
//       URL url0002=cldr.getResource("bin/images/tile02.png");
//       URL url0004=cldr.getResource("bin/images/tile04.png");
//       URL url0008=cldr.getResource("bin/images/tile08.png");
//       URL url0016=cldr.getResource("bin/images/tile16.png");
//       URL url0032=cldr.getResource("bin/images/tile32.png");
//       URL url0064=cldr.getResource("bin/images/tile64.png");
//       URL url0128=cldr.getResource("bin/images/tile128.png");
//       URL url0256=cldr.getResource("bin/images/til256.png");
//       URL url0512=cldr.getResource("bin/images/tile_512.png");
//       URL url1024=cldr.getResource("bin/images/tile_1024.png");

       numberTiles.put(0,new ImageIcon("bin/images/tile00.png"));
       numberTiles.put(1,new ImageIcon("bin/images/tile01.png"));
       numberTiles.put(2,new ImageIcon("bin/images/tile02.png"));
       numberTiles.put(4,new ImageIcon("bin/images/tile04.png"));
       numberTiles.put(8,new ImageIcon("bin/images/tile08.png"));
       numberTiles.put(16,new ImageIcon("bin/images/tile16.png"));
       numberTiles.put(32,new ImageIcon("bin/images/tile32.png"));
       numberTiles.put(64,new ImageIcon("bin/images/tile64.png"));
       numberTiles.put(128,new ImageIcon("bin/images/tile128.png"));
       numberTiles.put(256,new ImageIcon("bin/images/tile256.png"));
       numberTiles.put(512,new ImageIcon("bin/images/tile_512.png"));
       numberTiles.put(1024,new ImageIcon("bin/images/tile_1024.png"));
   }

     class GameBoard extends JPanel  {
       protected void paintComponent(Graphics g){
           g.setColor(new Color(20,20,20));
           g.fillRect(0,0,this.getWidth(),this.getHeight());
           int[][] board=game_0.getGameBoard();
           for(int y=1;y<5;y++){
               for(int x =1; x<5;x++){
                   int X= (8*x) + (64 *(x-1));
                   int Y= (8*y) + (64 *(y-1));

                   int thisNumber=board[y-1][x-1];
                   if(numberTiles.containsKey(thisNumber)) {
                       ImageIcon thisTile = (ImageIcon) numberTiles.get(thisNumber);
                       thisTile.paintIcon(this, g, X, Y);
                   }
               }
           }
       }



     }

     class MyFrame extends JFrame implements KeyListener{


         @Override
         public void keyTyped(KeyEvent e) {

         }

         @Override
         public void keyPressed(KeyEvent e) {

         }

         @Override
         public void keyReleased(KeyEvent e) {
             int key=e.getKeyCode();
             if (key==KeyEvent.VK_UP){
                 System.out.println("UP key pressed..");
                 game_0.pushUp();
                 game_0.addNewNumbers();
                 gb.repaint();
             }
             else if (key==KeyEvent.VK_DOWN){
                 System.out.println("down");
                 game_0.pushDown();
                 game_0.addNewNumbers();
                 gb.repaint();
             }
             else if (key==KeyEvent.VK_LEFT){
                 System.out.println("left");
                 game_0.pushLeft();
                 game_0.addNewNumbers();
                 gb.repaint();
             }
             else if (key==KeyEvent.VK_RIGHT){
                 System.out.println("right");
                 game_0.pushRight();
                 game_0.addNewNumbers();
                 gb.repaint();
             }
         }
     }

}
