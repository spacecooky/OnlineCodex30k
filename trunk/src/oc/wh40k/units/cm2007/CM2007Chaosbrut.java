package oc.wh40k.units.cm2007;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class CM2007Chaosbrut extends Eintrag {

	AnzahlPanel squad;

	public CM2007Chaosbrut() {
		name = "Chaosbrut";
		grundkosten = 0;
		this.setEintragsCNT(0);

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Chaosbrut", 1, 3, 40);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosSpawn.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
	}

}
