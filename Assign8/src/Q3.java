//BY NATHAN BROWN
//QUESTION 3

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.imageio.ImageIO;
import java.applet.AudioClip;
import java.applet.Applet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Q3 extends Canvas implements KeyListener, MouseListener, MouseMotionListener {

    private static final long serialVersionUID = 1L;
    private BufferStrategy strategy;
    private static spriteCache sprites;
    private static soundCache sounds;
    private static boolean gameOver = false;
    // Customizable settings
    private static String gameTitle = "Name of your game";
    private static Dimension gameSize = new Dimension(800, 600); // This sets the size of the game window
    private static int framesPerSecond = 60; // Changing this number limits the maximum rendered frames per second in your game
    private static int workPerSecond = 180; // Changing this number limits the speed of the game logic and calculations
    static /*
     * Declare variables - ex. private static int playerX;
     */
    
    boolean breaker;
    static Random rand;
    int xMouse;
	int yMouse;
	static int enCount;
	static ArrayList<Enemy> en;
	static ArrayList<Bullet> bullets;
	static ArrayList<Integer> removers;
	static Bullet toAddBullet;
	static boolean toAdd;
	static int tempX;
	static int tempY;
	static int tempW;
	static int tempH;
	static Player player1;

    public static void main(String[] args) {
        /*
         * Initialize variables - ex. playerX = 1;
         */
    	rand = new Random();
    	toAdd = false;
    	enCount = 30;
    	breaker = true;
    	bullets = new ArrayList<Bullet>();
    	en = new ArrayList<Enemy>();
    	player1 = new Player();
    	for (int i=0;i<enCount;i++){
    		add(en);	
    	}
        new Q3();
    }
    

    public void workGame() {
        /*
         * Change variables & use if statements, etc. here (logic worker thread)
         */

    	//System.out.println("def");
    	if (toAdd == true){
    		bullets.add(toAddBullet);
    		toAdd = false;
    	}
    	
    	removers = new ArrayList<Integer>();
    	
 
    	player1.move();
    	for (int i=0;i<en.size();i++){
    		//en.get(i).move(xMouse,yMouse,en);
    		en.get(i).move(player1.getX(),player1.getY(),en);
    		if (en.get(i).collide(bullets) == true){
    			removers.add(i);
    		}	
    	}
    	
    	removers = Enemy.sort(removers);
    	for (int i=0;i<removers.size();i++){
    		en.remove(removers.get(i)-i);
    		add(en);
    		
    	}

    	for (int i=0;i<bullets.size();i++){
    		bullets.get(i).move();
    	}
    }

    public void drawGame(Graphics2D g) {
        /*
         * Draw everything here using the variable g for your graphics (drawing thread)
         */
    	//System.out.println("abc");

    	g.setColor(Color.white);
    	g.fillRect(0,0, gameSize.width,gameSize.height);
    	g.setColor(Color.black);

    	
    	for (int i=0;i<en.size();i++){
    		en.get(i).paint(g);
    		
    	}

    	for (int i=0;i<bullets.size();i++){
    		bullets.get(i).paint(g);
    	}
    	player1.paint(g);



    }

    public Q3() {
        JFrame GameWindow = new JFrame(gameTitle);
        JPanel GamePanel = (JPanel) GameWindow.getContentPane();
        sprites = new spriteCache();
        setBounds(0, 0, gameSize.width, gameSize.height);
        GamePanel.setLayout(null);
        GamePanel.add(this);
        GameWindow.setBounds(0, 0, gameSize.width, gameSize.height);
        GameWindow.setVisible(true);
        GameWindow.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        GameWindow.setResizable(false);
        createBufferStrategy(2);
        strategy = getBufferStrategy();
        requestFocus();
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        new Thread(new Runnable() {
            public void run() {
                try {
                    long startTime;
                    Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
                    while (!gameOver) {
                        startTime = System.currentTimeMillis();
                        g.setColor(Color.BLACK);
                        g.fillRect(0, 0, gameSize.width, gameSize.height);
                        drawGame(g);
                        strategy.show();
                        do {
                            Thread.sleep(1);
                        } while (System.currentTimeMillis() - startTime < 1000 / framesPerSecond);
                    }
                } catch (Exception e) {
                }
            }
        }).start();
        try {
            long startTime;
            while (!gameOver) {
                startTime = System.currentTimeMillis();
                workGame();
                do {
                    Thread.sleep(1);
                } while (System.currentTimeMillis() - startTime < 1000 / workPerSecond);
            }
        } catch (Exception e) {
        }
    }

    public class spriteCache implements ImageObserver {

        protected HashMap<String, BufferedImage> sprites;

        public spriteCache() {
            sprites = new HashMap<String, BufferedImage>();
        }

        public BufferedImage getSprite(String name) {
            BufferedImage sprite = sprites.get(name);
            if (sprite == null) {
                try {
                    BufferedImage loaded = ImageIO.read(getClass().getClassLoader().getResource(name));
                    sprite = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().createCompatibleImage(loaded.getWidth(), loaded.getHeight(), Transparency.BITMASK);
                    sprite.getGraphics().drawImage(loaded, 0, 0, this);
                    sprites.put(name, sprite);
                } catch (Exception e) {
                    return null;
                }
            }
            return sprite;
        }

        public BufferedImage getSpriteRotated(String name, Double angle) {
            BufferedImage rotated = getSprite(name);
            AffineTransform transform = new AffineTransform();
            transform.rotate(Math.toRadians(angle), rotated.getWidth() / 2, rotated.getHeight() / 2);
            return new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR).filter(rotated, null);
        }

        public BufferedImage getSpriteScaled(String name, Double xscale, Double yscale) {
            BufferedImage scaled = getSprite(name);
            AffineTransform transform = new AffineTransform();
            transform.scale(xscale, yscale);
            return new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR).filter(scaled, null);
        }

        public BufferedImage getSpriteScaled(String name, Double scale) {
            return getSpriteScaled(name, scale, scale);
        }

        public BufferedImage getSpriteRotatedAndScaled(String name, Double angle, Double xscale, Double yscale) {
            BufferedImage transformed = getSprite(name);
            AffineTransform transform = new AffineTransform();
            transform.rotate(Math.toRadians(angle), transformed.getWidth() / 2, transformed.getHeight() / 2);
            transform.scale(xscale, yscale);
            return new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR).filter(transformed, null);
        }

        public BufferedImage getSpriteRotatedAndScaled(String name, Double angle, Double scale) {
            return getSpriteRotatedAndScaled(name, angle, scale, scale);
        }

        public boolean imageUpdate(Image img, int infoflags, int x, int y, int w, int h) {
            return (infoflags & (ALLBITS | ABORT)) == 0;
        }
    }

    public class soundCache {

        protected HashMap<String, AudioClip> sounds;

        public soundCache() {
            sounds = new HashMap<String, AudioClip>();
        }

        public AudioClip getSound(String name) {
            AudioClip sound = sounds.get(name);
            if (sound == null) {
                try {
                    sound = Applet.newAudioClip(getClass().getClassLoader().getResource(name));
                    sounds.put(name, sound);
                } catch (Exception e) {
                    return null;
                }
            }
            return sound;
        }

        public void playSound(final String name) {
            new Thread(new Runnable() {
                public void run() {
                    getSound(name).play();
                }
            }).start();
        }

        public void loopSound(final String name) {
            new Thread(new Runnable() {
                public void run() {
                    getSound(name).loop();
                }
            }).start();
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
        	if (player1.getVirDir() == 2){
        		player1.setvpDir(player1.getVirDir());
        	}
        	else{
        		player1.setvpDir(0);
        	}
            player1.setVirDir(1);
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
        	
        	if (player1.getHorDir() == 2){
        		player1.sethpDir(player1.getHorDir());
        	}
        	else{
        		player1.sethpDir(0);
        	}
            player1.setHorDir(1);
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
        	if (player1.getVirDir() == 1){
        		player1.setvpDir(player1.getVirDir());
        	}
        	else{
        		player1.setvpDir(0);
        	}
        	player1.setVirDir(2);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
        	if (player1.getHorDir() == 1){
        		player1.sethpDir(player1.getHorDir());
        	}
        	else{
        		player1.sethpDir(0);
        	}
        	player1.setHorDir(2);
        }
    }


    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
        	if (player1.getvpDir() == 1){
        		player1.setvpDir(0);		
        	}
        	if (player1.getVirDir() == 1){
        		player1.setVirDir(player1.getvpDir());
        	}

        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
        	
        	
        	if (player1.gethpDir() == 1){
        		player1.sethpDir(0);		
        	}
        	if (player1.getHorDir() == 1){
        		player1.setHorDir(player1.gethpDir());
        	}
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {

        	if (player1.getvpDir() == 2){
        		player1.setvpDir(0);		
        	}
        	if (player1.getVirDir()==2){
        		player1.setVirDir(player1.getvpDir());
        	}
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
        	if (player1.gethpDir() == 2){
        		player1.sethpDir(0);		
        	}
        	if (player1.getHorDir()==2){
        		player1.setHorDir(player1.gethpDir());
        	}
        }
    }

    public void keyTyped(KeyEvent e) {
             
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
    	toAddBullet = new Bullet(player1,e);
    	toAdd = true;
    }

    public void mouseExited(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
    	toAddBullet = new Bullet(player1,e);
    	toAdd = true;
    	
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
    	
    }

    public void mouseMoved(MouseEvent e) {
    	xMouse=e.getX();
    	yMouse=e.getY();
    }
    
    public static void add(ArrayList<Enemy> ens){
		breaker = true;
		while (breaker){
			breaker = false;
    		tempW = rand.nextInt(25)+25;
    		tempX = rand.nextInt(gameSize.width-tempW-6);
    		tempH = rand.nextInt(25)+25;
    		tempY = rand.nextInt(gameSize.height-tempH-28);
    		for (int j=0;j<en.size();j++){
    			if ( (tempX+tempW>en.get(j).x ) && (tempX<en.get(j).x+en.get(j).w) && (tempY+tempH>en.get(j).y ) && (tempY<en.get(j).y+en.get(j).h ) ){
    				breaker = true;;
    			}
    		}
		}
		
		en.add(new Enemy(tempX,tempY,tempW,tempH));
    }
}