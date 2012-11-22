package oc.wh30k.units.dg;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DGLegionTerminatorSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsZaehlerGruppe o4;
	OptionsZaehlerGruppe o7a;
	OptionsZaehlerGruppe o7aStandard;
	OptionsZaehlerGruppe o7aStandard2;
	OptionsZaehlerGruppe o7b;
	OptionsZaehlerGruppe o7bStandard;
	OptionsZaehlerGruppe o7c;
	OptionsZaehlerGruppe o8;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public DGLegionTerminatorSquad() {
		name = "Legion Terminator Squad\n";
		grundkosten = 25;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Terminators", 5, 10, 30);
		add(squad);

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Power weapon"), 0));
		add(o7aStandard = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 5));
		ogE.addElement(new OptionsGruppeEintrag("Lightning claw", 5));
		ogE.addElement(new OptionsGruppeEintrag("Chain fist", 10));
		ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 10));
		add(o7a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", 0));
		add(o7bStandard = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		
		ogE.addElement(new OptionsGruppeEintrag("Combi-weapon", 7));
		ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 7));
		add(o7b = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Pair of lightning claws", 15));
		add(o7c = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
			
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Reaper autocannon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma blaster", 15));
		add(o8 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DGSergeant", "Terminator Sergeant");
		rkBoss.setGrundkosten(0);
		//Assault, Bike, Breacher, Destroyer, Heavy, Reco, Seeker, Support, Tactical, Terminator, Veteran
		rkBoss.initKammer(false, false, false, false, false, false, false, false, false, true, false);
		rkBoss.setAbwaehlbar(false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DGTransporterKammer", "Transport");
		//Rhino, Pod, Phobos, Spartan
		rkTransport.initKammer(false, false, true, true);
		rkTransport.setButtonText("Dedicated transport");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
        int subtractor = 1; // boss
		int nksubractor=(o7a.getAnzahl()>o8.getAnzahl()?o7a.getAnzahl():o8.getAnzahl());
        
        o7b.setMaxAnzahl(squad.getModelle()-subtractor-o7c.getAnzahl()-nksubractor);
		o7a.setMaxAnzahl(squad.getModelle()-subtractor-o7c.getAnzahl());
		
		o7aStandard.setMaxAnzahl(squad.getModelle()-subtractor-o7a.getAnzahl()-o7c.getAnzahl());
		o7bStandard.setMaxAnzahl(squad.getModelle()-subtractor-o7b.getAnzahl()-o7c.getAnzahl()-o8.getAnzahl());
		o7aStandard.setAnzahl(0,o7aStandard.getMaxAnzahl());
		o7bStandard.setAnzahl(0,o7bStandard.getMaxAnzahl());
				
		o7c.setMaxAnzahl(squad.getModelle()-subtractor-(nksubractor>o7b.getAnzahl()?nksubractor:o7b.getAnzahl()));
		
		if(squad.getModelle() >= 5) {
			o8.setAktiv(true);
		} else {
			o8.setAktiv(false);
		}
		
		int maxAnzahl=squad.getModelle()/5;
		
		o8.setMaxAnzahl(maxAnzahl);
		
		int offeneFKOptionen=squad.getModelle()-1-o7b.getAnzahl()-o7c.getAnzahl();
		if(maxAnzahl>0 && offeneFKOptionen<2){
			o8.setMaxAnzahl(offeneFKOptionen);
		}
		
	}

}
