

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int globalMin = arrays.get(0).get(0); // Initialize with the first element of the first array
        int globalMax = arrays.get(0).get(arrays.get(0).size() - 1); // Initialize with the last element of the first array
        int maxDistance = 0;

        // Start iterating from the second array
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);
            int currentMin = currentArray.get(0);
            int currentMax = currentArray.get(currentArray.size() - 1);

            // Calculate possible max distances using current array's min and max with global max and min
            maxDistance = Math.max(maxDistance, Math.abs(currentMax - globalMin));
            maxDistance = Math.max(maxDistance, Math.abs(globalMax - currentMin));

            // Update the global min and max
            globalMin = Math.min(globalMin, currentMin);
            globalMax = Math.max(globalMax, currentMax);
        }

        return maxDistance;
    }
}
