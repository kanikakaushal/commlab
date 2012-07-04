package dei.vlab.communication.webapp.controller;

import java.sql.Timestamp;

import dei.vlab.communication.model.Calendarr;

public class CalendareData {

		private Long id;
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Timestamp getStart() {
			return start;
		}
		public void setStart(Timestamp start) {
			this.start = start;
		}
		public Timestamp getEnd() {
			return end;
		}
		public void setEnd(Timestamp end) {
			this.end = end;
		}
		private String name;
	    private String description;
	    private Timestamp start;
	    private Timestamp end;
	    
		public static CalendareData populate(Calendarr calendarr1) {
			// TODO Auto-generated method stub
			return null;
		}

}
