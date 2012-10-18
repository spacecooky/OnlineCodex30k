package oc.wh40k.units.ec;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ECCorsairFalconKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
    OptionsEinzelUpgrade oe1;

	public ECCorsairFalconKammer() {
		grundkosten = 130;
	}

	@Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/ECCorsairFalconKammer.jpg"));
		
		seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("T/L Shuriken Catapults", "Twin-linked Shuriken Catapults", 0));
		ogE.addElement(new OptionsGruppeEintrag("Shuriken Cannon", 10));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Shuriken Cannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Scatter Laser", 15));
		ogE.addElement(new OptionsGruppeEintrag("Eldar Missile Launcher", 20));
		ogE.addElement(new OptionsGruppeEintrag("Starcannon", 25));
		ogE.addElement(new OptionsGruppeEintrag("Bright Lance", 30));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Pulse Laser", 0));
        
        seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Spirit Stones", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Star Engines", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Vectored Engines", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Holo-field", 35));

		sizeSetzen();
	}

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        
        if(!oe1.isSelected()) oe1.setSelected(true);
    }

}
