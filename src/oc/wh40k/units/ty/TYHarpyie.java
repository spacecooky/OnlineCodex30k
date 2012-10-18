package oc.wh40k.units.ty;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TYHarpyie extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsUpgradeGruppe o4;

	public TYHarpyie() {
		name = "Harpyie";
		grundkosten = 160;

		add(ico = new oc.Picture("oc/wh40k/images/TYHarpyie.jpg"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sync. Dornenwürger", "Synchronisierte Dornenwürgerkanone", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Schw. Biozidkanone", "Synchronisierte Schwere Biozidkanone", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Stachelsalve", 0));
		ogE.addElement(new OptionsGruppeEintrag("Stachelhagel", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenalindrüsen", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxinkammern", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Regeneration", 15));

		complete();
	}

	@Override
	public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
	}

}
