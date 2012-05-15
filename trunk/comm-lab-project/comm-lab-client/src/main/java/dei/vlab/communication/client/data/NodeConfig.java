package dei.vlab.communication.client.data;

public class NodeConfig {

	private String name;
	private String ID;
	private Integer xCo;
	private Integer yCo;
	public NodeConfig() {
	}

	public NodeConfig(String id,String name, Integer xCo, Integer yCo) {
		super();
		this.ID =id;
		this.name = name;
		this.xCo = xCo;
		this.yCo = yCo;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getxCo() {
		return xCo;
	}

	public void setxCo(Integer xCo) {
		this.xCo = xCo;
	}

	public Integer getyCo() {
		return yCo;
	}

	public void setyCo(Integer yCo) {
		this.yCo = yCo;
	}

}
