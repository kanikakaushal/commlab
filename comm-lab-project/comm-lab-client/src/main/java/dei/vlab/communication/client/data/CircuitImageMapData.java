package dei.vlab.communication.client.data;

import java.util.ArrayList;
import java.util.List;

public class CircuitImageMapData {
	public CircuitImageMapData() {
		this.nodes = new ArrayList<NodeConfig>();
	}

	public CircuitImageMapData(String imageName, List<NodeConfig> nodes) {
		super();
		this.imageName = imageName;
		this.nodes = nodes;
	}

	private String imageName;
	private List<NodeConfig> nodes;

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public List<NodeConfig> getNodes() {
		return nodes;
	}

	public void addNode(NodeConfig nodeConfig) {
		this.nodes.add(nodeConfig);
	}

	public void removeNode(NodeConfig nodeConfig) {
		this.nodes.remove(nodeConfig);
	}

	public void removeNode(int index) {
		this.nodes.remove(index);
	}

}
