package oc.wh30k.units.we;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class WETheRedButchers extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o2, o4, o7a, o7aStandard, o7b, o7bStandard, o7c, o8;
	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o7aStandard2;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransportPhobos;
	RuestkammerStarter rkTransportProteus;
	RuestkammerStarter rkTransportSpartan;

	public WETheRedButchers() {
		name = "The Red Butchers\n";
		grundkosten = 50;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Butcher Terminators", 5, 10, 45);
		add(squad);
		
		seperator();		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Power axe"), 0));
		add(o7aStandard = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();		
		ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", 0));
		add(o7bStandard = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		
		ogE.addElement(new OptionsGruppeEintrag("Power axe", 0));
		add(o7b = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE));
		
		seperator();		
		ogE.addElement(new OptionsGruppeEintrag("Pair of lightning claws", 5));
		add(o7c = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "WESergeant", "The Devoured");
		rkBoss.setGrundkosten(0);
		//Assault, Bike, Breacher, Destroyer, Heavy, Reco, Seeker, Support, Tactical, Terminator, Veteran, Rampager, Butcher
		rkBoss.initKammer(false, false, false, false, false, false, false, false, false, false, false, false, true);
		rkBoss.setAbwaehlbar(false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

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
		rkTransportSpartan = new RuestkammerStarter(ID, randAbstand, cnt, "WETransportKammerSpartan", "Spartan Assault Tank\n");
		rkTransportSpartan.initKammer();
		rkTransportSpartan.setButtonText("Spartan Assault Tank");
		add(rkTransportSpartan);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
        int subtractor = 1; // boss
        
        o7b.setMaxAnzahl(squad.getModelle()-subtractor-o7c.getAnzahl());
		
		o7aStandard.setMaxAnzahl(squad.getModelle()-subtractor-o7c.getAnzahl());
		o7bStandard.setMaxAnzahl(squad.getModelle()-subtractor-o7b.getAnzahl()-o7c.getAnzahl());
		o7aStandard.setAnzahl(0,o7aStandard.getMaxAnzahl());
		o7bStandard.setAnzahl(0,o7bStandard.getMaxAnzahl());
				
		o7c.setMaxAnzahl(squad.getModelle()-subtractor-(o7b.getAnzahl()));	
		
		int offeneFKOptionen=squad.getModelle()-subtractor-o7b.getAnzahl()-o7c.getAnzahl();
		
			rkTransportPhobos.setAktiv(squad.getModelle() <=5&& !rkTransportProteus.isSelected() && !rkTransportSpartan.isSelected()
		        	&& BuildaHQ.getCountFromInformationVector("WERoW") != 1);
			
			rkTransportProteus.setAktiv(squad.getModelle() <=5 && !rkTransportPhobos.isSelected()&& !rkTransportSpartan.isSelected()
		        	&& BuildaHQ.getCountFromInformationVector("WERoW") != 1);
		        
			rkTransportSpartan.setAktiv(squad.getModelle() <=10 && !rkTransportPhobos.isSelected()&& !rkTransportProteus.isSelected()
		        	&& BuildaHQ.getCountFromInformationVector("WERoW") != 1);
		        
			rkTransportPhobos.getPanel().setLocation(
					(int) rkTransportPhobos.getPanel().getLocation().getX(),
					(int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height + 5
			);
	        
			rkTransportProteus.getPanel().setLocation(
					(int) rkTransportProteus.getPanel().getLocation().getX(),
					(int) rkTransportPhobos.getPanel().getLocation().getY() + rkTransportPhobos.getPanel().getSize().height + 5
			);
		        
			rkTransportSpartan.getPanel().setLocation(
					(int) rkTransportSpartan.getPanel().getLocation().getX(),
					(int) rkTransportProteus.getPanel().getLocation().getY() + rkTransportProteus.getPanel().getSize().height + 5
			);
		
		
	}

}
