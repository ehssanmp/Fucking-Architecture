package simulator.wrapper.wrappers;

import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Mux32To1 extends Wrapper {

	public Mux32To1(String label, String stream, Link... links) {
		super(label, stream, links);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		int j=1;
		int k=65;
		int b=1;
		Mux2To1 [] mux = new Mux2To1[32];
		for(int i=0 ;i<32;++i) {
			mux[i]= new Mux2To1("m"+i, "3X1",getInput(0));
			while(j<k) {
				mux[i].addInput(getInput(b));
				b=b+32;
			}
			j=j+1;
			b=j;
			k=k+1;
		}
		for(int i=0;i<32;++i) {
			addOutput(mux[i].getOutput(0));
		}
		
	}

}
