class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            if (map.containsKey(groupSize)) {
                List<Integer> integers = map.get(groupSize);
                integers.add(i);
                map.put(groupSize, integers);
            } else {
                List<Integer> integers = new ArrayList<>();
                integers.add(i);
                map.put(groupSize, integers);
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> integers = entry.getValue();
            List<Integer> integerList = new ArrayList<>();
            int listSize = integers.size();
            int count = key;
            for (int j = 0; j < listSize; j++, count--) {
                if (count == 0) {
                    count = key;
                    result.add(integerList);
                    integerList = new ArrayList<>();
                }
                integerList.add(integers.get(j));
            }
            result.add(integerList);
        }
        return result;
    }
}