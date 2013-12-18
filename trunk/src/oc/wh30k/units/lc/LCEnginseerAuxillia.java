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
	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2;
	RuestkammerStarter t1, t2;

	public LCEnginseerAuxillia() {
		name = "Enginseer Auxillia\n";
		grundkosten = 25;
		überschriftSetzen = true;				
		
		seperator();
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Servo-automata", 4, 8, 5);
		add(squad);
		
		seperator();
		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "LCEnginseerKammer", "Enginseer Adept");
		t1.initKammer();		
		t1.setAbwaehlbar(false);
		add(t1);		

		seperator();
		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "LCEnginseerKammer", "Enginseer Adept");		
		t2.initKammer();
		add(t2);

		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 5));
		ogE.addElement(new OptionsGruppeEintrag("Cyber-familiar", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Las-lock", 1));
		ogE.addElement(new OptionsGruppeEintrag("Servo-arm", 5));
		ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Rotor cannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		complete();
	}

	@Override
	public void refreshen() {
		int selections = t1.getSelectedAsInt() + t2.getSelectedAsInt();
		
		o1.setPreis(0, selections*5);
		o1.setPreis(1, selections*15);
        
        o2.setMaxAnzahl(squad.getModelle());
        
        t2.getPanel().setLocation(t2.getPanel().getX(), t1.getPanel().getY() + t1.getPanel().getHeight() + 10);
        o1.getPanel().setLocation(o1.getPanel().getX(), t2.getPanel().getY() + t2.getPanel().getHeight() + 10);
        o2.getPanel().setLocation(o2.getPanel().getX(), o1.getPanel().getY() + o1.getPanel().getHeight() + 10);
        		
	}

}
