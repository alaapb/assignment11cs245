import java.util.Arrays;
import java.lang.IndexOutOfBoundsException;

public class Judge {
    public Judge() {
        System.out.println("yay");
    }

    public int findJudge(int N, int trust[][]) throws IndexOutOfBoundsException{
        if(!(N < 1 && N > 1000) && trust.length > 9999) {
            throw new IndexOutOfBoundsException("Does not meet the requirements");
        }
        int[] trustCount = new int[N];
        int judgeID = -1;
        for (int i = 0; i < trustCount.length; i++) {
            trustCount[i] = 0;
        }
        if(trust == null) {
            return -1;
        }else{
            for(int[] pairs:trust) {
                int a = pairs[0];
                int b = pairs[1];
                trustCount[a-1] = -1;
                if (trustCount[b - 1] != -1) {
                    trustCount[b-1] = trustCount[b-1] + 1;
                }
            }

        }
        System.out.println(Arrays.toString(trustCount));
        int max = -1;
        for(int i = 0; i < trustCount.length; i++) {
            if(max < trustCount[i]) {
                judgeID = i+1;
            }
        }
        if(trust.length == 1) {
            return trust[0][1];
        }
        if(judgeID != -1) {
            if(trustCount[judgeID-1] == 1) {
                return -1;
            }
        }
        return judgeID;
    }
}