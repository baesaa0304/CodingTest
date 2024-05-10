import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
	long answer = 0;
    long min_time = times[0];
    long max_time =  (long)times[times.length-1]*(long)n;
        while(min_time <= max_time) {
			long mid = (min_time + max_time) / 2;
            long people = 0; // 입국 심사 끝난 사람	
			for(int time : times) {
				people += mid / time;
			}
			if (people >= n) {
				answer = mid;
				max_time = mid - 1;
			}
			else {
				min_time = mid + 1;
			}
		}
        return answer;
    }
}