package oc.wh40k.units.ec;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ECCorsairVenomKammer extends RuestkammerVater {

	OptionsUpgradeGruppe weapons;

	public ECCorsairVenomKammer() {
		grundkosten = 45;
	}

	@Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/ECCorsairVenomKammer.jpg"));
		
		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Shuriken Cannon", 0));
        ogE.addElement(new OptionsGruppeEintrag("Scatter Laser", 10));
        ogE.addElement(new OptionsGruppeEintrag("Eldar Missile Launcher", 15));
        ogE.addElement(new OptionsGruppeEintrag("Starcannon", 20));
        add(weapons = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Spirit Stones", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Star Engines", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vectored Engines", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Holo-field", 35));

		sizeSetzen();
	}

    @Override
    public void refreshen() {
        weapons.alwaysSelected();
    }

}
