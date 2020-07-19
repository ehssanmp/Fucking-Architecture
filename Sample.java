//Dedicated to Goli

package simulator;

import simulator.control.Simulator;
import simulator.gates.combinational.And;
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
    	Register [] Reg= new Register[32];
    	Link[] WriteData= new Link[32];
    	Clock clk = new Clock("CLOCK",1000);
    	Link RegWrite= Simulator.falseLogic;
    	Link[] WriteRegisterNumber= new Link[5];
    	Link[] ReadRegisterNumberA= new Link[5];
    	Link[] ReadRegisterNumberB= new Link[5]; 
    	And[] ands= new And[32];
    	MultiPlexer DEC= new MultiPlexer("DEC","5X32",WriteRegisterNumber[0],WriteRegisterNumber[1],WriteRegisterNumber[2],WriteRegisterNumber[3],WriteRegisterNumber[4]);
    	for(int i=0;i<32;++i) {
    		ands[i]= new And("a"+i,DEC.getOutput(i),RegWrite);
    	}
    	for(int i=0; i<32;++i) {
    		Reg[i]= new Register("h"+i, "33X32",ands[i].getOutput(i));
    		for(int j=0; j<32;++j) {
    			Reg[i].addInput(WriteData[j]);
    		}
    	}
    	MultiP MUX1 = new MultiP("MUX1","1029X32",ReadRegisterNumberA[0],ReadRegisterNumberA[1],ReadRegisterNumberA[2],ReadRegisterNumberA[3],ReadRegisterNumberA[4]);
    	
    	MultiP MUX2 = new MultiP("MUX2","1029X32",ReadRegisterNumberB[0],ReadRegisterNumberB[1],ReadRegisterNumberB[2],ReadRegisterNumberB[3],ReadRegisterNumberB[4]);
    	for(int i=0; i<32;++i) {
    		for(int j=0; j<32;++j) {
    			MUX1.addInput(Reg[i].getOutput(j));
    		}
    	}
    	for(int i=0; i<32; ++i) {
    		for(int j=0; j<32; ++j) {
    			MUX2.addInput(Reg[i].getOutput(j));
    		}
    	}
    	

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