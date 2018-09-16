package lab4;

public class Task1 {

    interface Worker {
        void work();
    }

    class Engineer implements Worker {
        @Override
        public void work() {
            System.out.println("Working!");
        }
    }

    class Manager extends Engineer {
        @Override
        public void work() {
            super.work();
        }
    }

}
