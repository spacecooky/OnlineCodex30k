package oc.whfb.units.bt;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.whfb.armies.VOLKBretonia;

public class BTGralsritter extends Eintrag {

	AnzahlPanel squad;
	boolean set = false;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	
	RuestkammerStarter rkBanner;

	public BTGralsritter() {
		name = BuildaHQ.translate("Gralsritter");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Gralsritter"),  3, 12, 38);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/DEDunkelelfenkrieger.jpg"));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 20));
		
		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "BTBanner", "");
		rkBanner.initKammer(true, true, false, false);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		rkBanner.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBanner);
		
		complete();
	}

	@Override
	public void refreshen() {
		rkBanner.setAktiv(oeS.isSelected());
		boolean louen = ( BuildaHQ.getCountFromInformationVector("BT_LOUEN") > 0 ? true : false );
		if(VOLKBretonia.GR > 1 && !louen) {
			setFehlermeldung(BuildaHQ.translate("0-1 Auswahl"));
		} else {
			if(!set){
				VOLKBretonia.GR ++;
			}
			setFehlermeldung("");
			set = true;
		}
	}	

	@Override
	public void deleteYourself() {
		VOLKBretonia.GR --;
		super.deleteYourself();
	}
}
