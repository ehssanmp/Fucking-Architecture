package simulator.wrapper.wrappers;

import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class MultiP extends Wrapper {

	public MultiP(String label, String stream, Link... links) {
		super(label, stream, links);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		int j=0;
		int k=32;
		Mux[] mx= new Mux[32];
		for (int i=0; i<32;++i) {
			mx[i]= new Mux("h"+i,"37X1",getInput(0),getInput(1),getInput(2),getInput(3),getInput(4));
			while(j<k) {
				mx[i].addInput(getInput(j+5));
				++j;
			}
			j=j+32;
			k=k+32;
			
		}
		for(int i=0;i<32;++i) {
			addOutput(mx[i].getOutput(0));
		}
		
		
	}

}
