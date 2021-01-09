package dynamic_programming;

import datastructures_for_dictionaries.LinkedList;

public class Knapsack {

    public static void main(String[] args) {
        // Example:
        Item[] items = {new Item(4, 12, "0"), new Item(2, 2, "1"), new Item(2, 1, "2"), new Item(1, 1, "3"), new Item(10, 4, "4")};
        System.out.println(knapsackMaxValueVariant(items, 15));  // [1, 2, 3, 4]
        System.out.println(knapsackMinWeightVariant(items, 15));  // [1, 2, 3, 4]
        System.out.println(knapsackApproximativeVariant(items, 15, 1.00));  // [1, 2, 3, 4]
        System.out.println(knapsackApproximativeVariant(items, 15, 0.90));
    }

    public static LinkedList<Item> knapsackMaxValueVariant(Item[] items, int weightLimit) {
        int[][] table = new int[items.length + 1][weightLimit + 1];
        for (int i = 0; i < items.length + 1; ++i) {
            table[i][0] = 0;
        }
        for (int w = 0; w < weightLimit + 1; ++w) {
            table[0][w] = 0;
        }

        for (int i = 1; i < items.length + 1; ++i) {
            for (int w = 1; w < weightLimit + 1; ++w) {
                Item currentItem = items[i - 1];
                int newValue = table[i - 1][w];
                if (w - currentItem.weight >= 0) {
                    newValue = Math.max(newValue, table[i - 1][w - currentItem.weight] + currentItem.value);
                }
                table[i][w] = newValue;
            }
        }

        LinkedList<Item> solution = new LinkedList<>();
        int i = items.length;
        int w = weightLimit;
        while (i != 0 && w != 0) {
            Item currentItem = items[i - 1];
            if (w - currentItem.weight >= 0 && table[i - 1][w - currentItem.weight] + currentItem.value > table[i - 1][w]) {
                solution.addFirst(currentItem);
                w -= currentItem.weight;
            }
            --i;
        }
        return solution;
    }

    public static LinkedList<Item> knapsackMinWeightVariant(Item[] items, int weightLimit) {
        int totalValue = 0;
        for (Item item : items) {
            totalValue += item.value;
        }
        int[][] table = new int[items.length + 1][totalValue + 1];
        for (int i = 0; i < items.length + 1; ++i) {
            table[i][0] = 0;
        }
        for (int w = 0; w < totalValue + 1; ++w) {
            table[0][w] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < items.length + 1; ++i) {
            for (int v = 1; v < totalValue + 1; ++v) {
                Item currentItem = items[i - 1];
                int newWeight = table[i - 1][v];
                if (v - currentItem.value >= 0) {
                    newWeight = Math.min(newWeight, table[i - 1][v - currentItem.value] + currentItem.weight);
                }
                table[i][v] = newWeight;
            }
        }

        LinkedList<Item> solution = new LinkedList<>();
        int i = items.length;
        int v = totalValue;
        while (table[i][v] > weightLimit) {
            --v;
        }
        while (i != 0 && v != 0) {
            Item currentItem = items[i - 1];
            if (v - currentItem.value >= 0 && table[i - 1][v - currentItem.value] + currentItem.weight > table[i - 1][v]) {
                solution.addFirst(currentItem);
                v -= currentItem.value;
            }
            --i;
        }
        return solution;
    }

    public static LinkedList<Item> knapsackApproximativeVariant(Item[] items, int weightLimit, double epsilon) {
        int maxValue = 0;
        for (Item item : items) {
            maxValue = Math.max(maxValue, item.value);
        }
        double k = (epsilon * maxValue) / items.length;
        int[] approxValues = new int[items.length];
        int totalValue = 0;
        for (int i = 0; i < approxValues.length; ++i) {
            int value = (int) (items[i].value / k);
            approxValues[i] = value;
            totalValue += value;
        }

        int[][] table = new int[items.length + 1][totalValue + 1];
        table[0][0] = 0;
        for (int w = 0; w < totalValue + 1; ++w) {
            table[0][w] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < items.length + 1; ++i) {
            for (int v = 0; v < totalValue + 1; ++v) {
                Item currentItem = items[i - 1];
                int currentItemApproxValue = approxValues[i - 1];
                int newWeight = table[i - 1][v];
                if (v - currentItemApproxValue >= 0) {
                    newWeight = Math.min(newWeight, table[i - 1][v - currentItemApproxValue] + currentItem.weight);
                }
                table[i][v] = newWeight;
            }
        }

        LinkedList<Item> solution = new LinkedList<>();
        int i = items.length;
        int v = totalValue;
        while (table[i][v] > weightLimit) {
            --v;
        }
        while (i != 0 && v != 0) {
            Item currentItem = items[i - 1];
            int currentItemApproxValue = approxValues[i - 1];
            if (v - currentItemApproxValue >= 0 && table[i - 1][v - currentItemApproxValue] + currentItem.weight > table[i - 1][v]) {
                solution.addFirst(currentItem);
                v -= currentItemApproxValue;
            }
            --i;
        }
        return solution;
    }

    public static class Item {
        int value;
        int weight;
        String label;

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        public Item(int value, int weight, String label) {
            this(value, weight);
            this.label = label;
        }

        @Override
        public String toString() {
            if (label != null) {
                return "Item{" + label + '}';
            }
            return super.toString();
        }
    }

}
