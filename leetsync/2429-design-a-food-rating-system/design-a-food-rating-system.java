class FoodRatings {

    class Pair implements Comparable<Pair> {
        String foodName;
        int rating;

        Pair(String name, int rate) {
            foodName = name;
            rating = rate;
        }

        public int compareTo(Pair obj) {
            if (this.rating != obj.rating) {
                return obj.rating - this.rating;
            }

            return this.foodName.compareTo(obj.foodName);
        }
    }

    Map<String, PriorityQueue<Pair>> cuisineToRatingsMap;
    Map<String, Integer> foodNameToIndex;
    Map<String, String> foodToCuisine;
    Pair[] foodRatingsArray;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;

        cuisineToRatingsMap = new HashMap<>();
        foodNameToIndex = new HashMap<>();
        foodToCuisine = new HashMap<>();

        foodRatingsArray = new Pair[n];

        for (int i = 0; i < n; i++) {
            foodRatingsArray[i] = new Pair(foods[i], ratings[i]);

            foodNameToIndex.put(foods[i], i);
            foodToCuisine.put(foods[i], cuisines[i]);

            if (!cuisineToRatingsMap.containsKey(cuisines[i])) {
                cuisineToRatingsMap.put(cuisines[i], new PriorityQueue<>());
            }

            PriorityQueue<Pair> temp = cuisineToRatingsMap.get(cuisines[i]);
            temp.offer(foodRatingsArray[i]);
            cuisineToRatingsMap.put(cuisines[i], temp);
        }
    }

    public void changeRating(String food, int newRating) {
        int position = foodNameToIndex.get(food);

        cuisineToRatingsMap.get(foodToCuisine.get(food)).remove(foodRatingsArray[position]);
        foodRatingsArray[position].rating = newRating;
        cuisineToRatingsMap.get(foodToCuisine.get(food)).offer(foodRatingsArray[position]);
    }

    public String highestRated(String cuisine) {
        return cuisineToRatingsMap.get(cuisine).peek().foodName;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */