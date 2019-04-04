public class StartAndRun {
    static class ThreadRun extends Thread{
        @Override
        public void run() {
            int i = 0;
            while(i<90){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName() + i++);
            }
        }
    }


    public static void main(String[] args) {
        ThreadRun threadRun = new ThreadRun();
        threadRun.setName("threadRun");
        //threadRun.run();
        threadRun.start();
    }
}
