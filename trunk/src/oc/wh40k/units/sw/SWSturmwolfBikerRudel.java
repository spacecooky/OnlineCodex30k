package oc.wh40k.units.sw;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SWSturmwolfBikerRudel extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;

	public SWSturmwolfBikerRudel() {
		name = "Sturmwolf-Biker-Rudel\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Biker", 3, 10, 25);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/SWBlutwolfBikeschwadron.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Trike mit Schwerer Bolter", 30));
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Trike mit Multimelter", 40));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melterbomben", 0));

		complete();
	}

	@Override
	public void refreshen() {
		oe2.setAktiv(!oe3.isSelected());
		oe3.setAktiv(!oe2.isSelected());

		int trike = oe3.isSelected() || oe2.isSelected() ? 1 : 0;
		oe1.setPreis((squad.getModelle() + trike) * 5);
	}

}
