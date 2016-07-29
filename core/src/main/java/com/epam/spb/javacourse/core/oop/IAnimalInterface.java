package com.epam.spb.javacourse.core.oop;

public interface IAnimalInterface {



    default void move() {
        int g = 10;
        System.out.println("g " + g);
    }

    default void feed(IFood food) {
        if( getPossibleHeight() > food.height() &&
            getPossibleWidth() > food.width()
        ) {
            putFoodIntoMouth(food);
            eat();
            applyCalories(food.getCalories());
        }
    }

    void putFoodIntoMouth(IFood food);
    void eat();
    void applyCalories(int caloriesCount);

    int getPossibleWidth();
    int getPossibleHeight();

    void generateKids();
}


interface IFood {
    default int getCalories() {
        return 10;
    }

    default int height() {
        return 10;
    }

    default int width() {
        return 1;
    }
}