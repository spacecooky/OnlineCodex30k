package oc.wh40k.units.ec;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ECCorsairNightSpinner extends Eintrag {

	OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade oe1;

	public ECCorsairNightSpinner() {
		name = "Corsair Night Spinner";
		grundkosten = 130;

		add(ico = new oc.Picture("oc/wh40k/images/ECCorsairNightSpinner.jpg"));
        
        ogE.addElement(new OptionsGruppeEintrag("T/L Shuriken Catapults", "Twin-linked Shuriken Catapults", 0));
        ogE.addElement(new OptionsGruppeEintrag("Shuriken Cannon", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();
        
        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Doomweaver", 0));
        
        seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Spirit Stones", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Star Engines", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vectored Engines", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Holo-field", 35));

		complete();
	}

    @Override
	public void refreshen() {
        o1.alwaysSelected();
        if(!oe1.isSelected()) oe1.setSelected(true);
	}
    
}