package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TYVenatoren extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;

	public TYVenatoren() {
		name = "Venatoren";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Venatoren", 3, 9, 30);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TYVenatoren.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Zangenkrallen", 5));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Stachelfäuste", 5));
		ogE.addElement(new OptionsGruppeEintrag("Neuralfresser", 5));
		ogE.addElement(new OptionsGruppeEintrag("Säurespucker", 5));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
		o1.setPreis(0, 5 * squad.getModelle());

		o2.setPreis(0, squad.getModelle() * 5);
		o2.setPreis(1, squad.getModelle() * 5);
		o2.setPreis(2, squad.getModelle() * 10);
	}

}
