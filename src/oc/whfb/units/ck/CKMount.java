package oc.whfb.units.ck;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CKMount extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade oe1;

	boolean isCommander = false;

	boolean availKhorne = true;
	boolean availNurgle = true;
	boolean availTzeentch = true;
	boolean availSlaanesh = true;

	public CKMount() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Chaosgeneral
		// defaults[1] = Meisterzauberer
		// defaults[2] = Chaoszauberer
		// defaults[3] = Erhabener Held

		isCommander = (defaults[0] || defaults[1]);

		
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Chaosstreitwagen"), 100));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Khorne"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Nurgle"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Tzeentch"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Slaanesh"), 10));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();
		

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Chaosdrache"), 360));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mantikor"), 200));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Dämonisches Reittier"), 50));
		//ogE.addElement(new OptionsGruppeEintrag("Streitwagen", 100));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Chaosross"), isCommander ? 24 : 16));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Moloch des Khorne"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sänfte des Nurgle"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Flugdämon des Tzeentch"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Slaaneshpferd"), 25));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Reittier"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1.setAktiv(BuildaHQ.translate("Chaosdrache"), isCommander);
		o1.setAktiv(BuildaHQ.translate("Mantikor"), isCommander);
		
		oe1.setAktiv(!o1.isSelected());

		o2.setAktiv(BuildaHQ.translate("Mal des Khorne"), oe1.isSelected() && !o1.isSelected() && availKhorne);
		o2.setAktiv(BuildaHQ.translate("Mal des Nurgle"), oe1.isSelected() && !o1.isSelected() && availNurgle);
		o2.setAktiv(BuildaHQ.translate("Mal des Tzeentch"), oe1.isSelected() && !o1.isSelected() && availTzeentch);
		o2.setAktiv(BuildaHQ.translate("Mal des Slaanesh"), oe1.isSelected() && !o1.isSelected() && availSlaanesh);		
	}

	@Override
	public void specialAction(boolean... action) {
		o1.setAktiv(BuildaHQ.translate("Moloch des Khorne"), action[0]);
		o1.setAktiv(BuildaHQ.translate("Sänfte des Nurgle"), action[1]);
		o1.setAktiv(BuildaHQ.translate("Flugdämon des Tzeentch"), action[2]);
		o1.setAktiv(BuildaHQ.translate("Slaaneshpferd"), action[3]);

		availKhorne = !action[1] && !action[2] && !action[3];
		availNurgle = !action[0] && !action[2] && !action[3];
		availTzeentch = !action[0] && !action[1] && !action[3];
		availSlaanesh = !action[0] && !action[1] && !action[2];
	}

}
