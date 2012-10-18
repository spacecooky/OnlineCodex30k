package oc.whfb.units.bdc;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class BDCEquipment extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade oe1;
	boolean commander = false;

	public BDCEquipment() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = lord
		// defaults[1] = doombull
		
		this.commander = (defaults[0]);
		
		if(defaults[1]){			
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), this.commander ? 15 : 10));						
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("zus. Handwaffe"), this.commander ? 8 : 5));						
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			setHeadline(o1, BuildaHQ.translate("Ausrüstung"));
		}
		else {
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"),this.commander ? 12 : 4));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("zus. Handwaffe"), this.commander ? 8 : 4));
			add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
			setHeadline(o1, BuildaHQ.translate("Ausrüstung"));
		}
			
		seperator();
		
		if(defaults[1]){			
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Leichte Rüstung"), this.commander ? 6 : 4));						
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwere Rüstung"), this.commander ? 12 : 8));						
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		}
		else {
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Leichte Rüstung"), this.commander ? 3 : 2));						
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwere Rüstung"), this.commander ? 6 : 4));						
			add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		}
		
		seperator();
		
		if(defaults[1]){			
			add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schild"), this.commander ? 6 : 4));
		}
		else {
			add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schild"), this.commander ? 3 : 2));
		}
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
