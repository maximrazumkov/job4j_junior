package ru.job4j;

public class MemoryUsage {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; ++i) {
            new User(String.format("User - %s", i));
        }
    }

    private static class User {
        private final String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println(name);
        }
    }
}
