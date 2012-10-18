package oc.wh40k.units.ec;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ECCorsairPhoenixBomber extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;

	public ECCorsairPhoenixBomber() {
		name = "Corsair Phoenix Bomber";
		grundkosten = 225;

		add(ico = new oc.Picture("oc/wh40k/images/ECCorsairPhoenixBomber.jpg"));

        ogE.addElement(new OptionsGruppeEintrag("Pulse Laser", 0));
        ogE.addElement(new OptionsGruppeEintrag("T/L Bright Lances", "Twin-linked Bright Lances", 0));
        ogE.addElement(new OptionsGruppeEintrag("T/L Starcannons", "Twin-linked Starcannons", 0));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Phoenix Missiles", "Phoenix Missile Launchers", 0));
        ogE.addElement(new OptionsGruppeEintrag("Nightfire Missiles", "Nightfire Missile Launchers", 10));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

    @Override
	public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
	}
    
}