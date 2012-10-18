package oc.wh40k.units.as;

import oc.AnzahlPanel;
import oc.RuestkammerVater;

public class ASLaeutererKammer extends RuestkammerVater {

	AnzahlPanel squad;

	public ASLaeutererKammer() {}

	public void initButtons(boolean... defaults) {
		name = "L�uterer";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "L�uterer", 1, 3, 85);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ASLaeuterer.jpg"));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
