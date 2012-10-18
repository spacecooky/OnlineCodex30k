package oc.wh40k.units.gk;

import oc.AnzahlPanel;
import oc.RuestkammerVater;

public class GKGefolgeArcoFlagellanten extends RuestkammerVater {

	AnzahlPanel squad;

	public GKGefolgeArcoFlagellanten() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Arco-Flagellant", "Arco-Flagellanten", 1, 12, 15));

		sizeSetzen(200, 100, 390, KAMMER_HOEHE + cnt);
	}

	@Override
	public void refreshen() {
	}

    @Override
    public Object getSpecialValue() {
        return (Integer) squad.getModelle();
    }

}
