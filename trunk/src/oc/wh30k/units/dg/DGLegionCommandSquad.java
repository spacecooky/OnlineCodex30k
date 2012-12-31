package oc.wh30k.units.dg;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DGLegionCommandSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1, o2, o4, o5, o6;
	OptionsZaehlerGruppe o3, o4a, o4b;
	OptionsZaehlerGruppe o7a;
	OptionsZaehlerGruppe o7aStandard;
	OptionsZaehlerGruppe o7b;
	OptionsZaehlerGruppe o7bStandard;
	OptionsZaehlerGruppe o7c;
	OptionsZaehlerGruppe o8;
	RuestkammerStarter rkTransport;

	public DGLegionCommandSquad() {
		name = "Legion Command Squad";
		grundkosten = 40;
		        
		BuildaHQ.addToInformationVector("DGLegionCommandSquad", 1);

		seperator();

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Chosen", 3, 5, 20);
		add(squad);

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Legion Standard Bearer", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 25));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Combat shield", 5));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Heavy chainsword", 5));
		ogE.addElement(new OptionsGruppeEintrag("Charnabal sabre", 5));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		ogE.addElement(new OptionsGruppeEintrag("Lightning law", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		add(o4a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
		add(o4b = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Jump pack", 15));
		ogE.addElement(new OptionsGruppeEintrag("Space Marine Bike", 20));
		ogE.addElement(new OptionsGruppeEintrag("Legion Jetbike", 35));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		ogE.addElement(new OptionsGruppeEintrag("Terminator armour", 15));
		ogE.addElement(new OptionsGruppeEintrag("Cataphractii armour", "Cataphractii Terminator armour", 15));
		add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
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
		add(o8 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

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
		
		if(!o1.isSelected()) o1.setSelected(0, true);
		o2.setAktiv(!o6.isSelected());
		o3.setAktiv(!o6.isSelected());
		o4a.setAktiv(!o6.isSelected());
		o4b.setAktiv(!o6.isSelected());
		o5.setAktiv(!o6.isSelected());
		
		o7a.setAktiv(o6.isSelected());
		o7aStandard.setAktiv(o6.isSelected());
		o7b.setAktiv(o6.isSelected());
		o7bStandard.setAktiv(o6.isSelected());
		o7c.setAktiv(o6.isSelected());
		o8.setAktiv(o6.isSelected());
		
		o3.setMaxAnzahl(squad.getModelle());
		o4a.setMaxAnzahl(squad.getModelle());
		o4b.setMaxAnzahl(squad.getModelle()-1);
		
		int nksubractor=(o7a.getAnzahl()>o8.getAnzahl()?o7a.getAnzahl():o8.getAnzahl());
        
        o7b.setMaxAnzahl(squad.getModelle()-o7c.getAnzahl());
		o7a.setMaxAnzahl(squad.getModelle()-o7c.getAnzahl());
		
		o7aStandard.setMaxAnzahl(squad.getModelle()-o7a.getAnzahl()-o7c.getAnzahl());
		o7bStandard.setMaxAnzahl(squad.getModelle()-o7b.getAnzahl()-o7c.getAnzahl()-o8.getAnzahl());
		o7aStandard.setAnzahl(0,o7aStandard.getMaxAnzahl());
		o7bStandard.setAnzahl(0,o7bStandard.getMaxAnzahl());
				
		o7c.setMaxAnzahl(squad.getModelle()-(nksubractor>o7b.getAnzahl()?nksubractor:o7b.getAnzahl()));
		
		
		
		int maxAnzahl=1;
		
		o8.setMaxAnzahl(maxAnzahl);
		
		int offeneFKOptionen=squad.getModelle()-o7b.getAnzahl()-o7c.getAnzahl();
		if(maxAnzahl>0 && offeneFKOptionen<2){
			o8.setMaxAnzahl(offeneFKOptionen);
		}


		int selectedSquads = BuildaHQ.getCountFromInformationVector("DGLegionCommandSquad");
		int possibleSquads = BuildaHQ.getCountFromInformationVector("DGPraetor");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("Command Squads > " + possibleSquads + "!");
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("DGLegionCommandSquad", -1);
		super.deleteYourself();
	}

}
