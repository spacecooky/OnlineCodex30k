package oc.whfb.units.og2004;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class OG2004Equipment extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsZaehlerGruppe o3;
	OptionsEinzelUpgrade oe;
	OptionsEinzelUpgrade og;

	boolean commander = false;

	public OG2004Equipment() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Tyrann
		// defaults[1] = Brecher

		this.commander = defaults[0];

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), this.commander ? 14 : 8));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zusätzliche Handwaffe"), this.commander ? 10 : 8));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Eisenfaust"), this.commander ? 12 : 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Cathay-Langschwert"), this.commander ? 10 : 8));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(og = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musketenpaar"), 12));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Leichte Rüstung"), 0));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwere Rüstung"), this.commander ? 6 : 4));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwertgnoblar"), 5));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();
		
		add(oe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Glücksgnoblar"), 5));
		setUeberschrift(BuildaHQ.translate("Ausrüstung"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o2.setLegal(o2.isSelected());
	}

	@Override
	public void specialAction(boolean... action) {
		o1.setAktiv(BuildaHQ.translate("Zweihandwaffe"), action[0]);
		o1.setAktiv(BuildaHQ.translate("Zusätzliche Handwaffe"), action[0]);
		o1.setAktiv(BuildaHQ.translate("Eisenfaust"), action[0]);
		o1.setAktiv(BuildaHQ.translate("Cathay-Langschwert"), action[0]);
		og.setAktiv(action[0]);
	}

}
