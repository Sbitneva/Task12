package sbitneva;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SyncArrayListTests {

    private SyncArrayList<Integer> syncArrayList = new SyncArrayList<>();
    Runnable runnable;
    private Thread thread1;
    private Thread thread2;

    @Before
    public void setUp(){
        syncArrayList.clear();
        syncArrayList.add(1);
        syncArrayList.add(2);
        syncArrayList.add(3);
        syncArrayList.add(4);
        syncArrayList.add(5);
        syncArrayList.add(6);
    }

    @Test
    public void addTest(){

        int sizeBefore = syncArrayList.size();
        int sizeAfter;

        thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncArrayList.add(this.hashCode());
            }
        });
        thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncArrayList.add(this.hashCode());
                syncArrayList.add(this.hashCode());
                syncArrayList.add(this.hashCode());
                syncArrayList.add(this.hashCode());
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        sizeAfter = syncArrayList.size();
        assertEquals(sizeBefore + 5, sizeAfter);
    }

    @Test
    public void isEmptyTest(){

        thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                assertFalse(syncArrayList.isEmpty());
            }
        });
        thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                assertFalse(syncArrayList.isEmpty());
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void containsTest() {

        thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                assertTrue(syncArrayList.contains(1));
                assertTrue(syncArrayList.contains(4));
            }
        });
        thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                assertTrue(syncArrayList.contains(2));
                assertTrue(syncArrayList.contains(3));
                assertTrue(syncArrayList.contains(4));
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void indexOf(){
        thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                assertEquals(syncArrayList.indexOf(1), 0);
                syncArrayList.remove(0);
            }
        });
        thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                assertEquals(syncArrayList.indexOf(2), 0);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void clear(){
        thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncArrayList.clear();
                assertEquals(syncArrayList.size(), 0);

            }
        });
        thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
               assertEquals(syncArrayList.size(), 0);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void forEach(){
        thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Integer index = 0;
                for(Integer number : syncArrayList){
                    ++index;
                    assertEquals( index,  number);

                }

            }
        });
        thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Integer index = 0;
                for(Integer number : syncArrayList){
                    ++index;
                    assertEquals( index,  number);
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getTest() {
        thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                assertEquals(syncArrayList.get(0), new Integer(1));
                syncArrayList.remove(0);


            }
        });
        thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                assertEquals(syncArrayList.get(0), new Integer(2));
                syncArrayList.remove(0);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        assertEquals(syncArrayList.size(), 4);
    }

}
