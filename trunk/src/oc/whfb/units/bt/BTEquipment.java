package oc.whfb.units.bt;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class BTEquipment extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;

	boolean commander = false;

	public BTEquipment() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Herzog
		// defaults[1] = Paladin

		this.commander = defaults[0];
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lanze"), this.commander ? 6 : 4));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), this.commander ? 6 : 4));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		setHeadline(o1, BuildaHQ.translate("Ausrüstung"));
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Morgenstern"), this.commander ? 3 : 2));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schild"), this.commander ? 3 : 2));
		setUeberschrift(BuildaHQ.translate("Ausrüstung"));
		sizeSetzen();

	}

	@Override
	public void refreshen() {
		
	}
	
	public void specialAction(boolean... action) {
		
		try {//Waffen
			o1.setAktiv(BuildaHQ.translate("Lanze"), !action[1]);
			o1.setAktiv(BuildaHQ.translate("Zweihandwaffe"), action[1]);
		} catch(Exception ex) {
			// ignore
		}
		
		refreshen();
	}
}
