package oc.wh40k.units.gk;

import oc.AnzahlPanel;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class GKGefolgeHeilige extends RuestkammerVater {

	AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1def;

	public GKGefolgeHeilige() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Heiliger", "Heilige", 1, 12, 15));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
		add(o1def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Eviscerator", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		sizeSetzen(200, 100, 390, KAMMER_HOEHE + cnt);
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		o1def.setMaxAnzahl(squad.getModelle() - o1.getAnzahl());
		o1def.setAnzahl(0, squad.getModelle() - o1.getAnzahl());
	}

    @Override
    public Object getSpecialValue() {
        return (Integer) squad.getModelle();
    }

}
