package oc.wh40k.units.cm2007;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class CM2007BeschworeneNiedereDaemonen extends Eintrag {

	AnzahlPanel squad;

	public CM2007BeschworeneNiedereDaemonen() {
		name = "Beschworene Niedere Dämonen";
		grundkosten = 0;
		this.setEintragsCNT(0);

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Niedere Dämonen", 5, 20, 13, "Beschworene Niedere Dämonen");
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SummonedLesserDaemons.gif"));
		

		complete();
	}

	@Override
	public void refreshen() {
	}

}
