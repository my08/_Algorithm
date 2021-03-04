package leetcode.dp;

import java.util.*;

public class _63_322_CoinChange {
    public static void main(String[] args) {
        _63_322_CoinChange a = new _63_322_CoinChange();
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(a.coinChange(coins, amount));

    }
    public int coinChange(int[] coins, int amount) {
        int max = amount+1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for(int i=1; i<=amount; i++){
            for(int j=0; j<coins.length; j++){
                if(i>=coins[j]){
                    //whether picking ith coins or not
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] +1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
