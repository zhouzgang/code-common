package effectiveJava;

import org.junit.Test;

import cn.ecomb.effectiveJava.enumDemo.Planet;

/**
 * Created by arron on 2017/3/21.
 */
public class TestEnum {

    @Test
    public void testPlanet(){
        double earthWeight = Double.parseDouble("175");
        double mass = earthWeight / Planet.EARTH.getSurfaceGravity();
        for (Planet planet : Planet.values()){
            System.out.println(planet + ":" + planet.surfaceWeight(mass));
        }
    }
}
