package oc.necro.units;

import oc.BuildaHQ;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerHelper;

public class SchwereWaffen extends RuestkammerHelper {

    String armee;
    boolean erstesSpiel;

    OptionsEinzelUpgrade[] oe = new OptionsEinzelUpgrade[2];

	OptionsZaehlerGruppe oz5;
	OptionsZaehlerGruppe oz5a;


	public SchwereWaffen() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
        armee = OnlineCodex.getInstance().getCurrentArmy();

        ogE.addElement(new OptionsGruppeEintrag("Maschinengewehr", 120));
        (BuildaHQ.equals(armee, goliath, orlock, cawdor) ? ogE : ogEa).addElement(new OptionsGruppeEintrag("schwerer Bolter", 180));
        (BuildaHQ.equals(armee, orlock) ? ogE : ogEa).addElement(new OptionsGruppeEintrag("Raketenwerfer", 185));
        (BuildaHQ.equals(armee, vansaar, delaque, escher) ? ogE : ogEa).addElement(new OptionsGruppeEintrag("Plasmakanone", 285));
        (BuildaHQ.equals(armee, goliath, cawdor) ? ogE : ogEa).addElement(new OptionsGruppeEintrag("Maschinenkanone", 300));
        (BuildaHQ.equals(armee, vansaar, delaque) ? ogE : ogEa).addElement(new OptionsGruppeEintrag("Laserkanone", 400));
        add(oz5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		setHeadline(oz5, "schwere Waffen");

        seperator();

        if(!ogEa.isEmpty()) {
            add(oz5a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogEa, 1));
            ogEa.clear();
            setHeadline(oz5a, "seltene schwere Waffen");
        }

        seperator();

        add(oe[0] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fragmentraketen", 35));
        add(oe[1] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sprengraketen" , 115));


		sizeSetzen();
	}

	@Override
	public void refreshen() {
        oz5.setMaxAnzahl(1 - oz5a.getAnzahl());
        oz5a.setMaxAnzahl(1 - oz5.getAnzahl());

        for(int i=0;i<oe.length;i++) {
            oe[i].setAktiv(oz5.isSelected("Raketenwerfer") || oz5a.isSelected("Raketenwerfer"));
        }

        oz5a.setAktiv(!erstesSpiel);
	}

    @Override
    public void specialVoid(boolean b) {
        erstesSpiel = b;
    }

}
