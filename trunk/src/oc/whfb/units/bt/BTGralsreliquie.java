package oc.whfb.units.bt;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.whfb.armies.VOLKBretonia;

public class BTGralsreliquie extends Eintrag {

	OptionsEinzelUpgrade oe;
	RuestkammerStarter rkMount;
	OptionsZaehlerGruppe oe1;
	boolean set = false;
	AnzahlPanel squad;

	boolean astSelected = false;

	public BTGralsreliquie() {
		name = BuildaHQ.translate("Gralsreliquie")+"\n";
		grundkosten = 10;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Gralspilger"), 6, 30, 9);
		squad.setGrundkosten(108 - (6*9));
		add(squad); 
		
		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));

		complete();
	}

	@Override
	public void refreshen() {		
		if(VOLKBretonia.RELIQUIE > 1) {
			setFehlermeldung(BuildaHQ.translate("0-1 Auswahl"));
		} else {
			if(!set)VOLKBretonia.RELIQUIE ++;
			setFehlermeldung("");
			set = true;
		}		
	}

	@Override
	public void deleteYourself() {		
		VOLKBretonia.RELIQUIE --;
		super.deleteYourself();
	}	
}
