package cn.ecomb.effectiveJava.createDestory;

/**
 * Created by arron on 2017/3/23.
 */
public class NutritionFacts {

    // 对这个final的使用思考？？？？？
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

//    public NutritionFacts(int servingSize, int servings) {
//        this(servingSize, servings,0);
//    }
//
//    public NutritionFacts(int servingSize, int servings, int calories) {
//        this(servingSize, servings, calories, 0);
//    }
//
//    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
//        this(servingSize, servings, calories, 0, 0, 0);
//    }
//
//    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
//        this.servingSize = servingSize;
//        this.servings = servings;
//        this.calories = calories;
//        this.fat = fat;
//        this.sodium = sodium;
//        this.carbohydrate = carbohydrate;
//    }


    public static class Builder{
        // 必须值
        private final int servingSize;
        private final int servings;
        private int calories;
        private int fat;
        private int sodium;
        private int carbohydrate;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }
        public Builder fat(int val) {
            calories = val;
            return this;
        }
        public Builder sodium(int val) {
            calories = val;
            return this;
        }
        public Builder carbohydrate(int val) {
            calories = val;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builser) {
        servingSize = builser.servingSize;
        servings = builser.servings;
        calories = builser.calories;
        fat = builser.fat;
        sodium = builser.sodium;
        carbohydrate = builser.carbohydrate;
    }

}
