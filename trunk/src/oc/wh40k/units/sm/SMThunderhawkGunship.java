package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMThunderhawkGunship extends Eintrag {

        OptionsUpgradeGruppe o1;
        OptionsUpgradeGruppe o2;

	public SMThunderhawkGunship() {
		name = "Thunderhawk Gunship";
		grundkosten = 900;

		add(ico = new oc.Picture("oc/wh40k/images/Thunderhawk.gif"));
		

        ogE.addElement(new OptionsGruppeEintrag("Heavy bombs","6 heavy bombs", 0));
		ogE.addElement(new OptionsGruppeEintrag("Hellstrike missiles","6 Hellstrike missiles",0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Thunderhawk cannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Turbo-laser destructor", 20));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Flare/chaff launcher", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armoured cockpit", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Illum flares", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Paint scheme","Distinctive paint scheme or markings", 10));
		
		complete();

	}

	public void refreshen() {
            if (!o1.isSelected()) o1.setSelected(0,true);
            if (!o2.isSelected()) o2.setSelected(0,true);
	}
}
