
package gameoriginal;


import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;

public class Enemy1 extends Sprite{
	public static final int Y_TO_FADE = 400;//
	public static final int Y_TO_DIE = 600;//เอาไว้เข็คว่าชนขอบหรือยัง
	
	private int step = 12;
	private boolean alive = true;
	
	public Enemy1(int x, int y) {
		super(x, y, 5, 10);
		
	}

	@Override
	public void draw(Graphics2D g) {
		if(y < Y_TO_FADE)
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		else{
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 
					(float)(Y_TO_DIE - y)/(Y_TO_DIE - Y_TO_FADE)));
		}
		g.setColor(Color.BLACK);
                
		g.fillRect(x, y, width, height);
		
	}

	public void proceed(){
		y += step;//เอาไว้เพิ่มความเร็วของข้าศึก
		if(y > Y_TO_DIE){
			alive = false;
		}
	}
	
	public boolean isAlive(){
		return alive;
	}
 
}