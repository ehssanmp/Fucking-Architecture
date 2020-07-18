//Dedicated to Goli

package simulator;

import simulator.control.Simulator;
import simulator.gates.combinational.Memory;
import simulator.gates.combinational.Not;

import simulator.gates.sequential.Clock;
import simulator.gates.sequential.flipflops.DFlipFlop;
import simulator.network.Link;
import simulator.wrapper.wrappers.MultiP;
import simulator.wrapper.wrappers.MultiPlexer;
import simulator.wrapper.wrappers.Mux;
import simulator.wrapper.wrappers.Register;

public class Sample {
    public static void main(String[] args) {
    	
    	//sample circuit
    	Link [] links= new Link[1024];
    	for(int i=0; i<32;++i) {
    		links[i]=Simulator.trueLogic;
    	}
    	links[0]=Simulator.falseLogic;
    	for(int i=32;i<1024;++i) {
    		links[i]=Simulator.falseLogic;
    	}
    	/*Mux mx= new Mux("hello", "37X1",Simulator.trueLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic);
    	for(int i=0;i<32;++i) {
    		mx.addInput(links[i]);
    	}*/
    	MultiP mp= new MultiP("hello","1029X32",Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic,Simulator.falseLogic);
    	for(int i=0;i<1024;++i) {
    		mp.addInput(links[i]);
    	}
    	
    	Clock clk = new Clock("CLOCK",1000);

        Simulator.debugger.addTrackItem(clk,mp);
        Simulator.debugger.setDelay(500);
        Simulator.circuit.startCircuit();
    	
        /*FullAdder fullAdder1 = new FullAdder("FULLADDER1", "3X2", Simulator.falseLogic,
                Simulator.trueLogic);
        FullAdder fullAdder2 = new FullAdder("FULLADDER2", "3X2", Simulator.falseLogic,
                Simulator.falseLogic, fullAdder1.getOutput(1));

        fullAdder1.addInput(fullAdder2.getOutput(1));*/
     

       /* Simulator.debugger.addTrackItem(rg);
        Simulator.debugger.setDelay(500);
        Simulator.circuit.startCircuit();*/
    }
}