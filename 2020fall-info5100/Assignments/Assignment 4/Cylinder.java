/**
 * A Cylinder is a Circle plus a height.
 * Availability: https://www3.ntu.edu.sg/home/ehchua/programming/java/J3b_OOPInheritancePolymorphism.html
 */
public class Cylinder extends Circle {
	
   // private instance variable
   private double height;

   // Constructors
   public Cylinder() {
      super();  // invoke constructor Circle()
      this.height = 1.0;
   }
   public Cylinder(double height) {
      super();  // invoke constructor Circle()
      this.height = height;
   }
   public Cylinder(double height, double radius) {
      super(radius);  // invoke constructor Circle(radius)
      this.height = height;
   }
   public Cylinder(double height, double radius, String color) {
      super(radius, color);  // invoke constructor Circle(radius, color)
      this.height = height;
   }

   // Getter and Setter
   public double getHeight() {
      return this.height;
   }
   public void setHeight(double height) {
      this.height = height;
   }

   /** Returns the volume of this Cylinder */
   public double getVolume() {
      return super.getArea()*height;   // use superclass' getArea()
   }
   
   // Override the getArea() method inherited from superclass Circle
   @Override
   public double getArea() {
	return 2*Math.PI*getRadius()*height + 2*super.getArea();
   }

   /** Returns a self-descriptive String */
   @Override
   public String toString() {
      return "Cylinder[" + super.toString() + ",height=" + height + "]";   
   }
}
