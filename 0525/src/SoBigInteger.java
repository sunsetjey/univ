import java.math.BigInteger;
import java.math.BigDecimal;

class SoBigInteger { // 꼭!! 오차가 존재해선 안되는 상황에서 사용
    public static void main(String[] args) {
        System.out.println("최대 정수: " + Long.MAX_VALUE);
        System.out.println("최소 정수: " + Long.MIN_VALUE);
        System.out.println();
        
        BigInteger big1 = new BigInteger("100000000000000000000");
        BigInteger big2 = new BigInteger("-99999999999999999999");
		
        BigInteger r1 = big1.add(big2);
        System.out.println("덧셈 결과: " + r1);

        BigInteger r2 = big1.multiply(big2);
        System.out.println("곱셈 결과: " + r2);
        System.out.println();

        int num = r1.intValueExact();
        System.out.println("From BigInteger: " + num);
        
        BigDecimal d1 = new BigDecimal("1.6"); //따음표가 없다면 오차
        BigDecimal d2 = new BigDecimal("-0.1");
        System.out.println(d1.add(d2));
        System.out.println(d1.multiply(d2));
        
    }
}