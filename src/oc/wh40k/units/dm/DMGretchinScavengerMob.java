package oc.wh40k.units.dm;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;

public class DMGretchinScavengerMob extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelZaehler oe1;
	OptionsEinzelZaehler oe2;

	public DMGretchinScavengerMob() {
		kategorie = 3;
		grundkosten = 0;

		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Gretchin Scavs", 10, 30, 4));

		add(ico = new oc.Picture("oc/wh40k/images/Grotz.gif"));
		

		seperator();

		add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Runtherd", squad.getModelle() / 10, 10));

		seperator();

		add(oe2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Grot-Prod", squad.getModelle() / 10, 5));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setMaxAnzahl(squad.getModelle() / 10);
		oe1.setAnzahl(squad.getModelle() / 10);
		oe2.setMaxAnzahl(oe1.getAnzahl());
	}

}
