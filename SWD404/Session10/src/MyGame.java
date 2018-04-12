import com.golden.gamedev.Game;

import java.awt.*;

import java.awt.event.*;

public class MyGame extends Game{

    private int x;
    private int y;
    private int c_x;
    private int c_y;
    boolean gameOver = false;
    Integer score;


    @Override
    public void initResources() {
        x = 320;
        y = 240;
        c_x = 30;
        c_y = 30;
        score = 0;
    }

    @Override
    public void update(long l) {

        if(keyDown(KeyEvent.VK_R)){
            x = 320;
            y = 240;
            c_x = 30;
            c_y = 30;
            score = 0;
        }

        if(c_x == x && c_y == y){
            gameOver = true;
        }else{
            if(keyDown(KeyEvent.VK_LEFT)){
                x--;
                if(x <= 0){
                    x = 640;
                }
            }
            if(keyDown(KeyEvent.VK_RIGHT)){
                x++;
                if(x >= 640){
                    x = 0;
                }
            }
            if(keyDown(KeyEvent.VK_UP)){
                y--;
                if(y <= 0){
                    y = 480;
                }
            }
            if(keyDown(KeyEvent.VK_DOWN)){
                y++;
                if(y >= 480){
                    y = 0;
                }
            }

            if(x > c_x){
                c_x++;
            }
            if(x < c_x){
                c_x--;
            }
            if(y > c_y){
                c_y++;
            }
            if(y < c_y){
                c_y--;
            }
            score++;
        }
    }

    @Override
    public void render(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(0,0,getWidth(), getHeight());

        graphics2D.setColor(Color.WHITE);
        graphics2D.fillOval(x, y, 20, 20);

        graphics2D.setColor(Color.RED);
        graphics2D.fillOval(c_x, c_y, 20, 20);
        if(gameOver) {
            graphics2D.setColor(Color.GREEN);
            graphics2D.setFont(new Font("TimesRoman", Font.BOLD, 30));
            graphics2D.drawString("Game Over", 230, 240);
        }

        graphics2D.setColor(Color.RED);
        graphics2D.drawRect(15, 10, 65, 20);
        graphics2D.setFont(new Font("TimesRoman", Font.BOLD, 10));
        graphics2D.drawString("(R)estart", 20, 25);

        graphics2D.setColor(Color.RED);
        graphics2D.setFont(new Font("TimesRoman", Font.BOLD, 10));
        graphics2D.drawString(score.toString(), 600, 460);

    }


}
