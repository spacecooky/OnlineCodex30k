package oc.wh40k.units.ec;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ECCorsairVoidDreamer extends Eintrag {

	OptionsUpgradeGruppe o1;
    
	public ECCorsairVoidDreamer() {
		name = "Corsair Void Dreamer";
		grundkosten = 70;
        
		add(ico = new oc.Picture("oc/wh40k/images/ECCorsairVoidDreamer.jpg"));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Neural Shredder", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power Weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Void Sabre", 15));
		ogE.addElement(new OptionsGruppeEintrag("Witchblade", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Haywire Grenades", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Webway Portal", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "A Gyrinx", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Spirit Stones", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Balelight", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Corsair Jet Pack", 20));
	}

	@Override
	public void refreshen() {
	}
    
}
