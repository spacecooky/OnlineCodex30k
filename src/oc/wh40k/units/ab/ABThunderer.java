package oc.wh40k.units.ab;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ABThunderer extends RuestkammerVater {

    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    OptionsUpgradeGruppe oAce;

	public ABThunderer() {
		grundkosten = 140;
	}

  @Override
	public void initButtons(boolean... defaults) {
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy stubber", 10));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Camo netting", 20));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Skilled driver", 5));
		ogE.addElement(new OptionsGruppeEintrag("Night Fighters", 5));
		ogE.addElement(new OptionsGruppeEintrag("Ace Gunner", 10));
        ogE.addElement(new OptionsGruppeEintrag("Disciplined Crew", 10));
		ogE.addElement(new OptionsGruppeEintrag("Gung-ho! Crew", 5));
		ogE.addElement(new OptionsGruppeEintrag("Battle Hardened Crew", 10));
		ogE.addElement(new OptionsGruppeEintrag("Veteran Commander", 10));
		ogE.addElement(new OptionsGruppeEintrag("Slick Loader", 20));
		add(oAce = new OptionsUpgradeGruppe(ID, randAbstand , cnt, "", ogE));
        setHeadline(oAce, "Ace Crew Skills");

		sizeSetzen();
	}

  @Override
	public void refreshen() {
		oe1.setAktiv(!oe2.isSelected());
		oe2.setAktiv(!oe1.isSelected());
	}

}
