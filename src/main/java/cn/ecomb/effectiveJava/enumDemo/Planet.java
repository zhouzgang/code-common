package cn.ecomb.effectiveJava.enumDemo;

/**
 * 将数据与enum关联起来
 *
 * Created by arron on 2017/3/21.
 */
public enum Planet {
    MERCURY(3.302e+23, 2.439e6),
    EARTH(5.975e24, 6.378e6);

    private final double mass;
    private final double radius;
    private final double surfaceGravity;

    private static final double G = 6.67300E-11;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public double getSurfaceGravity() {
        return surfaceGravity;
    }

    public double surfaceWeight(double mass){
        return mass * surfaceGravity;
    }

    public static void main(String args[]){
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight / Planet.EARTH.surfaceGravity;
        for (Planet planet : Planet.values()){
            System.out.println(planet + ":" + planet.surfaceWeight(mass));
        }
    }


}
