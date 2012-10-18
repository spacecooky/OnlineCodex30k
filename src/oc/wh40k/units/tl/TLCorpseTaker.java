package oc.wh40k.units.tl;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class TLCorpseTaker extends Eintrag {

	
	AnzahlPanel servitors;
	
	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade apo;
	RuestkammerStarter rkTransport;

	public TLCorpseTaker() {
		name="Corpse Taker\n";
		überschriftSetzen=true;
		
		
		servitors = new AnzahlPanel(ID, randAbstand, cnt, "Servitors", 2, 9, 10);
		add(servitors);
	
		seperator();
		
		add (apo=new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Apothecary", 30));
		add (new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Power Weapon", 10));
		add (new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Hellfire Rounds", 10));

		seperator();
		
		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "TLTransporterKammer", "Transporter");
		rkTransport.initKammer(false, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	// @OVERRIDE
	public void refreshen() {
		apo.setSelected(true);
	}

}
