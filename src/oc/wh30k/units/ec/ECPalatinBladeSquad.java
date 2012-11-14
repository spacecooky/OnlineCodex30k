package oc.wh30k.units.ec;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class ECPalatinBladeSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1, o2, o4;
	OptionsUpgradeGruppe o3;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;
	OptionsEinzelUpgrade oJP;
	OptionsEinzelUpgrade oMB;

	public ECPalatinBladeSquad() {
		name = "Palatin Blade Squad\n";
		grundkosten = 135;
		überschriftSetzen = true;

		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 5));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Power lance", 5));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sprungmodule", 50));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sonic shriekers", 10));
		

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "ECPalatinPrefector", "Palatin Prefector");
		rkBoss.setGrundkosten(0);
		rkBoss.initKammer(true, false, false, false, false);
		rkBoss.setAbwaehlbar(false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		seperator();
		
		
		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "ECTransporterKammer", "Transport");
		//Rhino, Pod, Phobos, Spartan
		rkTransport.initKammer(true, false, false, false);
		rkTransport.setButtonText("Dedicated transport");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);

        
	}

}
