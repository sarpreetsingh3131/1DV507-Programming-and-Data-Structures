package sb223ce_assign4.BinaryHeap;

public class WorkTask implements Task {

	// Fields
	private int priority = 0;
	private String description = "";

	// Empty constructor
	public WorkTask() {

	}

	// Constructor
	public WorkTask(int priority, String description) {
		check(priority);
		this.priority = priority;
		this.description = description;
	}

	public void createTask(int priority, String description) {
		check(priority);
		this.priority = priority;
		this.description = description;
	}

	/* Getters and Setters */

	public void setTaskDescription(String describe) {
		description = describe;
	}

	public int getTaskPriority() {
		return priority;
	}

	public String getTaskDescription() {
		return description;
	}

	public void setTaskPriority(int num) {
		check(num);
		priority = num;
	}

	@Override
	public String toString() {
		return "PRIORITY = " + priority + ",  TASK = " + description;
	}

	/* Task priority cannot be negative or zero */
	private void check(int a) {
		if (a > 0)
			return;
		else
			throw new IllegalArgumentException("You must provide positive task priority.");
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof WorkTask) {
			Task t = (WorkTask) o;
			return this.priority == t.getTaskPriority() && this.description.equals(t.getTaskDescription());
		}
		return false;
	}
}
