package oc.wh40k.units.ec;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ECCorsairPrince extends Eintrag {

	OptionsZaehlerGruppe o1;
	OptionsUpgradeGruppe o2;
    OptionsEinzelUpgrade jetpack;

	public ECCorsairPrince() {
		name = "Corsair Prince";
		grundkosten = 100;
        
        BuildaHQ.addToInformationVector("ECCorsairPrince", 1);

		add(ico = new oc.Picture("oc/wh40k/images/ECCorsairPrince.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Harlequin's Kiss", 5));
		ogE.addElement(new OptionsGruppeEintrag("Lasblaster", 2));
		ogE.addElement(new OptionsGruppeEintrag("Shuriken Catapult", 2));
		ogE.addElement(new OptionsGruppeEintrag("Fusion Pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power Weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Void Sabre", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Haywire Grenades", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Meltabombs", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Balelight", 10));
		add(jetpack = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Corsair Jet Pack", 20));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Shimmershield", 5));
		ogE.addElement(new OptionsGruppeEintrag("Force Shield", 20));
		ogE.addElement(new OptionsGruppeEintrag("Shadowfield", 35));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		BuildaHQ.addToInformationVector("ECCorsairPrince", -1);
	}
    
    @Override
    public boolean hasSpecialValue(String key) {
        if(key.equals("Jetpack"))
            return jetpack.isSelected();
        
        return false;
    }

}
