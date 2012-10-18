package oc.necro.units;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerHelper;

public class Granaten extends RuestkammerHelper {

    OptionsUpgradeGruppe oz3;
    OptionsUpgradeGruppe oz4;

    boolean erstesSpiel;

	public Granaten() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {

        ogE.addElement(new OptionsGruppeEintrag("Fragmentgranaten", 30));
        ogE.addElement(new OptionsGruppeEintrag("Sprenggranaten", 50));
        add(oz3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));
        setHeadline(oz3, "Granaten");

        ogE.addElement(new OptionsGruppeEintrag("Reizgasgranaten", 15));
        ogE.addElement(new OptionsGruppeEintrag("Hallzuinogengasgranaten", 40));
        ogE.addElement(new OptionsGruppeEintrag("Melterbomben", 40));
        ogE.addElement(new OptionsGruppeEintrag("Blendgranaten", 20));
        ogE.addElement(new OptionsGruppeEintrag("Plasmagranaten", 30));
        ogE.addElement(new OptionsGruppeEintrag("Panikgasgranaten", 20));
        ogE.addElement(new OptionsGruppeEintrag("Nebelgranaten", 10));
        add(oz4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 7));
        setHeadline(oz4, "seltene Granaten");

		sizeSetzen();
	}

	@Override
	public void refreshen() {
        oz4.setAktiv(!erstesSpiel);
	}
    
    @Override
    public void specialVoid(boolean b) {
        erstesSpiel = b;
    }
}
