package br.ufes.inf.lprm.ReactiveCodeGenerate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.ow2.orchestra.jaxb.bpmn.*;
import org.ow2.orchestra.jaxb.bpmn.bpmndi.BPMNDiagram;
import org.ow2.orchestra.jaxb.bpmn.bpmndi.BPMNEdge;
import org.ow2.orchestra.jaxb.bpmn.bpmndi.BPMNPlane;
import org.ow2.orchestra.jaxb.bpmn.bpmndi.BPMNShape;
import org.ow2.orchestra.jaxb.bpmn.di.DiagramElement;
import org.xml.sax.SAXException;

import com.sun.xml.bind.v2.model.impl.ModelBuilder;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;


public class App {
	
	private static final String MODEL = "C:/Users/BrunoAgrizzi/Desktop/AbsentSensor.bpmn2";
	
    public static void main( String[] args ) throws JAXBException, IOException, SAXException {
    	
    	// GET BPMN MODEL FROM FILE
    	File model = new File(MODEL);
    	Definitions def = JaxbUtil.unmarshalBpmn(model);
    	
    	
    	// BPMN PROCESS
    	for (int i = 0; i < def.getRootElements().size(); i++) {
    		 
    		System.out.println(def.getRootElements().get(i).getDeclaredType());
    		
    		
    		
    		//BPMNPlane plane = diagram.getBPMNPlane();
    		
    		/*for (int j = 0; j < plane.getDiagramElements().size(); j++) {
    			
    			JAXBElement element = plane.getDiagramElements().get(j);
    			
    			if (element.getDeclaredType().isAssignableFrom(BPMNShape.class)) {
    				BPMNShape shape = (BPMNShape) element.getValue();
    				System.out.println("Um elemento Shape do id: " + shape.getBpmnElement());
    			}
    			
    			if (element.getDeclaredType().isAssignableFrom(BPMNEdge.class)) {
    				BPMNEdge edge = (BPMNEdge) element.getValue();
    				System.out.println("Um elemento Edge do id: " + edge.getBpmnElement());
    			}
    			
    		}*/
		}
    	
 
    	
    	
    	// BPMN DIAGRAM
    	for (int i = 0; i < def.getBPMNDiagrams().size(); i++) {
    		BPMNDiagram diagram = (BPMNDiagram) def.getBPMNDiagrams().get(i);
    		
    		BPMNPlane plane = diagram.getBPMNPlane();
    		
    		for (int j = 0; j < plane.getDiagramElements().size(); j++) {
    			
    			JAXBElement element = plane.getDiagramElements().get(j);
    			
    			if (element.getDeclaredType().isAssignableFrom(BPMNShape.class)) {
    				BPMNShape shape = (BPMNShape) element.getValue();
    				System.out.println("Um elemento Shape do id: " + shape.getBpmnElement());
    			}
    			
    			if (element.getDeclaredType().isAssignableFrom(BPMNEdge.class)) {
    				BPMNEdge edge = (BPMNEdge) element.getValue();
    				System.out.println("Um elemento Edge do id: " + edge.getBpmnElement());
    			}
    			
    		}
		}
    	
        
    }
}
