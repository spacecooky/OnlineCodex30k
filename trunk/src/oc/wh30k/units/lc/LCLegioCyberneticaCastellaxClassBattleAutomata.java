package oc.wh30k.units.lc;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class LCLegioCyberneticaCastellaxClassBattleAutomata extends Eintrag {

	OptionsUpgradeGruppe o1, o2;
	RuestkammerStarter t1, t2, t3, t4, t5;

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
		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "LCCastellaxKammer", "Castellax");
		t1.initKammer();
		t1.setAbwaehlbar(false);
		add(t1);

		seperator();
		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "LCCastellaxKammer", "Castellax");
		t2.initKammer();
		add(t2);

		seperator();
		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "LCCastellaxKammer", "Castellax");
		t3.initKammer();
		add(t3);

		seperator();
		t4 = new RuestkammerStarter(ID, randAbstand, cnt, "LCCastellaxKammer", "Castellax");
		t4.initKammer();
		add(t4);

		seperator();
		t5 = new RuestkammerStarter(ID, randAbstand, cnt, "LCCastellaxKammer", "Castellax");
		t5.initKammer();
		add(t5);

		complete();
	}

	
	public void refreshen() {
            int selections = t1.getSelectedAsInt() + t2.getSelectedAsInt() + t3.getSelectedAsInt()
            		 + t4.getSelectedAsInt() + t5.getSelectedAsInt();
                                    
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
            
			t2.setAktiv(t1.isSelected() && !o1.isSelected());
            t3.setAktiv(t2.isSelected() && !o1.isSelected());
            t4.setAktiv(t3.isSelected() && !o1.isSelected());
            t5.setAktiv(t4.isSelected() && !o1.isSelected());

            t2.getPanel().setLocation(t2.getPanel().getX(), t1.getPanel().getY() + t1.getPanel().getHeight() + 5);
            t3.getPanel().setLocation(t3.getPanel().getX(), t2.getPanel().getY() + t2.getPanel().getHeight() + 5);
            t4.getPanel().setLocation(t4.getPanel().getX(), t3.getPanel().getY() + t3.getPanel().getHeight() + 5);
            t5.getPanel().setLocation(t5.getPanel().getX(), t4.getPanel().getY() + t4.getPanel().getHeight() + 5);
            

            }

}
