package simulator.wrapper.wrappers;

import simulator.network.Link;
import simulator.wrapper.Wrapper;
import simulator.gates.sequential.*;
import simulator.gates.sequential.flipflops.DFlipFlop;
public class Register extends Wrapper {

	public Register(String label, String stream,Link [] link, Link... links) {
		super(label, stream, link,links);
		// TODO Auto-generated constructor stub
		DFlipFlop [] df= new DFlipFlop[32];
		for(int i=0;i<32;++i) {
			df[i]= new DFlipFlop("d1",getOutput(0),link[i]);
		}
		for(int i=0;i<32;++i) {
			addOutput(df[i].getOutput(0));
		}
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
		
	}

}
