package simulator.wrapper.wrappers;

import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class AluControl extends Wrapper {

	public AluControl(String label, String stream, Link... links) {
		super(label, stream, links);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		And and1= new And("A1");
		And and2= new And("A2");
		Or or1= new Or("O1");
		Or or2= new Or("O2");
		Or or3 = new Or("O3");
		Not not1= new Not("N1");
		Not not2= new Not("N2");
		and1.addInput(getInput(1),getInput(3));
		or1.addInput(and1.getOutput(0),getInput(0));
		not1.addInput(getInput(1));
		not2.addInput(getInput(4));
		or2.addInput(not1.getOutput(0),not2.getOutput(0));
		or3.addInput(getInput(2),getInput(5));
		and2.addInput(getInput(1),or3.getOutput(0));
		addOutput(and2.getOutput(0));
		addOutput(or2.getOutput(0));
		addOutput(or1.getOutput(0));
	}
	
}
