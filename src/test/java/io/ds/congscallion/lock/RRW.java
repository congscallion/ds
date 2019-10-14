package io.ds.congscallion.lock;

import io.ds.congscallion.lock.RRW.Sync.HoldCounter;
import io.ds.congscallion.lock.RRW.Sync.ThreadLocalHoldCounter;

public class RRW {


  abstract static class Sync {

    private transient ThreadLocalHoldCounter readHolds;

    public ThreadLocalHoldCounter getReadHolds() {
      return readHolds;
    }

    public void setReadHolds(ThreadLocalHoldCounter readHolds) {
      this.readHolds = readHolds;
    }

    static final class HoldCounter {

      int count = 0;
      final long tid = 1L;
    }

    static final class ThreadLocalHoldCounter extends ThreadLocal<HoldCounter> {

      @Override
      protected HoldCounter initialValue() {
        return new HoldCounter();
      }
    }

    Sync() {
      readHolds = new ThreadLocalHoldCounter();
    }
  }


  static final class NonFairSync extends Sync {

  }

  static final class FiarSync extends Sync {

  }


  public static void main(String[] args) {

    NonFairSync sync = new NonFairSync();

    ThreadLocalHoldCounter readHolds = sync.getReadHolds();
    HoldCounter holdCounter = readHolds.get();
    System.out.println(holdCounter.count);
    System.out.println(holdCounter.tid);

    FiarSync fiarSync = new FiarSync();

    readHolds = fiarSync.getReadHolds();
    holdCounter = readHolds.get();
    System.out.println(holdCounter.count);
    System.out.println(holdCounter.tid);

  }

}
