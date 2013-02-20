package oc.wh30k.units.we;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class WELegionTacticalSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o5;
	OptionsUpgradeGruppe o1, o2, o3;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public WELegionTacticalSquad() {
		name = "Legion Tactical Squad\n";
		grundkosten = 50;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 10, 20, 10);
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Legion Vexilla", 10));
		ogE.addElement(new OptionsGruppeEintrag("Nuncio Vox", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolters", 0));
		ogE.addElement(new OptionsGruppeEintrag("Chainswords", 0));
		ogE.addElement(new OptionsGruppeEintrag("Chainaxes", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		ogE.addElement(new OptionsGruppeEintrag("Additional chainswords", 2));
		ogE.addElement(new OptionsGruppeEintrag("Additional chainaxes", 2));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "WESergeant", "Tactical Sergeant");
		rkBoss.setGrundkosten(0);
		//Assault, Bike, Breacher, Destroyer, Heavy, Reco, Seeker, Support, Tactical, Terminator, Veteran, Rampager
		rkBoss.initKammer(false, false, false, false, false, false, false, false, true, false, false, false);
		rkBoss.setAbwaehlbar(false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "WETransporterKammer", "Transport");
		//Rhino, Pod, Dreadclaw, Phobos, Spartan
		rkTransport.initKammer(true, true, false, true, false);
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
        o3.setAktiv(!o2.isSelected(1) && !o2.isSelected(2));
        
        o3.setPreis(0, squad.getModelle() * 2);
        o3.setPreis(1, squad.getModelle() * 2);
        
        rkTransport.getPanel().setLocation(
				(int) rkTransport.getPanel().getLocation().getX(),
				(int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height + 5
	    );
	}

}
