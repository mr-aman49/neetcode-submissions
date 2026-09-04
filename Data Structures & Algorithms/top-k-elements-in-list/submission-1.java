class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> x = new HashMap<>();
        for(int num : nums){
            x.put(num, x.getOrDefault(num,0)+1);
        }
        List<Integer>[] buckets = new List[nums.length+1];
        for(Map.Entry<Integer,Integer> entry :x.entrySet()){
            int num = entry.getKey();
            int frequency = entry.getValue();
            if(buckets[frequency] == null){
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(num);
        }
        int[]  result = new int[k];
        int index =0;
        for(int frequency = buckets.length-1; frequency >=0; frequency--){
            if(buckets[frequency]!= null){
                for(int num : buckets[frequency]){
                    result[index++] = num;
                    if(index == k){
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
