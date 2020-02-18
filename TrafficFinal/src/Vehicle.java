import java.awt.Graphics;

public class Vehicle {
		int x;
		int y;
		int speed;
		int width;
		int height;
		int position=0;
		String road;
		boolean turn1=false;
		boolean turn2=false;
		boolean turn3=false;
		public Vehicle(int x,int y) {
			this.x=x;
			this.y=y;
			if(x>=0 & x<=305 & y==104 || y==135 & x>=0 & x<=310) {
				this.road="r1";
			}
			else if(y>=0 & y<=55 & x==354 || x==385 & y>=0 & y<=60) {
				this.road="r2";
				
			}
			else if(y<=370 & y>=165 & x==385 ||x==354 & y<=365 & y>=150) {
				this.road="r3";
			}
			else if(x>=395 & x<=820 & y==135 || x>=395 & x<=820 & y==104) {
				this.road="r4";
			}
			else if(y<=560 & y>=445 & x==185 || x==155 & y<=560 & y>=445) {
				this.road="r5";
			}
			else if(y<=560 & y>=445 & x==385 || y<=560 & y>=445 & x==355 ) {
				this.road="r6";
			}
			else if(y<=560 & y>=445 & x==685 || y<=560 & y>=445 & x==655) {
				this.road="r7";
			}
			else if(x>=0 & x<=820 & y==404 || x>=0 & x<=820 & y==432 ) {
				this.road="main";
			}
			
		}
		public void paintMe(Graphics g) {
			
		}
		public void setPosition(int p) {
			this.position=p;
		}
		public int getX() {
			return x;
		}
		
		public void setX(int x) {
			this.x = x;
		}
		
		public int getY() {
			return y;
		}
		
		public void setY(int y) {
			this.y = y;
		}
		
		public int getSpeed() {
			return speed;
		}
		
		public void setSpeed(int speed) {
			this.speed = speed;
		}
		
		public int getWidth() {
			return width;
		}
		
		public void setWidth(int width) {
			this.width = width;
		}
		
		public int getHeight() {
			return height;
		}
		
		public void setHeight(int height) {
			this.height = height;
		}
		public void setRoad(int x,int y) {
			if(x>=0 & x<=305 & y==104 || y==135 & x>=0 & x<=310) {
				this.road="r1";
			}
			else if(y>=0 & y<=55 & x==354 || x==385 & y>=0 & y<=60) {
				this.road="r2";
				
			}
			else if(y<=370 & y>=165 & x==385 ||x==354 & y<=355 & y>=150) {
				this.road="r3";
			}
			else if(x>=409 & x<=820 & y==135 || x>=390 & x<=820 & y==104) {
				this.road="r4";
			}
			else if(y<=560 & y>=465 & x==185 || x==155 & y<=560 & y>=445) {
				this.road="r5";
			}
			else if(y<=560 & y>=465 & x==385 || y<=560 & y>=445 & x==355 ) {
				this.road="r6";
			}
			else if(y<=560 & y>=465 & x==685 || y<=560 & y>=445 & x==655) {
				this.road="r7";
			}
			else if(x>=0 & x<=820 & y==404 || x>=0 & x<=820 & y==432 ) {
				this.road="main";
			}
			else {
				this.road="in";
//				if((y<-50) & x==385) {
//					this.x=354;
//					this.y=0;
//					
//					this.turn1=true;
//					this.turn2=false;
//				}
//				else if((x<-97) & y==404) {
//					this.x=0;
//					this.y=432;
//					this.turn3=false;
//				}
//				else if((x>850) & y==432) {
//					this.x=0;
//					this.y=404;
//					this.turn3=false;
//				}
//				else if((x>320) & y==404) {
//					this.x=0;
//					this.y=432;
//					this.turn3=false;
//				}
//				else if((x>850) & y==432) {
//					this.x=0;
//					this.y=404;
//					this.turn3=false;
//				}
				
			}
		}
		public void turn1() {
			if(this.turn1==false) {
			int t=0;
			t=this.height;
			this.height=this.width;
			this.width=t;
			this.turn1=true;
			
			}
			else {
				int t=0;
				t=this.height;
				this.height=this.width;
				this.width=t;
				this.turn1=false;
			}
		}
		public void turn2() {
			if(this.turn2==false) {
			int t=0;
			t=this.height;
			this.height=this.width;
			this.width=t;
			this.turn2=true;
			
			}
			else {
				int t=0;
				t=this.height;
				this.height=this.width;
				this.width=t;
				this.turn2=false;
			}
		}
		public void turn3() {
			if(this.turn3==false) {
				this.turn3=true;
			
			}
			else {
				this.turn3=false;
			}
		}
	}

