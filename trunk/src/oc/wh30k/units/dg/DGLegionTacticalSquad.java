package oc.wh30k.units.dg;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DGLegionTacticalSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o5;
	OptionsUpgradeGruppe o1, o2, o3;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public DGLegionTacticalSquad() {
		name = "Legion Tactical Squad\n";
		grundkosten = 50;
		�berschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 10, 20, 10);
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Legion Vexilla", 10));
		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 25));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolters", 0));
		ogE.addElement(new OptionsGruppeEintrag("Chainswords", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		ogE.addElement(new OptionsGruppeEintrag("Additional chainswords", 2));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DGSergeant", "Tactical Sergeant");
		rkBoss.setGrundkosten(0);
		//Assault, Bike, Breacher, Destroyer, Heavy, Reco, Seeker, Support, Tactical, Terminator, Veteran
		rkBoss.initKammer(false, false, false, false, false, false, false, false, true, false, false);
		rkBoss.setAbwaehlbar(false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DGTransporterKammer", "Transport");
		//Rhino, Pod, Phobos, Spartan
		rkTransport.initKammer(true, false, false, false);
		rkTransport.setButtonText("Dedicated transport");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        if(!o3.isSelected() && !o2.isSelected(1)) o2.setSelected(0, true);
        
        rkTransport.setAktiv(squad.getModelle() <=10);
        o2.setAktiv(1, !o3.isSelected());
        o3.setAktiv(!o2.isSelected(1));
        
        o3.setPreis(0, squad.getModelle() * 2);
	}

}