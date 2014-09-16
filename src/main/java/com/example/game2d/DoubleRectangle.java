package com.example.game2d;

public class DoubleRectangle {

	/** double rectangle parameters
	 * 
	 */
	public double x,y,width,height;
	
	public DoubleRectangle(){
		setBounds(0,0,0,0);
	}
	
	/** double Rectangle with set Bounds:
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public DoubleRectangle(double x, double y, double width, double height){
		setBounds(x,y,width,height);
	}
	
	public void setBounds(double x, double y, double width, double height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
}
