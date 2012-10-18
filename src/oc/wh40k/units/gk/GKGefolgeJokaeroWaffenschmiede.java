package oc.wh40k.units.gk;

import oc.AnzahlPanel;
import oc.RuestkammerVater;

public class GKGefolgeJokaeroWaffenschmiede extends RuestkammerVater {

	AnzahlPanel squad;

	public GKGefolgeJokaeroWaffenschmiede() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Jokaero-Waffenschmied", "Jokaero-Waffenschmiede", 1, 12, 35));

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
