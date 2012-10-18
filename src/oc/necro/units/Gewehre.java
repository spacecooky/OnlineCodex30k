package oc.necro.units;

import oc.BuildaHQ;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerHelper;

public class Gewehre extends RuestkammerHelper {

    String armee;
    boolean boss;
    boolean erstesSpiel = false;

    OptionsEinzelUpgrade[] oe = new OptionsEinzelUpgrade[4];

	OptionsZaehlerGruppe oz3;
	OptionsZaehlerGruppe oz3a;


	public Gewehre() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
        armee = OnlineCodex.getInstance().getCurrentArmy();
        boss = defaults[0];

        ogE.addElement(new OptionsGruppeEintrag("Sturmgewehr", 20));
        ogE.addElement(new OptionsGruppeEintrag("Schrotflinte", 20));
        (BuildaHQ.equals(armee, orlock, vansaar, delaque, escher) ? ogE : ogEa).addElement(new OptionsGruppeEintrag("Lasergewehr", 25));
        (BuildaHQ.equals(armee, goliath, cawdor, delaque, escher) ? ogE : ogEa).addElement(new OptionsGruppeEintrag("Bolter", 35));
        add(oz3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		setHeadline(oz3, "Gewehre");

        seperator();

        if(!ogEa.isEmpty()) {
            add(oz3a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogEa));
            ogEa.clear();
            setHeadline(oz3a, "seltene Gewehre");
        }

        seperator();

        add(oe[0] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Panzerbrecher", 5));
        add(oe[1] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Brandgeschosse", 5));
        add(oe[2] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boltgeschosse", 15));
        add(oe[3] = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "HE-Laserzelle", "Hochenergielaserzelle", 15));


		sizeSetzen();
	}

	@Override
	public void refreshen() {
        if(oz3a != null) oz3a.setAktiv(!erstesSpiel);

        for(int i=0;i<3;i++) {
            oe[i].setAktiv(oz3.isSelected("Schrotflinte") || (oz3a != null ? oz3a.isSelected("Schrotflinte") : false));
        }

        oe[3].setAktiv(!erstesSpiel && (oz3.isSelected("Lasergewehr") || (oz3a != null ? oz3a.isSelected("Lasergewehr") : false)));

        if(erstesSpiel) {
            oz3.setAktiv("Bolter", (BuildaHQ.equals(armee, delaque, escher) && boss) || BuildaHQ.equals(armee, goliath, cawdor));
        } else
            oz3.setAktiv(true);
	}


    @Override
    public void specialVoid(boolean b) {
        erstesSpiel = b;
    }
}
