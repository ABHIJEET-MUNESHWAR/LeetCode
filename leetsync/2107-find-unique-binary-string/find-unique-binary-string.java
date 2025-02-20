class Solution {
    public String findDifferentBinaryString(String[] nums) {
        List<String> allSubSequences = new ArrayList<>();
        String current = new String();
        generateAllSubSequences(nums[0].length(), allSubSequences, current, 0);
        Set<String> set = new HashSet<>();
        for (String num : nums) {
            set.add(num);
        }
        for (String subSequence : allSubSequences) {
            if (!set.contains(subSequence)) {
                return subSequence;
            }
        }
        return "";
    }

    public void generateAllSubSequences(int length, List<String> allSubSequences, String current, int index) {
        if (index >= length) {
            allSubSequences.add(current);
            return;
        }

        // Backtrack with 0
        // Do
        current = current + "0";
        // Explore
        generateAllSubSequences(length, allSubSequences, current, index + 1);
        // Undo
        current = current.substring(0, current.length() - 1);

        // Backtrack with 1
        // Do
        current = current + "1";
        // Explore
        generateAllSubSequences(length, allSubSequences, current, index + 1);
        // Undo
        current = current.substring(0, current.length() - 1);
    }
}