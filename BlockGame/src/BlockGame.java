import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BlockGame {

	static class MyFrame extends JFrame {

		// constant
		static int BALL_WIDTH = 20;
		static int BALL_HEIGHT = 20;
		static int BLOCK_ROWS = 5; // 5줄
		static int BLOCK_COLUMNS = 12; // 가로세로 10개가 놓이도록 설정
		static int BLOCK_WIDTH = 40;
		static int BLOCK_HEIGHT = 20;
		static int BLOCK_GAP = 3;
		static int BAR_WIDTH = 80;
		static int BAR_HEIGHT = 20;
		static int CANVAS_WIDTH = 500 + (BLOCK_GAP * BLOCK_COLUMNS) - BLOCK_GAP;
		static int CANVAS_HEIGHT = 500;

		// variable
		static MyPanel myPanel = null;
		static int score = 0; // 점수
		static Timer timer = null;
		static Block[][] blocks = new Block[BLOCK_ROWS][BLOCK_COLUMNS]; // 공간만 만들어짐
		static Bar bar = new Bar();
		static Ball ball = new Ball();
		static int barXTarget = bar.x; // Target Value- 보관을 하기 위한
		static int dir = 0; // 0 :Up-Right | 1: Down-Right | 2: Up-Left | 3: Down-Left
		static int ballSpeed = 5;

		static class Ball {
			int x = CANVAS_WIDTH / 2 - BALL_WIDTH; // 공이 화면 중앙에 있으니 가운데로
			int y = CANVAS_HEIGHT / 2 - BALL_HEIGHT;
			int width = BALL_WIDTH;
			int height = BALL_HEIGHT;

			Point getCenter() {
				return new Point(x + (BALL_WIDTH / 2), y + (BALL_HEIGHT / 2));
			}

			Point getBottomCenter() {
				return new Point(x + (BALL_WIDTH / 2), y + (BALL_HEIGHT));

			}

			Point getTopCenter() {
				return new Point(x + (BALL_WIDTH / 2), y);

			}

			Point getLeftCenter() {
				return new Point(x, y + (BALL_HEIGHT));

			}

			Point getRightCenter() {
				return new Point(x + (BALL_WIDTH), y + (BALL_HEIGHT / 2));

			}
		}

		// 바 좌우로 움직이는 정보를 받기위한 클래스
		static class Bar {
			int x = CANVAS_WIDTH / 2 - BAR_WIDTH / 2;
			int y = CANVAS_HEIGHT - 100; // 600에서 100정도 떨어진 값
			int width = BAR_WIDTH;
			int height = BAR_HEIGHT;
		}

		static class Block {
			int x = 0;
			int y = 0;
			int width = BLOCK_WIDTH;
			int height = BLOCK_HEIGHT;
			int color = 0; // 0:white 1:gelbe 2.blau 3:mazante 4:rot
			boolean isHidden = false; // 충돌후 블록이 사라지게 하기 위해서.

		}

		static class MyPanel extends JPanel { //
			public MyPanel() {
				this.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
				this.setBackground(Color.BLACK);
			}

			@Override
			public void paint(Graphics g) {
				super.paint(g);
				Graphics2D g2d = (Graphics2D) g;

				drawUI(g2d);
			}

			private void drawUI(Graphics2D g2d) {
				// 블록들을 그려보자
				for (int i = 0; i < BLOCK_ROWS; i++) { // 블록 5줄
					for (int j = 0; j < BLOCK_COLUMNS; j++) {
						if (blocks[i][j].isHidden) {
							continue;
						}
						if (blocks[i][j].color == 0) {
							g2d.setColor(Color.WHITE);
						} else if (blocks[i][j].color == 1) {
							g2d.setColor(Color.YELLOW);
						} else if (blocks[i][j].color == 2) {
							g2d.setColor(Color.BLUE);
						} else if (blocks[i][j].color == 3) {
							g2d.setColor(Color.MAGENTA);
						} else if (blocks[i][j].color == 4) {
							g2d.setColor(Color.RED);
						}
						g2d.fillRect(blocks[i][j].x, blocks[i][j].y, blocks[i][j].width, blocks[i][j].height);

					}
					// draw score
					g2d.setColor(Color.WHITE);
					g2d.setFont(new Font("TimesRoman", Font.BOLD, 20));
					g2d.drawString("score: " + score, CANVAS_WIDTH / 2 - 50, 20);

					// draw Ball
					g2d.setColor(Color.WHITE);
					g2d.fillOval(ball.x, ball.y, BALL_WIDTH, BALL_HEIGHT);

					// drwa Bar
					g2d.setColor(Color.WHITE);
					g2d.fillRect(bar.x, bar.y, bar.width, bar.height);

				}
			}
		}

		public MyFrame(String title) {
			super(title); // jframe에 들어가있는 생성자에다가 연결
			this.setVisible(true);
			this.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
			this.setLocation(400, 300);
			this.setLayout(new BorderLayout());
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			initData();

			myPanel = new MyPanel();
			this.add("Center", myPanel);

			setKeyListener();
			startTimer();
		}

		public void initData() {
			for (int i = 0; i < BLOCK_ROWS; i++) { // 블록 5줄
				for (int j = 0; j < BLOCK_COLUMNS; j++) {
					blocks[i][j] = new Block();
					blocks[i][j].x = BLOCK_WIDTH * j + BLOCK_GAP * j;
					blocks[i][j].y = 100 + BLOCK_HEIGHT * i + BLOCK_GAP * i;
					blocks[i][j].width = BLOCK_WIDTH;
					blocks[i][j].height = BLOCK_HEIGHT;
					blocks[i][j].color = 4 - i; // 0:white 1:gelbe 2.blau 3:mazante 4:rot
					blocks[i][j].isHidden = false;

				}
			}
		}

		public void setKeyListener() {
			this.addKeyListener(new KeyAdapter() {// 객체 임명 함수

				@Override
				public void keyPressed(KeyEvent e) { // Key Event
					if (e.getKeyCode() == KeyEvent.VK_LEFT) {
						System.out.println("Pressed Left Key");
						barXTarget -= 20;
						if (bar.x < barXTarget) { // 타겟보다 작은 경우가 생김 그래서
							barXTarget = bar.x; //
						}
					} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
						System.out.println("Pressed Right Key");
						barXTarget += 20;
						if (bar.x > barXTarget) { // 타겟보다 작은 경우가 생김 그래서
							barXTarget = bar.x; // 키 밀리는거 방지용

						}

					}

				}

			});
		}

		public void startTimer() {
			timer = new Timer(20, new ActionListener() {// 스윙쪽에서 지원해주는

				@Override //
				public void actionPerformed(ActionEvent e) { // 타이머 이벤트
					movement();
					checkCollision(); // 벽이랑 바랑
					checkCollisionBlock(); // 블록 50개 충돌
					myPanel.repaint(); // Redraw!
				}

			});
			timer.start(); // Start Timer!
		}

		public void movement() {
			if (bar.x < barXTarget) {
				bar.x += 5; // 부드러운 움직임을 위해서
			} else if (bar.x > barXTarget) {
				bar.x -= 5;
			}

			if (dir == 0) {
				ball.x += ballSpeed;
				ball.y -= ballSpeed;
			} else if (dir == 1) { // 1: Down-Right
				ball.x += ballSpeed;
				ball.y += ballSpeed;
			} else if (dir == 2) { // 2: Up-Left
				ball.x -= ballSpeed;
				ball.y -= ballSpeed;
			} else if (dir == 3) { // 3: Down-Left
				ball.x -= ballSpeed;
				ball.y += ballSpeed;
			}
		}

		public boolean duplRect(Rectangle rect1, Rectangle rect2) {
			return rect1.intersects(rect2); // 체크해주는 함수 2개의 사각형
		}

		public void checkCollision() {
			if (dir == 0) {
				// Wall
				if (ball.y < 0) { // 위쪽 벽 충돌 했을때
					dir = 1;
				}
				if (ball.x > CANVAS_WIDTH - BALL_WIDTH) { // 오른쪽 벽
					dir = 2;
				}
				// Bar
				// none
			} else if (dir == 1) { // 1: Down-Right
				// Wall
				if (ball.y > CANVAS_HEIGHT - BALL_HEIGHT - BALL_HEIGHT) {// 아랫쪽 벽 충돌했을때.
					dir = 0;
				}
				if (ball.x > CANVAS_WIDTH - BALL_WIDTH) {
					dir = 3;
				}
				// Bar
				if (ball.getBottomCenter().y >= bar.y) {
					if (duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
							new Rectangle(bar.x, bar.y, bar.width, bar.height))) {
						dir = 0;
					}
				}
			} else if (dir == 2) { // 2: Up-Left
				// wall
				if (ball.y < 0) {// wall upper
					dir = 3;

				}
				if (ball.x < 0) { // wall left
					dir = 0;
				}
				// Bar- none
			} else if (dir == 3) { // 3: Down-Left
				// wall
				if (ball.y > CANVAS_HEIGHT - BALL_HEIGHT - BALL_HEIGHT) { // wall bottom
					dir = 2;

				}
				if (ball.x < 0) { // wall left
					dir = 1;

				}
				if (ball.getBottomCenter().y >= bar.y) {
					if (duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
							new Rectangle(bar.x, bar.y, bar.width, bar.height))) {
						dir = 2;
					}
				}
			}
		}

		public void checkCollisionBlock() {
			// 0 :Up-Right | 1: Down-Right | 2: Up-Left | 3: Down-Left
			for (int i = 0; i < BLOCK_ROWS; i++) {
				for (int j = 0; j < BLOCK_COLUMNS; j++) {
					Block block = blocks[i][j];
					if (block.isHidden == false) {
						if (dir == 0) {// 0 :Up-Right
							if (duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
									new Rectangle(block.x, block.y, block.width, block.height))) {
								if (ball.x > block.x + 2 && ball.getRightCenter().x <= block.x + block.width - 2) {
									// 블록 아랫쪽에 부딫혔을때.
									dir = 1;
								} else {
									// block left collision
									dir = 2;
								}
								block.isHidden = true;
							}
						} else if (dir == 1) { // 1: Down-Right

							if (duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
									new Rectangle(block.x, block.y, block.width, block.height))) {
								if (ball.x > block.x + 2 && ball.getRightCenter().x <= block.x + block.width - 2) {
									// 블록 위쪽이 부딫혔을때
									dir = 0;
								} else {
									// block left collision
									dir = 3;
								}
								block.isHidden = true;
							}
						}
					} else if (dir == 2) {// 2: Up-Left

						if (duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
								new Rectangle(block.x, block.y, block.width, block.height))) {
							if (ball.x > block.x + 2 && ball.getRightCenter().x <= block.x + block.width - 2) {
								// 블록 위쪽이 부딫혔을때
								dir = 3;
							} else {
								// block top collision
								dir = 0;
							}
							block.isHidden = true;
						}

					} else if (dir == 3) {// 3: Down-Left

						if (duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
								new Rectangle(block.x, block.y, block.width, block.height))) {
							if (ball.x > block.x + 2 && ball.getRightCenter().x <= block.x + block.width - 2) {
								// 블록 윗쪽 부딫혔을때
								dir = 2;
							} else {
								// block right collision
								dir = 1;
							}
							block.isHidden = true;
						}

					}
				}
			}
		}
	}

	public static void main(String[] args) {

		new MyFrame("Block Game");

	}

}// end of class
