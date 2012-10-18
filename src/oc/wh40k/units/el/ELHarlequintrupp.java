package oc.wh40k.units.el;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ELHarlequintrupp extends Eintrag {

	AnzahlPanel Harlequintrupp;
	OptionsEinzelZaehler o4;
	OptionsEinzelUpgrade o2;
	OptionsEinzelUpgrade o3;
	OptionsEinzelZaehler o5;
	OptionsEinzelUpgrade o1;
	OptionsUpgradeGruppe o7;

	public ELHarlequintrupp() {
		name = "Harlequintrupp";
		grundkosten = 0;

		Harlequintrupp = new AnzahlPanel(ID, randAbstand, cnt, "Harlequine", 5, 10, 18);
		add(Harlequintrupp);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/ELHarlequintrupp.jpg"));
		

		add(o5 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Harlequinpeitsche", Harlequintrupp.getModelle(), 4));
		add(o4 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Fusionspistole", 2, 10));

		seperator();

		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Todesjoker", 10));

		seperator(8);

		add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schicksalsleser", 30));

		seperator();

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Meistermime", 20));

		seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 0));
		ogE.addElement(new OptionsGruppeEintrag("Harlequinpeitsche", 0));

		add(o7 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		complete();
	}

	//@OVERRIDE
	public void refreshen() {
		o7.setAktiv(o1.isSelected());

		int cnt = 0;

		if (o1.isSelected()) {
			++cnt;
		}

		if (o2.isSelected()) {
			++cnt;
		}

		o5.setMaxAnzahl(Harlequintrupp.getModelle() - cnt);
	}

}
