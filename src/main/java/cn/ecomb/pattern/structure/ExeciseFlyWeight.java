package cn.ecomb.pattern.structure;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhouzhigang on 2017/10/23.
 */
public class ExeciseFlyWeight {
    public static void main(String[] args) {
        FlyWeight flyWeightMan = HumanFlyWeightFactory.getHuman("man");
        FlyWeight flyWeightWoman = HumanFlyWeightFactory.getHuman("woman");
        Character character = new Character("qiangjiande ");
        flyWeightMan.display(character);

    }

}


interface FlyWeight {
    void setSex(String sex);
    String getSex();
    void display(Character c);
}

class HumanFlyWeight implements FlyWeight{
    private String sex;

    public HumanFlyWeight(String sex) {
        this.sex = sex;
    }

    @Override
    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String getSex() {
        return this.sex;
    }

    @Override
    public void display(Character c) {
        System.out.printf(c.getCharacter() + "的" + this.sex);
    }
}


class HumanFlyWeightFactory {
    private static Map<String, FlyWeight> map = new HashMap();

    public static FlyWeight getHuman(String sex) {
        if (map.get(sex) != null) {
            return map.get(sex);
        } else {
            HumanFlyWeight human = new HumanFlyWeight(sex);
            map.put(sex, human);
            return human;
        }
    }
}


class Character{
    private String character;

    public Character(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}