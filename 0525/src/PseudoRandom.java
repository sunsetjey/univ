import java.util.Random;

class PseudoRandom {
    public static void main(String[] args) {
        Random rand = new Random();
        
        for(int i = 0; i < 7; i++)
            System.out.println(rand.nextInt(1000));
    	System.out.println(rand.nextBoolean());
    	System.out.println(rand.nextLong());
    	System.out.println(rand.nextFloat());
    	System.out.println(rand.nextDouble());
    	
    	System.currentTimeMillis();
    }
}