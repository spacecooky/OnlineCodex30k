package oc.wh40k.units.de;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class DEMandraks extends Eintrag {

	AnzahlPanel squad;

	public DEMandraks() {
		name = "Mandraks-Trupp\n";
		grundkosten = 0;
        überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Mandraks", 3, 10, 15);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/DEMandraks.jpg"));

		seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Upgrade zum Nachtteufel", 10));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
