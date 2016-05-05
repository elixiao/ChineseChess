import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ChineseChess extends Frame implements MouseListener,Runnable{
    int screenX = Toolkit.getDefaultToolkit().getScreenSize().width;
    int screenY = Toolkit.getDefaultToolkit().getScreenSize().height;

    public static final int FRAME_X = 800;
    public static final int FRAME_Y = 820;
    public static final int CHESS_X = 640;
    public static final int CHESS_Y = 720;
    public static final int MENU = 15;
    public static final int ZZ = 8;
    public static final int CHESS = 80;

    Chess[][] chessboard = new Chess[9][10];
    int x,y;
    Thread t;
    Boolean flag = true;
    Chess currentChess;
    ArrayList<Chess> yourChess = new ArrayList<Chess>();
    ArrayList<Chess> myChess = new ArrayList<Chess>();

    public ChineseChess() {
        this.setSize(FRAME_X,FRAME_Y);
        this.setLocation((screenX-FRAME_X)/2,(screenY-FRAME_Y)/2);
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setBackground(Color.gray);
        this.setVisible(true);
        this.addMouseListener(this);
        this.start();
        t = new Thread(this);
        t.start();
    }
    public void start() {
        yourChess.add(0,new Chess(0,0,0,"车"));
        yourChess.add(1,new Chess(1,0,0,"马"));
        yourChess.add(2,new Chess(2,0,0,"象"));
        yourChess.add(3,new Chess(3,0,0,"士"));
        yourChess.add(4,new Chess(4,0,0,"将"));
        yourChess.add(5,new Chess(5,0,0,"士"));
        yourChess.add(6,new Chess(6,0,0,"象"));
        yourChess.add(7,new Chess(7,0,0,"马"));
        yourChess.add(8,new Chess(8,0,0,"车"));
        yourChess.add(9,new Chess(1,2,0,"炮"));
        yourChess.add(10,new Chess(7,2,0,"炮"));
        yourChess.add(11,new Chess(0,3,0,"卒"));
        yourChess.add(12,new Chess(2,3,0,"卒"));
        yourChess.add(13,new Chess(4,3,0,"卒"));
        yourChess.add(14,new Chess(6,3,0,"卒"));
        yourChess.add(15,new Chess(8,3,0,"卒"));
        myChess.add(0,new Chess(0,9,1,"车"));
        myChess.add(1,new Chess(1,9,1,"马"));
        myChess.add(2,new Chess(2,9,1,"相"));
        myChess.add(3,new Chess(3,9,1,"士"));
        myChess.add(4,new Chess(4,9,1,"将"));
        myChess.add(5,new Chess(5,9,1,"士"));
        myChess.add(6,new Chess(6,9,1,"象"));
        myChess.add(7,new Chess(7,9,1,"马"));
        myChess.add(8,new Chess(8,9,1,"车"));
        myChess.add(9,new Chess(1,7,1,"炮"));
        myChess.add(10,new Chess(7,7,1,"炮"));
        myChess.add(11,new Chess(0,6,1,"兵"));
        myChess.add(12,new Chess(2,6,1,"兵"));
        myChess.add(13,new Chess(4,6,1,"兵"));
        myChess.add(14,new Chess(6,6,1,"兵"));
        myChess.add(15,new Chess(8,6,1,"兵"));
        chessboard[0][0]=yourChess.get(0);
        chessboard[1][0]=yourChess.get(1);
        chessboard[2][0]=yourChess.get(2);
        chessboard[3][0]=yourChess.get(3);
        chessboard[4][0]=yourChess.get(4);
        chessboard[5][0]=yourChess.get(5);
        chessboard[6][0]=yourChess.get(6);
        chessboard[7][0]=yourChess.get(7);
        chessboard[8][0]=yourChess.get(8);
        chessboard[1][2]=yourChess.get(9);
        chessboard[7][2]=yourChess.get(10);
        chessboard[0][3]=yourChess.get(11);
        chessboard[2][3]=yourChess.get(12);
        chessboard[4][3]=yourChess.get(13);
        chessboard[6][3]=yourChess.get(14);
        chessboard[8][3]=yourChess.get(15);
        chessboard[0][9]=myChess.get(0);
        chessboard[1][9]=myChess.get(1);
        chessboard[2][9]=myChess.get(2);
        chessboard[3][9]=myChess.get(3);
        chessboard[4][9]=myChess.get(4);
        chessboard[5][9]=myChess.get(5);
        chessboard[6][9]=myChess.get(6);
        chessboard[7][9]=myChess.get(7);
        chessboard[8][9]=myChess.get(8);
        chessboard[1][7]=myChess.get(9);
        chessboard[7][7]=myChess.get(10);
        chessboard[0][6]=myChess.get(11);
        chessboard[2][6]=myChess.get(12);
        chessboard[4][6]=myChess.get(13);
        chessboard[6][6]=myChess.get(14);
        chessboard[8][6]=myChess.get(15);

    }
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawLine((FRAME_X-CHESS_X)/2, MENU+(FRAME_Y-CHESS_Y)/2, (FRAME_X+CHESS_X)/2,MENU+(FRAME_Y-CHESS_Y)/2);
        g.drawLine((FRAME_X-CHESS_X)/2, MENU+(FRAME_Y-CHESS_Y)/2, (FRAME_X-CHESS_X)/2,MENU+(FRAME_Y+CHESS_Y)/2);
        g.drawLine((FRAME_X+CHESS_X)/2, MENU+(FRAME_Y+CHESS_Y)/2, (FRAME_X+CHESS_X)/2,MENU+(FRAME_Y-CHESS_Y)/2);
        g.drawLine((FRAME_X+CHESS_X)/2, MENU+(FRAME_Y+CHESS_Y)/2, (FRAME_X-CHESS_X)/2,MENU+(FRAME_Y+CHESS_Y)/2);

        g.drawLine((FRAME_X-CHESS_X)/2-ZZ, MENU+(FRAME_Y-CHESS_Y)/2-ZZ, (FRAME_X+CHESS_X)/2+ZZ,MENU+(FRAME_Y-CHESS_Y)/2-ZZ);
        g.drawLine((FRAME_X-CHESS_X)/2-ZZ, MENU+(FRAME_Y-CHESS_Y)/2-ZZ, (FRAME_X-CHESS_X)/2-ZZ,MENU+(FRAME_Y+CHESS_Y)/2+ZZ);
        g.drawLine((FRAME_X+CHESS_X)/2+ZZ, MENU+(FRAME_Y+CHESS_Y)/2+ZZ, (FRAME_X+CHESS_X)/2+ZZ,MENU+(FRAME_Y-CHESS_Y)/2-ZZ);
        g.drawLine((FRAME_X+CHESS_X)/2+ZZ, MENU+(FRAME_Y+CHESS_Y)/2+ZZ, (FRAME_X-CHESS_X)/2-ZZ,MENU+(FRAME_Y+CHESS_Y)/2+ZZ);

        for(int i=(FRAME_X-CHESS_X)/2,j=MENU+(FRAME_Y-CHESS_Y)/2;i<=(FRAME_X+CHESS_X)/2;i+=80){
            g.drawLine(i, j, i, j+CHESS*4);
            g.drawLine(i, j+CHESS*5, i, j+CHESS_Y);
        }

        for(int i=(FRAME_X-CHESS_X)/2,j=MENU+(FRAME_Y-CHESS_Y)/2;j<=MENU+(FRAME_Y+CHESS_Y)/2;j+=80)
            g.drawLine(i,j,i+CHESS_X,j);
        g.drawLine((FRAME_X-CHESS_X)/2+3*CHESS,MENU+(FRAME_Y-CHESS_Y)/2,(FRAME_X-CHESS_X)/2+5*CHESS, MENU+(FRAME_Y-CHESS_Y)/2+2*CHESS);
        g.drawLine((FRAME_X-CHESS_X)/2+5*CHESS,MENU+(FRAME_Y-CHESS_Y)/2,(FRAME_X-CHESS_X)/2+3*CHESS, MENU+(FRAME_Y-CHESS_Y)/2+2*CHESS);
        g.drawLine((FRAME_X-CHESS_X)/2+3*CHESS,MENU+(FRAME_Y+CHESS_Y)/2,(FRAME_X-CHESS_X)/2+5*CHESS, MENU+(FRAME_Y+CHESS_Y)/2-2*CHESS);
        g.drawLine((FRAME_X-CHESS_X)/2+5*CHESS,MENU+(FRAME_Y+CHESS_Y)/2,(FRAME_X-CHESS_X)/2+3*CHESS, MENU+(FRAME_Y+CHESS_Y)/2-2*CHESS);


        for(int i=0;i<2;i++) {
            for(int j=0;j<2;j++) {
                g.drawLine((FRAME_X-CHESS_X)/2+CHESS-ZZ+i*6*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+2*CHESS-ZZ+j*5*CHESS,(FRAME_X-CHESS_X)/2+CHESS-2*ZZ+i*6*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+2*CHESS-ZZ+j*5*CHESS);
                g.drawLine((FRAME_X-CHESS_X)/2+CHESS-ZZ+i*6*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+2*CHESS-ZZ+j*5*CHESS,(FRAME_X-CHESS_X)/2+CHESS-ZZ+i*6*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+2*CHESS-2*ZZ+j*5*CHESS);
                g.drawLine((FRAME_X-CHESS_X)/2+CHESS+ZZ+i*6*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+2*CHESS-ZZ+j*5*CHESS,(FRAME_X-CHESS_X)/2+CHESS+2*ZZ+i*6*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+2*CHESS-ZZ+j*5*CHESS);
                g.drawLine((FRAME_X-CHESS_X)/2+CHESS+ZZ+i*6*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+2*CHESS-ZZ+j*5*CHESS,(FRAME_X-CHESS_X)/2+CHESS+ZZ+i*6*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+2*CHESS-2*ZZ+j*5*CHESS);
                g.drawLine((FRAME_X-CHESS_X)/2+CHESS-ZZ+i*6*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+2*CHESS+ZZ+j*5*CHESS,(FRAME_X-CHESS_X)/2+CHESS-2*ZZ+i*6*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+2*CHESS+ZZ+j*5*CHESS);
                g.drawLine((FRAME_X-CHESS_X)/2+CHESS-ZZ+i*6*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+2*CHESS+ZZ+j*5*CHESS,(FRAME_X-CHESS_X)/2+CHESS-ZZ+i*6*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+2*CHESS+2*ZZ+j*5*CHESS);
                g.drawLine((FRAME_X-CHESS_X)/2+CHESS+ZZ+i*6*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+2*CHESS+ZZ+j*5*CHESS,(FRAME_X-CHESS_X)/2+CHESS+2*ZZ+i*6*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+2*CHESS+ZZ+j*5*CHESS);
                g.drawLine((FRAME_X-CHESS_X)/2+CHESS+ZZ+i*6*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+2*CHESS+ZZ+j*5*CHESS,(FRAME_X-CHESS_X)/2+CHESS+ZZ+i*6*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+2*CHESS+2*ZZ+j*5*CHESS);
            }
        }
        for(int i=0;i<2;i++) {
            for(int j=0;j<5;j++) {
                if(j==0) {
                    g.drawLine((FRAME_X-CHESS_X)/2+ZZ,MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS-ZZ+i*3*CHESS,(FRAME_X-CHESS_X)/2+2*ZZ, MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS-ZZ+i*3*CHESS);
                    g.drawLine((FRAME_X-CHESS_X)/2+ZZ,MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS-ZZ+i*3*CHESS,(FRAME_X-CHESS_X)/2+ZZ, MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS-2*ZZ+i*3*CHESS);
                    g.drawLine((FRAME_X-CHESS_X)/2+ZZ,MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS+ZZ+i*3*CHESS,(FRAME_X-CHESS_X)/2+2*ZZ, MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS+ZZ+i*3*CHESS);
                    g.drawLine((FRAME_X-CHESS_X)/2+ZZ,MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS+ZZ+i*3*CHESS,(FRAME_X-CHESS_X)/2+ZZ, MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS+2*ZZ+i*3*CHESS);
                }else if(j==4) {
                    g.drawLine((FRAME_X-CHESS_X)/2-ZZ+8*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS-ZZ+i*3*CHESS,(FRAME_X-CHESS_X)/2-2*ZZ+8*CHESS, MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS-ZZ+i*3*CHESS);
                    g.drawLine((FRAME_X-CHESS_X)/2-ZZ+8*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS-ZZ+i*3*CHESS,(FRAME_X-CHESS_X)/2-ZZ+8*CHESS, MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS-2*ZZ+i*3*CHESS);
                    g.drawLine((FRAME_X-CHESS_X)/2-ZZ+8*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS+ZZ+i*3*CHESS,(FRAME_X-CHESS_X)/2-2*ZZ+8*CHESS, MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS+ZZ+i*3*CHESS);
                    g.drawLine((FRAME_X-CHESS_X)/2-ZZ+8*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS+ZZ+i*3*CHESS,(FRAME_X-CHESS_X)/2-ZZ+8*CHESS, MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS+2*ZZ+i*3*CHESS);
                }else {
                    g.drawLine((FRAME_X-CHESS_X)/2+ZZ+j*2*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS-ZZ+i*3*CHESS,(FRAME_X-CHESS_X)/2+2*ZZ+j*2*CHESS, MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS-ZZ+i*3*CHESS);
                    g.drawLine((FRAME_X-CHESS_X)/2+ZZ+j*2*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS-ZZ+i*3*CHESS,(FRAME_X-CHESS_X)/2+ZZ+j*2*CHESS, MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS-2*ZZ+i*3*CHESS);
                    g.drawLine((FRAME_X-CHESS_X)/2+ZZ+j*2*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS+ZZ+i*3*CHESS,(FRAME_X-CHESS_X)/2+2*ZZ+j*2*CHESS, MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS+ZZ+i*3*CHESS);
                    g.drawLine((FRAME_X-CHESS_X)/2+ZZ+j*2*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS+ZZ+i*3*CHESS,(FRAME_X-CHESS_X)/2+ZZ+j*2*CHESS, MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS+2*ZZ+i*3*CHESS);
                    g.drawLine((FRAME_X-CHESS_X)/2-ZZ+j*2*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS-ZZ+i*3*CHESS,(FRAME_X-CHESS_X)/2-2*ZZ+j*2*CHESS, MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS-ZZ+i*3*CHESS);
                    g.drawLine((FRAME_X-CHESS_X)/2-ZZ+j*2*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS-ZZ+i*3*CHESS,(FRAME_X-CHESS_X)/2-ZZ+j*2*CHESS, MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS-2*ZZ+i*3*CHESS);
                    g.drawLine((FRAME_X-CHESS_X)/2-ZZ+j*2*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS+ZZ+i*3*CHESS,(FRAME_X-CHESS_X)/2-2*ZZ+j*2*CHESS, MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS+ZZ+i*3*CHESS);
                    g.drawLine((FRAME_X-CHESS_X)/2-ZZ+j*2*CHESS,MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS+ZZ+i*3*CHESS,(FRAME_X-CHESS_X)/2-ZZ+j*2*CHESS, MENU+(FRAME_Y-CHESS_Y)/2+3*CHESS+2*ZZ+i*3*CHESS);
                }
            }
        }
        for(int i=0;i<chessboard.length;i++) {
            for(int j=0;j<chessboard[i].length;j++) {
                if(chessboard[i][j]!=null) {
                    chessboard[i][j].draw(g);
                }
            }
        }
        if(myChess.size()>=4 && myChess.get(4)==null) showMsg("You loss!");
        else if(yourChess.size()>=4 && yourChess.get(4)==null) showMsg("You win!");
    }

    public void showMsg(String msg) {
        flag = false;
        int k = JOptionPane.showConfirmDialog(this, msg);
        flag = true;
        if(k==0) {
            myChess.clear();
            yourChess.clear();
            for(int i = 0;i<chessboard.length;i++)
                for(int j=0;j<chessboard[i].length;j++)
                    chessboard[i][j]=null;
            this.start();
            this.repaint();
        }else System.exit(0);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getX()>=(FRAME_X-CHESS_X)/2-Chess.SIZE/2&&e.getX()<=(FRAME_X+CHESS_X)/2+Chess.SIZE/2&&e.getY()>=MENU+(FRAME_Y-CHESS_Y)/2-Chess.SIZE/2&&e.getY()<=MENU+(FRAME_Y+CHESS_Y)/2+Chess.SIZE/2) {

            x = Math.round((e.getX()-(FRAME_X-CHESS_X)/2)/80.0f);
            y = Math.round((e.getY()-MENU-(FRAME_Y-CHESS_Y)/2)/80.0f);
            if(chessboard[x][y]!=null&&currentChess==null) {
                currentChess=chessboard[x][y];
                chessboard[x][y]=null;
                this.repaint();
            }else if(currentChess!=null) {
                if(currentChess.x==x&&currentChess.y==y) {
                    this.step();
                    return;
                }
                if(currentChess.s.equals("车")) {
                    if(x==currentChess.x) {
                        for(int i=Math.min(y, currentChess.y)+1;i<Math.max(y, currentChess.y);i++) {
                            if(chessboard[x][i]!=null&&chessboard[x][i].side!=currentChess.side)
                                return;

                        }
                        this.step();
                    }else if(y==currentChess.y) {
                        for(int i=Math.min(x, currentChess.x)+1;i<Math.max(x, currentChess.x);i++) {
                            if(chessboard[i][y]!=null&&chessboard[i][y].side!=currentChess.side)
                                return;

                        }
                        this.step();
                    }
                }else if(currentChess.s.equals("马")) {
                    if(x==currentChess.x-1&&y==currentChess.y-2&&chessboard[currentChess.x][currentChess.y-1]==null||
                            x==currentChess.x-1&&y==currentChess.y+2&&chessboard[currentChess.x][currentChess.y+1]==null||
                            x==currentChess.x+1&&y==currentChess.y-2&&chessboard[currentChess.x][currentChess.y-1]==null||
                            x==currentChess.x+1&&y==currentChess.y+2&&chessboard[currentChess.x][currentChess.y+1]==null||
                            x==currentChess.x+2&&y==currentChess.y-1&&chessboard[currentChess.x+1][currentChess.y]==null||
                            x==currentChess.x+2&&y==currentChess.y+1&&chessboard[currentChess.x+1][currentChess.y]==null||
                            x==currentChess.x-2&&y==currentChess.y-1&&chessboard[currentChess.x-1][currentChess.y]==null||
                            x==currentChess.x-2&&y==currentChess.y+1&&chessboard[currentChess.x-1][currentChess.y]==null) {
                        this.step();
                    }

                }else if(currentChess.s.equals("象")||currentChess.s.equals("相")) {
                    if(currentChess.side==0&&y<=4||currentChess.side==1&&y>=5) {
                        if(x==currentChess.x-2&&y==currentChess.y-2&&chessboard[x+1][y+1]==null||
                                x==currentChess.x-2&&y==currentChess.y+2&&chessboard[x+1][y-1]==null||
                                x==currentChess.x+2&&y==currentChess.y-2&&chessboard[x-1][y+1]==null||
                                x==currentChess.x+2&&y==currentChess.y+2&&chessboard[x-1][y-1]==null)
                            this.step();
                    }
                }else if(currentChess.s.equals("士")) {
                    if(currentChess.side==0&&x>=3&&x<=5&&y>=0&&y<=2||currentChess.side==1&&x>=3&&x<=5&&y>=7&&y<=9)
                        if(x==currentChess.x-1&&y==currentChess.y-1||
                                x==currentChess.x-1&&y==currentChess.y+1||
                                x==currentChess.x+1&&y==currentChess.y-1||
                                x==currentChess.x+1&&y==currentChess.y+1)
                            this.step();

                }else if(currentChess.s.equals("将")) {
                    if(currentChess.side==0&&x>=3&&x<=5&&y>=0&&y<=2||currentChess.side==1&&x>=3&&x<=5&&y>=7&&y<=9)
                        if(x==currentChess.x-1&&y==currentChess.y||
                                x==currentChess.x+1&&y==currentChess.y||
                                x==currentChess.x&&y==currentChess.y-1||
                                x==currentChess.x&&y==currentChess.y+1)
                            this.step();
                }else if(currentChess.s.equals("炮")) {
                    if(x==currentChess.x&&chessboard[x][y]!=null) {
                        int k=0;
                        for(int i=Math.min(y, currentChess.y)+1;i<Math.max(y, currentChess.y);i++)
                            if(chessboard[x][i]!=null)
                                k++;
                        if(k==1)
                            this.step();

                    }else if(y==currentChess.y&&chessboard[x][y]!=null) {
                        int k=0;
                        for(int i=Math.min(x, currentChess.x)+1;i<Math.max(x, currentChess.x);i++)
                            if(chessboard[i][y]!=null)
                                k++;
                        if(k==1)
                            this.step();
                    }else if(x==currentChess.x) {
                        for(int i=Math.min(y, currentChess.y)+1;i<Math.max(y, currentChess.y);i++)
                            if(chessboard[x][i]!=null)
                                return;
                        this.step();
                    }else if(y==currentChess.y) {
                        for(int i=Math.min(x, currentChess.x)+1;i<Math.max(x, currentChess.x);i++)
                            if(chessboard[i][y]!=null)
                                return;
                        this.step();
                    }

                }else if(currentChess.s.equals("兵")||currentChess.s.equals("卒")) {
                    if(currentChess.side==0&&y<=4) {
                        if(y==currentChess.y+1&&x==currentChess.x)
                            this.step();
                    }else if(currentChess.side==0&&y>=5) {
                        if(y==currentChess.y+1&&x==currentChess.x||x==currentChess.x+1&&y==currentChess.y||x==currentChess.x-1&&y==currentChess.y)
                            this.step();
                    }else if(currentChess.side==1&&y>=5) {
                        if(y==currentChess.y-1&&x==currentChess.x)
                            this.step();
                    }else if(currentChess.side==1&&y<=4) {
                        if(y==currentChess.y-1&&x==currentChess.x||x==currentChess.x+1&&y==currentChess.y||x==currentChess.x-1&&y==currentChess.y)
                            this.step();
                    }
                }

            }

        }
    }
    public void step()  {
        if(chessboard[x][y]==null) {
            currentChess.reLocation(x, y);
            chessboard[x][y]=currentChess;
            currentChess = null;
            this.repaint();
        }else if(chessboard[x][y]!=null&&currentChess.side!=chessboard[x][y].side) {
            if(chessboard[x][y].side==0)
                yourChess.set(yourChess.indexOf(chessboard[x][y]),null);
            else myChess.set(myChess.indexOf(chessboard[x][y]),null);
            currentChess.reLocation(x, y);
            chessboard[x][y]=currentChess;
            currentChess = null;
            this.repaint();
        }
    }

    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    public void run() {
        while(flag) {
            this.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


























