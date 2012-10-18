package oc.wh40k.units.tl;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class TLAuxiliaSiegeDefenceSquadron extends Eintrag {

	OptionsEinzelUpgrade oe1;
	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	public TLAuxiliaSiegeDefenceSquadron() {
		name = "Auxilia Siege Defence Squadron";
		grundkosten = 0;
		this.überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/AuxiliaSiegeDefenceSquadron.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo netting", 20));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "TLSiegeDefence", "", 1);
		t1.initKammer();
		t1.setButtonText("Tank 1");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "TLSiegeDefence", "", 1);
		t2.initKammer();
		t2.setButtonText("Tank 2");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "TLSiegeDefence", "", 1);
		t3.initKammer();
		t3.setButtonText("Tank 3");
		add(t3);

		complete();
	}

	@Override
	public void refreshen() {
		int tanks = 0;

		
		if(t1.isSelected() ){
			if(((TLSiegeDefence)t1.getKammer()).o1.getSelectedIndex()==0){
				tanks +=20;
			} else{
				tanks +=30;
			}
			
		}
		if(t2.isSelected() ){
			if(((TLSiegeDefence)t2.getKammer()).o1.getSelectedIndex()==0){
				tanks +=20;
			} else{
				tanks +=30;
			}
			
		}
		if(t3.isSelected() ){
			if(((TLSiegeDefence)t3.getKammer()).o1.getSelectedIndex()==0){
				tanks +=20;
			} else{
				tanks +=30;
			}
			
		}
		
		oe1.setPreis(tanks);
		oe1.setAktiv(tanks > 0);

	}

}
