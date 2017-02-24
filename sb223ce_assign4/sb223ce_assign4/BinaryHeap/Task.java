package sb223ce_assign4.BinaryHeap;

public interface Task {

	void createTask(int priority, String description); // make new task

	void setTaskDescription(String describe); // set task description

	int getTaskPriority(); // get task priority

	String getTaskDescription(); // get task description

	void setTaskPriority(int num); // set task description

	String toString(); // to string
	
	boolean equals(Object t);
}
