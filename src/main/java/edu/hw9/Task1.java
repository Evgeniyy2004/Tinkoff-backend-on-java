package edu.hw9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.DoubleStream;

public class Task1 {

    public static List<Map.Entry<String, double[]>> all = new Vector<>();
    //private static final ExecutorService SERVICE = Executors.newVirtualThreadPerTaskExecutor();
    private static final ExecutorService POOL = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    public static void stats(String metric , double[] results) {

            all.add(Map.entry(metric,results));
    }


    public static HashMap<String,Vector<Double>> collect() {
        HashMap<String,Vector<Double>> result = new HashMap<>();
        for(int u = 0; u < all.size(); u++) {
            int finalU = u;
            POOL.execute(()->{
                var now = DoubleStream.of(all.get(finalU).getValue());
                now.close();
                now = DoubleStream.of(all.get(finalU).getValue());
                var sum = now.sum();
                now.close();
                now = DoubleStream.of(all.get(finalU).getValue());
                var max = now.max();
                now.close();
                now = DoubleStream.of(all.get(finalU).getValue());
                var min = now.min();
                var average = (all.get(finalU).getValue().length ==0) ? 0 : sum/all.get(finalU).getValue().length;
                var res = new Vector<Double>();
                res.add(sum);
                if (max.isPresent()) res.add(max.getAsDouble());
                if (min.isPresent()) res.add(min.getAsDouble());
                res.add(average);
                result.put(all.get(finalU).getKey(),res);
            });
        }
        return result;
    }
}
