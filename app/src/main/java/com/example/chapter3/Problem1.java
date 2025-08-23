package com.example.chapter3;

public class Problem1 {
    static class Stack {
        private static Integer[] list = new Integer[9];
        private int stackNumber;

        public Stack(int stackNumber) {
            this.stackNumber = stackNumber;
        }

        public void push(int item) {
            var index = stackNumber % 3;
            if (!hasSpaceOfList(index)) {
                extendList();
            }
            Integer previousValue = item;
            for (int i = index; i < list.length; i += 3) {
                Integer tmp = list[i];
                list[i] = previousValue;
                previousValue = tmp;
                if (previousValue == null) {
                    break;
                }
            }
        }

        public Integer pop() {
            var index = stackNumber % 3;
            if (list[index] == null) {
                return null;
            }

            Integer nextValue = null;
            for (int i = getLastOfStackNumber(index); i > 0; i -= 3) {
                Integer tmp = list[i];
                list[i] = nextValue;
                nextValue = tmp;
            }

            return nextValue;
        }

        public Integer peek() {
            var index = stackNumber % 3;
            return list[index];
        }

        public boolean isEmpty() {
            var index = stackNumber % 3;
            return list[index] == null;
        }

        public void show() {
            var index = stackNumber % 3;
            for (int i = index; i < list.length; i += 3) {
                if (list[i] == null) {
                    break;
                }
                System.out.print(list[i]);
                if (i + 3 < list.length) {
                    System.out.print(" → ");
                }
            }
            System.out.println();
        }

        private boolean hasSpaceOfList(int index) {
            return list[getLastOfStackNumber(index)] == null;
        }

        private void extendList() {
            var newList = new Integer[list.length + list.length];

            for (int i = 0; i < list.length; i++) {
                newList[i] = list[i];
            }
            list = newList;
        }

        private int getLastOfStackNumber(int index) {
            final int ToLastIndexOfStackNumber = 2 - index;
            var last = list.length - 1 - ToLastIndexOfStackNumber;
            return last;
        }
    }

    public static void main(String[] args) {
        var stack1 = new Stack(1);
        var stack2 = new Stack(2);
        var stack3 = new Stack(3);

        System.out.println("is stack1 empty :" + stack1.isEmpty());

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.pop();
        System.out.println("is stack1 empty :" + stack1.isEmpty());

        stack2.push(4);
        stack2.push(3);
        stack2.push(2);
        stack2.push(1);

        stack1.show();
        stack2.show();
        stack3.show();

        System.out.println("stask1 peeks " + stack1.peek());
        System.out.println("stask2 peeks " + stack2.peek());
        System.out.println("stask3 peeks " + stack3.peek());
    }
}
