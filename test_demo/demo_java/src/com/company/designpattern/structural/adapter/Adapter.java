package com.company.designpattern.structural.adapter;

public class Adapter {
    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow();
        ToyDuck toyDuck = new PlasticToyDuck();

        ToyDuck birdAdapter = new BirdAdapter(sparrow);

        System.out.println("========Sparrow===============");
        sparrow.fly();
        sparrow.makeSound();

        System.out.println("===========ToyDuck==============");
        toyDuck.squeak();

        System.out.println("=============BirdAdapter==================");
        birdAdapter.squeak();
    }

    interface Bird {
        void fly();

        void makeSound();
    }

    static class Sparrow implements Bird {
        @Override
        public void fly() {
            System.out.println("Flying");
        }

        @Override
        public void makeSound() {
            System.out.println("Chirp Chirp");
        }
    }

    interface ToyDuck {
        void squeak();
    }

    static class PlasticToyDuck implements ToyDuck {
        @Override
        public void squeak() {
            System.out.println("Squeak");
        }
    }

    static class BirdAdapter implements ToyDuck {
        Bird bird;

        public BirdAdapter(Bird bird) {
            this.bird = bird;
        }

        @Override
        public void squeak() {
            bird.makeSound();
        }
    }


}

