package oc.wh30k.units.we;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class WELegionArtilleryTankSquadron extends Eintrag {

	OptionsUpgradeGruppe o1;
	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	public WELegionArtilleryTankSquadron() {
		name = "Legion Artillery Tank Squadron";
		grundkosten = 0;
        überschriftSetzen = true;

        seperator();
        		
        ogE.addElement(new OptionsGruppeEintrag("Command tank", 25));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        		
        seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "WEArtilleryKammer", "", 1);
		t1.initKammer();
		t1.setButtonText("Legion Artillery Tank");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "WEArtilleryKammer", "", 1);
		t2.initKammer();
		t2.setButtonText("Legion Artillery Tank");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "WEArtilleryKammer", "", 1);
		t3.initKammer();
		t3.setButtonText("Legion Artillery Tank");
		add(t3);

		complete();
	}

	
	public void refreshen() {
            int selections = t1.getSelectedAsInt() + t2.getSelectedAsInt() + t3.getSelectedAsInt();
            
            t1.setLegal(selections > 0);
            
            t1.setAktiv(t1.isSelected() || selections < 3);
            t2.setAktiv(t2.isSelected() || (t1.isSelected() && selections < 3));
            t3.setAktiv(t3.isSelected() || (t2.isSelected() && selections < 3));

            t2.getPanel().setLocation(t2.getPanel().getX(), t1.getPanel().getY() + t1.getPanel().getHeight() + 10);
            t3.getPanel().setLocation(t3.getPanel().getX(), t2.getPanel().getY() + t2.getPanel().getHeight() + 10);
    
            setUnikat(true);  
            o1.setAktiv(t3.isSelected());
	}
	
}
