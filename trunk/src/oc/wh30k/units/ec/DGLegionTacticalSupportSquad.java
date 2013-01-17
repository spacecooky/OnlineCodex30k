package oc.wh30k.units.ec;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DGLegionTacticalSupportSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public DGLegionTacticalSupportSquad() {
		name = "Legion Tactical Support Squad\n";
		grundkosten = 25;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 5, 10, 15);
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Rotor cannon", 5));
		ogE.addElement(new OptionsGruppeEintrag("Volkite Caliver", 5));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Melta gun", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DGSergeant", "Legion Sergeant");
		rkBoss.setGrundkosten(0);
		//Assault, Bike, Breacher, Destroyer, Heavy, Reco, Seeker, Support, Tactical, Terminator, Veteran
		rkBoss.initKammer(false, false, false, false, false, false, false, false, true, false, false);
		rkBoss.setAbwaehlbar(false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DGTransporterKammer", "Transport");
		//Rhino, Pod, Phobos, Spartan
		rkTransport.initKammer(true, true, true, false);
		rkTransport.setButtonText("Dedicated transport");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        if (!o1.isSelected()) o1.setSelected(0, true);
        
		o1.setPreis(0, 0);
		o1.setPreis(1, (squad.getModelle()-1) * 5);
		o1.setPreis(2, (squad.getModelle()-1) * 5);
		o1.setPreis(3, (squad.getModelle()-1) * 15);
		o1.setPreis(4, (squad.getModelle()-1) * 15);
	}

}
