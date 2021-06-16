package block.panel;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.LinkedList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import block.access.BlockAccess;
import block.access.BlockDAO;
import block.model.BlockPlayer;

class BlockPanelPlaying extends BlockSubPanel{ // 게임 패널 
	
	LinkedList<Block> block =new LinkedList<Block>();//블록을 넣을 연결리스트 
	LinkedList<Ball> ball=new LinkedList<Ball>();//공을 넣을 연결리스트 

	int x = 340, y= 670;// 라켓 위치 
	int rWidth =140, rHeight = 25; //라켓 크기
	int bWidth, bHeight;//블록 크기 
	int score =0;
	int stage =1;
	
	int n=rWidth/5;//라켓 5분할
	int x1=x+n;
	int x2=x1+n;
	int x3=x2+n;
	int x4=x3+n;
	int x5=x4+n;
	
	Clip clipBreak;
	Clip clipLevel;
	Clip clipAttack;

	public BlockPanelPlaying(BlockPanel blockPanel){
		
		super(blockPanel);
		
	    try {
	    	clipBreak = AudioSystem.getClip();
	    	clipLevel = AudioSystem.getClip();
	    	clipAttack = AudioSystem.getClip();
	    	URL urlBreak = getClass().getResource("/bgm/break.wav");
	    	URL urlLevel = getClass().getResource("/bgm/levelup.wav");
	    	URL urlAttack = getClass().getResource("/bgm/attack.wav");
	    	AudioInputStream streamBreak  = AudioSystem.getAudioInputStream(urlBreak);
	    	AudioInputStream streamLevel  = AudioSystem.getAudioInputStream(urlLevel);
	    	AudioInputStream streamAttack  = AudioSystem.getAudioInputStream(urlAttack);
	    	clipBreak.open(streamBreak);
	    	clipLevel.open(streamLevel);
	    	clipAttack.open(streamAttack);
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	    
		PanelName="Playing";
		Ball b = new Ball();
		ball.add(b);
		setStage();
		
	}
	
	
	class Ball{ //Ball 클래스 
		   int bx=400;
		   int by=650;
		   int br=10;
		   int ballcenter=(bx+br/2); 
		   Point []pt=new Point[4]; //공의 상하좌우 네 점을 저장 
		   int dx=-1;
		   int dy=3;
		   Ball()
		   {
		      pt[0]=new Point(bx, by+(br/2)); // 좌 
		      pt[1]=new Point(bx+(br/2), by); // 상 
		      pt[2]=new Point(bx+br, by+(br/2)); // 우 
		      pt[3]=new Point(bx+(br/2), by+br); // 하 
		   }
		   
		   Ball(int x, int y, int _dx, int _dy)
		   {
		      bx=x;
		      by=y;
		      ballcenter=(bx+br/2);
		      dx=_dx;
		      dy=_dy;
		      pt[0]=new Point(bx, by+(br/2));
		      pt[1]=new Point(bx+(br/2), by);
		      pt[2]=new Point(bx+br, by+(br/2));
		      pt[3]=new Point(bx+(br/2), by+br);
		   }
		}

	class Block{ // 벽돌 
			
			Point pt=new Point();
			boolean special=false;	
			Block(Point p, boolean spe)
			{
				pt=p;
				special=spe;
			}
		}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // 배경그리기 
		Graphics2D g2 = (Graphics2D)g;
		for(Block bl : block) {
			if(bl.special) {
				int random =(int)((Math.random()*100)%7+1);
				GradientPaint gp1;
				if(random == 1) {
					gp1=new GradientPaint(bl.pt.x,bl.pt.y,new Color(255,255,255),bl.pt.x,bl.pt.y+bHeight,new Color(246,246,246));
				}
				else {
					gp1=new GradientPaint(bl.pt.x,bl.pt.y,new Color(230,255,255),bl.pt.x,bl.pt.y+bHeight,new Color(246,246,246));
		        }
				g2.setPaint(gp1);
			}
			else {
				GradientPaint gp1=new GradientPaint(bl.pt.x,bl.pt.y,new Color(106,132,185),bl.pt.x,bl.pt.y+bHeight,new Color(53,71,125));
	            g2.setPaint(gp1);
			}
			 g2.fillRoundRect(bl.pt.x, bl.pt.y, bWidth, bHeight, 5, 5);
		}//블록 그리기 
		setBall();
		g2.setColor(new Color(251,146,158));
		g2.fillRoundRect(x, y, rWidth, rHeight, 10, 10); // 라켓 그리기 
		g2.setColor(new Color(246,246,246));
		for(int i=0;i<ball.size();i++) {
			g2.fillOval(ball.get(i).bx, ball.get(i).by, ball.get(i).br, ball.get(i).br);
		}//공 그리기 
	}
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		if(PanelName.equals("Playing")){
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				if(x<70) x=0;
				else x-=60;
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				if(x+140>630) x=610;
				else x+=60;
			}
		}
		divideRacket();
		setBall();
		repaint();
	}
	@Override
	public void run() {
		int interval=100;
		while(true) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				return;
			}
			switch(stage) {
				case 1:interval = 10; break;
				case 2:interval = 9; break;
				case 3:interval = 8; break;
				case 4:interval = 8; break;
			}
			for(int i=0; i<ball.size();i++) {
				ball.get(i).by-=ball.get(i).dy;
			}
			
			for(int i=0;i<ball.size();i++) {
				if(ball.get(i).by>800)
					ball.remove(i);
			}
			if(ball.size()<=0) {
				
				gameOver();
			}
			repaint();
		}
	}
	
	
	boolean check_collision(Point p, int _x, int _y, Point bp) {//충돌 검사
		Rectangle2D r=new Rectangle2D.Float(p.x,p.y,_x,_y);
	    if (r.contains(bp))
	    	return true;
	    else
	    	return false;
	}
	
	void resolve_collision() { // 벽돌 삭제 
		for(int k=0; k<ball.size();k++) {
			for(int i=0;i<4;i++) {
				for(int j=0;j<block.size();j++) {
					if(check_collision(block.get(j).pt,bWidth,bHeight,ball.get(k).pt[i])) {
						if (i==1 || i==3) // 상하가 충돌 
							ball.get(k).dy=-ball.get(k).dy; //y방향을 바꿔줌 
						else if (i==0 || i==2) // 좌우가 충돌 
							ball.get(k).dx=-ball.get(k).dx; //x방향을 바꿔줌
						 if (block.get(j).special==true){//공의 갯수 추가 	 
		                     Ball b1=new Ball(ball.get(k).bx, ball.get(k).by+10, ball.get(k).dx+1, ball.get(k).dy);
		                     Ball b2=new Ball(ball.get(k).bx, ball.get(k).by+10, ball.get(k).dx-1, ball.get(k).dy);
		                     ball.add(b1);
		                     ball.add(b2);
		                     clipAttack.setFramePosition(0);
			     			 clipAttack.start();
			                 
						 }
						 else {
			                 clipBreak.setFramePosition(0);
			     			 clipBreak.start();
						 }
						 score+=10;
		                 block.remove(j); //충돌한 벽돌 삭제 

					}
				}
			}
		} 
	}
	
	void divideRacket() { //라켓을 5부분으로 나눔 
		n=rWidth/5;
		x1=x+n;
		x2=x1+n;
		x3=x2+n;
		x4=x3+n;
		x5=x4+n;
	}
	
	void setBall() { //공의 속도, 방향 바꿈 
		divideRacket();
		for (int i=0; i<ball.size(); i++) {
			ball.get(i).ballcenter=(ball.get(i).bx+(ball.get(i).br/2));
		}
		for (int i=0; i<ball.size(); i++){
			if(ball.size()<=0) break;
			if (ball.get(i).by+ball.get(i).br>=670 && ball.get(i).by+ball.get(i).br <= 695 && ball.get(i).ballcenter>=x && ball.get(i).ballcenter<=x+rWidth){
				//라켓과 공이 부딪혔을 때 
				ball.get(i).by=650;
				ball.get(i).dy=-ball.get(i).dy;
	            if ( x<=ball.get(i).ballcenter && x1>=ball.get(i).ballcenter)
	            	ball.get(i).dx=-3;
	            else if (x1<ball.get(i).ballcenter && ball.get(i).ballcenter<=x2)
	            	ball.get(i).dx=-2;
	            else if (x2<ball.get(i).ballcenter && ball.get(i).ballcenter<=x3)
	            	 ball.get(i).dx=1;
	            else if (x3<ball.get(i).ballcenter && ball.get(i).ballcenter<=x4)
	            	 ball.get(i).dx=2;
	            else if (x4<ball.get(i).ballcenter && ball.get(i).ballcenter<=x5)
	            	 ball.get(i).dx=3;
			}
		}
		for (int i=0; i<ball.size(); i++) {
			if (ball.get(i).bx<0 || ball.get(i).bx>=750-ball.get(i).br) // 벽에 공이 부딪힌 경우 
				ball.get(i).dx=-ball.get(i).dx;
	        if (ball.get(i).by<20) { // 위에 부딪힌 경우 
	            ball.get(i).by=20;
	            ball.get(i).dy=-ball.get(i).dy;
	        }
	    }// 공의 방향 다시 설정 
		for (int i=0; i<ball.size(); i++){
			ball.get(i).bx+=ball.get(i).dx;
			ball.get(i).pt[0]=new Point(ball.get(i).bx, ball.get(i).by+(ball.get(i).br/2));
			ball.get(i).pt[1]=new Point(ball.get(i).bx+(ball.get(i).br/2), ball.get(i).by);
			ball.get(i).pt[2]=new Point(ball.get(i).bx+ball.get(i).br, ball.get(i).by+(ball.get(i).br/2));
			ball.get(i).pt[3]=new Point(ball.get(i).bx+(ball.get(i).br/2), ball.get(i).by+ball.get(i).br);
		}// 공의 상하좌우 점 다시 설정 
		resolve_collision(); //충돌한 블록 삭제 
		if(block.size()<=0) { //블록이 모두 삭제 되었을 경우
			stage++;
			setStage();
            clipLevel.setFramePosition(0);
			clipLevel.start();
		}
	}
	
	void setBlock(int width, int height) { //스테이지 별로 블록 셋팅 
		int random; 
		bWidth=width;
		bHeight=height;
		for(int i=0;i<3*stage;i++) { //블록 갯수 = (스테이지*3)^2
			for(int j=0;j<3*stage;j++) {
				Point p = new Point (10+(width*j)+(5*j),25+(5*i)+(height*i));
				boolean temp = false;
				random=(int)((Math.random()*10)%5+1);
				if(random == 1) {
					temp = true;
				}
				block.add(new Block(p,temp));
			}
		}
	}
	void setStage() { // 공 새로만들고 블록 셋팅 
		ball.removeAll(ball);
		Ball b = new Ball();
		b.bx=x+50;
		b.by=640;
		ball.add(b);
		if(stage==1) {
			setBlock(240,90); //블록 하나의 가로, 세로 높이 인자로 전달 
		}
		else if(stage==2) {
			setBlock(117,50);
		}
		else if(stage==3) {
			setBlock(76,40);
		}
		else if(stage==4) {
			setBlock(56,30);
		}
		else {
			gameOver();
		}
	}


	void gameOver() {
		
		if(score>(blockPanel.getScore())) {
			blockPanel.setScore(score); //최고 점수 비교 후 수정 
		}
		
		blockPanel.myScore = score;
		t.interrupt();
		blockPanel.changeMode("Ending");
		
	
		
	}
}
