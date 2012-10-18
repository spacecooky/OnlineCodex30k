package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class TYYmgarlSymbionten extends Eintrag {

	AnzahlPanel squad;

	public TYYmgarlSymbionten() {
		name = "Ymgarl-Symbionten";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Ymgarl-Symbionten", 5, 10, 23);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TYSymbionten.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
