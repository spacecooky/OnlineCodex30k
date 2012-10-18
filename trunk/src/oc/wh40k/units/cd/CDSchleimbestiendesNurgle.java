package oc.wh40k.units.cd;


import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CDSchleimbestiendesNurgle extends Eintrag {

	AnzahlPanel CDSchleimbestiendesNurgle;

	public CDSchleimbestiendesNurgle() {

		name = "Schleimbestien des Nurgle";

		grundkosten = 0;



		add(new AnzahlPanel(ID, randAbstand, cnt, "Schleimbestie des Nurgle", "Schleimbestien des Nurgle", 1, 7, 35));





		add(ico = new oc.Picture("oc/wh40k/images/CDSchleimbestiendesNurgle.gif"));

		seperator();







		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ätzende Berührung", 10));



		complete();

	}

	@Override
	public void refreshen() {
	}
}
