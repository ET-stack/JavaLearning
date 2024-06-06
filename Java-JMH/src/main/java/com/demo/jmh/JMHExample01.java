package com.demo.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class JMHExample01 {

    private final static String DATA = "dummy data";
    private List<String> arrayList;
    private List<String> linkedList;

    @Setup(Level.Iteration)
    public void setUp() {
        this.arrayList = new ArrayList<String>();
        this.linkedList = new LinkedList<String>();
    }

    @Benchmark
    public List<String> arrayListAdd() {
        this.arrayList.add(DATA);
        return arrayList;
    }

    @Benchmark
    public List<String> linkedListAdd() {
        this.linkedList.add(DATA);
        return linkedList;
    }

    public static void main(String[] args) throws RunnerException {
        final Options opts = new OptionsBuilder().
                include(JMHExample01.class.getSimpleName()).forks(1)
                .measurementBatchSize(10) //度量执行的批次为10
                .warmupBatchSize(10)//10个批次的预热
                .build();
        new Runner(opts).run();
    }
}
