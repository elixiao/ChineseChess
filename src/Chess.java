
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Chess {
    public int x;
    public int y;
    public int side;
    public static final int SIZE = 50;
    String s;

    public Chess(int x,int y,int side,String s) {
        this.x = x;
        this.y = y;
        this.side = side;
        this.s = s;
    }
    public void draw(Graphics g) {
        if(side==1) {
            g.setColor(Color.black);
            g.fillOval((ChineseChess.FRAME_X-ChineseChess.CHESS_X)/2+x*80-SIZE/2,ChineseChess.MENU+(ChineseChess.FRAME_Y-ChineseChess.CHESS_Y)/2+y*80-SIZE/2,SIZE,SIZE);
            g.setColor(Color.white);
            g.setFont(new Font("宋体",Font.PLAIN,35));
            g.drawString(s, (ChineseChess.FRAME_X-ChineseChess.CHESS_X)/2+x*80-SIZE/2+6,ChineseChess.MENU+(ChineseChess.FRAME_Y-ChineseChess.CHESS_Y)/2+y*80+SIZE/2-10);
        }else {
            g.setColor(Color.darkGray);
            g.fillOval((ChineseChess.FRAME_X-ChineseChess.CHESS_X)/2+x*80-SIZE/2,ChineseChess.MENU+(ChineseChess.FRAME_Y-ChineseChess.CHESS_Y)/2+y*80-SIZE/2,SIZE,SIZE);
            g.setColor(Color.magenta);
            g.setFont(new Font("宋体",Font.PLAIN,35));
            g.drawString(s, (ChineseChess.FRAME_X-ChineseChess.CHESS_X)/2+x*80-SIZE/2+6,ChineseChess.MENU+(ChineseChess.FRAME_Y-ChineseChess.CHESS_Y)/2+y*80+SIZE/2-10);
        }
    }
    public void reLocation(int x,int y) {
        this.x = x;
        this.y = y;
    }
}


