package AbstractMethods;
import java.util.Scanner;

import AbstractMethods.RightTriangle;
public class Lab8
{
	public static void main(String args[])
	{
		// DATA
		Shape[] shapes = new Shape[10];
		int nextIDNumber = 1;
		boolean exit = false;
		int selection;
		Scanner input = new Scanner(System.in);
		int id;
		int x, y;
		double base, height, width, radius;
		boolean found = false;

		// ALGORITHM
		// loop until user exits
		do
		{
			// display menu
			System.out.println("1 Add a new circle");
			System.out.println("2 Add a new rectangle");
			System.out.println("3 Add a new right triangle");
			System.out.println("4 Delete a shape");
			System.out.println("5 Delete all shape");
			System.out.println("6 Display all shapes");
			System.out.println("7 Move a shape");
			System.out.println("8 Enter a scale factor");
			System.out.println("9 Scale all shapes");
			System.out.println("10 Exit program");

			// get user choice
			selection = input.nextInt();
			while (selection < 1 || selection > 10)
			{
				System.out.println("Please enter valid choice");
				selection = input.nextInt();
			}

			// switch on selection
			switch(selection)
			{
			case 1:
				// ADD NEW CIRCLE
				// get size from user (one variable)
					System.out.println("Enter the radius of the new circle.");
					radius = input.nextDouble();
					
				// get location from user (two variables)
					System.out.println("Enter the X location");
					x = input.nextInt();
					System.out.println("Enter the Y location");
					y = input.nextInt();
				
					// set found to false
					found = false;
				
					// loop through array
					for (int i = 0; i < shapes.length; i++)
					{
						if (shapes[i] == null)
						{
							shapes[i] = new Circle(nextIDNumber++, x, y, radius);
							shapes[i].setid(i);
							found = true;
							break;
						}
					
					}
					break;


			case 2:
				// ADD NEW RECTANGLE
				// get size from user (two variables)
				System.out.println("Enter the base of the rectangle");
				base = input.nextDouble();
				System.out.println("Enter the height of the rectangle");
				height = input.nextDouble();
				
				// get location from user (two variables)

				System.out.println("Enter the X location");
				x = input.nextInt();
				System.out.println("Enter the Y location");
				y = input.nextInt();
				
				// set found to false
				found = false;

				// loop through array
				for (int i = 0; i < shapes.length; i++)
				{
					if (shapes[i] == null)
					{
						shapes[i] = new Rectangle(nextIDNumber++, x, y, base, height);
						shapes[i].setid(i);
						found = true;
						break;
					}
				
				}
				break;

			case 3:
				// ADD NEW RIGHT TRIANGLE
				// get size from user (two variables)
				System.out.println("Enter the base");
				base = input.nextDouble();
				while (base <= 0)
				{
					System.out.println("Invalid number, please enter positive number");
					base = input.nextDouble();
				}

				System.out.println("Enter the height");
				height = input.nextDouble();
				while (height <= 0)
				{
					System.out.println("Invalid number, please enter positive number");
					height = input.nextDouble();
				}

				// get location from user (two variables)
				System.out.println("Enter X location");
				x = input.nextInt();
				while (x < 0)
				{
					System.out.println("Invalid number, please enter positive number or zero");
					x = input.nextInt();
				}

				System.out.println("Enter Y location");
				y = input.nextInt();
				while (y < 0)
				{
					System.out.println("Invalid number, please enter positive number or zero");
					y = input.nextInt();
				}

				// set found to false
				found = false;

				// loop through array
				for (int i = 0; i < shapes.length; i++)
				{
					// if this is not a valid object
					if (shapes[i] == null)
					{
	 					// create new RightTriangle object and assign to current array element
						shapes[i] = new RightTriangle(nextIDNumber++, x, y, base, height);
						shapes[i].setid(i);
						// set found to true
						found = true;

						// break out of loop
						break;
					}
				}

				// if not found, give error message
				if (!found)
				{
					System.out.println("No more room");
				}

				// break out of switch statement
				break;

			case 4:
				// DELETE ONE SHAPE
				// get id number to delete
				System.out.println("Enter the number of the shape that you would like to delete.");
				id = input.nextInt();

				// set found to false
				found = false;

				// loop through array
				for (int i = 0; i < shapes.length; i++)
				{
					if (shapes[i] != null && shapes[i].getid() == id)
					{
						shapes[i] = null;
						found = true;
						break;
					}
					else
					{
						System.out.println("Sorry, this one cannot be deleted.");
						
					}
				}
					break;
			case 5:
				// DELETE ALL SHAPES
				for (int i = 0; i < shapes.length; i++)
				{
					// if this is a valid object and the correct object
					if (shapes[i] != null)
					{
						// delete object
						shapes[i] = null;

						// set found to true
						found = true;
					}
				
				}
				
				// break out of loop
				break;

			case 6:
				// DISPLAY ALL SHAPES
				// print header
				System.out.println("Here are our shapes");
				System.out.println();
				
				for (int i = 0; i < shapes.length; i++)
				{
					if (shapes[i] != null)
					{
					System.out.println("Information for Shape: ");
					System.out.println("X Location: " + shapes[i].getxLoc());
					System.out.println("Y Location: " + shapes[i].getyLoc());
					System.out.println("Area: " + shapes[i].GetArea());
					System.out.println("Perimeter: " + shapes[i].GetPerimeter());
					System.out.println("ID: " + shapes[i].getid());
					System.out.println();
					}
				}
				
				// break out of switch statement
				break;
			case 7:
				// MOVE A SHAPE
				// get id number to move
				System.out.println("Which Shape would you like to move?");
				int id1 = input.nextInt();
				// get location from user (two variables)
				System.out.println("What is the new X location?");
				int x1 = input.nextInt();
				System.out.println("What is the new Y location?");
				int y1 = input.nextInt();

				// set found to false
				found = false;
				// loop through array
				for (int i = 0; i < shapes.length; i++)
				{
					if (shapes[i].getid() == id1)
					{
						shapes[i].setxLoc(x1);
						shapes[i].setyLoc(y1);
						found = true;
						break;
					}
				}
				
				
				break;

			case 8:
				// ENTER A SCALE FACTOR
				// get scale factor
				System.out.println("Set the scale factor");
				double scale = input.nextDouble();
				
				// call SetScaleFactor to set the new scale factor
				RightTriangle.setscaleFactor(scale);
				// break out of switch statement
				break;
			
			case 9:
				// SCALE ALL SHAPES
				// loop through array
				for (int i = 0; i < shapes.length; i++)
				{
					if (shapes[i] != null)
					{
						shapes[i].ScaleShape();
					}
				}

				// break out of switch statement
				break;

			case 10:
				// EXIT PROGRAM
				System.out.println("Are you sure you want to exit? (1 for Yes - 2 for No)");
				int num = input.nextInt();
				if (num == 1) {
					exit = true;
				}
				else {
					continue;
				}
			}

		} while (!exit);
		System.out.println("Good Bye!");
	}

}

