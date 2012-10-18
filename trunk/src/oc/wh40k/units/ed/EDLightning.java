package oc.wh40k.units.ed;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class EDLightning extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;

	public EDLightning() {
		name = "Lightning";
		grundkosten = 145;

		add(ico = new oc.Picture("oc/wh40k/images/ABVulture.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("lb autocannon", "long-barrelled autocannon with AA mount", 0));
		ogE.addElement(new OptionsGruppeEintrag("2 Hellstrike missiles", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("4 Hellstrike missiles", 40));
		ogE.addElement(new OptionsGruppeEintrag("4 Hellfury missiles", 40));
		ogE.addElement(new OptionsGruppeEintrag("4 Bombs", 40));
		ogE.addElement(new OptionsGruppeEintrag("6 Skystrike missiles", 50));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Infra-red targeting", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Illum flares", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Distinctive paint", "Distinctive paint scheme/decals", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Flare/chaff launcher", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Armoured cockpit", 20));

		complete();
	}

	@Override
	public void refreshen() {
        o1.alwaysSelected();
	}

}
