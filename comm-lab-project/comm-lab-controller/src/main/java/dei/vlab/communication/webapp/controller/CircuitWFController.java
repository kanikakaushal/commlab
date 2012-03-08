package dei.vlab.communication.webapp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import dei.vlab.communication.model.Circuit;
import dei.vlab.communication.service.CircuitManager;
import dei.vlab.communication.webapp.data.CircuitData;

@Controller
public class CircuitWFController  implements ServletContextAware{
	
	private CircuitManager circuitManager;
	private ServletContext servletContext;
	
	public ServletContext getServletContext() {
		return servletContext;
	}

	@Autowired
	public void setCircuitManager(CircuitManager circuitManager) {
		this.circuitManager = circuitManager;
	}

	@RequestMapping(value="/circuit*" , method=RequestMethod.GET)
	public @ResponseBody
	List<CircuitData> listCircuits(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println(">>>>>>>>>>>>>>"+circuitManager);
		 List<Circuit> circuits =circuitManager.getALL();
		List<CircuitData> circuitDatas = new ArrayList<CircuitData>();
		if(circuits!=null && !circuits.isEmpty()){
			for(Circuit circuit:circuits){
				circuitDatas.add(CircuitData.populate(circuit));
			}
		}
		return circuitDatas;
	}
	
	@RequestMapping(value="/circuit*", method=RequestMethod.PUT)
	public @ResponseBody
	String saveUpdateCircuit(@ModelAttribute CircuitData circuitData) throws Exception {
		int id = circuitData.getId()!=null ?circuitData.getId():0;
		Circuit circuit =circuitManager.getCircutById(new Long(id));
		if(circuit==null){
		 circuit= new Circuit();
		}
		System.out.println(">>>>>>>>>>>>>>"+circuit);
		circuit.setName(circuitData.getName());
		circuit.setType(circuitData.getType());
		circuit.setConfigProperties("");
		circuit.setNoceCordinate("");
		circuit.setDescription(circuitData.getDescription());
		circuit.setImageFile("");
		circuitManager.saveUpdate(circuit);
		
		System.out.println(">>>>>saveUpdateCircuit" +circuitData);
		return "success";
	}

	
	@RequestMapping("/imageUploadRest")
	@Transactional
	public void processImageUploadRest(@RequestParam("image") MultipartFile image,@RequestParam("circuitName") String circuitName,
				HttpServletRequest request,HttpServletResponse response) throws IOException, Exception {
		     String uploadDir = getServletContext().getRealPath("/resources")+"/";
		     System.out.println(">>>>>>>>>>>>>>"+image+">>>>>>>"+circuitName);
		// the directory to upload to
   
        // Create the directory if it doesn't exist
        File dirPath = new File(uploadDir);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
        //retrieve the file data
        InputStream stream = image.getInputStream();

        //write the file to the file specified
        OutputStream bos = new FileOutputStream(uploadDir + image.getOriginalFilename());
        int bytesRead;
        byte[] buffer = new byte[8192];

        while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }

        bos.close();

        //close the stream
        stream.close();
		Circuit circuit=circuitManager.getCircuitByName(circuitName);
		if(circuit!=null){
		circuit.setImageFile(image.getOriginalFilename());
		circuitManager.saveUpdate(circuit);
		}
		System.out.println("image content type"+image+"  "+request.getParameterMap());
		System.out.println("Uploaded Location "+uploadDir + image.getOriginalFilename());
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		
	}


}
