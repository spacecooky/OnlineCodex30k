package oc.wh30k.units.ec;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class ECPalatineBladeSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o2;
	OptionsUpgradeGruppe o1, o3;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public ECPalatineBladeSquad() {
		name = "Palatine Blade Squad\n";
		grundkosten = 135;
		überschriftSetzen = true;
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sonic Shriekers", 10));
		ogE.addElement(new OptionsGruppeEintrag("Jump packs", 50));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Power sword", 5));
		ogE.addElement(new OptionsGruppeEintrag("Power lance", 5));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "ECSergeant", "Palatine Prefector");
		rkBoss.setGrundkosten(0);
		//Assault, Bike, Breacher, Destroyer, Heavy, Reco, Seeker, Support, Tactical, Terminator, Veteran, Palatine
		rkBoss.initKammer(false, false, false, false, false, false, false, false, false, false, false, true);
		rkBoss.setAbwaehlbar(false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		
		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "ECTransporterKammer", "Dedicated transport");
		//Rhino, Pod, Phobos, Spartan
		rkTransport.initKammer(true, true, true, false);
		rkTransport.setButtonText("Dedicated transport");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
		if(!rkBoss.isSelected()) {rkBoss.setSelected(true);}
        
	}


}