abstract class Shape
{
	 private static double scaleFactor;
	 private int id;
	 private int xLoc;
	 private int yLoc;
	 
	// declare static variable

	// declare instance variables
	 public Shape(int id, int xLoc, int yLoc) {
		 setid(id);
		 setxLoc(xLoc);
		 setyLoc(yLoc);
	 }

	// one constructor

	// get/set methods
	 public static void setscaleFactor(double scale) {
			if(scale >= 1) {
				scaleFactor = scale;
			}
		}
		public double getscaleFactor() {
			return scaleFactor;
		}
	 
	 public void setid(int idd) {
			if(idd >= 0) {
				id = idd;
			}
		}
		
		public int getid() {
			return id;
		}
		public void setxLoc(int x) {
			if(x >= 0) {
				xLoc = x;
			}
			
		}
		
		public int getxLoc() {
			return xLoc;
		}
		
		public void setyLoc(int y) {
			if(y >= 0) {
				yLoc = y;
			}
		}
		
		public int getyLoc() {
			return yLoc;
		}
		
		
		// abstract methods
		public abstract double GetArea();
		public abstract double GetPerimeter();
		public abstract double ScaleShape();
}

class Circle extends Shape
{
	// declare instance variable
	private double radius;

	// one constructor
	public Circle(int id, int xLoc, int yLoc, double r){
		super(id, xLoc, yLoc);
		SetRadius(r);
	}
	// get/set methods
	public double GetRadius()
	{
		return radius;
	}
	public void SetRadius(double r)
	{
		if (r > 0.0)
		{
			radius = r;
		}
	}

	// override abstract methods
	// GetPerimeter method
	public double GetPerimeter()
	{
		return 2 * Math.PI * radius;
	}

	// GetArea method
	public double GetArea()
	{
		return Math.PI * radius * radius;
	}

	// ScaleShape method
	public double ScaleShape()
	{
		double scale = getscaleFactor();
		radius = radius * scale;
		 return radius;
	}

}

class Rectangle extends Shape
{
	// declare instance variables
	private double base;
	private double height;

	// one constructor
	public Rectangle(int id, int xLoc, int yLoc, double b, double h)
	{
		super(id, xLoc, yLoc);
		SetBase(b);
		SetHeight(h);
		
	}
	// get/set methods
	public double GetBase()
	{
		return base;
	}
	public void SetBase(double b)
	{
		if (b > 0.0)
		{
			base = b;
		}
	}
	public double GetHeight()
	{
		return height;
	}
	public void SetHeight(double h)
	{
		if (h > 0.0)
		{
			height = h;
		}
	}

	// override abstract methods
	// GetPerimeter method
	public double GetPerimeter()
	{
		return (2 * base + 2 * height);
	}

	// GetArea method
	public double GetArea()
	{
		return base * height;
	}

	// ScaleShape method
	public double ScaleShape()
	{
	double scale = getscaleFactor();
	double areaScaled = (base * scale) * (height * scale);
	return areaScaled;
		
	}

}

class RightTriangle extends Shape
{
	// declare instance variables
	private double base;
	private double height;
	private double hypotenuse;

	// one constructor
	public RightTriangle(int id, int xLoc, int yLoc, double b, double h)
	{
		super(id, xLoc, yLoc);
		SetBaseAndHeight(b,h);
		
	}
	// get/set methods
	public void SetBaseAndHeight(double b, double h)
	{
		if (b > 0.0 && h > 0)
		{
			base = b;
			height = h;
			hypotenuse = Math.sqrt(base*base + height*height);
		}
	}

	public double GetBase()
	{
		return base;
	}
	public double GetHeight()
	{
		return height;
	}

	public double GetHypotenuse()
	{
		return hypotenuse;
	}

	// override abstract methods
	// GetPerimeter method
	public double GetPerimeter()
	{
		return base + height + hypotenuse;
	}

	// GetArea method
	public double GetArea()
	{
		return 0.5 * base * height;
	}

	// ScaleShape method
	public double ScaleShape()
	{
		double scale = getscaleFactor();
		double b = base * scale;
		double h = height * scale;
		double hyp = Math.sqrt(b*b + h*h);
		return b + h + hyp;
	
	}

}