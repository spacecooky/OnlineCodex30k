package oc.wh40k.units.cd;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CDHerolddesKhorne extends CDHerold {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;

    boolean ironBuffer = false;
    boolean mountBuffer = false;

	public CDHerolddesKhorne() {
		name = "Herold des Khorne";
		grundkosten = 70;

		add(ico = new oc.Picture("oc/wh40k/images/CDHerolddesKhorne.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Moloch", 35));
		ogE.addElement(new OptionsGruppeEintrag("Streitwagen des Khorne", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Zorn des Khorne", 10));
		ogE.addElement(new OptionsGruppeEintrag("Blutgeiﬂel", 15));
		ogE.addElement(new OptionsGruppeEintrag("Segen des Blutgottes", 5));
		ogE.addElement(new OptionsGruppeEintrag("Eisenhaut", 15));
		ogE.addElement(new OptionsGruppeEintrag("Chaosikone", 25));
		ogE.addElement(new OptionsGruppeEintrag("Unheilige St‰rke", 15));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));

		complete();
	}

	@Override
	public void refreshen() {
        super.refreshen();

        o2.setPreis("Eisenhaut", o1.isSelected() ? 0 : 15);
        if(o1.isSelected()) o2.setSelected("Eisenhaut", true);
        o2.setMaxAnzahl(o1.isSelected() ? 4 : 3);

        if(mountBuffer && !o1.isSelected()) {
            o2.setSelected("Eisenhaut", ironBuffer);
        }

        if(!o1.isSelected()) {
            ironBuffer = o2.isSelected("Eisenhaut");
        }

        mountBuffer = o1.isSelected();
	}

}
