package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;

public class NEDestruktoren extends Eintrag {

	AnzahlPanel squad;
    OptionsEinzelZaehler oe1;

	public NEDestruktoren() {
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Destruktor", "Destruktoren", 1, 5, 40);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/NEDestruktoren.jpg"));

		seperator();
        
		add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Schwerer Destruktor", "Upgrade zum Schweren Destruktor", 0, 20));

		complete();
	}

	@Override
	public void refreshen() {
        oe1.setMaxAnzahl(squad.getModelle() < 4 ? squad.getModelle() : 3);
	}

}
