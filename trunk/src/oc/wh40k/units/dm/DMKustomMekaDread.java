package oc.wh40k.units.dm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class DMKustomMekaDread extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;

	public DMKustomMekaDread() {
		kategorie = 1;
		name = "Kustom Meka-Dread";
		grundkosten = 180;


		add(ico = new oc.Picture("oc/wh40k/images/KustomMekaDread.gif"));
		
		
        ogE.addElement(new OptionsGruppeEintrag("Mega Charga", 15));
        ogE.addElement(new OptionsGruppeEintrag("Rokkit-Bom Racks", 35));
		ogE.addElement(new OptionsGruppeEintrag("Kustom Force Field", 75));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Big Zzappa", 15));
		ogE.addElement(new OptionsGruppeEintrag("Shunta", 25));
		ogE.addElement(new OptionsGruppeEintrag("Rattler Kannon", 10));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();

	}

	public void refreshen() {
        o1.setLegal(o1.isSelected());
	}
	
}
