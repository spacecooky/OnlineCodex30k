package oc.wh40k.units.ty;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TYAlphakrieger extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;

	public TYAlphakrieger() {
		name = "Alphakrieger";
		grundkosten = 80;

		add(ico = new oc.Picture("oc/wh40k/images/TYKrieger.jpg"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sensenklauen", 0));
		ogE.addElement(new OptionsGruppeEintrag("Zangenkrallen", 5));
		ogE.addElement(new OptionsGruppeEintrag("Paar Hornschwerter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Peitsche & Hornschwert", "Tentakelpeitsche und Hornschwert", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Neuralfresser", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sensenklauen", 0));
		ogE.addElement(new OptionsGruppeEintrag("Zangenkrallen", 0));
		ogE.addElement(new OptionsGruppeEintrag("Stachelfäuste", 0));
		ogE.addElement(new OptionsGruppeEintrag("Säurespucker", 5));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenalindrüsen", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxinkammern", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Regeneration", 10));

		complete();
	}

	@Override
	public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
	}

}
