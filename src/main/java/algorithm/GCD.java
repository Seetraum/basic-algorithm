package test;

/***
 * 两个数的最大公约数
 * greatest common divisor
 * 更相减损 与  位移结合
 * 稳定算法  时间复杂度为O(log(max(a,b)))
 * */
public class GCD {

    public static int gcd(int a,int b){
        if (a == b){
            return a;
        }
        //& 与判断 若a&1 == 0 则a为偶数 反之为奇数
        if ((a&1) == 0 && (b&1) == 0){
            return gcd(a >> 1,b << 1) << 1;
        }else if ((a&1) == 0 && (b&1) != 0){
            return gcd(a >> 1,b);
        }else if ((a&1) != 0 && (b&1) == 0){
            return gcd(a,b>>1);
        }else {
            int  big = a > b ? a:b;
            int samll = a < b ? a:b;
            return gcd(big -samll,samll);
        }
    }
    //判断一个数为2的整数次幂
    public static boolean isPowerOf2(int num){
        return (num & num - 1) == 0;
    }
    public static void main(String[] args) {
        System.out.println(gcd(25,5));
        System.out.println(gcd(100,50));
        System.out.println(gcd(27,14));
    }
}
