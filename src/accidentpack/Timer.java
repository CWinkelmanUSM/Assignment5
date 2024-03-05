package accidentpack;

/**
 * Class implements a timer for measuring task duration
 *
 * Setters are not implemented as time is only set by startTimer and endTimer
 * @author Charles Winkelman
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
     * @pre: started and stopped timer
     *
     * @return timer end - timer start / 1e-9
     */
	public double getSeconds() {
      return (timerEndTime - timerStartTime) / 1000000000.0;
    }
	
	/**
	 * Returns timer duration in milliseconds
	 * @pre: started and stopped timer
	 * 
	 * @return timer end - timer start / 1e-6
	 */
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
