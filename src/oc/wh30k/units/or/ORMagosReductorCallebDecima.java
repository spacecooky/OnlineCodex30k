package oc.wh30k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ORMagosReductorCallebDecima extends Eintrag {
	
	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2, o3;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public ORMagosReductorCallebDecima() {
		name = "Magos Reductor Calleb Decima";
		grundkosten = 175;

		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Cyber-familiar", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Servo-automata", 12));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
		
		ogE.addElement(new OptionsGruppeEintrag("Lascutter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Rotor cannon", 10));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 4));
		
		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "ORTransporterKammer", "Mechanicum Land Raider");
		//Rhino, Pod, Phobos, Spartan
		rkTransport.initKammer();
		rkTransport.setButtonText("Mechanicum Land Raider");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
        
        o3.setMaxAnzahl(o2.getAnzahl());
	}

}
