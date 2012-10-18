package oc.wh40k.units.tl;

import oc.BuildaHQ;
import oc.wh40k.units.sm.SMSpartanAssaultTank;

public class TLSpartanAssaultTank extends SMSpartanAssaultTank {
	
	public TLSpartanAssaultTank() {
		
		BuildaHQ.addToInformationVector("TLSupport", 1);
		
	}
	
	public void refreshen() {
		int selectedSquads = BuildaHQ.getCountFromInformationVector("TLSupport");
		int possibleSquads = BuildaHQ.getCountFromInformationVector("TLEnableHeavySupport");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("SM-Unterstützung > " + possibleSquads + "!");
		} else {
			setFehlermeldung("");
		}
	}
	
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("TLSupport", -1);
		super.deleteYourself();
	}
	
}