class Solution {
    public int numberOfSets(int n, int k) {
        long MOD = 1_000_000_007;
        long num = 1;
        long den = 1;
        int N = n + k - 1;
        int K = 2 * k;

        if (K > N) return 0;

        for (int i = 1; i <= K; i++) {
            num = (num * (N - i + 1)) % MOD;
            den = (den * i) % MOD;
        }

        return (int) (num * power(den, MOD - 2, MOD) % MOD);
    }

    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}