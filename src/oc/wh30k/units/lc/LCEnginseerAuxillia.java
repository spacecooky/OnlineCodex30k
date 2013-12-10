package oc.wh30k.units.lc;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class LCEnginseerAuxillia extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1, o2;
	OptionsZaehlerGruppe o3, o4, o5;
	RuestkammerStarter rkTransport;

	public LCEnginseerAuxillia() {
		name = "Enginseer Auxillia\n";
		grundkosten = 25;
		�berschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Enginseer", 1, 2, 20);
		add(squad);
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Servo-automata", 4, 8, 5);
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Nuncio-vox", 10));
		ogE.addElement(new OptionsGruppeEintrag("Augury scanner", 5));
		ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
		ogE.addElement(new OptionsGruppeEintrag("Cortex Controller", 15));
		ogE.addElement(new OptionsGruppeEintrag("Graviton gun", 5));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 5));
		
		seperator();

		//ogE.addElement(new OptionsGruppeEintrag("Close combat weapon", 0));
		//add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
		ogE.addElement(new OptionsGruppeEintrag("Heavy chainblade", 5));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Multi-laser", 5));
		ogE.addElement(new OptionsGruppeEintrag("Phase-plasma fusil", 10));
		ogE.addElement(new OptionsGruppeEintrag("Irad cleanser", 10));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 15));
		ogE.addElement(new OptionsGruppeEintrag("Photon thruster", 25));
		add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
        o1.setPreis(0, squad.getModelle()*5);
		 
        o4.setMaxAnzahl(squad.getModelle());
        o5.setMaxAnzahl(squad.getModelle()/3);
		
		//o3.setMaxAnzahl(squad.getModelle()-o4.getAnzahl());
		//o3.setAnzahl(0, o4.getMaxAnzahl()-o4.getAnzahl());
		
	}

}
