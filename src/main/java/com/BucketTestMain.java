package com;

import com.zerotoproduction.Bucket;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class BucketTestMain {

    public static void printBuckets1(List<Bucket> buckets)
    {

        for (Bucket b: buckets)

            if (b.getPriority() > 7)

                System.out.println(b);

    }

    public static void printBuckets2(List<Bucket> buckets)
    {
        Stream<Bucket> bucketStream = buckets.stream();
//        buckets.stream()
//                .filter(new Predicate<Bucket>() {
//                        public boolean test(Bucket bucket){
//                            return bucket.getPriority() > 7;
//                        }
//                })
//                .forEach(bucket -> System.out.println(bucket));
        bucketStream
                .filter( BucketTestMain::isaAboveNumber)
                .forEach( System.out::println);
//        buckets.stream()
//                .filter(bucket -> bucket.getPriority() > 7)
//                .forEach(new Consumer<Bucket>(){
//                    @Override
//                    public void accept(Bucket b){
//                        System.out.println(b);
//                    }
//                });

    }

    private static boolean isaAboveNumber(Bucket bucket) {
        return bucket.getPriority() > 7;
    }

    public static void main(String[] args){
        List<Bucket> myBuckets = new ArrayList<>();
        myBuckets.add(new Bucket("Visit  Coliseum, Rome, Italy", "The Coliseum, also known as the Flavian Amphitheatre, is an oval amphitheatre in the centre of the city of Rome, Italy. Built of travertine, tuff, and brick-faced concrete, it is the largest amphitheatre ever built", 1));
        myBuckets.add(new Bucket("Visit  Christ the Redeemer Statue, Rio de Janeiro, Brazil", "Christ the Redeemer is an Art Deco statue of Jesus Christ in Rio de Janeiro, Brazil, created by French sculptor Paul Landowski", 3));
        myBuckets.add(new Bucket("Visit  Taj Mahal, India", "The Taj Mahal is an ivory-white marble mausoleum on the south bank of the Yamuna river in the Indian city of Agra. It was commissioned in 1632", 6));
        myBuckets.add(new Bucket("Visit  Great Wall of China, China", "Built between the 5th century B.C. and the 16th century, the Great Wall of China is a stone-and-earth fortification created to protect the borders of the Chinese Empire from invading Mongols. The Great Wall is actually a succession of multiple walls spanning approximately 4,000 miles, making it the world's longest manmade structure", 8));


        BucketTestMain.printBuckets2(myBuckets);
        System.out.printf("%n%n");
        System.out.printf("---Imperative---%n%n");
        BucketTestMain.printBuckets1(myBuckets);
    }

}
