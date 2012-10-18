package oc.whfb.units.he;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class HEEquipment extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;

	boolean commander = false;

	public HEEquipment() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Kommandant
		// defaults[1] = Edler

		this.commander = defaults[0];

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lanze"), this.commander ? 6 : 4));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Speer"), this.commander ? 3 : 2));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), this.commander ? 12 : 8));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hellebarde"), this.commander ? 6 : 4));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zusätzliche Handwaffe"), this.commander ? 6 : 4));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schild"), this.commander ? 3 : 2));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Langbogen"), 10));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Leichte Rüstung"), this.commander ? 3 : 2));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwere Rüstung"), this.commander ? 6 : 4));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Drachenrüstung"), this.commander ? 9 : 6));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Ausrüstung"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
