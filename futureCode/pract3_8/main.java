package futureCode.pract3_8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class main extends JFrame implements KeyListener{
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
    private static final int PADDLE_WIDTH = 20;//изменено
    private static final int PADDLE_HEIGHT = 90;//изменено
    private static final int BALL_SIZE = 15 ;
    private static final int PADDLE_SPEED = 16;//изменено 2 раза
    private static final int BALL_SPEED = 8;//изменено 2 раза
    private static final int MAX_SCORE= 5;

    private int paddle1Y;
    private int paddle2Y;
    private int ballX;
    private int ballY;
    private int ballXSpeed;
    private int ballYSpeed;
    private int player1Score;
    private int player2Score;

    private boolean paused;//добавлено

    public main(){
        setTitle("PingPong");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        addKeyListener(this);
        setFocusable(true);
        paddle1Y = HEIGHT/2 - PADDLE_HEIGHT/2;
        paddle2Y = HEIGHT/2 - PADDLE_HEIGHT/2;
        ballX = WIDTH/2 - BALL_SIZE/2;
        ballY = HEIGHT/2 - BALL_SIZE/2;
        ballXSpeed = BALL_SPEED;
        ballYSpeed = BALL_SPEED;
        player1Score=0;
        player2Score=0;
        
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(!paused){//добавлено
                moveBall();
                repaint();
            }}
        });
        timer.restart();
    }
    public void movePaddle1Up(){
        paddle1Y -= PADDLE_SPEED;
        if (paddle1Y<0){
            paddle1Y=0;
        }
    }
    public void movePaddle2Up(){
        paddle2Y -= PADDLE_SPEED;
        if (paddle2Y<0){
            paddle2Y=0;
        }
    }
    public void movePaddle1Down(){
        paddle1Y += PADDLE_SPEED;
        if (paddle1Y>HEIGHT-PADDLE_HEIGHT){
            paddle1Y=HEIGHT-PADDLE_HEIGHT;
        }
    }
    public void movePaddle2Down(){
        paddle2Y += PADDLE_SPEED;
        if (paddle2Y>HEIGHT-PADDLE_HEIGHT){
            paddle2Y=HEIGHT-PADDLE_HEIGHT;
        }
    }
    public void moveBall(){
        ballX+=ballXSpeed;
        ballY+=ballYSpeed;
        //а есле пролетит через ракетку??
        if (ballX<=PADDLE_WIDTH && ballX+BALL_SIZE<=paddle1Y && ballY<= paddle1Y+PADDLE_HEIGHT){
            ballXSpeed = BALL_SPEED;
        }else if (ballX>=WIDTH-PADDLE_WIDTH-BALL_SIZE && ballY+BALL_SIZE>=paddle2Y && ballY <= paddle2Y+PADDLE_HEIGHT) {
            ballXSpeed = -BALL_SPEED;
        }
        if (ballY<=0 || ballY >= HEIGHT-BALL_SIZE){
            ballYSpeed = -ballYSpeed;
        }
        if (ballX<0){
            player2Score++;
            resetGame();
        }else if (ballX>WIDTH-BALL_SIZE){
            player1Score++;
            resetGame();
        }
        if (player1Score>=MAX_SCORE || player2Score >= MAX_SCORE){
            String winner = (player1Score >= MAX_SCORE) ? "Player 1" : "Player 2";
        // JOptionPane.showMessageDialog(this, winner+ " победил!");
        // System.exit(0);
// добавлено отсюда
        Object[] options = {"ОК", "Restart","Начать заново"};
        int result = JOptionPane.showOptionDialog(this, winner+" виннер", "game over", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (result==1 || result ==2) {
            restartGame();
        }else{
            System.exit(0);
        }}
    }

    public void restartGame(){
        player1Score=player2Score=0;
        resetGame();
    }
// досюда
    public void resetGame(){
        ballX = WIDTH/2 - BALL_SIZE/2;
        ballY = HEIGHT/2 - BALL_SIZE/2;
        ballXSpeed = BALL_SPEED;
        ballYSpeed = BALL_SPEED;
    }
    public void paint(Graphics g){
        super.paint(g);

        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH,HEIGHT);

        g.setColor(Color.WHITE);
        g.fillRect(PADDLE_WIDTH, paddle1Y,PADDLE_WIDTH,PADDLE_HEIGHT);
        g.fillRect(WIDTH-2*PADDLE_WIDTH, paddle2Y, PADDLE_WIDTH,PADDLE_HEIGHT);
        g.fillOval(ballX,ballY,BALL_SIZE,BALL_SIZE);
        

        g.setColor(Color.WHITE);
        Font font = new Font("Arial",Font.PLAIN,20);
        g.setFont(font);
        FontMetrics fontMetrics = g.getFontMetrics(font);
        String player1ScoreStr = "Player 1 : "+ player1Score;
        String player2ScoreStr = "Player 2 : "+ player2Score;
        int player1ScoreX = (WIDTH - fontMetrics.stringWidth(player1ScoreStr));
        int player2ScoreX = 2*WIDTH /3 - fontMetrics.stringWidth(player2ScoreStr);
        g.drawString(player1ScoreStr,player1ScoreX,60);
        g.drawString(player2ScoreStr, player2ScoreX,60);

        Toolkit.getDefaultToolkit().sync();
    }

    //добавлено
    private void togglePause(){
        paused = !paused;
        if (paused){
            JOptionPane.showMessageDialog(this,"Пауза");
        }
    }//

    //добавлено
    private void exitGame(){
        paused=true;
        JOptionPane.showMessageDialog(this,"Вы вышли из игры");
        System.exit(0);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new main().setVisible(true);
            }
        });
    }
    @Override
    public void keyTyped(KeyEvent e){
    }
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_W){
            movePaddle1Up();
        }else if (e.getKeyCode()==KeyEvent.VK_S) {
            movePaddle1Down();
        }else if (e.getKeyCode()==KeyEvent.VK_UP){
            movePaddle2Up();
        }else if(e.getKeyCode()==KeyEvent.VK_DOWN){
            movePaddle2Down();
        }else if(e.getKeyCode()==KeyEvent.VK_P){//добавлено
            togglePause();
        }else if(e.getKeyCode()==KeyEvent.VK_ESCAPE){//добавлено
            exitGame();
        }
    }
    @Override
    public void keyReleased(KeyEvent e){
    }




















}
