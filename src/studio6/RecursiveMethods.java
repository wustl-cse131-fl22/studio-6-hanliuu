package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		
			if (n==0) {
				return 0;
			}
			else {
				return geometricSum(n-1)+Math.pow(2, -n);
			}
			
			
		
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		
		if (p%q==0) {
			return q;
		}
		else {
			return gcd(q,p%q);
		}
		
	}

	

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {

		int[] reversed = new int[array.length];
		if (array.length==0) {
			return reversed;
		}
		else {
			helper(array,0,reversed);
			return reversed;
		}
		
	}
	
	public static int[] helper(int[] array, int index,int[] reversed)  {
		if (index>array.length/2) {
			return reversed;
		}
		else {
			reversed[index]=array[array.length-index-1];
			reversed[array.length-index-1]=array[index];
			return helper(array, index+1, reversed);
		}
	}

	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {

		if (radius/3<radiusMinimumDrawingThreshold) {
			StdDraw.circle(xCenter,yCenter,radius);
		}
		else {
			radius=radius/3.0;
			xCenter=xCenter-radius;
			circlesUponCircles(xCenter, yCenter, radius,radiusMinimumDrawingThreshold);
			xCenter=xCenter+2*radius;
			circlesUponCircles(xCenter, yCenter, radius,radiusMinimumDrawingThreshold);
			xCenter=xCenter-radius;
			yCenter=xCenter-radius;
			circlesUponCircles(xCenter, yCenter, radius,radiusMinimumDrawingThreshold);
			yCenter=xCenter+2*radius;
			circlesUponCircles(xCenter, yCenter, radius,radiusMinimumDrawingThreshold);
				
			}
		}
	}


