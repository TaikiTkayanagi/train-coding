package com.example.chapter3;

import com.example.util.SinglyNode;

public class Problem6 {
    private static class Animal {
        private static String DOG = "dog";
        private static String CAT = "cat";
        public String kind;

        public Animal(String kind) {
            this.kind = kind;
        }

        public boolean isDog() {
            return this.kind.equals(DOG);
        }

        public boolean isCat() {
            return this.kind.equals(CAT);
        }
    }

    private static class AnimalShelter {
        private SinglyNode<Animal> list;

        public void enqueue(Animal value) {
            if (list == null) {
                list = new SinglyNode<Animal>(value);
                return;
            }
            var tmp = list;
            list = new SinglyNode<Animal>(value);
            list.setNext(tmp);
        }

        public Animal dequeueAny() {
            if (list == null) {
                return new Animal(null);
            }
            SinglyNode<Animal> before = null;
            var iterator = list;
            while (iterator.getNext() != null) {
                before = iterator;
                iterator = iterator.getNext();
            }
            if (before != null) {
                before.setNext(null);
            } else {
                list = null;
            }
            return iterator.getValue();
        }

        public Animal dequeueDog() {
            if (list == null) {
                return new Animal(null);
            }
            SinglyNode<Animal> before = null;
            SinglyNode<Animal> lastDog = null;
            SinglyNode<Animal> beofreLastDog = null;
            var iterator = list;
            while (iterator != null) {
                if (iterator.getValue().isDog()) {
                    beofreLastDog = before;
                    lastDog = iterator;
                }
                before = iterator;
                iterator = iterator.getNext();
            }

            if (lastDog == null) {
                return new Animal(null);
            }

            if (beofreLastDog != null) {
                beofreLastDog.setNext(lastDog.getNext());
            } else {
                list = lastDog.getNext();
            }
            return lastDog.getValue();
        }

        public Animal dequeueCat() {
            if (list == null) {
                return new Animal(null);
            }
            SinglyNode<Animal> before = null;
            SinglyNode<Animal> lastCat = null;
            SinglyNode<Animal> beofreLastCat = null;
            var iterator = list;
            while (iterator != null) {
                if (iterator.getValue().isCat()) {
                    beofreLastCat = before;
                    lastCat = iterator;
                }
                before = iterator;
                iterator = iterator.getNext();
            }

            if (lastCat == null) {
                return new Animal(null);
            }

            if (beofreLastCat != null) {
                beofreLastCat.setNext(lastCat.getNext());
            } else {
                list = lastCat.getNext();
            }
            return lastCat.getValue();
        }
    }

    public static void main(String[] args) {
        var shelter = new AnimalShelter();

        shelter.enqueue(new Animal(Animal.CAT));
        shelter.enqueue(new Animal(Animal.DOG));
        shelter.enqueue(new Animal(Animal.DOG));
        shelter.enqueue(new Animal(Animal.DOG));
        shelter.enqueue(new Animal(Animal.CAT));

        System.out.println("shelter dequee Any " + shelter.dequeueCat().kind);
        System.out.println("shelter dequee Any " + shelter.dequeueCat().kind);
        System.out.println("shelter dequee Any " + shelter.dequeueAny().kind);
        System.out.println("shelter dequee Dog " + shelter.dequeueDog().kind);
    }
}
