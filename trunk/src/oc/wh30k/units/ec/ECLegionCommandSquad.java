package oc.wh30k.units.ec;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ECLegionCommandSquad extends Eintrag {

	OptionsEinzelUpgrade apo;
	OptionsEinzelUpgrade boss;
	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o3;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o4, o5;
	RuestkammerStarter rkTransport;
	RuestkammerStarter rkPod;
	RuestkammerStarter rkPrometheus;
	AnzahlPanel squad;
        

	public ECLegionCommandSquad() {
		name = "Legion Command Squad\n";
		grundkosten = 40;
		        
		BuildaHQ.addToInformationVector("ECLegionCommandSquad", 1);

		seperator();
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Legion Space Marine Chosen", 3, 10, 20);
		add(squad);
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 25));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Combat chield", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

		seperator();
		// replace Bolt Pistol
		ogE.addElement(new OptionsGruppeEintrag("Heavy Chainsword", 5));
		ogE.addElement(new OptionsGruppeEintrag("Charnabal sabre", 5));
		ogE.addElement(new OptionsGruppeEintrag("Power Weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power Fist", 15));
		ogE.addElement(new OptionsGruppeEintrag("Lightning Claw", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));
		seperator();
		
		//replace ccw
		ogE.addElement(new OptionsGruppeEintrag("Heavy Chainsword", 5));
		ogE.addElement(new OptionsGruppeEintrag("Charnabal sabre", 5));
		ogE.addElement(new OptionsGruppeEintrag("Power Weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power Fist", 15));
		ogE.addElement(new OptionsGruppeEintrag("Lightning Claw", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));
		seperator();
		
		// replace bolter
		ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Volkit charger", 10));
		add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));
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
		// maximal so viele combat shields wie modelle im trupp
		o2.setButtonMaxAnzahl(squad.getModelle());
		o2.setMaxAnzahl(squad.getModelle());
		// chainswords & stuff replacing bolt pistol 
		o3.setButtonMaxAnzahl(squad.getModelle());
		o3.setMaxAnzahl(squad.getModelle());
		// chainswords & stuff replacing CCW
		o4.setButtonMaxAnzahl(squad.getModelle());
		o4.setMaxAnzahl(squad.getModelle());
		// bolter NOTE: standart bearer has no bolter
		o5.setButtonMaxAnzahl(squad.getModelle()-1);
		o5.setMaxAnzahl(squad.getModelle()-1);

	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("ECCommandSquad", -1);
		super.deleteYourself();
	}

}
