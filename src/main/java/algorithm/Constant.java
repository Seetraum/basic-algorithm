package test;

import java.util.function.BiPredicate;

public enum Constant {
        GT((a,b) -> Integer.parseInt(a) > Integer.parseInt(b)),
        LT((a,b)-> Integer.parseInt(b) > Integer.parseInt(a)),
        KEY(String::contains);

    private BiPredicate<String,String> biPredicate;
    Constant(BiPredicate<String,String> biPredicate){
        this.biPredicate = biPredicate;
    }
    public boolean test(String expect,String actual){
        return this.biPredicate.test(expect,actual);
    }
}
