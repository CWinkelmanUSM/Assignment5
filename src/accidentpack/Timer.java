package accidentpack;

/**
 * Class implements a timer for measuring task duration
 *
 * Setters are not implemented as time is only set by startTimer and endTimer
 * Changed to no longer print timer, returns timer duration in seconds instead
 */
public class Timer{

	private long timerStartTime;
	private long timerEndTime;

    /**
     * General Timer constructor
     */
    public Timer(){};

    /**
     * Sets timer start to now
     */
	public void start() {
		timerStartTime = System.nanoTime();
	}

    /**
     * Sets timer end to now
     */
	public void stop() {
      timerEndTime = System.nanoTime();
  }

    /**
     * Returns timer duration in seconds
     * Pre: started and stopped timer
     *
     * @return timer end - timer start / 1000
     */
	public double getSeconds() {
      return (timerEndTime - timerStartTime) / 1000000000.0;
    }
	
	public double getMilliseconds() {
		return (timerEndTime - timerStartTime) / 1000000.0;
	}

    /**
     * Get start time
     * @return start time
     */
	public long getStartTime() { return timerStartTime; }

    /**
     * Get end time
     * @return end time
     */
	public long getEndTime() { return timerEndTime; }

}
