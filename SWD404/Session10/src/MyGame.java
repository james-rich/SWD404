import com.golden.gamedev.Game;

import java.awt.*;

import java.awt.event.*;


public class MyGame extends Game{

    private int x;
    private int y;
    private Snake head;
    private int food_x;
    private int food_y;
    private int comp_x;
    private int comp_y;
    private boolean gameOver;
    private boolean reset;
    private Integer score;
    private boolean pause;


    @Override
    public void initResources() {
        x = 320;
        y = 240;
        food_x = 360;
        food_y = 260;
        head = new Snake(x, y);
        comp_x = 30;
        comp_y = 30;
        score = 0;
        gameOver = false;
        reset = false;
        pause = false;
    }

    @Override
    public void update(long l) {

        if (keyDown(KeyEvent.VK_R)) {
            initResources();
            reset = true;
        }

        if(keyDown(KeyEvent.VK_Q)){
            finish();
        }

        if(keyDown(KeyEvent.VK_P) && !pause){
            stop();
            pause = true;
        }
        if(keyDown(KeyEvent.VK_P)){
            start();
            pause = false;
        }





        if(Math.abs((comp_x + 10) - (x + 10)) <= 10 && Math.abs((comp_y + 10) - (y + 10)) <= 10){
            gameOver = true;
        }else if(Math.abs((food_x + 4) - (x + 10)) <= 8 && Math.abs((food_y + 4) - (y + 10)) <= 8){
            food_x = getRandom(0, 620);/*(int)(Math.random() * 639) + 1;*/
            food_y = getRandom(0, 460);/*(int)(Math.random() * 479) + 1;*/
            score++;
        }else{
            if(keyDown(KeyEvent.VK_LEFT)){
                x--;
                x = (x + 620) % 620;
            }
            if(keyDown(KeyEvent.VK_RIGHT)){
                x++;
                x = x % 620;
            }
            if(keyDown(KeyEvent.VK_UP)){
                y--;
                y = (y-- + 460) % 460;
            }
            if(keyDown(KeyEvent.VK_DOWN)){
                y++;
                y = y++ % 460;

            }
            head.setX(x);
            head.setY(y);


            if(x > comp_x){
                comp_x++;
            }
            if(x < comp_x){
                comp_x--;
            }
            if(y > comp_y){
                comp_y++;
            }
            if(y < comp_y){
                comp_y--;
            }

        }
    }

    @Override
    public void render(Graphics2D graphics2D) {
        if(reset){
            graphics2D.clearRect(230,240, 10, 10);
        }
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(0,0,getWidth(), getHeight());

        graphics2D.setColor(Color.GREEN);
        graphics2D.fillOval(food_x, food_y, 8,8);

        graphics2D.setColor(Color.WHITE);

        graphics2D.fillOval(head.getX(), head.getY(),20, 20);


        graphics2D.setColor(Color.RED);
        graphics2D.fillOval(comp_x, comp_y, 20, 20);


        graphics2D.setColor(Color.RED);
        graphics2D.drawRect(15, 10, 65, 20);
        graphics2D.setFont(new Font("TimesRoman", Font.BOLD, 10));
        graphics2D.drawString("(R)estart", 20, 25);

        graphics2D.setColor(Color.RED);
        graphics2D.setFont(new Font("TimesRoman", Font.BOLD, 30));
        graphics2D.drawString(score.toString(), 600, 460);
        if(gameOver) {
            graphics2D.setColor(Color.GREEN);
            graphics2D.setFont(new Font("TimesRoman", Font.BOLD, 30));
            graphics2D.drawString("Game Over", 230, 240);
        }


    }


}
