package oc.wh30k.units.we;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class WELegionTacticalSupportSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1, o2;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransportEagle;
	RuestkammerStarter rkTransportPhobos;
	RuestkammerStarter rkTransportPod;
	RuestkammerStarter rkTransportProteus;
	RuestkammerStarter rkTransportRhino;

	public WELegionTacticalSupportSquad() {
		name = "Legion Tactical Support Squad\n";
		grundkosten = 25;
		�berschriftSetzen = true;
		setCountToMinimum(false);

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
		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "WESergeant", "Legion Sergeant");
		rkBoss.setGrundkosten(0);
		//Assault, Bike, Breacher, Destroyer, Heavy, Reco, Seeker, Support, Tactical, Terminator, Veteran, Rampager
		rkBoss.initKammer(false, false, false, false, false, false, false, true, false, false, false, false);
		rkBoss.setAbwaehlbar(false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		seperator();
		rkTransportPod = new RuestkammerStarter(ID, randAbstand, cnt, "WETransportKammerPod", "Legion Drop Pod\n");
		rkTransportPod.initKammer();
		rkTransportPod.setButtonText("Legion Drop Pod");
		add(rkTransportPod);

		seperator();
		rkTransportEagle = new RuestkammerStarter(ID, randAbstand, cnt, "WETransportKammerEagle", "Legion Storm Eagle Assault Gunship\n");
		rkTransportEagle.initKammer();
		rkTransportEagle.setButtonText("Legion Storm Eagle Assault Gunship");
		add(rkTransportEagle);

		seperator();
		rkTransportPhobos = new RuestkammerStarter(ID, randAbstand, cnt, "WETransportKammerPhobos", "Legion Land Raider Phobos\n");
		rkTransportPhobos.initKammer();
		rkTransportPhobos.setButtonText("Legion Land Raider Phobos");
		add(rkTransportPhobos);

		seperator();
		rkTransportProteus = new RuestkammerStarter(ID, randAbstand, cnt, "WETransportKammerProteus", "Legion Land Raider Proteus\n");
		rkTransportProteus.initKammer();
		rkTransportProteus.setButtonText("Legion Land Raider Proteus");
		add(rkTransportProteus);

		seperator();
		rkTransportRhino = new RuestkammerStarter(ID, randAbstand, cnt, "WETransportKammerRhino", "Legion Rhino Armoured Carrier\n");
		rkTransportRhino.initKammer();
		rkTransportRhino.setButtonText("Legion Rhino Armoured Carrier");
		add(rkTransportRhino);

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
		
		rkTransportPod.setAktiv(squad.getModelle() <=10 && !rkTransportRhino.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportPhobos.isSelected() 
        		&& !rkTransportProteus.isSelected() 
        		&& BuildaHQ.getCountFromInformationVector("WERoW") == 3);
        
        rkTransportEagle.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportRhino.isSelected() 
        		&& !rkTransportPhobos.isSelected() 
        		&& !rkTransportProteus.isSelected() 
        		&& BuildaHQ.getCountFromInformationVector("WERoW") == 1);
        
        rkTransportPhobos.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportRhino.isSelected() 
        		&& !rkTransportProteus.isSelected() 
        		&& BuildaHQ.getCountFromInformationVector("WERoW") == 2);
        
        rkTransportProteus.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportPhobos.isSelected() 
        		&& !rkTransportRhino.isSelected()
        		&& BuildaHQ.getCountFromInformationVector("WERoW") == 2);
        
        rkTransportRhino.setAktiv(squad.getModelle() <=10 && !rkTransportPod.isSelected() 
        		&& !rkTransportEagle.isSelected() 
        		&& !rkTransportPhobos.isSelected() 
        		&& !rkTransportProteus.isSelected()
        		&& BuildaHQ.getCountFromInformationVector("WERoW") != 1
        		&& BuildaHQ.getCountFromInformationVector("WERoW") != 3);
        
        rkTransportPod.getPanel().setLocation(
				(int) rkTransportPod.getPanel().getLocation().getX(),
				(int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height + 5
		);
        
        rkTransportEagle.getPanel().setLocation(
				(int) rkTransportEagle.getPanel().getLocation().getX(),
				(int) rkTransportPod.getPanel().getLocation().getY() + rkTransportPod.getPanel().getSize().height + 5
		);
        
        rkTransportPhobos.getPanel().setLocation(
				(int) rkTransportPhobos.getPanel().getLocation().getX(),
				(int) rkTransportEagle.getPanel().getLocation().getY() + rkTransportEagle.getPanel().getSize().height + 5
		);
        
        rkTransportProteus.getPanel().setLocation(
				(int) rkTransportProteus.getPanel().getLocation().getX(),
				(int) rkTransportPhobos.getPanel().getLocation().getY() + rkTransportPhobos.getPanel().getSize().height + 5
		);
        
        rkTransportRhino.getPanel().setLocation(
				(int) rkTransportRhino.getPanel().getLocation().getX(),
				(int) rkTransportProteus.getPanel().getLocation().getY() + rkTransportProteus.getPanel().getSize().height + 5
	    );
	}

}
