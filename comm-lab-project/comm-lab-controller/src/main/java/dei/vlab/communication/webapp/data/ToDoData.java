package dei.vlab.communication.webapp.data;

import java.io.Serializable;

public class ToDoData implements Serializable {
	private static final long serialVersionUID = -7709859601663162213L;

	public ToDoData() {
	}

	public ToDoData(Integer id, String task) {
		super();
		this.id = id;
		this.task = task;
	}

	private Integer id;
	private String task;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

}
