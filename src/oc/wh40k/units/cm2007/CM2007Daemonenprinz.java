package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CM2007Daemonenprinz extends Eintrag {

	OptionsEinzelUpgrade o1;
	OptionsUpgradeGruppe o3;
	OptionsEinzelZaehler o4;
	OptionsUpgradeGruppe o5;
	OptionsUpgradeGruppe o6;
	RuestkammerStarter ot;

	public CM2007Daemonenprinz() {
		name = "Dämonenprinz";
		grundkosten = 110;

		add(ico = new oc.Picture("oc/wh40k/images/DaemonPrince.gif"));
		

		seperator(5);

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Flügel", 20));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Mal des Slaanesh", 5));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Khorne", 10));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Nurgle", 20));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", 20));
		add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Strahl des Verderbens", 10));
		ogE.addElement(new OptionsGruppeEintrag("Warpzeit", 25));
		ogE.addElement(new OptionsGruppeEintrag("Chaoswind", 30));
		ogE.addElement(new OptionsGruppeEintrag("Geschenk des Chaos", 30));
		ogE.addElement(new OptionsGruppeEintrag("Fäulnis des Nurgle", 15));
		ogE.addElement(new OptionsGruppeEintrag("Blitz des Tzeentch", 25));
		ogE.addElement(new OptionsGruppeEintrag("Peitsche der Unterwerfung", 20));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		complete();
	}

	@Override
	public void refreshen() {
		o5.setAktiv(!o6.isSelected("Mal des Khorne"));

		if (!o6.isSelected("Mal des Khorne")) {
			o5.setAktiv("Fäulnis des Nurgle", o6.isSelected("Mal des Nurgle"));
			o5.setAktiv("Peitsche der Unterwerfung", o6.isSelected("Mal des Slaanesh"));
			o5.setAktiv("Blitz des Tzeentch", o6.isSelected("Mal des Tzeentch"));
			o5.setMaxAnzahl((o6.isSelected("Mal des Tzeentch") ? 2 : 1));
		}
	}

}
