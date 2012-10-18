package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsUpgradeGruppe;

public class SMThunderhawkTransporter extends Eintrag {

        OptionsUpgradeGruppe o1;
        OptionsUpgradeGruppe o2;

	public SMThunderhawkTransporter() {
		name = "Thunderhawk Transporter";
		grundkosten = 455;


		add(ico = new oc.Picture("oc/wh40k/images/Thunderhawk.gif"));
     
		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Hellstrike missiles", 6, 10));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Flare/chaff launcher", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armoured cockpit", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Illum flares", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Paint scheme","Distinctive paint scheme or markings", 10));
		

		complete();

	}

	public void refreshen() {
	}
}
