package oc.wh40k.units.dk;

import oc.AnzahlPanel;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DKOrdnanceGun extends RuestkammerVater {

    AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;

	public DKOrdnanceGun() {
		grundkosten = 0;
	}

    @Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGOrdnanceTank.jpg"));

		ogE.addElement(new OptionsGruppeEintrag("Earthshaker", 75));
		ogE.addElement(new OptionsGruppeEintrag("Medusa Siege Gun", 100));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Crew", 4, 7, 6));
        squad.setGrundkosten(-24);
        squad.setNichtDieErsteOption(true);

        seperator();
        
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Bastion-breacher shells", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Trojan", 35));

		sizeSetzen();
	}

    @Override
	public void refreshen() {
        o1.alwaysSelected();
		
		oe1.setAktiv(o1.isSelected("Medusa Siege Gun"));
	}

}
