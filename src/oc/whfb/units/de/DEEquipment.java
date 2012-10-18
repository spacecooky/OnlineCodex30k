package oc.whfb.units.de;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DEEquipment extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;

	boolean commander = false;

	public DEEquipment() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Hochgeborener
		// defaults[1] = Adliger

		this.commander = defaults[0];

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lanze"), this.commander ? 6 : 4));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), this.commander ? 6 : 4));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hellebarde"), this.commander ? 6 : 4));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zus�tzliche Handwaffe"), this.commander ? 6 : 4));
		if(defaults[1]) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gei�el"), BuildaHQ.translate("Gei�el des Bestienmeisters"), 6));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		setHeadline(o1, BuildaHQ.translate("Ausr�stung"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Repetier-Armbrust"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Repetier-Handarmbrust"),8));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("2 Repetier-Handarmbr�ste"), 16));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Leichte R�stung"), this.commander ? 3 : 2));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwere R�stung"), this.commander ? 6 : 4));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schild"), this.commander ? 3 : 2));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Seedrachenumhang"), this.commander ? 6 : 4));
		setUeberschrift(BuildaHQ.translate("Ausr�stung"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
