package oc.wh30k.units.lc;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class LCLegioCyberneticaCastellaxClassBattleAutomata extends Eintrag {

	OptionsUpgradeGruppe o1, o2;
	RuestkammerStarter t1, t2, t3;

	public LCLegioCyberneticaCastellaxClassBattleAutomata() {
		name = "Legio Cybernetica Castellax Class Battle-Automata";
		grundkosten = 0;
        überschriftSetzen = true;
        
        seperator();
		ogE.addElement(new OptionsGruppeEintrag("Paragon of Metal", 35));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Searchlight", 1));
		ogE.addElement(new OptionsGruppeEintrag("Infravisor", 5));
		ogE.addElement(new OptionsGruppeEintrag("Frag grenades", 5));
		ogE.addElement(new OptionsGruppeEintrag("Enhanced targeting array", 15));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 4));

		seperator();
		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "LCCastellaxKammer", "", 1);
		t1.initKammer();
		t1.setButtonText("Castellax Class Battle-Automata");
		add(t1);

		seperator();
		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "LCCastellaxKammer", "", 1);
		t2.initKammer();
		t2.setButtonText("Castellax Class Battle-Automata");
		add(t2);

		seperator();
		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "LCCastellaxKammer", "", 1);
		t3.initKammer();
		t3.setButtonText("Castellax Class Battle-Automata");
		add(t3);

		complete();
	}

	
	public void refreshen() {
            int selections = t1.getSelectedAsInt() + t2.getSelectedAsInt() + t3.getSelectedAsInt();
            
            if (!o1.isSelected()) {
            	o2.setPreis(0, selections);
            	o2.setPreis(1, selections*5);
            	o2.setPreis(2, selections*5);
            	o2.setPreis(3, selections*15);
            }
            else {
            	o2.setPreis(0, 1);
                o2.setPreis(1, 5);
                o2.setPreis(2, 5);
                o2.setPreis(3, 15);
            }
            
			t1.setLegal(selections > 0);
            
            t1.setAktiv(t1.isSelected() || selections < 3);
            t2.setAktiv(t1.isSelected() && selections < 3 && !o1.isSelected());
            t3.setAktiv(t2.isSelected() && selections < 3 && !o1.isSelected());

            t2.getPanel().setLocation(t2.getPanel().getX(), t1.getPanel().getY() + t1.getPanel().getHeight() + 10);
            t3.getPanel().setLocation(t3.getPanel().getX(), t2.getPanel().getY() + t2.getPanel().getHeight() + 10);
            

            }

}
