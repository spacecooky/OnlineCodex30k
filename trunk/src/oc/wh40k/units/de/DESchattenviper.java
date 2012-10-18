package oc.wh40k.units.de;


import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DESchattenviper extends RuestkammerVater {

	OptionsUpgradeGruppe weapons;

	public DESchattenviper() {
		grundkosten = 55;
	}

	@Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/DESchattenviper.jpg"));
		

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Splittergewehr", 0));
        ogE.addElement(new OptionsGruppeEintrag("Splitterkanone", 10));
        add(weapons = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Bremstriebwerke", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Fangketten", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Grausige Trophäen", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Toxinklingen", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Nachtfeld", 10));

		sizeSetzen();
	}

    @Override
    public void refreshen() {
        if (!weapons.isSelected()) {
            weapons.setSelected(0, true);
        }
    }


}
