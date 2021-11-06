package List;
// Task: Implement a class named 'RangeList'
// A pair of integers define a range, for example: [1, 5). This range
// includes integers: 1, 2, 3, and 4.
// A range list is an aggregate of these ranges: [1, 5), [10, 11), [100, 201)


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeList {

    /**
     * Constructor without the parameter.
     */
    public RangeList() {
        this.rangeLists = new ArrayList<>();
    }

    /**
     * Adds a range to the list
     *
     * @param range Array of two integers that specify beginning and end of range.
     */
    public void add(Integer[] range) {
        // The range list after inserting the range
        List<List<Integer>> addRangeList = new ArrayList<>();
        // The index points to the current rangeLists
        int index = 0;
        // The size of the current rangeLists
        int size = rangeLists.size();

        // If the start index range[0] >= end index range[1], it's invalid and return
        if (range[0] >= range[1]) {
            return;
        }

        // First iterate over the ranges on the left side of the new range and add them to the addRangeList
        while (index < size && rangeLists.get(index).get(1) < range[0]) {
            addRangeList.add(rangeLists.get(index));
            index += 1;
        }

        // When the intervals have overlap
        while (index < size && rangeLists.get(index).get(0) <= range[1]) {
            // start and end index of current range
            int start = rangeLists.get(index).get(0), end = rangeLists.get(index).get(1);

            // When two intervals have overlap
            // choose the smaller start index as the new start index and choose the larger end index as the new end index
            range[0] = Math.min(range[0], start);
            range[1] = Math.max(range[1], end);

            index += 1;
        }
        // Add the new range to the addRangeList
        addRangeList.add(Arrays.asList(range));

        // Iterate over the ranges on the right side of the new range and add to the addRangeList
        while (index < size) {
            addRangeList.add(rangeLists.get(index));
            index += 1;
        }

        // Assign the addRangeList to the rangeLists
        this.rangeLists = addRangeList;
    }

    /***
     * Removes a range from the list
     * @param range Array of two integers that specify beginning and end of range.
     */
    public void remove(Integer[] range) {
        // The range list after inserting the range
        List<List<Integer>> deleteRangeList = new ArrayList<>();
        // The index points to the current rangeLists
        int index = 0;
        // The size of the current rangeLists
        int size = rangeLists.size();

        // If the start index range[0] >= end index range[1], it's invalid and return
        if (range[0] >= range[1]) {
            return;
        }

        // First iterate over the ranges on the left side of the new range and add them to the deleteRangeList
        while (index < size && rangeLists.get(index).get(1) < range[0]) {
            deleteRangeList.add(rangeLists.get(index));
            index += 1;
        }

        // When the intervals have overlap
        while (index < size && rangeLists.get(index).get(0) <= range[1]) {
            // start and end index of current range
            int start = rangeLists.get(index).get(0), end = rangeLists.get(index).get(1);

            // When current range's start index is smaller than the delete range's start index,
            // add the [rangeLists.get(index).get(0), range[0]) to the deleteRangeList
            if (start < range[0]) {
                List<Integer> addRange = new ArrayList<>();
                addRange.add(start);
                addRange.add(range[0]);
                deleteRangeList.add(addRange);
            }

            // When current range's end index is larger than the delete range's end index,
            // add the [range[1], rangeLists.get(index).get(1)) to the deleteRangeList
            if (end > range[1]) {
                List<Integer> addRange = new ArrayList<>();
                addRange.add(range[1]);
                addRange.add(end);
                deleteRangeList.add(addRange);
            }

            index += 1;
        }

        // Iterate over the ranges on the right side of the new range and add to the addRangeList
        while (index < size) {
            deleteRangeList.add(rangeLists.get(index));
            index += 1;
        }

        // Assign the deleteRangeList to the rangeLists
        this.rangeLists = deleteRangeList;
    }

    /**
     * Print out the list of ranges in the range list.
     */
    public void print() {
        // Iterate to print the range
        for (List<Integer> range : rangeLists) {
            System.out.print("[" + range.get(0) + ", " + range.get(1) + ") ");
        }
        System.out.println();
    }

    /**
     * List stores every ranges.
     */
    private List<List<Integer>> rangeLists;

    // Test of the rangeList class
    public static void main(String[] args) {
        RangeList rangeList = new RangeList();
        rangeList.add(new Integer[]{1, 5});
        rangeList.print();

        rangeList.add(new Integer[]{10, 20});
        rangeList.print();

        rangeList.add(new Integer[]{20, 20});
        rangeList.print();

        rangeList.add(new Integer[]{20, 21});
        rangeList.print();

        rangeList.add(new Integer[]{2, 4});
        rangeList.print();

        rangeList.add(new Integer[]{3, 8});
        rangeList.print();

        rangeList.remove(new Integer[]{10, 10});
        rangeList.print();

        rangeList.remove(new Integer[]{10, 11});
        rangeList.print();

        rangeList.remove(new Integer[]{15, 17});
        rangeList.print();

        rangeList.remove(new Integer[]{3, 19});
        rangeList.print();
    }

}

