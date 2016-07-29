package com.epam.spb.javacourse.core.oop;

public abstract class Animal implements IAnimalInterface {
    protected boolean isHuman;

    public abstract void breath();

    {

    }

    public static void main(String[] args) {
        Animal петр = new Осетр();
        Animal bird = new Bird();
    }
}

class Bird extends Animal {

    @Override
    public void breath() {

    }

    @Override
    public void move() {

    }

    @Override
    public void putFoodIntoMouth(IFood food) {

    }

    @Override
    public void eat() {

    }

    @Override
    public void applyCalories(int caloriesCount) {

    }

    @Override
    public int getPossibleWidth() {
        return 0;
    }

    @Override
    public int getPossibleHeight() {
        return 0;
    }

    @Override
    public void generateKids() {

    }
}

class Осетр extends Animal {
    @Override
    public void breath() {

    }

    @Override
    public void move() {

    }

    @Override
    public void putFoodIntoMouth(IFood food) {

    }

    @Override
    public void eat() {

    }

    @Override
    public void applyCalories(int caloriesCount) {

    }

    @Override
    public int getPossibleWidth() {
        return 0;
    }

    @Override
    public int getPossibleHeight() {
        return 0;
    }

    @Override
    public void generateKids() {

    }
}
