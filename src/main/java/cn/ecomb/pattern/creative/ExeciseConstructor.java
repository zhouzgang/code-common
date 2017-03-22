package cn.ecomb.pattern.creative;

/**
 * Created by arron on 2016/12/20.
 * 构建者模式
 *  分离了对象组件的单独构造（由Builder来负责）和装配（由Director来负责）
 *  总结：主要是创建有组件构成的对象时，分离组件创建过程和组件最后的的装配过程
 *        可以接着在这上面进行改进，比如说: 使用不同的构建者创建的组件，装配成一个对象
 */
public class ExeciseConstructor {
    public void execute(){
        MyAirShipDirector myAirShipDirector = new MyAirShipDirector(new MyAirShipBuilder());
        AirShip airShip = myAirShipDirector.directorAirShip();
        System.out.println("装配后的引擎：" + airShip.getEngine().getName());
        airShip.launch();
    }
}

/**
 * 飞船类
 */
class AirShip {
    private OrbitalModule orbitalModule;  //轨道仓
    private Engine engine; //发动机
    private EscapeTower escapeTower;  //逃逸塔

    public void launch(){
        System.out.println("发射！");
    }

    public OrbitalModule getOrbitalModule() {
        return orbitalModule;
    }

    public void setOrbitalModule(OrbitalModule orbitalModule) {
        this.orbitalModule = orbitalModule;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public EscapeTower getEscapeTower() {
        return escapeTower;
    }

    public void setEscapeTower(EscapeTower escapeTower) {
        this.escapeTower = escapeTower;
    }
}

//轨道仓
class OrbitalModule {
    private String name;

    public OrbitalModule(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//发动机
class Engine {
    private String name;

    public Engine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//逃逸塔
class EscapeTower {
    private String name;

    public EscapeTower(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//飞船的组件构建接口
interface AirShipBuilder{
    OrbitalModule builderOrbitalModule();
    Engine builderEngine();
    EscapeTower builderEscapeTower();
}

//飞船的装配接口
interface AirShipDirector {
    AirShip directorAirShip();
}

//某一个飞船制造商
class MyAirShipBuilder implements AirShipBuilder {

    public OrbitalModule builderOrbitalModule() {
        System.out.println("创建轨道舱");
        return new OrbitalModule("XXX轨道舱");
    }

    public Engine builderEngine() {
        System.out.println("创建发动机");
        return new Engine("XXX发动机");
    }

    public EscapeTower builderEscapeTower() {
        System.out.println("创建逃逸塔");
        return new EscapeTower("XXX逃逸塔");
    }
}

//我飞船装配者
class MyAirShipDirector implements AirShipDirector {

    private AirShipBuilder airShipBuilder;

    public MyAirShipDirector(AirShipBuilder airShipBuilder) {
        this.airShipBuilder = airShipBuilder;
    }

    public AirShip directorAirShip() {
        AirShip airShip = new AirShip();
        airShip.setOrbitalModule(airShipBuilder.builderOrbitalModule());
        airShip.setEngine(airShipBuilder.builderEngine());
        airShip.setEscapeTower(airShipBuilder.builderEscapeTower());
        return airShip;
    }
}