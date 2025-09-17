class FoodRatings {
    private Map<String, String> foodToCuisineMap = new HashMap<>();
    private Map<String, Integer> foodToRatingMap = new HashMap<>();
    private Map<String, TreeSet<Pair<Integer, String>>> cuisineToRatingFoodMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        for (int i = 0; i < n; i++) {
            foodToCuisineMap.put(foods[i], cuisines[i]);
            foodToRatingMap.put(foods[i], ratings[i]);
            cuisineToRatingFoodMap
                    .computeIfAbsent(
                            cuisines[i], k -> new TreeSet<>((a, b) -> {
                                int compareByRating = Integer.compare(a.getKey(), b.getKey());
                                if (compareByRating == 0) {
                                    return a.getValue().compareTo(b.getValue());
                                }
                                return compareByRating;
                            }))
                    .add(new Pair(-ratings[i], foods[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisineName = foodToCuisineMap.get(food);
        TreeSet<Pair<Integer, String>> cuisinSet = cuisineToRatingFoodMap.get(cuisineName);
        Pair<Integer, String> oldElement = new Pair<>(-foodToRatingMap.get(food), food);
        cuisinSet.remove(oldElement);
        foodToRatingMap.put(food, newRating);
        cuisinSet.add(new Pair<>(-newRating, food));
    }

    public String highestRated(String cuisine) {
        Pair<Integer, String> hishestRated = cuisineToRatingFoodMap.get(cuisine).first();
        return hishestRated.getValue();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */