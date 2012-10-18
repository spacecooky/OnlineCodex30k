package oc.whfb.units.vf;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class VFNecromanticSpells extends RuestkammerVater {

	OptionsEinzelUpgrade oe;
	
	public VFNecromanticSpells() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		
		add(oe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Anrufung von Nehek"), 15, false));	
		oe.setSelected(true);
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Tote Erwecken"), 15, false));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Vanhels Totentanz"), 15, false));
		
		setUeberschrift(BuildaHQ.translate("Nekromantie"));
		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void refreshen() {
		setButtonState(BuildaHQ.noErrors);	
		
		if( super.getKosten() == 0 ){
			oe.setSelected(true);
		}	
	}

	@Override
	public double getKosten() {
		double kosten = super.getKosten();
		if ( kosten > 0 ){
			return kosten -= 15;
		}
		return super.getKosten();
	}
}
