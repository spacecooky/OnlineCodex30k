package oc.whfb.units.og;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class OGEquipment extends RuestkammerVater {

	OptionsUpgradeGruppe o1, o2;
	boolean commander = false;

	public OGEquipment() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Tyrann
		// defaults[1] = Brecher

		this.commander = defaults[0];
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zusätzliche Handwaffe"), 3));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Eisenfaust"), this.commander ? 5 : 4));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), this.commander ? 12 : 11));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ogerpistole"), this.commander ? 8 : 6));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ogerpistolenpaar"), this.commander ? 14 : 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Leichte Rüstung"), 0));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwere Rüstung"), this.commander ? 5 : 4));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		setUeberschrift(BuildaHQ.translate("Ausrüstung"));
		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void refreshen() {
	}
}
