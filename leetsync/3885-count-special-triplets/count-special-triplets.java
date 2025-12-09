class Solution {
    final static int mod=(int)1e9+7, M=(int)1e5+1;
    public int specialTriplets(int[] nums) {
        final int  n=nums.length;
        int [] freq=new int[M];
        int [] prev=new int[M];
        for(int x: nums) freq[x]++;
        long cnt=0;
        prev[nums[0]]++;
        for(int i=1; i<n-1; i++){
            final int x=nums[i], x2=x<<1;
            if (x2<M)
                cnt+=(long)prev[x2]*(freq[x2]-prev[x2]-(x==0?1:0));
            prev[x]++;
        }
        return (int)(cnt%mod);
    }
}