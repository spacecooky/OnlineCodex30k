package oc.necro.units;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerHelper;

public class Territorienfertigkeiten extends RuestkammerHelper {
    
    OptionsUpgradeGruppe o1;


	public Territorienfertigkeiten() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {

        ogE.addElement(new OptionsGruppeEintrag("Chemoteich: Angst"));
		ogE.addElement(new OptionsGruppeEintrag("Pilzhöhle: Sporenkrankh.", "Pilzhöhle: Sporenkrankheit"));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 6));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
