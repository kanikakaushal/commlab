package dei.vlab.communication.service;

import java.util.List;

import dei.vlab.communication.model.Circuit;

public interface CircuitManager extends GenericManager<Circuit, Long> {

 public Circuit getCircuitByName(String name);
 
 public void saveUpdate(Circuit circuit);
 public List<Circuit> getALL();
 public Circuit getCircutById(Long id);
}
