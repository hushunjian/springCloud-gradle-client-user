package com.hushunjian.springcloud.client.user.enumeration;

public enum Operation {

    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public abstract double apply(double x, double y);

    public static void main(String[] args) {
        double x = 2;
        double y = 2;

        for (Operation operation : Operation.values()) {
            System.out.printf("%f %s %f = %f%n", x, operation, y, operation.apply(x, y));
        }
    }
}
