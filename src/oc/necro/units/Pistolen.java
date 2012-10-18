package oc.necro.units;

import oc.BuildaHQ;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerHelper;

public class Pistolen extends RuestkammerHelper {

    String armee;
    boolean boss;
    boolean erstesSpiel;

    OptionsEinzelUpgrade oe1;

	OptionsZaehlerGruppe oz2;
	OptionsZaehlerGruppe oz2a;

	public Pistolen() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
        armee = OnlineCodex.getInstance().getCurrentArmy();
        boss = defaults[0];

        ogE.addElement(new OptionsGruppeEintrag("Automatikpistole", 10));
        ogE.addElement(new OptionsGruppeEintrag("Maschinenpistole", 15));
        ogE.addElement(new OptionsGruppeEintrag("Laserpistole", 15));
        (BuildaHQ.equals(armee, cawdor) ? ogE : ogEa).addElement(new OptionsGruppeEintrag("Flammenpistole", 15));
        (BuildaHQ.equals(armee, vansaar, cawdor, goliath, delaque) ? ogE : ogEa).addElement(new OptionsGruppeEintrag("Boltpistole", 20));
        (BuildaHQ.equals(armee, vansaar, escher) ? ogE : ogEa).addElement(new OptionsGruppeEintrag("Plasmapistole", 25));
        add(oz2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		setHeadline(oz2, "Pistolen");

        seperator();

        ogEa.addElement(new OptionsGruppeEintrag("Nadelpistole", 100));
        ogEa.addElement(new OptionsGruppeEintrag("Netzpistole", 120));
        add(oz2a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogEa));
        ogEa.clear();
        setHeadline(oz2a, "seltene Pistolen");

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dum-Dum-Geschosse", 5));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
        oz2a.setAktiv(!erstesSpiel);
        oe1.setAktiv(oz2.isSelected("Automatikpistole") || oz2a.isSelected("Automatikpistole"));

        if(erstesSpiel) {
            oz2.setAktiv("Boltpistole", (BuildaHQ.equals(armee, goliath, delaque) && boss) || BuildaHQ.equals(armee, vansaar, cawdor));
            oz2.setAktiv("Plasmapistole", boss);
        } else
            oz2.setAktiv(true);
	}

    @Override
    public void specialVoid(boolean b) {
        erstesSpiel = b;
    }
}
