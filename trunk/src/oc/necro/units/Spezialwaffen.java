package oc.necro.units;

import oc.BuildaHQ;
import oc.OnlineCodex;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerHelper;

public class Spezialwaffen extends RuestkammerHelper {

    String armee;
    boolean boss;
    boolean erstesSpiel;

	OptionsZaehlerGruppe oz4;
	OptionsZaehlerGruppe oz4a;


	public Spezialwaffen() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
        armee = OnlineCodex.getInstance().getCurrentArmy();
        boss = defaults[0];

        ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 40));
        (BuildaHQ.equals(armee, vansaar, delaque, escher) ? ogE : ogEa).addElement(new OptionsGruppeEintrag("Plasmawerfer", 70));
        (BuildaHQ.equals(armee, orlock, vansaar, delaque) ? ogE : ogEa).addElement(new OptionsGruppeEintrag("Melter", 95));
        (BuildaHQ.equals(armee, goliath, orlock, cawdor) ? ogE : ogEa).addElement(new OptionsGruppeEintrag("Granatwerfer", 130));
        add(oz4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		setHeadline(oz4, "Spezialwaffen");

        seperator();

        ogEa.addElement(new OptionsGruppeEintrag("Nadelgewehr", 230));
        add(oz4a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogEa));
        ogEa.clear();
        setHeadline(oz4a, "seltene Spezialwaffen");

		sizeSetzen();
	}

	@Override
	public void refreshen() {
        oz4a.setAktiv(!erstesSpiel);

        if(erstesSpiel) {
            oz4.setAktiv("Melter", boss);
        } else
            oz4.setAktiv(true);
	}

    @Override
    public void specialVoid(boolean b) {
        erstesSpiel = b;
    }

}
