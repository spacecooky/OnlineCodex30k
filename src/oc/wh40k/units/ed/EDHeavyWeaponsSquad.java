package oc.wh40k.units.ed;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class EDHeavyWeaponsSquad extends RuestkammerVater {

	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1x;
    RuestkammerStarter rkTransport;

	public EDHeavyWeaponsSquad() {
		grundkosten = 65;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGInfantrySquad.jpg"));
		
        
		ogE.addElement(new OptionsGruppeEintrag("Mortar", 0));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
		ogE.addElement(new OptionsGruppeEintrag("Heavy Bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "krak grenades", 5));

        seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "EDValkyrie", "Valkyrie Airborne Assault Carrier");
		rkTransport.initKammer(true);
		add(rkTransport);

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
        o1x.setAnzahl(0, 3 - o1.getAnzahl());
	}




}
