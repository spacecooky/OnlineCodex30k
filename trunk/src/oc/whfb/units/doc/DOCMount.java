package oc.whfb.units.doc;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DOCMount extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	
	boolean khorne = false;
	boolean tzeentch = false;
	boolean nurgle = false;
	boolean slaanesh = false;
	boolean skulltaker = false;
	
	public DOCMount() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		if(defaults[0]) khorne = true;
		if(defaults[1]) tzeentch = true;
		if(defaults[2]) nurgle = true;
		if(defaults[3]) slaanesh = true;
		if(defaults[4]) skulltaker = true;
		
		if(khorne){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Streitwagen des Khorne"), this.skulltaker ? 150 : 75));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Moloch des Khorne"), 50));
		}
		else if(tzeentch){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Streitwagen des Tzeentch"), 60));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Flugdämon des Tzeentch"), 20));
		}
		else if(nurgle){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sänfte des Nurgle"), 50));
		}
		else if(slaanesh){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Streitwagen des Slaanesh"), 75));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Slaaneshpferd"), 25));
		}
		
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Reittier"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
